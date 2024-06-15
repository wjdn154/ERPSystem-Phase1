package com.erp.system.financial.service.basic_information_management;

import com.erp.system.financial.model.basic_information_management.company_registration.*;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;

import java.util.Collection;
import java.util.Optional;

public interface CompanyRegistrationService {
    void saveCompany(Company company);
    void saveAddress(Address address);
    void saveContact(Contact contact);
    void saveCorporateKind(CorporateKind corporateKind);
    void saveCorporateType(CorporateType corporateType);
    void saveRepresentative(Representative representative);
    void saveTax(Tax tax);

    Optional<Company> findCompanyById(String id);
    Optional<Company> findCompanyByCode(String code);
    Optional<Address> findAddressById(String id);
    Optional<Address> findAddressByCode(String code);
    Optional<Contact> findContactById(String id);
    Optional<Contact> findContactByCode(String code);
    Optional<CorporateKind> findCorporateKindById(String id);
    Optional<CorporateKind> findCorporateKindByCode(String code);
    Optional<CorporateType> findCorporateTypeById(String id);
    Optional<CorporateType> findCorporateTypeByCode(String code);
    Optional<Representative> findRepresentativeById(String id);
    Optional<Representative> findRepresentativeByCode(String code);
    Optional<Tax> findTaxById(String id);
    Optional<Tax> findTaxByCode(String code);

    Collection<Company> findAllCompanies();
    Collection<Address> findAllAddresses();
    Collection<Contact> findAllContacts();
    Collection<CorporateKind> findAllCorporateKinds();
    Collection<CorporateType> findAllCorporateTypes();
    Collection<Representative> findAllRepresentatives();
    Collection<Tax> findAllTaxes();
}