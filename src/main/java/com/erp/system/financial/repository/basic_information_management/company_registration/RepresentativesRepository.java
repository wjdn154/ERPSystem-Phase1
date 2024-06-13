package com.erp.system.financial.repository.basic_information_management.company_registration;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccounts;
import com.erp.system.financial.model.basic_information_management.company_registration.Representatives;

/**
 * 회사 대표자 정보 엔티티에 대한 리포지토리 인터페이스.
 */
public interface RepresentativesRepository extends GenericRepository<Representatives> {
    @Override
    void save(Representatives entity);
}