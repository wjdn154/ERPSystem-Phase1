package com.erp.system.common;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class HashJoin {
    /**
     * 두 리스트를 해시 조인함.
     * 왼쪽과 오른쪽 리스트에 대한 키 추출 함수를 통해 두 리스트를 매칭시켜 조인 결과를 반환함.
     *
     * @param leftList 왼쪽 리스트
     * @param rightList 오른쪽 리스트
     * @param leftKeyExtractor 왼쪽 리스트의 조인 조건 키를 추출하는 함수
     * @param rightKeyExtractor 오른쪽 리스트의 조인 조건 키를 추출하는 함수
     * @return 조인된 결과의 맵을 반환, 각 맵은 조인된 레코드의 속성을 포함함
     */
    public static <T, U, K> List<Map<String, Object>> hashJoin(List<T> leftList, List<U> rightList, Function<T, K> leftKeyExtractor, Function<U, K> rightKeyExtractor) {

        // 오른쪽 리스트를 키로 그룹화하여 해시맵 생성
        Map<K, List<U>> rightMap = rightList.stream().collect(Collectors.groupingBy(rightKeyExtractor));

        List<Map<String, Object>> result = new ArrayList<>();

        // 왼쪽 리스트의 각 요소에 대해 조인 키를 추출하고 매칭된 오른쪽 리스트의 요소와 결합
        leftList.forEach(leftItem -> {
            K leftKey = leftKeyExtractor.apply(leftItem);
            List<U> matchedItems = rightMap.getOrDefault(leftKey, Collections.emptyList());
            matchedItems.forEach(rightItem -> {
                Map<String, Object> joinedRow = new LinkedHashMap<>();
                mergeProperties(joinedRow, leftItem, "");
                mergeProperties(joinedRow, rightItem, rightItem.getClass().getSimpleName() + ".");
                result.add(joinedRow);
            });
        });

        return result;
    }

    /**
     * 주어진 객체의 속성을 맵에 병합함. 필드 이름 앞에 접두사를 붙여서 필드 이름 충돌을 방지함.
     *
     * @param targetMap 속성을 저장할 맵
     * @param source 속성을 추출할 객체
     * @param prefix 필드 이름 앞에 추가할 문자열 접두사
     */
    private static void mergeProperties(Map<String, Object> targetMap, Object source, String prefix) {
        if (source instanceof Map) {
            // source가 Map인 경우, 키-값 쌍을 직접 복사
            ((Map<?, ?>) source).forEach((key, value) -> {
                // idIndex 필드는 무시
                if (!"idIndex".equals(key)) {
                    targetMap.put(prefix + key, value);
                }
            });
        } else {
            // 일반 객체인 경우, 리플렉션을 사용
            Arrays.stream(source.getClass().getDeclaredFields())
                    .filter(field -> !field.getName().equals("idIndex")) // idIndex 필드는 무시
                    .peek(field -> field.setAccessible(true))
                    .forEach(field -> {
                        try {
                            targetMap.put(prefix + field.getName(), field.get(source));
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException("필드 접근 실패", e);
                        }
                    });
        }
    }
}