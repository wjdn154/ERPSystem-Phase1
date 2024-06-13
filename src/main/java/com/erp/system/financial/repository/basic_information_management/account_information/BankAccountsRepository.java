package com.erp.system.financial.repository.basic_information_management.account_information;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccounts;

/**
 * 은행 계좌 엔티티에 대한 리포지토리 인터페이스.
 */
public interface BankAccountsRepository extends GenericRepository<BankAccounts> {
    @Override
    void save(BankAccounts entity);
}