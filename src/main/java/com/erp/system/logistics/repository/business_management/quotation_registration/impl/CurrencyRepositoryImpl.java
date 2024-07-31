package com.erp.system.logistics.repository.business_management.quotation_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.logistics.model.business_management.quotation_registration.Currency;
import com.erp.system.logistics.repository.business_management.quotation_registration.CurrencyRepository;

@Component
public class CurrencyRepositoryImpl extends GenericRepositoryImpl<Currency> implements CurrencyRepository {
    public CurrencyRepositoryImpl() {
        super(Currency.class);
    }
}
