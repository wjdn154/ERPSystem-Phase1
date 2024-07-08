package com.erp.system.production.repository.basic_information_management.factory.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.basic_information_management.factory.Factory;

@Component
public class FactoryRepositoryImpl extends GenericRepositoryImpl<Factory> {
    private FactoryRepositoryImpl() { super(Factory.class); }

}
