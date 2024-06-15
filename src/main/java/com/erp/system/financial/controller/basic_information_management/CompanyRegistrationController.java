package com.erp.system.financial.controller.basic_information_management;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.financial.model.basic_information_management.company_registration.*;
import com.erp.system.financial.service.basic_information_management.CompanyRegistrationService;

import java.util.Collection;
import java.util.Optional;

@Component
@Priority(3)
public class CompanyRegistrationController {
    private final CompanyRegistrationService companyRegistrationService;

    public CompanyRegistrationController(CompanyRegistrationService companyRegistrationService) {
        this.companyRegistrationService = companyRegistrationService;
    }
    /**
     * 회사를 저장함
     * @param company 저장할 회사
     */
    public void saveCompany(Company company) {
        companyRegistrationService.saveCompany(company);
    }

    /**
     * 주소를 저장함
     * @param address 저장할 주소
     */
    public void saveAddress(Address address) {
        companyRegistrationService.saveAddress(address);
    }

    /**
     * 연락처를 저장함
     * @param contact 저장할 연락처
     */
    public void saveContact(Contact contact) {
        companyRegistrationService.saveContact(contact);
    }

    /**
     * 법인 종류를 저장함
     * @param corporateKind 저장할 법인 종류
     */
    public void saveCorporateKind(CorporateKind corporateKind) {
        companyRegistrationService.saveCorporateKind(corporateKind);
    }

    /**
     * 법인 유형을 저장함
     * @param corporateType 저장할 법인 유형
     */
    public void saveCorporateType(CorporateType corporateType) {
        companyRegistrationService.saveCorporateType(corporateType);
    }

    /**
     * 대표자를 저장함
     * @param representative 저장할 대표자
     */
    public void saveRepresentative(Representative representative) {
        companyRegistrationService.saveRepresentative(representative);
    }

    /**
     * 세금을 저장함
     * @param tax 저장할 세금
     */
    public void saveTax(Tax tax) {
        companyRegistrationService.saveTax(tax);
    }

    /**
     * ID로 회사를 조회함
     * @param id 회사의 ID
     * @return 조회된 회사를 Optional로 반환
     */
    public Optional<Company> findCompanyById(String id) {
        return companyRegistrationService.findCompanyById(id);
    }

    /**
     * 코드로 회사를 조회함
     * @param code 회사의 코드
     * @return 조회된 회사를 Optional로 반환
     */
    public Optional<Company> findCompanyByCode(String code) {
        return companyRegistrationService.findCompanyByCode(code);
    }

    /**
     * ID로 주소를 조회함
     * @param id 주소의 ID
     * @return 조회된 주소를 Optional로 반환
     */
    public Optional<Address> findAddressById(String id) {
        return companyRegistrationService.findAddressById(id);
    }

    /**
     * 코드로 주소를 조회함
     * @param code 주소의 코드
     * @return 조회된 주소를 Optional로 반환
     */
    public Optional<Address> findAddressByCode(String code) {
        return companyRegistrationService.findAddressByCode(code);
    }

    /**
     * ID로 연락처를 조회함
     * @param id 연락처의 ID
     * @return 조회된 연락처를 Optional로 반환
     */
    public Optional<Contact> findContactById(String id) {
        return companyRegistrationService.findContactById(id);
    }

    /**
     * 코드로 연락처를 조회함
     * @param code 연락처의 코드
     * @return 조회된 연락처를 Optional로 반환
     */
    public Optional<Contact> findContactByCode(String code) {
        return companyRegistrationService.findContactByCode(code);
    }

    /**
     * ID로 법인 종류를 조회함
     * @param id 법인 종류의 ID
     * @return 조회된 법인 종류를 Optional로 반환
     */
    public Optional<CorporateKind> findCorporateKindById(String id) {
        return companyRegistrationService.findCorporateKindById(id);
    }

    /**
     * 코드로 법인 종류를 조회함
     * @param code 법인 종류의 코드
     * @return 조회된 법인 종류를 Optional로 반환
     */
    public Optional<CorporateKind> findCorporateKindByCode(String code) {
        return companyRegistrationService.findCorporateKindByCode(code);
    }

    /**
     * ID로 법인 유형을 조회함
     * @param id 법인 유형의 ID
     * @return 조회된 법인 유형을 Optional로 반환
     */
    public Optional<CorporateType> findCorporateTypeById(String id) {
        return companyRegistrationService.findCorporateTypeById(id);
    }

    /**
     * 코드로 법인 유형을 조회함
     * @param code 법인 유형의 코드
     * @return 조회된 법인 유형을 Optional로 반환
     */
    public Optional<CorporateType> findCorporateTypeByCode(String code) {
        return companyRegistrationService.findCorporateTypeByCode(code);
    }

    /**
     * ID로 대표자를 조회함
     * @param id 대표자의 ID
     * @return 조회된 대표자를 Optional로 반환
     */
    public Optional<Representative> findRepresentativeById(String id) {
        return companyRegistrationService.findRepresentativeById(id);
    }

    /**
     * 코드로 대표자를 조회함
     * @param code 대표자의 코드
     * @return 조회된 대표자를 Optional로 반환
     */
    public Optional<Representative> findRepresentativeByCode(String code) {
        return companyRegistrationService.findRepresentativeByCode(code);
    }

    /**
     * ID로 세금을 조회함
     * @param id 세금의 ID
     * @return 조회된 세금을 Optional로 반환
     */
    public Optional<Tax> findTaxById(String id) {
        return companyRegistrationService.findTaxById(id);
    }

    /**
     * 코드로 세금을 조회함
     * @param code 세금의 코드
     * @return 조회된 세금을 Optional로 반환
     */
    public Optional<Tax> findTaxByCode(String code) {
        return companyRegistrationService.findTaxByCode(code);
    }

    /**
     * 모든 회사를 조회함
     * @return 저장된 모든 회사의 컬렉션
     */
    public Collection<Company> findAllCompanies() {
        return companyRegistrationService.findAllCompanies();
    }

    /**
     * 모든 주소를 조회함
     * @return 저장된 모든 주소의 컬렉션
     */
    public Collection<Address> findAllAddresses() {
        return companyRegistrationService.findAllAddresses();
    }

    /**
     * 모든 연락처를 조회함
     * @return 저장된 모든 연락처의 컬렉션
     */
    public Collection<Contact> findAllContacts() {
        return companyRegistrationService.findAllContacts();
    }

    /**
     * 모든 법인 종류를 조회함
     * @return 저장된 모든 법인 종류의 컬렉션
     */
    public Collection<CorporateKind> findAllCorporateKinds() {
        return companyRegistrationService.findAllCorporateKinds();
    }

    /**
     * 모든 법인 유형을 조회함
     * @return 저장된 모든 법인 유형의 컬렉션
     */
    public Collection<CorporateType> findAllCorporateTypes() {
        return companyRegistrationService.findAllCorporateTypes();
    }

    /**
     * 모든 대표자를 조회함
     * @return 저장된 모든 대표자의 컬렉션
     */
    public Collection<Representative> findAllRepresentatives() {
        return companyRegistrationService.findAllRepresentatives();
    }

    /**
     * 모든 세금을 조회함
     * @return 저장된 모든 세금의 컬렉션
     */
    public Collection<Tax> findAllTaxes() {
        return companyRegistrationService.findAllTaxes();
    }
}