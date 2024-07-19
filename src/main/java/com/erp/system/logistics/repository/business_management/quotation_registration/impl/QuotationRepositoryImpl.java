package com.erp.system.logistics.repository.business_management.quotation_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.logistics.model.business_management.quotation_registration.Quotation;
import com.erp.system.logistics.repository.business_management.quotation_registration.QuotationRepository;

@Component
public class QuotationRepositoryImpl extends GenericRepositoryImpl<Quotation> implements QuotationRepository {
    public QuotationRepositoryImpl() {
        super(Quotation.class);
    }
}
