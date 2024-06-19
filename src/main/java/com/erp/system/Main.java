package com.erp.system;


import com.erp.system.common.DependencyInjector.DependencyInjector;
import com.erp.system.financial.controller.basic_information_management.PurchaseSalesSlipController;
import com.erp.system.common.ERPDataInitializer;
import com.erp.system.financial.controller.basic_information_management.TaxInvoiceController;
import com.erp.system.financial.controller.book_keeping.AccountingLedgerController;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccount;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import static com.erp.system.common.PrintAllEntities.printAllEntities;

public class Main {
    public static void main(String[] args) throws Exception {
//
//        DependencyInjector injector = DependencyInjector.getInstance();
//
//        // ERPSystem 초기 데이터 생성
//        new ERPDataInitializer();


        BankAccount BA = new BankAccount.Builder()  // 기존 객체
                .code("1")
                .branchLocation("")
                .bankName("original")
                .number("바뀌기 전이에요~~")
                .build();

        System.out.println(BA.getId()+ " " + BA.getCode() + " " + BA.getBankName() + " " + BA.getNumber());

        BA = BA.tobuild()       // 기존 객체에서 변경된 객체
                .bankName("Modify")
                .number("바꿧어요~~")
                .build();


        System.out.println(BA.getId()+ " " + BA.getCode() + " " + BA.getBankName() + " " + BA.getNumber());

//        // Controller 인스턴스 생성
//        PurchaseSalesSlipController purchaseSalesSlipController = injector.getInstance(PurchaseSalesSlipController.class);
//        AccountingLedgerController accountingLedgerController = injector.getInstance(AccountingLedgerController.class);
//        TaxInvoiceController taxInvoiceController = injector.getInstance(TaxInvoiceController.class);
//
//
//        printAllEntities(purchaseSalesSlipController.findAllEntries(), "code"); // Entry 출력
//        printAllEntities(purchaseSalesSlipController.findAllVatTypes(), "code"); // VatType 출력
//        printAllEntities(accountingLedgerController.findAllCashBooks(), "code"); // CashBook 출력
//        printAllEntities(taxInvoiceController.findAllTaxInvoices(), "code"); // TaxInvoice 출력
//
//        taxInvoiceController.findAllTaxInvoices().forEach(taxInvoice -> {
//            System.out.println(taxInvoice.getNtsTransmissionStatus().getClass()); // enum 확인
//        });
    }
}