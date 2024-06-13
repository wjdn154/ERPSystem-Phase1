package com.erp.system.financial.repository.basic_information_management.vendor_registration.impl;

import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.basic_information_management.vendor_registration.Vendors;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.PurchaseSalesSlipRepository;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorsRepository;

public class VendorsRepositoryImpl extends GenericRepositoryImpl<Vendors> implements VendorsRepository {
    private static volatile VendorsRepositoryImpl instance;

    /**
     * 싱글톤 인스턴스 반환.
     * @return VendorsRepositoryImpl 인스턴스
     */
    public static synchronized VendorsRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new VendorsRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private VendorsRepositoryImpl() {
        super(Vendors.class);
    }

    
}