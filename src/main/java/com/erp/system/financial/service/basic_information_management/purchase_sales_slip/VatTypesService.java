package com.erp.system.financial.service.basic_information_management.purchase_sales_slip;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatTypes;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntriesRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.VatTypesRepository;

import java.util.Collection;

public class VatTypesService {
    private static VatTypesService instance;
    private VatTypesRepository vatTypesRepository;

    private VatTypesService() {
        vatTypesRepository = VatTypesRepository.getInstance();
    }

    public static synchronized VatTypesService getInstance() {
        if (instance == null) {
            instance = new VatTypesService();
        }
        return instance;
    }

    public void saveEntry(VatTypes vatTypes) {
        vatTypesRepository.save(vatTypes);
    }

    public VatTypes getEntryByIdOrCode(String idOrCode) {
        return vatTypesRepository.findByIdOrCode(idOrCode);
    }

    public void updateEntry(VatTypes vatTypes) {
        vatTypesRepository.update(vatTypes);
    }

    public void deleteEntry(VatTypes vatTypes) {
        vatTypesRepository.delete(vatTypes);
    }

    public Collection<VatTypes> getAllEntries() {
        return vatTypesRepository.findAll();
    }
}