package com.erp.system.common.generic_repository.impl;

import com.erp.system.common.generic_repository.GenericRepository;

import java.lang.reflect.Field;
import java.util.*;

import static com.erp.system.common.Rules.ID_FIELD_NAME;

/**
 * 모든 유형의 엔티티에 대한 공통 메서드를 제공하는 제네릭 리포지토리 구현 클래스.
 * @param <T> 엔티티 유형
 */
public class GenericRepositoryImpl<T> implements GenericRepository<T> {

    private final Map<String, T> store = new HashMap<>(); // ID로 엔티티를 저장할 맵
    private final Class<T> entityClass; // 엔티티 클래스 타입

    /**
     * protected 생성자. 싱글톤 패턴 적용.
     * @param entityClass 엔티티 클래스 타입
     */
    protected GenericRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * 엔티티를 저장함.
     * @param entity 저장할 엔티티
     */
    @Override
    public void save(T entity) {
        try {
            String id = getFieldValue(entity, ID_FIELD_NAME);
            if (store.containsKey(id)) {
                throw new IllegalArgumentException("이미 존재하는 ID입니다: " + id);
            }

            store.put(id, entity);
        } catch (Exception e) {
            throw new RuntimeException("Entity 저장 실패", e);
        }
    }

    /**
     * ID로 엔티티를 조회함.
     * @param id 엔티티의 ID
     * @return 조회된 엔티티를 Optional로 반환
     */
    @Override
    public Optional<T> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    /**
     * 엔티티를 업데이트함.
     * @param entity 업데이트할 엔티티
     */
    @Override
    public void update(T entity) {
        try {
            String id = getFieldValue(entity, ID_FIELD_NAME);
            if (store.containsKey(id)) {
                store.put(id, entity);

            } else {
                throw new RuntimeException("Entity 를 찾을 수 없습니다. : " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Entity 수정을 실패했습니다. : ", e);
        }
    }

    /**
     * ID로 엔티티를 삭제함.
     * @param id 삭제할 엔티티의 ID
     */
    @Override
    public void delete(String id) {
        try {
            T entity = store.remove(id);
        } catch (Exception e) {
            throw new RuntimeException("Entity 삭제를 실패했습니다. : ", e);
        }
    }

    /**
     * 모든 엔티티를 조회함.
     * @return 저장된 모든 엔티티
     */
    @Override
    public List<T> findAll() {
        return new ArrayList<>(store.values());
    }

    /**
     * 엔티티 객체에서 특정 필드 값을 추출함.
     * 리플렉션을 사용하여 필드 값을 동적으로 가져옴.
     * @param entity 필드 값을 추출할 엔티티 객체
     * @param fieldName 추출할 필드 이름
     * @return 추출된 필드 값
     * @throws NoSuchFieldException 필드를 찾을 수 없는 경우
     * @throws IllegalAccessException 필드 접근이 불가능한 경우
     */

    @SuppressWarnings("unchecked")
    private <V> V getFieldValue(T entity, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = entityClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        return (V) field.get(entity);
    }

    /**
     * 엔티티에 특정 필드가 존재하는지 확인함.
     * @param entity 필드 존재 여부를 확인할 엔티티 객체
     * @param fieldName 확인할 필드 이름
     * @return 필드가 존재하면 true, 그렇지 않으면 false
     */
    private boolean hasField(T entity, String fieldName) {
        try {
            entityClass.getDeclaredField(fieldName);
            return true;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

    /**
     * 저장된 모든 엔티티를 초기화함.
     */
    @Override
    public void reset() {
        store.clear();
    }
}