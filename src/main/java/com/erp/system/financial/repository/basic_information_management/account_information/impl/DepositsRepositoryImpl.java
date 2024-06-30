package com.erp.system.financial.repository.basic_information_management.account_information.impl;

import com.erp.system.common.DependencyInjector;
import com.erp.system.common.HashJoin;
import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccount;
import com.erp.system.financial.model.basic_information_management.account_information.BankTransaction;
import com.erp.system.financial.model.basic_information_management.account_information.Deposit;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.repository.basic_information_management.account_information.BankAccountRepository;
import com.erp.system.financial.repository.basic_information_management.account_information.BankTransactionRepository;
import com.erp.system.financial.repository.basic_information_management.account_information.DepositRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class DepositsRepositoryImpl extends GenericRepositoryImpl<Deposit> implements DepositRepository {
    private DepositsRepositoryImpl() {
        super(Deposit.class);
    }
}