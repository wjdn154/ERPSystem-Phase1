package com.erp.system.common;

import com.erp.system.common.DependencyInjector.DependencyInjector;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;
import com.erp.system.financial.model.book_keeping.accounting_ledger.CashBook;
import com.erp.system.financial.repository.book_keeping.accounting_ledger.CashBookRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntryRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.VatTypeRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.erp.system.common.Rules.DATA_FILE_PATH;

/**
 * Excel 파일을 읽고 각 시트의 데이터를 처리하는 클래스.
 */
public class ERPDataInitializer {
    DependencyInjector di = DependencyInjector.getInstance();

    private Map<String, Class<?>> tableClassMap;
    private Map<Class<?>, Object> repositories;

    private EntryRepository entriesRepository;
    private VatTypeRepository vatTypesRepository;
    private CashBookRepository cashBookRepository;
    // 1. 여기에 Repository 추가

    /**
     * ERPDataInitializer 생성자
     */
    public ERPDataInitializer() {
        System.out.println("\n--------------------------- 2. ERPDataInitializer 생성 ---------------------------\n");
        // 테이블과 해당하는 클래스 타입을 매핑
        tableClassMap = new HashMap<>();
        tableClassMap.put("Entries", Entry.class);
        tableClassMap.put("VatTypes", VatType.class);
        tableClassMap.put("CashBook", CashBook.class);
        // 2. 여기에 테이블 매핑 추가

        // 각 엔티티 타입에 해당하는 리포지토리 인스턴스를 싱글톤 패턴으로 생성
        repositories = new HashMap<>();
        entriesRepository = di.getInstance(EntryRepository.class);
        vatTypesRepository = di.getInstance(VatTypeRepository.class);
        cashBookRepository = di.getInstance(CashBookRepository.class);
        // 3. 여기에 싱글톤 적용

        repositories.put(Entry.class, entriesRepository);
        repositories.put(VatType.class, vatTypesRepository);
        repositories.put(CashBook.class, cashBookRepository);
        // 4. 여기에 Domain과 Repository 매핑 추가

        readExcel(DATA_FILE_PATH);
        System.out.println("\n--------------------------- 2. ERPDataInitializer 초기화 완료 ---------------------------\n");
    }

