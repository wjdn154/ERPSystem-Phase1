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

        DependencyInjector di = DependencyInjector.getInstance();
        setupDependencyInjector(di);

        // Controller 인스턴스 생성
        EntriesController entriesController = di.resolve(EntriesController.class);
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

    private static void setupDependencyInjector(DependencyInjector di) {
        di.register(EntriesRepository.class, EntriesRepositoryImpl::getInstance); // EntriesRepository 인터페이스를 사용하여 의존성 등록
        di.register(EntriesServiceImpl.class, () -> new EntriesServiceImpl(di.resolve(EntriesRepository.class))); // EntriesServiceImpl 생성자에는 EntriesRepository 인터페이스의 인스턴스를 주입
        di.register(EntriesController.class, () -> new EntriesController(di.resolve(EntriesServiceImpl.class))); // EntriesController 생성자에는 EntriesServiceImpl의 인스턴스를 주입
    }

}