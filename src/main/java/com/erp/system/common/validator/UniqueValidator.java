package com.erp.system.common.validator;

import com.erp.system.common.DependencyInjector;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.generic_repository.GenericRepository;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class UniqueValidator {

    /**
     * 객체의 @Unique 애너테이션이 붙은 모든 필드를 검사하여 중복된 값이 있는지 검증.
     * @param obj 검증할 객체
     * @throws IllegalAccessException    필드 접근 권한이 없을 경우 발생
     * @throws NoSuchMethodException     적절한 메소드를 찾지 못했을 때 발생
     * @throws InvocationTargetException 메소드 호출이 올바르게 처리되지 않았을 때 발생
     * @throws NoSuchFieldException      필드를 찾지 못했을 때 발생
     */
    public static void safeValidateFields(Object obj) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> clazz = obj.getClass();
        DependencyInjector injector = DependencyInjector.getInstance();
        GenericRepository<?> repository = (GenericRepository<?>) injector.getInstancesOfType(GenericRepository.class, clazz);

        validateAllUniqueFields(clazz, repository, obj);
    }

    /**
     * 클래스의 모든 Unique 필드에 대한 중복 검사 실행.
     * @param clazz      객체의 클래스
     * @param repository 데이터를 조회할 리포지토리
     * @param obj        검사할 객체 인스턴스
     */
    private static void validateAllUniqueFields(Class<?> clazz, GenericRepository<?> repository, Object obj) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Method findAllMethod = repository.getClass().getMethod("findAll");
        List<?> allEntities = (List<?>) findAllMethod.invoke(repository);

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Unique.class)) {
                field.setAccessible(true);
                Object fieldValue = field.get(obj);
                validateFieldValueUniqueness(field, fieldValue, allEntities);
            }
        }
    }

    /**
     * 단일 필드 값의 유니크함을 확인.
     * @param field       검사할 필드
     * @param fieldValue  검사할 필드의 값
     * @param allEntities 모든 엔티티 데이터
     */
    private static void validateFieldValueUniqueness(Field field, Object fieldValue, List<?> allEntities) throws NoSuchFieldException, IllegalAccessException {
        for (Object entity : allEntities) {
            Field entityField = entity.getClass().getDeclaredField(field.getName());
            entityField.setAccessible(true);
            Object entityFieldValue = entityField.get(entity);
            if (fieldValue != null && fieldValue.equals(entityFieldValue)) {
                throw new IllegalArgumentException(field.getName() + "[" + fieldValue + "] 필드는 Unique 값만 입력할 수 있습니다.");
            }
        }
    }

    /**
     * 주어진 객체의 모든 필드 유효성 검사를 수행하고 예외 처리.
     * @param obj 검사할 객체
     */
    public static void validateFields(Object obj) {
        try {
            safeValidateFields(obj);
        } catch (Exception e) {
            throw new RuntimeException("유효성 검사 중 오류: ", e);
        }
    }
}