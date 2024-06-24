package com.erp.system.common;

import com.erp.system.common.annotation.EnumMapping;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.reflections.Reflections;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.erp.system.common.Rules.*;

/**
 * Excel 파일을 읽고 각 시트의 데이터를 처리하는 클래스.
 */
public class ERPDataInitializer {
    private final DependencyInjector di = DependencyInjector.getInstance();
    private final Map<String, Class<?>> tableClassMap = new HashMap<>();
    private final Map<Class<?>, Object> repositories = new HashMap<>();

    /**
     * ERPDataInitializer 생성자.
     */
    public ERPDataInitializer() {
        System.out.println("--------------------------- 2. ERPDataInitializer 생성 ---------------------------");
        long startTime = System.nanoTime(); // 시작 시간 기록
        autoRegister();
        readExcel(FINANCIAL_ACCOUNTING_DATA_FILE_PATH); // 회계 데이터
//        readExcel(HUMAN_RESOURCES_DATA_FILE_PATH); // 인사 데이터
//        readExcel(LOGISTICS_DATA_FILE_PATH); // 물류 데이터
//        readExcel(PRODUCTION_DATA_FILE_PATH); // 생산 데이터
        long endTime = System.nanoTime(); // 종료 시간 기록
        long duration = endTime - startTime; // 실행 시간 계산
        System.out.println("\n실행 시간: " + duration / 1_000_000 + " ms");
        System.out.println("--------------------------- 2. ERPDataInitializer 종료 ---------------------------\n");
    }

