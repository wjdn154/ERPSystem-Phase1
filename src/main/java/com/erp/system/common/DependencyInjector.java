package com.erp.system.common;

import com.erp.system.financial.controller.basic_information_management.purchase_sales_slip.EntriesController;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntriesRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl.EntriesRepositoryImpl;
import com.erp.system.financial.service.basic_information_management.purchase_sales_slip.EntriesService;
import com.erp.system.financial.service.basic_information_management.purchase_sales_slip.impl.EntriesServiceImpl;

public class DependencyInjector {

    // Repository 인스턴스 생성
    public static EntriesRepository createEntriesRepository() {
        return EntriesRepositoryImpl.getInstance();
    }

    // Service 인스턴스 생성
    public static EntriesService createEntriesService() {
        return EntriesServiceImpl.getInstance(createEntriesRepository());
    }

    // Controller 인스턴스 생성
    public static EntriesController createEntriesController() {
        return EntriesController.getInstance(createEntriesService());
    }

}
