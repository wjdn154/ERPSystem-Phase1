package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
import com.erp.system.financial.model.basic_information_management.company_registration.*;
import com.erp.system.financial.repository.basic_information_management.company_registration.*;
import com.erp.system.financial.service.basic_information_management.CompanyRegistrationService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.erp.system.common.Rules.ID_FIELD_NAME;

@Component
@Priority(2)
public class CompanyRegistrationServiceImpl implements CompanyRegistrationService {
    private final AddressRepository addressesRepository;
    private final CompanyRepository companiesRepository;
    private final ContactRepository contactsRepository;
    private final CorporateKindRepository corporateKindsRepository;
    private final CorporateTypeRepository corporateTypesRepository;
    private final RepresentativeRepository representativesRepository;
    private final TaxRepository taxesRepository;

    public CompanyRegistrationServiceImpl(AddressRepository addressesRepository,
                                          CompanyRepository companiesRepository,
                                          ContactRepository contactsRepository,
                                          CorporateKindRepository corporateKindsRepository,
                                          CorporateTypeRepository corporateTypesRepository,
                                          RepresentativeRepository representativesRepository,
                                          TaxRepository taxesRepository) {
        this.addressesRepository = addressesRepository;
        this.companiesRepository = companiesRepository;
        this.contactsRepository = contactsRepository;
        this.corporateKindsRepository = corporateKindsRepository;
        this.corporateTypesRepository = corporateTypesRepository;
        this.representativesRepository = representativesRepository;
        this.taxesRepository = taxesRepository;
    }

    /**
     * 참고용
     * @param corporateType
     * @param corporateKinds
     */
    @Override
    public void register(String corporateType, String corporateKinds) {
        String id;
        for (CorporateType cType : corporateTypesRepository
                                .findAll()
                                .stream()
                                .filter(s -> s.getType().equals(corporateType))
                                .toList()){
            id = cType.getId();
        }
    }
}