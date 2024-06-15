package com.erp.system.financial.repository.basic_information_management.account_information;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.account_information.Deposit;

/**
 * 예적금 현황 엔티티에 대한 리포지토리 인터페이스.
 */
public interface DepositRepository extends GenericRepository<Deposit> {
    @Override
    void save(Deposit entity);
}