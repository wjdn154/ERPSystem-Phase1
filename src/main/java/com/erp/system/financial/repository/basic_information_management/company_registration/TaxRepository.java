package com.erp.system.financial.repository.basic_information_management.company_registration;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.company_registration.TaxOffice;

import java.util.List;

/**
 * 세무 정보 엔티티에 대한 리포지토리 인터페이스.
 */
public interface TaxRepository extends GenericRepository<TaxOffice> {
    @Override
    void save(TaxOffice entity);

    @Override
    List<TaxOffice> findAll();
}