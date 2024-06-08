package com.erp.system.financial.controller.basic_information_management.purchase_sales_slip;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatTypes;
import com.erp.system.financial.service.basic_information_management.purchase_sales_slip.EntriesService;
import com.erp.system.financial.service.basic_information_management.purchase_sales_slip.VatTypesService;

import java.util.Collection;

public class VatTypesController {
    private static VatTypesController instance;
    private VatTypesService vatTypesService;

    private VatTypesController() {
        vatTypesService = VatTypesService.getInstance();
    }

    public static synchronized VatTypesController getInstance() {
        if (instance == null) {
            instance = new VatTypesController();
        }
        return instance;
    }

    public void saveEntry(VatTypes vatTypes) {
        vatTypesService.saveEntry(vatTypes);
    }

    public VatTypes getEntryByIdOrCode(String idOrCode) {
        return vatTypesService.getEntryByIdOrCode(idOrCode);
    }

    public Collection<VatTypes> allEntries() {
        return vatTypesService.getAllEntries();
    }
}