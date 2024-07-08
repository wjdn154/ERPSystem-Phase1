package com.erp.system.production.repository.production_standard_information.bom_management;


import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.production_standard_information.bom_management.BomExcel;

import java.util.List;

/**
 * 자재명세서 엑셀 엔티티 Repository IF
 */
public interface BomExcelRepository extends GenericRepository<BomExcel> {
    @Override
    void save(BomExcel entity);

    @Override
    List<BomExcel> findAll();
}
