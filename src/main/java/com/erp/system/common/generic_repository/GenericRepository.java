package com.erp.system.common.generic_repository;

import java.util.List;
import java.util.Optional;

/**
 * 모든 유형의 엔티티에 대한 공통 메서드를 제공하는 제네릭 리포지토리 인터페이스.
 * @param <T> 엔티티 유형
 * @param <ID> 엔티티의 식별자 유형
 * @param <Code> 엔티티의 코드 유형
 */
public interface GenericRepository<T, ID, Code> {

    /**
     * 엔티티를 저장함.
     * @param entity 저장할 엔티티
     */
    void save(T entity);

    /**
     * 식별자로 엔티티를 찾음.
     * @param id 엔티티의 식별자
     * @return 찾은 엔티티를 Optional로 반환
     */
    Optional<T> findByIdOrCode(ID id);

    /**
     * 식별자 또는 코드로 엔티티를 찾음.
     * @param id 엔티티의 식별자
     * @param code 엔티티의 코드
     * @return 찾은 엔티티를 Optional로 반환
     */
    Optional<T> findByIdOrCode(ID id, Code code);

    /**
     * 엔티티를 업데이트함.
     * @param entity 업데이트할 엔티티
     */
    void update(T entity);

    /**
     * 식별자로 엔티티를 삭제함.
     * @param id 삭제할 엔티티의 식별자
     */
    void delete(ID id);

    /**
     * 모든 엔티티를 찾음.
     * @return 모든 엔티티의 리스트
     */
    List<T> findAll();

    /**
     * 저장된 모든 엔티티를 초기화함.
     */
    void reset();
}