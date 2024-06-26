package com.erp.system.financial.repository.basic_information_management.account_information.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.account_information.Deposit;
import com.erp.system.financial.repository.basic_information_management.account_information.DepositRepository;


@Component
public class DepositsRepositoryImpl extends GenericRepositoryImpl<Deposit> implements DepositRepository {
    private DepositsRepositoryImpl() {
        super(Deposit.class);
    }
}