package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.Contact;
import com.erp.system.financial.repository.basic_information_management.company_registration.ContactRepository;

@Component
public class ContactsRepositoryImpl extends GenericRepositoryImpl<Contact> implements ContactRepository {
    private ContactsRepositoryImpl() {
        super(Contact.class);
    }
}