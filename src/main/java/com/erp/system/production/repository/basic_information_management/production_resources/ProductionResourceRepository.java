package com.erp.system.production.repository.basic_information_management.production_resources;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.basic_information_management.production_resources.ProductionResource;

import java.util.List;

/**
 * 생산자원 기본정보 엔티티 리포지터리 인터페이스
 */

public interface ProductionResourceRepository extends GenericRepository<ProductionResource> {
    @Override
    void save(ProductionResource entity);

    @Override
    List<ProductionResource>findAll();
}
