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
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.erp.system.common.Rules.DATA_FILE_PATH;

/**
 * Excel 파일을 읽고 각 시트의 데이터를 처리하는 클래스.
 */
public class ERPDataInitializer {
    private final DependencyInjector di = DependencyInjector.getInstance();
    private final Map<String, Class<?>> tableClassMap = new HashMap<>();
    private final Map<Class<?>, Object> repositories = new HashMap<>();

    /**
     * ERPDataInitializer 생성자
     */
    public ERPDataInitializer() {
        System.out.println("--------------------------- 2. ERPDataInitializer 생성 ---------------------------");
        long startTime = System.nanoTime(); // 시작 시간 기록
        autoRegister();
        readExcel(DATA_FILE_PATH);
        long endTime = System.nanoTime(); // 종료 시간 기록
        long duration = endTime - startTime; // 실행 시간 계산
        System.out.println("\n실행 시간: " + duration / 1_000_000 + " ms");
        System.out.println("--------------------------- 2. ERPDataInitializer 종료 ---------------------------\n");
    }

    /**
     * 모든 컴포넌트를 자동으로 등록하고 매핑을 설정하는 메서드
     */
    private void autoRegister() {
        Map<Class<?>, Object> allRepositories = di.getAllInstancesOfType(Object.class); // 모든 리포지토리를 가져옴

        // 모든 리포지토리를 순회하며 처리
        for (Map.Entry<Class<?>, Object> entry : allRepositories.entrySet()) {
            Class<?> repositoryClass = entry.getKey(); // 리포지토리 클래스
            Object repositoryInstance = entry.getValue(); // 리포지토리 인스턴스
            Class<?> domainClass = getDomainClassFromRepository(repositoryClass); // 리포지토리로부터 도메인 클래스를 추론

            // 도메인 클래스가 null이 아닌 경우
            if (domainClass != null) {
                String tableName = domainClass.getSimpleName(); // 도메인 클래스 이름을 테이블 이름으로 사용
                tableClassMap.put(tableName, domainClass); // 테이블 이름과 도메인 클래스를 매핑
                repositories.put(domainClass, repositoryInstance); // 도메인 클래스와 리포지토리 인스턴스를 매핑
            }
        }
    }

    /**
     * 리포지토리 클래스에서 도메인 클래스를 추론하는 메서드
     * @param repositoryClass 리포지토리 클래스
     * @return 도메인 클래스
     */
    private Class<?> getDomainClassFromRepository(Class<?> repositoryClass) {
        Type[] genericInterfaces = repositoryClass.getGenericInterfaces(); // 리포지토리 클래스의 제네릭 인터페이스를 가져옴, ex)Repository<Entry>

        // 제네릭 인터페이스를 순회
        for (Type genericInterface : genericInterfaces) {
            // 제네릭 인터페이스가 ParameterizedType인 경우
            if (genericInterface instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericInterface; // ParameterizedType으로 캐스팅
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments(); // 제네릭 타입 인수를 가져옴, ex)Repository<Entry>의 경우 Entry

                // 제네릭 타입 인수가 있는 경우
                if (actualTypeArguments.length > 0) {
                    return (Class<?>) actualTypeArguments[0]; // 첫 번째 제네릭 타입 인수를 도메인 클래스로 반환
                }
            }
        }

        return null; // 도메인 클래스를 찾지 못한 경우 null 반환
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

        for (Cell cell : includeRow) {
            includeInConstructor.add("1".equals(formatter.formatCellValue(cell)));
        }

        for (Cell cell : typeRow) {
            dataTypes.add(formatter.formatCellValue(cell));
        }

        for (Cell cell : headerRow) {
            columnNames.add(formatter.formatCellValue(cell));
        }

        List<List<String>> allData = new ArrayList<>();

        for (int i = 3; i <= sheet.getLastRowNum(); i++) {
            Row currentRow = sheet.getRow(i);
            List<String> rowData = new ArrayList<>();
            for (int j = 0; j < currentRow.getLastCellNum(); j++) {
                rowData.add(formatter.formatCellValue(currentRow.getCell(j)));
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

        if (clazz == null) {
            System.err.println("클래스를 찾을 수 없습니다: " + tableName);
            return;
        }

        System.out.println("\n처리 중인 시트: " + tableName);

        for (List<String> rowData : allData) {
            try {
                Object entity = createEntity(clazz, includeInConstructor, columnNames, dataTypes, rowData);
                Method saveMethod = repository.getClass().getMethod("save", clazz);
                saveMethod.invoke(repository, entity);
                System.out.println("저장된 엔티티: " + entity);
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

        for (int i = 0; i < includeInConstructor.size(); i++) {
            if (includeInConstructor.get(i)) {
                Class<?> type = getTypeFromString(dataTypes.get(i));
                Object value = type.isEnum() ? Enum.valueOf((Class<Enum>) type, rowData.get(i)) : convertValue(rowData.get(i), type);
                paramTypesList.add(type);
                paramValuesList.add(value);
            }
        }


        Class<?>[] paramTypesArray = paramTypesList.toArray(new Class<?>[0]);

        Constructor<?> matchedConstructor = null;
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

        for (int i = 0; i < columnNames.size(); i++) {
            if (!includeInConstructor.get(i)) {
                String columnName = columnNames.get(i);
                String value = rowData.get(i);

                try {
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    Class<?> fieldType = field.getType();
                    Object convertedValue = fieldType.isEnum() ? Enum.valueOf((Class<Enum>) fieldType, value) : convertValue(value, fieldType);
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
            case "enum": return Enum.class;
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