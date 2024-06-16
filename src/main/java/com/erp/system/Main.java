package com.erp.system;


import com.erp.system.common.DependencyInjector;
import com.erp.system.financial.controller.basic_information_management.PurchaseSalesSlipController;
import com.erp.system.common.ERPDataInitializer;
import com.erp.system.financial.controller.basic_information_management.TaxInvoiceController;
import com.erp.system.financial.controller.book_keeping.AccountingLedgerController;

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

        printAllEntities(purchaseSalesSlipController.findAllEntries(), "code"); // Entry 출력
        printAllEntities(purchaseSalesSlipController.findAllVatTypes(), "code"); // VatType 출력
        printAllEntities(accountingLedgerController.findAllCashBooks(), "code"); // CashBook 출력
        printAllEntities(taxInvoiceController.findAllTaxInvoices(), "code"); // TaxInvoice 출력

        taxInvoiceController.findAllTaxInvoices().forEach(taxInvoice -> {
            System.out.println(taxInvoice.getNtsTransmissionStatus().getClass()); // enum 확인
        });


    }
}