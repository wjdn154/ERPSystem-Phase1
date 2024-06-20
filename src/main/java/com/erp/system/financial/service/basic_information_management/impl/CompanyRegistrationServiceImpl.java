package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
import com.erp.system.financial.model.basic_information_management.company_registration.*;
import com.erp.system.financial.repository.basic_information_management.company_registration.*;
import com.erp.system.financial.service.basic_information_management.CompanyRegistrationService;

import java.util.Collection;
import java.util.Optional;

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
     * 회사 정보 저장
     * @param company 저장할 회사 객체
     * @throws IllegalArgumentException 저장할 회사가 null일 경우 예외 발생
     */
    @Override
    public void saveCompany(Company company) {
        if (company == null) {
            throw new IllegalArgumentException("저장할 회사는 null일 수 없습니다.");
        }
        companiesRepository.save(company);
    }

    /**
     * 주소 정보 저장
     * @param address 저장할 주소 객체
     * @throws IllegalArgumentException 저장할 주소가 null일 경우 예외 발생
     */
    @Override
    public void saveAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("저장할 주소는 null일 수 없습니다.");
        }
        addressesRepository.save(address);
    }

    /**
     * 연락처 정보 저장
     * @param contact 저장할 연락처 객체
     * @throws IllegalArgumentException 저장할 연락처가 null일 경우 예외 발생
     */
    @Override
    public void saveContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("저장할 연락처는 null일 수 없습니다.");
        }
        contactsRepository.save(contact);
    }

    /**
     * 법인 종류 정보 저장
     * @param corporateKind 저장할 법인 종류 객체
     * @throws IllegalArgumentException 저장할 법인 종류가 null일 경우 예외 발생
     */
    @Override
    public void saveCorporateKind(CorporateKind corporateKind) {
        if (corporateKind == null) {
            throw new IllegalArgumentException("저장할 법인 종류는 null일 수 없습니다.");
        }
        corporateKindsRepository.save(corporateKind);
    }

    /**
     * 법인 유형 정보 저장
     * @param corporateType 저장할 법인 유형 객체
     * @throws IllegalArgumentException 저장할 법인 유형이 null일 경우 예외 발생
     */
    @Override
    public void saveCorporateType(CorporateType corporateType) {
        if (corporateType == null) {
            throw new IllegalArgumentException("저장할 법인 유형은 null일 수 없습니다.");
        }
        corporateTypesRepository.save(corporateType);
    }

    /**
     * 대표자 정보 저장
     * @param representative 저장할 대표자 객체
     * @throws IllegalArgumentException 저장할 대표자가 null일 경우 예외 발생
     */
    @Override
    public void saveRepresentative(Representative representative) {
        if (representative == null) {
            throw new IllegalArgumentException("저장할 대표자는 null일 수 없습니다.");
        }
        representativesRepository.save(representative);
    }

    /**
     * 세금 정보 저장
     * @param tax 저장할 세금 객체
     * @throws IllegalArgumentException 저장할 세금 정보가 null일 경우 예외 발생
     */
    @Override
    public void saveTax(Tax tax) {
        if (tax == null) {
            throw new IllegalArgumentException("저장할 세금 정보는 null일 수 없습니다.");
        }
        taxesRepository.save(tax);
    }

    /**
     * ID로 회사 검색
     * @param id 회사 ID
     * @return 검색된 회사 객체를 Optional로 반환
     */
    @Override
    public Optional<Company> findCompanyById(String id) {
        return companiesRepository.findById(id);
    }

    /**
     * 코드로 회사 검색
     * @param code 회사 코드
     * @return 검색된 회사 객체를 Optional로 반환
     */
    @Override
    public Optional<Company> findCompanyByCode(String code) {
        return companiesRepository.findByCode(code);
    }

    /**
     * ID로 주소 검색
     * @param id 주소 ID
     * @return 검색된 주소 객체를 Optional로 반환
     */
    @Override
    public Optional<Address> findAddressById(String id) {
        return addressesRepository.findById(id);
    }

    /**
     * 코드로 주소 검색
     * @param code 주소 코드
     * @return 검색된 주소 객체를 Optional로 반환
     */
    @Override
    public Optional<Address> findAddressByCode(String code) {
        return addressesRepository.findByCode(code);
    }

    /**
     * ID로 연락처 검색
     * @param id 연락처 ID
     * @return 검색된 연락처 객체를 Optional로 반환
     */
    @Override
    public Optional<Contact> findContactById(String id) {
        return contactsRepository.findById(id);
    }

    /**
     * 코드로 연락처 검색
     * @param code 연락처 코드
     * @return 검색된 연락처 객체를 Optional로 반환
     */
    @Override
    public Optional<Contact> findContactByCode(String code) {
        return contactsRepository.findByCode(code);
    }

    /**
     * ID로 법인 종류 검색
     * @param id 법인 종류 ID
     * @return 검색된 법인 종류 객체를 Optional로 반환
     */
    @Override
    public Optional<CorporateKind> findCorporateKindById(String id) {
        return corporateKindsRepository.findById(id);
    }

    /**
     * 코드로 법인 종류 검색
     * @param code 법인 종류 코드
     * @return 검색된 법인 종류 객체를 Optional로 반환
     */
    @Override
    public Optional<CorporateKind> findCorporateKindByCode(String code) {
        return corporateKindsRepository.findByCode(code);
    }

    /**
     * ID로 법인 유형 검색
     * @param id 법인 유형 ID
     * @return 검색된 법인 유형 객체를 Optional로 반환
     */
    @Override
    public Optional<CorporateType> findCorporateTypeById(String id) {
        return corporateTypesRepository.findById(id);
    }

    /**
     * 코드로 법인 유형 검색
     * @param code 법인 유형 코드
     * @return 검색된 법인 유형 객체를 Optional로 반환
     */
    @Override
    public Optional<CorporateType> findCorporateTypeByCode(String code) {
        return corporateTypesRepository.findByCode(code);
    }

    /**
     * ID로 대표자 검색
     * @param id 대표자 ID
     * @return 검색된 대표자 객체를 Optional로 반환
     */
    @Override
    public Optional<Representative> findRepresentativeById(String id) {
        return representativesRepository.findById(id);
    }

    /**
     * 코드로 대표자 검색
     * @param code 대표자 코드
     * @return 검색된 대표자 객체를 Optional로 반환
     */
    @Override
    public Optional<Representative> findRepresentativeByCode(String code) {
        return representativesRepository.findByCode(code);
    }

    /**
     * ID로 세금 정보 검색
     * @param id 세금 ID
     * @return 검색된 세금 객체를 Optional로 반환
     */
    @Override
    public Optional<Tax> findTaxById(String id) {
        return taxesRepository.findById(id);
    }

    /**
     * 코드로 세금 정보 검색
     * @param code 세금 코드
     * @return 검색된 세금 객체를 Optional로 반환
     */
    @Override
    public Optional<Tax> findTaxByCode(String code) {
        return taxesRepository.findByCode(code);
    }

    /**
     * 모든 회사 정보 조회
     * @return 모든 회사 리스트
     */
    @Override
    public Collection<Company> findAllCompanies() {
        return companiesRepository.findAll();
    }

    /**
     * 모든 주소 정보 조회
     * @return 모든 주소 리스트
     */
    @Override
    public Collection<Address> findAllAddresses() {
        return addressesRepository.findAll();
    }

    /**
     * 모든 연락처 정보 조회
     * @return 모든 연락처 리스트
     */
    @Override
    public Collection<Contact> findAllContacts() {
        return contactsRepository.findAll();
    }

    /**
     * 모든 법인 종류 정보 조회
     * @return 모든 법인 종류 리스트
     */
    @Override
    public Collection<CorporateKind> findAllCorporateKinds() {
        return corporateKindsRepository.findAll();
    }

    /**
     * 모든 법인 유형 정보 조회
     * @return 모든 법인 유형 리스트
     */
    @Override
    public Collection<CorporateType> findAllCorporateTypes() {
        return corporateTypesRepository.findAll();
    }

    /**
     * 모든 대표자 정보 조회
     * @return 모든 대표자 리스트
     */
    @Override
    public Collection<Representative> findAllRepresentatives() {
        return representativesRepository.findAll();
    }

    /**
     * 모든 세금 정보 조회
     * @return 모든 세금 리스트
     */
    @Override
    public Collection<Tax> findAllTaxes() {
        return taxesRepository.findAll();
    }
}