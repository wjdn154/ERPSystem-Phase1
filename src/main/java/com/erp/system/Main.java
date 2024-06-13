package com.erp.system;


import com.erp.system.common.DependencyInjector;
import com.erp.system.financial.controller.basic_information_management.purchase_sales_slip.EntriesController;
import com.erp.system.common.ERPDataInitializer;
import com.erp.system.financial.repository.basic_information_management.account_information.BankAccountsRepository;
import com.erp.system.financial.repository.basic_information_management.account_information.BankTransactionsRepository;
import com.erp.system.financial.repository.basic_information_management.account_information.DepositsRepository;
import com.erp.system.financial.repository.basic_information_management.account_information.impl.BankAccountsRepositoryImpl;
import com.erp.system.financial.repository.basic_information_management.account_information.impl.BankTransactionsRepositoryImpl;
import com.erp.system.financial.repository.basic_information_management.account_information.impl.DepositsRepositoryImpl;
import com.erp.system.financial.repository.basic_information_management.company_registration.*;
import com.erp.system.financial.repository.basic_information_management.company_registration.impl.*;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.PurchaseSalesSlipRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.VatTypesRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl.PurchaseSalesSlipRepositoryImpl;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl.VatTypesRepositoryImpl;
import com.erp.system.financial.repository.basic_information_management.tax_invoices.TaxInvoicesRepository;
import com.erp.system.financial.repository.basic_information_management.tax_invoices.impl.TaxInvoicesRepositoryImpl;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorTypesRepository;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorsRepository;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.impl.VendorTypesRepositoryImpl;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.impl.VendorsRepositoryImpl;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.AccountsRepository;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.MemosRepository;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.VoucherTypesRepository;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.VouchersRepository;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.impl.AccountsRepositoryImpl;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.impl.MemosRepositoryImpl;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.impl.VoucherTypesRepositoryImpl;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.impl.VouchersRepositoryImpl;
import com.erp.system.financial.repository.book_keeping.accounting_ledger.CashBookRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntriesRepository;
import com.erp.system.financial.repository.book_keeping.accounting_ledger.GeneralLedgerRepository;
import com.erp.system.financial.repository.book_keeping.accounting_ledger.impl.CashBookRepositoryImpl;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl.EntriesRepositoryImpl;
import com.erp.system.financial.repository.book_keeping.accounting_ledger.impl.GeneralLedgerRepositoryImpl;
import com.erp.system.financial.service.basic_information_management.PurchaseSalesSlipService;
import com.erp.system.financial.service.basic_information_management.impl.PurchaseSalesSlipServiceImpl;

public class Main {
    public static void main(String[] args) throws Exception {

        DependencyInjector di = DependencyInjector.getInstance();
        setupDependencyInjector(di);

        // ERPSystem 초기 데이터 생성
        new ERPDataInitializer();


        // Controller 인스턴스 생성
        EntriesController entriesController = di.resolve(EntriesController.class);
//        VatTypesController vatTypesController = VatTypesController.getInstance();
        CashBookRepository cashBookRepository = CashBookRepositoryImpl.getInstance();


//        entriesController.allEntries().stream()
//                .sorted((e1, e2) -> e1.getCode().compareTo(e2.getCode()))
//                .forEach(entry -> {
//                    System.out.println(entry.getCode() + " : " + entry.getName());
//                });
        System.out.println("--------------------------------");

//        vatTypesController.allEntries().stream()
//                .sorted((v1, v2) -> {
//                    int code1 = Integer.parseInt(v1.getCode());
//                    int code2 = Integer.parseInt(v2.getCode());
//                    return Integer.compare(code1, code2);
//                })
//                .forEach(vatType -> {
//                    System.out.println(vatType.getCode() + " : " + vatType.getCategory() + " : " + vatType.getName());
//                });
        System.out.println("--------------------------------");

        cashBookRepository.findAll().stream()
                .sorted((c1, c2) -> c1.getId().compareTo(c2.getId()))
                .forEach(System.out::println);

    }

    private static void setupDependencyInjector(DependencyInjector di) {
        di.register(BankAccountsRepository.class, BankAccountsRepositoryImpl::getInstance);
        di.register(BankTransactionsRepository.class, BankTransactionsRepositoryImpl::getInstance);
        di.register(DepositsRepository.class, DepositsRepositoryImpl::getInstance);
        di.register(AddressesRepository.class, AddressesRepositoryImpl::getInstance);
        di.register(CompaniesRepository.class, CompaniesRepositoryImpl::getInstance);
        di.register(ContactsRepository.class, ContactsRepositoryImpl::getInstance);
        di.register(CorporateKindsRepository.class, CorporateKindsRepositoryImpl::getInstance);
        di.register(CorporateTypesRepository.class, CorporateTypesRepositoryImpl::getInstance);
        di.register(RepresentativesRepository.class, RepresentativesRepositoryImpl::getInstance);
        di.register(TaxesRepository.class, TaxesRepositoryImpl::getInstance);
        di.register(EntriesRepository.class, EntriesRepositoryImpl::getInstance);
        di.register(PurchaseSalesSlipRepository.class, PurchaseSalesSlipRepositoryImpl::getInstance);
        di.register(VatTypesRepository.class, VatTypesRepositoryImpl::getInstance);
        di.register(TaxInvoicesRepository.class, TaxInvoicesRepositoryImpl::getInstance);
        di.register(VendorsRepository.class, VendorsRepositoryImpl::getInstance);
        di.register(VendorTypesRepository.class, VendorTypesRepositoryImpl::getInstance);
        di.register(AccountsRepository.class, AccountsRepositoryImpl::getInstance);
        di.register(MemosRepository.class, MemosRepositoryImpl::getInstance);
        di.register(VouchersRepository.class, VouchersRepositoryImpl::getInstance);
        di.register(VoucherTypesRepository.class, VoucherTypesRepositoryImpl::getInstance);
        di.register(CashBookRepository.class, CashBookRepositoryImpl::getInstance);
        di.register(GeneralLedgerRepository.class, GeneralLedgerRepositoryImpl::getInstance);
        di.register(PurchaseSalesSlipServiceImpl.class, () -> new PurchaseSalesSlipServiceImpl(
                di.resolve(EntriesRepository.class), di.resolve(PurchaseSalesSlipRepository.class), di.resolve(VatTypesRepository.class)));
    }
}