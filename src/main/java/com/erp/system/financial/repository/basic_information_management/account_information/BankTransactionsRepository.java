package com.erp.system.financial.repository.basic_information_management.account_information;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccounts;
import com.erp.system.financial.model.basic_information_management.account_information.BankTransactions;

/**
 * 은행 거래 엔티티에 대한 리포지토리 인터페이스.
 */
public interface BankTransactionsRepository extends GenericRepository<BankTransactions> {
    @Override
    void save(BankTransactions entity);
}