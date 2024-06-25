package com.erp.system.financial.repository.basic_information_management.company_registration;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.company_registration.Address;
import com.erp.system.financial.model.basic_information_management.company_registration.Company;

import java.util.List;

/**
 * 회사 기본 정보 엔티티에 대한 리포지토리 인터페이스.
 */
public interface CompanyRepository extends GenericRepository<Company> {
    @Override
    void save(Company entity);

    @Override
    List<Company> findAll();
}