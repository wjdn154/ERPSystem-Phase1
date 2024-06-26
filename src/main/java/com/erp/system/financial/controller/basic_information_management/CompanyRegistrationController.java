package com.erp.system.financial.controller.basic_information_management;

import com.erp.system.common.annotation.Component;
import com.erp.system.financial.model.basic_information_management.company_registration.*;
import com.erp.system.financial.repository.basic_information_management.company_registration.*;
import com.erp.system.financial.service.basic_information_management.CompanyRegistrationService;
import org.apache.commons.math3.analysis.function.Add;

import java.util.Collection;
import java.util.Optional;

@Component
public class CompanyRegistrationController {
    private final CompanyRegistrationService companyRegistrationService;
    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;
    private final ContactRepository contactRepository;
    private final CorporateKindRepository corporateKindRepository;
    private final CorporateTypeRepository corporateTypeRepository;
    private final RepresentativeRepository representativeRepository;
    private final TaxRepository taxRepository;


    public CompanyRegistrationController(CompanyRegistrationService companyRegistrationService,
                                         AddressRepository addressRepository,
                                         CompanyRepository companyRepository,
                                         ContactRepository contactRepository,
                                         CorporateKindRepository corporateKindRepository,
                                         CorporateTypeRepository corporateTypeRepository,
                                         RepresentativeRepository representativeRepository,
                                         TaxRepository taxRepository) {
        this.companyRegistrationService = companyRegistrationService;
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
        this.contactRepository = contactRepository;
        this.corporateKindRepository = corporateKindRepository;
        this.corporateTypeRepository = corporateTypeRepository;
        this.representativeRepository = representativeRepository;
        this.taxRepository = taxRepository;
    }

    /**
     * 주소를 저장함
     * @param address 저장할 주소
     */
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    /**
     * 회사를 저장함
     * @param company 저장할 회사
     */
    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

    /**
     * 연락처를 저장함
     * @param contact 저장할 연락처
     */
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    /**
     * 법인 종류를 저장함
     * @param corporateKind 저장할 법인 종류
     */
    public void saveCorporateKind(CorporateKind corporateKind) {
        corporateKindRepository.save(corporateKind);
    }

    /**
     * 법인 유형을 저장함
     * @param corporateType 저장할 법인 유형
     */
    public void saveCorporateType(CorporateType corporateType) {
        corporateTypeRepository.save(corporateType);
    }

    /**
     * 대표자를 저장함
     * @param representative 저장할 대표자
     */
    public void saveRepresentative(Representative representative) {
        representativeRepository.save(representative);
    }

    /**
     * 세금을 저장함
     * @param tax 저장할 세금
     */
    public void saveTax(Tax tax) {
        taxRepository.save(tax);
    }

    /**
     * ID로 주소를 조회함
     * @param id 주소의 ID
     * @return 조회된 주소를 Optional로 반환
     */
    public Optional<Address> findAddressById(String id) {
        return addressRepository.findById(id);
    }

    /**
     * ID로 회사를 조회함
     * @param id 회사의 ID
     * @return 조회된 회사를 Optional로 반환
     */

    public Optional<Company> findCompanyById(String id) {
        return companyRepository.findById(id);
    }

    /**
     * ID로 연락처를 조회함
     * @param id 연락처의 ID
     * @return 조회된 연락처를 Optional로 반환
     */
    public Optional<Contact> findContactById(String id) {
        return contactRepository.findById(id);
    }

    /**
     * ID로 법인 종류를 조회함
     * @param id 법인 종류의 ID
     * @return 조회된 법인 종류를 Optional로 반환
     */
    public Optional<CorporateKind> findCorporateKindById(String id) {
        return corporateKindRepository.findById(id);
    }

    /**
     * ID로 법인 유형을 조회함
     * @param id 법인 유형의 ID
     * @return 조회된 법인 유형을 Optional로 반환
     */
    public Optional<CorporateType> findCorporateTypeById(String id) {
        return corporateTypeRepository.findById(id);
    }

    /**
     * ID로 대표자를 조회함
     * @param id 대표자의 ID
     * @return 조회된 대표자를 Optional로 반환
     */
    public Optional<Representative> findRepresentativeById(String id) {
        return representativeRepository.findById(id);
    }

    /**
     * ID로 세금을 조회함
     * @param id 세금의 ID
     * @return 조회된 세금을 Optional로 반환
     */
    public Optional<Tax> findTaxById(String id) {
        return taxRepository.findById(id);
    }

    /**
     * 모든 주소를 조회함
     * @return 저장된 모든 주소의 컬렉션
     */
    public Collection<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    /**
     * 모든 회사를 조회함
     * @return 저장된 모든 회사의 컬렉션
     */
    public Collection<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    /**
     * 모든 연락처를 조회함
     * @return 저장된 모든 연락처의 컬렉션
     */
    public Collection<Contact> findAllContacts() {
        return contactRepository.findAll();
    }

    /**
     * 모든 법인 종류를 조회함
     * @return 저장된 모든 법인 종류의 컬렉션
     */
    public Collection<CorporateKind> findAllCorporateKinds() {
        return corporateKindRepository.findAll();
    }

    /**
     * 모든 법인 유형을 조회함
     * @return 저장된 모든 법인 유형의 컬렉션
     */
    public Collection<CorporateType> findAllCorporateTypes() {
        return corporateTypeRepository.findAll();
    }

    /**
     * 모든 대표자를 조회함
     * @return 저장된 모든 대표자의 컬렉션
     */
    public Collection<Representative> findAllRepresentatives() {
        return representativeRepository.findAll();
    }

    /**
     * 모든 세금을 조회함
     * @return 저장된 모든 세금의 컬렉션
     */
    public Collection<Tax> findAllTaxes() {
        return taxRepository.findAll();
    }



}