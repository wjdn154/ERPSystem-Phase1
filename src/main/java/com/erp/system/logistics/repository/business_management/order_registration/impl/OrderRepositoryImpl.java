package com.erp.system.logistics.repository.business_management.order_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.logistics.model.business_management.order_registration.Order;
import com.erp.system.logistics.repository.business_management.order_registration.OrderRepository;

@Component
public class OrderRepositoryImpl extends GenericRepositoryImpl<Order> implements OrderRepository {
    public OrderRepositoryImpl() {
        super(Order.class);
    }
}
