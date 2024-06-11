package com.erp.system.financial.service.basic_information_management.purchase_sales_slip;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;

import java.util.Collection;
import java.util.Optional;

public interface EntriesService {

    void saveEntry(Entries entry);

    Optional<Entries> findByIdOrCode(String id, String code);

    void updateEntry(Entries entry);

    void deleteEntry(String id);

    Collection<Entries> findAllEntries();
}