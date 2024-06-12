package com.erp.system;


import com.erp.system.common.DependencyInjector;
import com.erp.system.financial.controller.basic_information_management.purchase_sales_slip.EntriesController;
import com.erp.system.financial.controller.basic_information_management.purchase_sales_slip.VatTypesController;
import com.erp.system.common.ERPDataInitializer;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.CashBookRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntriesRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl.CashBookRepositoryImpl;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl.EntriesRepositoryImpl;
import com.erp.system.financial.service.basic_information_management.purchase_sales_slip.impl.EntriesServiceImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        // ERPSystem 초기 데이터 생성
        new ERPDataInitializer();

        DependencyInjector di = new DependencyInjector();

        // EntriesRepositoryImpl 싱글톤 인스턴스 등록
        di.register(EntriesRepositoryImpl.class, EntriesRepositoryImpl::getInstance);

        // EntriesServiceImpl 의존성을 등록, EntriesRepositoryImpl 필요
        di.register(EntriesServiceImpl.class, () -> new EntriesServiceImpl(di.resolve(EntriesRepositoryImpl.class)));

        // EntriesController 의존성을 등록, EntriesServiceImpl 필요
        di.register(EntriesController.class, () -> new EntriesController(di.resolve(EntriesServiceImpl.class)));

        // 컨트롤러를 통해 서비스와 레포지토리 기능 사용
        EntriesController controller = di.resolve(EntriesController.class);





        // Controller 인스턴스 생성
        EntriesController entriesController = controller;
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