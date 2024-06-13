package com.erp.system.common;

import com.erp.system.financial.controller.basic_information_management.purchase_sales_slip.EntriesController;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntriesRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl.EntriesRepositoryImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DependencyInjector {
    private static DependencyInjector instance;
    private final Map<Class<?>, Supplier<?>> registry = new HashMap<>();

    private DependencyInjector() {}

    public static synchronized DependencyInjector getInstance() {
        if (instance == null) {
            instance = new DependencyInjector();
        }
        return instance;
    }

    public <T> void register(Class<T> interfaceType, Supplier<T> supplier) {
        registry.put(interfaceType, supplier);
    }

    public <T> T resolve(Class<T> interfaceType) {
        Supplier<?> supplier = registry.get(interfaceType);
        if (supplier == null) {
            throw new IllegalArgumentException("등록된 interfaceType 이 없습니다. " + interfaceType.getName());
        }
        return interfaceType.cast(supplier.get());
    }
}