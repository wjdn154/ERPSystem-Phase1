package com.erp.system.financial.repository.basic_information_management.company_registration;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccounts;
import com.erp.system.financial.model.basic_information_management.company_registration.CorporateKinds;

/**
 * 법인종류 엔티티에 대한 리포지토리 인터페이스.
 */
public interface CorporateKindsRepository extends GenericRepository<CorporateKinds> {
    @Override
    void save(CorporateKinds entity);
}