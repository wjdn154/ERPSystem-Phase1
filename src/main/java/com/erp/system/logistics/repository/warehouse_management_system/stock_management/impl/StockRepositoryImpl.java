package com.erp.system.logistics.repository.warehouse_management_system.stock_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.logistics.model.warehouse_management_system.stock_management.Stock;
import com.erp.system.logistics.repository.warehouse_management_system.stock_management.StockRepository;

@Component
public class StockRepositoryImpl extends GenericRepositoryImpl<Stock> implements StockRepository {
    public StockRepositoryImpl() {
        super(Stock.class);
    }
}