    /**
     * Excel 파일을 읽는 메서드
     * @param filePath 읽을 파일의 경로
     */
    public void readExcel(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            for (Sheet sheet : workbook) {
                handleSheet(sheet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 각 시트를 처리하는 메서드
     * 시트 내의 데이터를 읽어 엔티티 객체로 변환 후 저장
     * @param sheet 처리할 Excel 시트 객체
     */
    public void handleSheet(Sheet sheet) {
        Row includeRow = sheet.getRow(0);
        Row typeRow = sheet.getRow(1);
        Row headerRow = sheet.getRow(2);

        List<Boolean> includeInConstructor = new ArrayList<>();
        List<String> dataTypes = new ArrayList<>();
        List<String> columnNames = new ArrayList<>();

        DataFormatter formatter = new DataFormatter();

        // 생성자에 필드 설정
        for (Cell cell : includeRow) {
            String cellValue = formatter.formatCellValue(cell);
            includeInConstructor.add("1".equals(cellValue));
        }

        // 데이터 타입 설정
        for (Cell cell : typeRow) {
            dataTypes.add(formatter.formatCellValue(cell));
        }

        // 컬럼 이름 설정
        for (Cell cell : headerRow) {
            columnNames.add(formatter.formatCellValue(cell));
        }

        List<List<String>> allData = new ArrayList<>();

        // 데이터 행 설정
        for (int i = 3; i <= sheet.getLastRowNum(); i++) {
            Row currentRow = sheet.getRow(i);
            List<String> rowData = new ArrayList<>();
            for (int j = 0; j < currentRow.getLastCellNum(); j++) {
                Cell cell = currentRow.getCell(j);
                rowData.add(formatter.formatCellValue(cell));
            }
            allData.add(rowData);
        }

        saveEntity(sheet, includeInConstructor, columnNames, dataTypes, allData);
    }

    /**
     * 엔티티를 생성하고 저장하는 메서드
     * @param sheet 시트 객체
     * @param includeInConstructor 생성자에 포함될 필드 여부 리스트
     * @param columnNames 컬럼 이름 리스트
     * @param dataTypes 데이터 타입 리스트
     * @param allData 모든 데이터 리스트
     */
    private void saveEntity(Sheet sheet, List<Boolean> includeInConstructor, List<String> columnNames, List<String> dataTypes, List<List<String>> allData) {
        String tableName = sheet.getSheetName();
        Class<?> clazz = tableClassMap.get(tableName);
        Object repository = repositories.get(clazz);

        System.out.println("처리 중인 시트: " + tableName);

        for (List<String> rowData : allData) {
            try {
                Object entity = createEntity(clazz, includeInConstructor, columnNames, dataTypes, rowData);
                if (entity != null) {
                    Method saveMethod = repository.getClass().getMethod("save", clazz);
                    saveMethod.invoke(repository, entity);
                    System.out.println("저장된 엔티티: " + entity);
                }
            } catch (Exception e) {
                System.out.println("엔티티 생성 또는 저장 오류: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * 엔티티 객체를 생성하는 메서드.
     * @param clazz 클래스 객체
     * @param includeInConstructor 생성자에 포함될 필드 여부 리스트
     * @param columnNames 컬럼 이름 리스트
     * @param dataTypes 데이터 타입 리스트
     * @param rowData 행 데이터 리스트
     * @return 생성된 엔티티 객체
     * @throws ReflectiveOperationException 리플렉션 작업 중 발생하는 예외
     * @throws ParseException 날짜 파싱 예외
     */
    private Object createEntity(Class<?> clazz, List<Boolean> includeInConstructor, List<String> columnNames, List<String> dataTypes, List<String> rowData) throws ReflectiveOperationException, ParseException {
        List<Class<?>> paramTypesList = new ArrayList<>();
        List<Object> paramValuesList = new ArrayList<>();

        // 생성자의 파라미터 타입과 값을 설정
        for (int i = 0; i < includeInConstructor.size(); i++) {
            if (includeInConstructor.get(i)) {
                Class<?> type = getTypeFromString(dataTypes.get(i));
                Object value = convertValue(rowData.get(i), type);
                paramTypesList.add(type);
                paramValuesList.add(value);
            }
        }

        Class<?>[] paramTypesArray = paramTypesList.toArray(new Class<?>[0]);

        Constructor<?> matchedConstructor = null;
        // 일치하는 생성자 찾기
        for (Constructor<?> constructor : clazz.getConstructors()) {
            Class<?>[] constructorParamTypes = constructor.getParameterTypes();
            if (Arrays.equals(constructorParamTypes, paramTypesArray)) {
                matchedConstructor = constructor;
                break;
            }
        }

        if (matchedConstructor == null) {
            throw new NoSuchMethodException(clazz.getName() + "에 맞는 생성자를 찾을 수 없습니다.");
        }

        Object entity = matchedConstructor.newInstance(paramValuesList.toArray());

        // 생성자를 통하지 않고 나머지 필드 설정
        for (int i = 0; i < columnNames.size(); i++) {
            if (!includeInConstructor.get(i)) {
                String columnName = columnNames.get(i);
                String value = rowData.get(i);

                try {
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    Class<?> fieldType = field.getType();
                    Object convertedValue = convertValue(value, fieldType);
                    field.set(entity, convertedValue);
                } catch (NoSuchFieldException e) {
                    System.out.println("필드 설정 오류: " + columnName + " 필드를 찾을 수 없습니다.");
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    System.out.println("필드 설정 오류: " + columnName + " 필드에 접근할 수 없습니다.");
                    e.printStackTrace();
                }
            }
        }

        return entity;
    }

    /**
     * 문자열로부터 클래스 타입을 반환하는 메서드
     * @param typeStr 타입 문자열
     * @return 클래스 타입
     */
    private Class<?> getTypeFromString(String typeStr) {
        switch (typeStr.toLowerCase()) {
            case "string": return String.class;
            case "int": return Integer.class;
            case "boolean": return Boolean.class;
            case "double": return Double.class;
            case "date": return Date.class;
            case "bigdecimal": return BigDecimal.class;
            default: throw new IllegalArgumentException("지원하지 않는 타입: " + typeStr);
        }
    }

    /**
     * 문자열 값을 특정 타입으로 변환하는 메서드
     * @param value 문자열 값
     * @param type 변환할 클래스 타입
     * @return 변환된 객체
     * @throws ParseException 날짜 파싱 예외
     */
    private Object convertValue(String value, Class<?> type) throws ParseException {
        if (value == null || value.isEmpty()) return null;
        if (type == String.class) return value;
        if (type == Integer.class || type == int.class) return Integer.parseInt(value);
        if (type == Boolean.class || type == boolean.class) return Boolean.parseBoolean(value);
        if (type == Double.class || type == double.class) return Double.parseDouble(value);
        if (type == Date.class) return new SimpleDateFormat("yyyyMMdd").parse(value);
        if (type == BigDecimal.class) return new BigDecimal(value);
        throw new IllegalArgumentException("지원하지 않는 타입 변환: " + type.getSimpleName());
    }
}