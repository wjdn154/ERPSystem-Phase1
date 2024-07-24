package com.erp.system.production.repository.production_standard_information.bom_management.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.production_standard_information.bom_management.BomExcel;
import com.erp.system.production.repository.production_standard_information.bom_management.BomExcelRepository;

public class BomExcelRepositoryImpl extends GenericRepositoryImpl<BomExcel> implements BomExcelRepository {
    private BomExcelRepositoryImpl() { super(BomExcel.class);}
}
