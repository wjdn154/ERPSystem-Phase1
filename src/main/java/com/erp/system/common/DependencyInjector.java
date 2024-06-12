package com.erp.system.common;

import com.erp.system.financial.controller.basic_information_management.purchase_sales_slip.EntriesController;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntriesRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl.EntriesRepositoryImpl;
import com.erp.system.financial.service.basic_information_management.purchase_sales_slip.EntriesService;
import com.erp.system.financial.service.basic_information_management.purchase_sales_slip.impl.EntriesServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DependencyInjector {
    private final Map<Class<?>, Supplier<?>> registry = new HashMap<>();

    // Method to register a component and its creation logic
    public <T> void register(Class<T> interfaceType, Supplier<T> supplier) {
        registry.put(interfaceType, supplier);
    }

    // Method to retrieve an instance of the registered class
    public <T> T resolve(Class<T> interfaceType) {
        Supplier<?> supplier = registry.get(interfaceType);
        if (supplier == null) {
            throw new IllegalArgumentException("No supplier registered for " + interfaceType.getName());
        }
        return interfaceType.cast(supplier.get());
    }
}
