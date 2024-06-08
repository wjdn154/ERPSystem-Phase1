package com.erp.system.financial.service.basic_information_management.purchase_sales_slip;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntriesRepository;

import java.util.Collection;

public class EntriesService {
    private static EntriesService instance;
    private EntriesRepository entriesRepository;

    private EntriesService() {
        entriesRepository = EntriesRepository.getInstance();
    }

    public static synchronized EntriesService getInstance() {
        if (instance == null) {
            instance = new EntriesService();
        }
        return instance;
    }

    public void saveEntry(Entries entry) {
        entriesRepository.save(entry);
    }

    public Entries getEntryByIdOrCode(String idOrCode) {
        return entriesRepository.findByIdOrCode(idOrCode);
    }

    public void updateEntry(Entries entry) {
        entriesRepository.update(entry);
    }

    public void deleteEntry(Entries entry) {
        entriesRepository.delete(entry);
    }

    public Collection<Entries> getAllEntries() {
        return entriesRepository.findAll();
    }
}