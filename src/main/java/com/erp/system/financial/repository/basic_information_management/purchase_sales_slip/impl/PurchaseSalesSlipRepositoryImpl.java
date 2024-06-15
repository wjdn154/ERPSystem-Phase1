package com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.PurchaseSalesSlipRepository;

@Component
@Priority(1)
public class PurchaseSalesSlipRepositoryImpl extends GenericRepositoryImpl<PurchaseSalesSlip> implements PurchaseSalesSlipRepository {
    private static volatile PurchaseSalesSlipRepositoryImpl instance;

    /**
     * 싱글톤 인스턴스 반환.
     * @return PurchaseSalesSlipRepositoryImpl 인스턴스
     */
    public static synchronized PurchaseSalesSlipRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new PurchaseSalesSlipRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private PurchaseSalesSlipRepositoryImpl() {
        super(PurchaseSalesSlip.class);
    }

    
}