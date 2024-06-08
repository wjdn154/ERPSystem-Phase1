package com.erp.system.financial.controller.basic_information_management.purchase_sales_slip;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;
import com.erp.system.financial.service.basic_information_management.purchase_sales_slip.EntriesService;

import java.util.Collection;
import java.util.List;

public class EntriesController {
    private static EntriesController instance;
    private EntriesService entriesService;

    private EntriesController() {
        entriesService = EntriesService.getInstance();
    }

    public static synchronized EntriesController getInstance() {
        if (instance == null) {
            instance = new EntriesController();
        }
        return instance;
    }

    public void saveEntry(Entries entry) {
        entriesService.saveEntry(entry);
    }

    public Entries getEntryByIdOrCode(String idOrCode) {
        return entriesService.getEntryByIdOrCode(idOrCode);
    }

    public Collection<Entries> allEntries() {
        return entriesService.getAllEntries();
    }
}