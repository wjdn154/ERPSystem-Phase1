package com.erp.system.financial.service.basic_information_management;

import com.erp.system.financial.model.basic_information_management.account_information.BankAccount;
import com.erp.system.financial.model.basic_information_management.account_information.BankTransaction;
import com.erp.system.financial.model.basic_information_management.account_information.Deposit;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;

import java.util.Collection;
import java.util.Optional;

public interface AccountInformationService {
    void saveBankAccount(BankAccount bankAccount);
    void saveBankTransaction(BankTransaction bankTransaction);
    void saveDeposit(Deposit deposit);

    Optional<BankAccount> findBankAccountById(String id);
    Optional<BankAccount> findBankAccountByCode(String code);
    Optional<BankTransaction> findBankTransactionById(String id);
    Optional<BankTransaction> findBankTransactionByCode(String code);
    Optional<Deposit> findDepositById(String id);
    Optional<Deposit> findDepositByCode(String code);

    Collection<BankAccount> findAllBankAccounts();
    Collection<BankTransaction> findAllBankTransactions();
    Collection<Deposit> findAllDeposits();
}