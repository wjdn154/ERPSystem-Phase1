package com.erp.system.logistics.repository.basic_information_registration.warehouse_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.logistics.model.basic_information_registration.warehouse_registration.Area;
import com.erp.system.logistics.repository.basic_information_registration.warehouse_registration.AreaRepository;

@Component
public class AreaRepositoryImpl extends GenericRepositoryImpl<Area> implements AreaRepository {
    public AreaRepositoryImpl() {
        super(Area.class);
    }
}