    /**
     * 모든 컴포넌트를 자동으로 등록하고 매핑을 설정함.
     */
    private void autoRegister() {
        Map<Class<?>, Object> allRepositories = di.getAllInstancesOfType(Object.class); // 모든 리포지토리를 가져옴

        // 모든 리포지토리를 순회하며 처리함
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
     * 리포지토리 클래스에서 도메인 클래스를 추론함.
     * @param repositoryClass 리포지토리 클래스
     * @return 도메인 클래스
     */
    private Class<?> getDomainClassFromRepository(Class<?> repositoryClass) {
        Type[] genericInterfaces = repositoryClass.getGenericInterfaces(); // 리포지토리 클래스의 제네릭 인터페이스를 가져옴

        // 제네릭 인터페이스를 순회
        for (Type genericInterface : genericInterfaces) {
            // 제네릭 인터페이스가 ParameterizedType인 경우
            if (genericInterface instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericInterface; // ParameterizedType으로 캐스팅
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments(); // 제네릭 타입 인수를 가져옴

                // 제네릭 타입 인수가 있는 경우
                if (actualTypeArguments.length > 0) {
                    return (Class<?>) actualTypeArguments[0]; // 첫 번째 제네릭 타입 인수를 도메인 클래스로 반환
                }
            }
        }

        return null; // 도메인 클래스를 찾지 못한 경우 null 반환
    }

    /**
     * Excel 파일을 읽음.
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
     * 각 시트를 처리함.
     * 시트 내의 데이터를 읽어 엔티티 객체로 변환 후 저장
     * @param sheet 처리할 Excel 시트 객체
     */
    public void handleSheet(Sheet sheet) {
        Row typeRow = sheet.getRow(0); // 첫 번째 행에서 데이터 타입을 읽음
        Row headerRow = sheet.getRow(1); // 두 번째 행에서 컬럼 이름을 읽음

        List<String> dataTypes = new ArrayList<>(); // 데이터 타입 리스트
        List<String> columnNames = new ArrayList<>(); // 컬럼 이름 리스트

        DataFormatter formatter = new DataFormatter(); // 셀 값을 문자열로 변환하는 포맷터

        for (Cell cell : typeRow) {
            dataTypes.add(formatter.formatCellValue(cell)); // 데이터 타입을 리스트에 추가
        }

        for (Cell cell : headerRow) {
            columnNames.add(formatter.formatCellValue(cell)); // 컬럼 이름을 리스트에 추가
        }

        List<List<String>> allData = new ArrayList<>(); // 모든 데이터 리스트

        for (int i = 2; i <= sheet.getLastRowNum(); i++) { // 세 번째 행부터 데이터를 읽음
            Row currentRow = sheet.getRow(i);
            List<String> rowData = new ArrayList<>();
            for (int j = 0; j < currentRow.getLastCellNum(); j++) {
                rowData.add(formatter.formatCellValue(currentRow.getCell(j))); // 각 셀의 값을 문자열로 변환하여 리스트에 추가
            }
            allData.add(rowData); // 한 행의 데이터를 리스트에 추가
        }

        saveEntity(sheet, columnNames, dataTypes, allData); // 엔티티를 저장
    }

    /**
     * 엔티티를 생성하고 저장함.
     * @param sheet 시트 객체
     * @param columnNames 컬럼 이름 리스트
     * @param dataTypes 데이터 타입 리스트
     * @param allData 모든 데이터 리스트
     */
    private void saveEntity(Sheet sheet, List<String> columnNames, List<String> dataTypes, List<List<String>> allData) {
        String tableName = sheet.getSheetName(); // 시트 이름을 테이블 이름으로 사용
        Class<?> clazz = tableClassMap.get(tableName); // 테이블 이름으로 도메인 클래스 조회
        Object repository = repositories.get(clazz); // 도메인 클래스로 리포지토리 조회

        if (clazz == null) {
            System.err.println("클래스를 찾을 수 없습니다: " + tableName); // 클래스를 찾을 수 없는 경우 에러 메시지 출력
            return;
        }

        System.out.println("\n처리 중인 시트: " + tableName); // 처리 중인 시트 이름 출력

        for (List<String> rowData : allData) {
            try {
                Object entity = createEntity(clazz, columnNames, dataTypes, rowData); // 엔티티 생성
                Method saveMethod = repository.getClass().getMethod("save", clazz); // 리포지토리의 save 메서드 조회
                saveMethod.invoke(repository, entity); // 엔티티를 리포지토리에 저장
                System.out.println("저장된 엔티티: " + entity); // 저장된 엔티티 출력
            } catch (Exception e) {
                System.out.println("엔티티 생성 또는 저장 오류: " + e.getMessage()); // 엔티티 생성 또는 저장 오류 메시지 출력
                e.printStackTrace();
            }
        }
    }

    /**
     * 엔티티 객체를 생성함.
     * @param clazz 클래스 객체
     * @param columnNames 컬럼 이름 리스트
     * @param dataTypes 데이터 타입 리스트
     * @param rowData 행 데이터 리스트
     * @return 생성된 엔티티 객체
     * @throws ReflectiveOperationException 리플렉션 작업 중 발생하는 예외
     * @throws ParseException 날짜 파싱 예외
     */
    private Object createEntity(Class<?> clazz, List<String> columnNames, List<String> dataTypes, List<String> rowData) throws ReflectiveOperationException, ParseException {
        // Builder 클래스 조회
        Class<?> builderClass = Arrays.stream(clazz.getDeclaredClasses())
                .filter(cl -> cl.getSimpleName().equals("Builder"))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(clazz.getSimpleName() + " 클래스에 Builder 클래스가 존재하지 않습니다."));

        // Builder 생성자 조회 및 인스턴스 생성
        Constructor<?> constructor = builderClass.getDeclaredConstructors()[0]; // 첫 번째 생성자를 사용
        constructor.setAccessible(true);

        // 생성자에 필요한 매개변수 추출 및 값 할당
        Class<?>[] paramTypes = constructor.getParameterTypes();
        Object[] constructorArgs = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            int paramIndex = columnNames.indexOf(columnNames.get(i));
            if (paramIndex == -1) {
                throw new IllegalArgumentException("매개변수 " + columnNames.get(i) + "에 대한 컬럼을 찾을 수 없습니다.");
            }
            constructorArgs[i] = convertValue(rowData.get(paramIndex), paramTypes[i], clazz.getSimpleName());
        }

        // Builder 인스턴스 생성
        Object builder = constructor.newInstance(constructorArgs);

        // 나머지 선택적 필드 설정
        for (int i = 0; i < columnNames.size(); i++) {
            if (Arrays.asList(constructorArgs).contains(rowData.get(i))) continue; // 이미 생성자에서 사용된 필드는 건너뜀
            String methodName = columnNames.get(i);
            Class<?> fieldType = getTypeFromString(dataTypes.get(i));
            Object value = convertValue(rowData.get(i), fieldType, clazz.getSimpleName());
            Method setterMethod = findBuilderMethod(builder.getClass(), methodName, fieldType);
            setterMethod.invoke(builder, value);
        }

