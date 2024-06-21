package com.erp.system.common.generic_repository;

import java.util.List;
import java.util.Optional;

/**
 * 모든 유형의 엔티티에 대한 공통 메서드를 제공하는 제네릭 리포지토리 인터페이스.
 * @param <T> 엔티티 유형
 */
public interface GenericRepository<T> {

    void save(T entity);

    Optional<T> findById(String id);
    List<T> findAll();

    void update(T entity);

    void delete(String id);

    void reset();
}