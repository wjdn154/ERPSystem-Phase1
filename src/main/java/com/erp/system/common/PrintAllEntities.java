package com.erp.system.common;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 엔티티 컬렉션을 정렬하고 출력하는 유틸리티 클래스.
 */
public class PrintAllEntities {

    /**
     * 엔티티 컬렉션을 정렬하여 출력함
     *
     * @param entities    출력할 엔티티 컬렉션
     * @param sortByField 정렬 기준이 되는 필드 이름
     * @param <T>         엔티티 타입
     */
    public static <T> void printAllEntities(Collection<T> entities, String sortByField) {
        entities.stream()
                .sorted((e1, e2) -> {
                    try {
                        // 정렬 기준 필드를 가져옴
                        Field field1 = e1.getClass().getDeclaredField(sortByField);
                        field1.setAccessible(true);
                        Field field2 = e2.getClass().getDeclaredField(sortByField);
                        field2.setAccessible(true);

                        // 필드 값을 Integer로 변환하여 비교
                        Integer value1 = Integer.parseInt(String.valueOf(field1.get(e1)));
                        Integer value2 = Integer.parseInt(String.valueOf(field2.get(e2)));

                        return Integer.compare(value1, value2);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .forEach(entity -> {
                    String output = formatEntity(entity);
                    // 출력 문자열 생성
                    System.out.println(output);
                });
        System.out.println("----------------------------------------------------------------");
    }

    /**
     * 엔티티를 형식화하여 문자열로 반환함
     *
     * @param entity 형식화할 엔티티
     * @param <T>    엔티티 타입
     * @return 형식화된 엔티티 문자열
     */
    private static <T> String formatEntity(T entity) {
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> !field.getName().equalsIgnoreCase("idIndex"))
                .map(field -> {
                    field.setAccessible(true);
                    try {
                        return field.getName() + ": " + field.get(entity);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return "";
                    }
                })
                .collect(Collectors.joining(", ", "[", "]"));
    }
}