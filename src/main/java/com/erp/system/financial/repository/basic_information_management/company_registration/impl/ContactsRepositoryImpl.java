package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.Contact;
import com.erp.system.financial.repository.basic_information_management.company_registration.ContactRepository;

@Component
@Priority(1)
public class ContactsRepositoryImpl extends GenericRepositoryImpl<Contact> implements ContactRepository {
    private static volatile ContactsRepositoryImpl instance; // 싱글톤 인스턴스를 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return ContactsRepositoryImpl 인스턴스
     */
    public static synchronized ContactsRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ContactsRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private ContactsRepositoryImpl() {
        super(Contact.class);
    }
}