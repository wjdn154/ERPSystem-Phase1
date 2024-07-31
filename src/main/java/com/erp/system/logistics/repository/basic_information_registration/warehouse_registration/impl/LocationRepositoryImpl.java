package com.erp.system.logistics.repository.basic_information_registration.warehouse_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.logistics.model.basic_information_registration.warehouse_registration.Location;
import com.erp.system.logistics.repository.basic_information_registration.warehouse_registration.LocationRepository;

@Component
public class LocationRepositoryImpl extends GenericRepositoryImpl<Location> implements LocationRepository {
    public LocationRepositoryImpl() {
        super(Location.class);
    }
}
