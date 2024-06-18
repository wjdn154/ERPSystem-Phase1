package com.erp.system.common;

import com.erp.system.common.annotation.NotNull;

import java.lang.reflect.Field;

public class NotNullValidator {
    public static void validateFields(Object obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();
        for (Field field : objClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true); // private 필드 접근을 가능하게 함
                if (field.get(obj) == null) {
                    throw new IllegalArgumentException(field.getName() + "필드는 null 일 수 없습니다.");
                }
            }
        }
    }

    public static void safeValidateFields(Object obj) {
        try {
            validateFields(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("유효성 검사 중 오류 : ", e);
        }
    }
}