package com.erp.system;


import com.erp.system.common.DependencyInjector;
import com.erp.system.financial.controller.basic_information_management.purchase_sales_slip.EntriesController;
import com.erp.system.financial.controller.basic_information_management.purchase_sales_slip.VatTypesController;
import com.erp.system.common.ERPDataInitializer;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.CashBookRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl.CashBookRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        // ERPSystem 초기 데이터 생성
        new ERPDataInitializer();


        // Controller 인스턴스 생성
        EntriesController entriesController = EntriesController.getInstance(DependencyInjector.createEntriesService());
        VatTypesController vatTypesController = VatTypesController.getInstance();
        CashBookRepository cashBookRepository = CashBookRepositoryImpl.getInstance();


        entriesController.allEntries().stream()
                .sorted((e1, e2) -> e1.getCode().compareTo(e2.getCode()))
                .forEach(entry -> {
                    System.out.println(entry.getCode() + " : " + entry.getName());
                });
        System.out.println("--------------------------------");

        vatTypesController.allEntries().stream()
                .sorted((v1, v2) -> {
                    int code1 = Integer.parseInt(v1.getCode());
                    int code2 = Integer.parseInt(v2.getCode());
                    return Integer.compare(code1, code2);
                })
                .forEach(vatType -> {
                    System.out.println(vatType.getCode() + " : " + vatType.getCategory() + " : " + vatType.getName());
                });
        System.out.println("--------------------------------");

        cashBookRepository.findAll().stream()
                .sorted((c1, c2) -> c1.getId().compareTo(c2.getId()))
                .forEach(System.out::println);

    }

}