package com.erp.system.financial.repository.basic_information_management.company_registration;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.company_registration.CorporateType;
import com.erp.system.financial.model.basic_information_management.company_registration.Representative;

import java.util.List;

/**
 * 회사 대표자 정보 엔티티에 대한 리포지토리 인터페이스.
 */
public interface RepresentativeRepository extends GenericRepository<Representative> {
    @Override
    void save(Representative entity);

    @Override
    List<Representative> findAll();
}