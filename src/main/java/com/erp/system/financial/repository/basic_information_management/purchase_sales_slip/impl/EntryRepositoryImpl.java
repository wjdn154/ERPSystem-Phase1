package com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntryRepository;

@Component
public class EntryRepositoryImpl extends GenericRepositoryImpl<Entry> implements EntryRepository {
    private EntryRepositoryImpl() {
        super(Entry.class);
    }
}