        // build 메서드를 호출하여 최종 객체 생성
        Method buildMethod = builderClass.getMethod("build");
        return buildMethod.invoke(builder);
    }

    /**
     * Builder 클래스의 필드를 설정하는 메서드를 찾는 메서드.
     * @param builderClass Builder 클래스
     * @param fieldName 필드 이름
     * @param parameterType 매개변수 타입
     * @return 필드를 설정하는 메서드
     * @throws NoSuchMethodException 메서드를 찾지 못한 경우
     */
    private Method findBuilderMethod(Class<?> builderClass, String fieldName, Class<?> parameterType) throws NoSuchMethodException {
        for (Method method : builderClass.getMethods()) {
            if (method.getName().equalsIgnoreCase(fieldName) && method.getParameterTypes().length == 1) {
                Class<?> methodParamType = method.getParameterTypes()[0];
                if (methodParamType.equals(parameterType) || methodParamType.isEnum()) {
                    return method;
                }
            }
        }
        System.out.println(fieldName + "에 대한 빌더 메서드를 " + parameterType.getSimpleName() + " 타입으로 찾지 못했습니다.");
        throw new NoSuchMethodException(builderClass.getName() + " 클래스의 빌더에서 " + fieldName + "에 대한 적절한 메서드를 찾을 수 없습니다.");
    }


    /**
     * 문자열로부터 클래스 타입을 반환하는 메서드.
     * @param typeStr 타입 문자열
     * @return 클래스 타입
     */
    private Class<?> getTypeFromString(String typeStr) {
        switch (typeStr.toLowerCase()) {
            case "string": return String.class;
            case "int": return Integer.class;
            case "boolean": return Boolean.class;
            case "double": return Double.class;
            case "localdate": return LocalDate.class;
            case "localdatetime": return LocalDateTime.class;
            case "bigdecimal": return BigDecimal.class;
            case "enum": return Enum.class;
            default: throw new IllegalArgumentException("지원하지 않는 타입: " + typeStr);
        }
    }

    /**
     * 문자열 값을 특정 타입으로 변환하는 메서드.
     * @param value 문자열 값
     * @param expectedType 변환할 클래스 타입
     * @param className 현재 클래스 이름
     * @return 변환된 객체
     * @throws ParseException 날짜 파싱 예외
     * @throws ClassNotFoundException 클래스 로드 예외
     */
    private Object convertValue(String value, Class<?> expectedType, String className) throws ParseException, ClassNotFoundException {
        if (value == null || value.isEmpty()) return null;
        if (expectedType == String.class) return value;
        if (expectedType == Integer.class || expectedType == int.class) return Integer.parseInt(value);
        if (expectedType == Boolean.class || expectedType == boolean.class) return Boolean.parseBoolean(value);
        if (expectedType == Double.class || expectedType == double.class) return Double.parseDouble(value);
        if (expectedType == BigDecimal.class) return new BigDecimal(value);
        if (expectedType == LocalDate.class) return LocalDate.parse(value, DateTimeFormatter.ofPattern("M/d/yy"));
        if (expectedType == LocalDateTime.class) return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        if (Enum.class.isAssignableFrom(expectedType)) {
            String[] parts = value.split("\\.");
            if (parts.length < 2) throw new IllegalArgumentException("Enum 값은 'EnumClassName.EnumValue' 형태여야 합니다: " + value);

            String enumClassName = parts[0];
            String enumValue = parts[1];

            // 어노테이션을 사용하여 클래스 경로 찾기
            Class<?> clazz = findClassBySheetName(className);
            if (clazz == null) throw new ClassNotFoundException("클래스를 찾을 수 없습니다: " + className);

            // 해당 클래스 내부에 선언된 enum을 동적으로 로드
            for (Class<?> innerClass : clazz.getDeclaredClasses()) {
                if (innerClass.getSimpleName().equals(enumClassName) && Enum.class.isAssignableFrom(innerClass)) {
                    return Enum.valueOf((Class<Enum>) innerClass, enumValue);
                }
            }
            throw new ClassNotFoundException("해당 enum 클래스가 존재하지 않습니다: " + enumClassName);
        }

        throw new IllegalArgumentException("지원하지 않는 타입 변환: " + expectedType.getSimpleName());
    }

    /**
     * 시트명을 기반으로 클래스를 찾음.
     * @param sheetName 시트명
     * @return 해당 시트명을 가진 클래스
     */
    private Class<?> findClassBySheetName(String sheetName) {
        Reflections reflections = new Reflections(PACKAGE_PATH); // 패키지 경로
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(EnumMapping.class);

        for (Class<?> clazz : annotatedClasses) {
            EnumMapping annotation = clazz.getAnnotation(EnumMapping.class);
            if (annotation != null && clazz.getSimpleName().equals(sheetName)) {
                return clazz;
            }
        }
        return null;
    }

}