package com.erp.system.production.repository.basic_information_management.factory;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.basic_information_management.factory.Factory;

import java.util.List;

/**
 * 공장 기본 정보 엔티티 리포지토리 IF
 */
public interface FactoryRepository extends GenericRepository<Factory> {
    @Override
    void save(Factory entity);

    @Override
    List<Factory>findAll();
}
