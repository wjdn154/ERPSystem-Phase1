package com.erp.system;


import com.erp.system.common.DependencyInjector;
import com.erp.system.financial.controller.basic_information_management.AccountInformationController;
import com.erp.system.financial.controller.basic_information_management.PurchaseSalesSlipController;
import com.erp.system.common.ERPDataInitializer;
import com.erp.system.financial.controller.basic_information_management.TaxInvoiceController;
import com.erp.system.financial.controller.book_keeping.AccountingLedgerController;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccount;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.repository.basic_information_management.account_information.BankAccountRepository;

import java.util.Optional;

import static com.erp.system.common.PrintAllEntities.printAllEntities;

public class Main {
    public static void main(String[] args) throws Exception {

        DependencyInjector injector = DependencyInjector.getInstance();

        // ERPSystem 초기 데이터 생성
        new ERPDataInitializer();


        // Controller 인스턴스 생성
        PurchaseSalesSlipController purchaseSalesSlipController = injector.getInstance(PurchaseSalesSlipController.class);
        AccountingLedgerController accountingLedgerController = injector.getInstance(AccountingLedgerController.class);
        TaxInvoiceController taxInvoiceController = injector.getInstance(TaxInvoiceController.class);
        AccountInformationController accountInformationController = injector.getInstance(AccountInformationController.class);

        printAllEntities(purchaseSalesSlipController.findAllEntries(), "code"); // Entry 출력
        printAllEntities(purchaseSalesSlipController.findAllVatTypes(), "code"); // VatType 출력
        printAllEntities(accountingLedgerController.findAllCashBooks(), "code"); // CashBook 출력
        printAllEntities(taxInvoiceController.findAllTaxInvoices(), "code"); // TaxInvoice 출력


        // 테스트 객체 생성
        BankAccount BA = new BankAccount.Builder()
                .code("1")
                .bankName("original")
                .branchLocation("this.branchLocation")
                .number("this.number")
                .owner("this.owner")
                .depositType("this.depositType")
                .build();
        BankAccount BA2 = new BankAccount.Builder()
                .code("2")
                .bankName("original")
                .branchLocation("this.branchLocation")
                .number("this.number")
                .owner("this.owner")
                .depositType("this.depositType")
                .build();

        // 저장
        accountInformationController.saveBankAccount(BA); 
        accountInformationController.saveBankAccount(BA2);

        // 수정 전 조회
        printAllEntities(accountInformationController.findAllBankAccounts(), "code");
        
        BankAccountRepository bankAccountRepository = injector.getInstance(BankAccountRepository.class);
        
        // 객체 수정
        BankAccount bankAccount = bankAccountRepository.findByCode("2").get();
        bankAccount.toBuilder().bankName("바꿧어요~~").build();

        System.out.println("bankAccount = " + bankAccount.getBank_name());

        // 수정된 객체 업데이트
        bankAccountRepository.update(bankAccount);
        
        // 수정 후 조회
        printAllEntities(accountInformationController.findAllBankAccounts(), "code");
    }
}