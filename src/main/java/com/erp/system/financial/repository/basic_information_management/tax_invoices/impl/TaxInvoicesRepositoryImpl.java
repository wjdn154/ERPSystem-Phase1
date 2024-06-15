package com.erp.system.financial.repository.basic_information_management.tax_invoices.impl;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.tax_invoices.TaxInvoice;
import com.erp.system.financial.repository.basic_information_management.tax_invoices.TaxInvoiceRepository;

@Component
@Priority(1)
public class TaxInvoicesRepositoryImpl extends GenericRepositoryImpl<TaxInvoice> implements TaxInvoiceRepository {
    private static TaxInvoicesRepositoryImpl instance; // 싱글톤 인스턴스를 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return CashBookRepositoryImpl 인스턴스
     */
    public static synchronized TaxInvoicesRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new TaxInvoicesRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private TaxInvoicesRepositoryImpl() {
        super(TaxInvoice.class); // 부모 클래스의 생성자를 호출
    }

}