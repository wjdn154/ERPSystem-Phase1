package com.erp.system;


import com.erp.system.financial.controller.basic_information_management.purchase_sales_slip.EntriesController;
import com.erp.system.financial.controller.basic_information_management.purchase_sales_slip.VatTypesController;
import com.erp.system.common.ERPDataInitializer;

public class Main {
    public static void main(String[] args) {
        // ERPDataInitializer를 통해 Excel 파일을 읽어 데이터 초기화
        new ERPDataInitializer("src/main/resources/data.xlsx");

        // Controller 인스턴스 생성
        EntriesController entriesController = EntriesController.getInstance();
        VatTypesController vatTypesController = VatTypesController.getInstance();


        System.out.println("--------------------------------");
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
    }
}