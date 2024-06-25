package com.erp.system;


import com.erp.system.common.DependencyInjector;
import com.erp.system.common.HashJoin;
import com.erp.system.financial.controller.basic_information_management.*;
import com.erp.system.common.ERPDataInitializer;
import com.erp.system.financial.controller.book_keeping.AccountingLedgerController;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccount;
import com.erp.system.financial.model.basic_information_management.company_registration.Company;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Voucher;
import com.erp.system.financial.repository.basic_information_management.account_information.BankAccountRepository;
import com.erp.system.financial.service.basic_information_management.CompanyRegistrationService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.erp.system.common.PrintAllEntities.printAllEntities;
import static com.erp.system.common.Rules.ID_FIELD_NAME;

public class Main {
    public static void main(String[] args) throws Exception {

        // DI 컨테이너 생성
        DependencyInjector injector = DependencyInjector.getInstance();

        // ERPSystem 초기 데이터 생성
        new ERPDataInitializer();

        // 모든 Controller 인스턴스 생성
        createControllerInstance result = getCreateControllerInstance(injector);

        // 모든 객체 출력
        printAll(result);

        //hashJoin 테스트
        hashJoinTest(result.purchaseSalesSlipController());

        // service 테스트
        serviceTest(injector);

        // builder 패턴 수정 테스트
        modifyBuilderPatternTest(result.accountInformationController(), injector);
    }

    private static void printAll(createControllerInstance result) {
        printAllEntities(result.accountInformationController().findAllBankAccounts(), ID_FIELD_NAME); // BankAccount 출력
        printAllEntities(result.accountInformationController().findAllBankTransactions(), ID_FIELD_NAME); // BankTransaction 출력
        printAllEntities(result.accountInformationController().findAllDeposits(), ID_FIELD_NAME); //Deposit 출력

        printAllEntities(result.companyRegistrationController().findAllAddresses(), ID_FIELD_NAME); // Address 출력
        printAllEntities(result.companyRegistrationController().findAllCompanies(), ID_FIELD_NAME); // Company 출력
        printAllEntities(result.companyRegistrationController().findAllContacts(), ID_FIELD_NAME); // Contact 출력
        printAllEntities(result.companyRegistrationController().findAllCorporateKinds(), ID_FIELD_NAME); // CorporateKind 출력
        printAllEntities(result.companyRegistrationController().findAllCorporateTypes(), ID_FIELD_NAME); // CorporateType 출력
        printAllEntities(result.companyRegistrationController().findAllRepresentatives(), ID_FIELD_NAME); // Representative 출력
        printAllEntities(result.companyRegistrationController().findAllTaxes(), ID_FIELD_NAME); // Tax 출력

        printAllEntities(result.purchaseSalesSlipController().findAllEntries(), ID_FIELD_NAME); // Entry 출력
        printAllEntities(result.purchaseSalesSlipController().findAllPurchaseSalesSlip(), ID_FIELD_NAME); // PurchaseSalesSlip 출력
        printAllEntities(result.purchaseSalesSlipController().findAllVatTypes(), ID_FIELD_NAME); // VatType 출력

        printAllEntities(result.taxInvoiceController().findAllTaxInvoices(), ID_FIELD_NAME); // TaxInvoice 출력

        printAllEntities(result.vendorRegistrationController().findAllVendors(), ID_FIELD_NAME); // Vendor 출력
        printAllEntities(result.vendorRegistrationController().findAllVendorTypes(), ID_FIELD_NAME); // VendorType 출력

        printAllEntities(result.voucherRegistrationController().findAllAccounts(), ID_FIELD_NAME); // Account 출력
        printAllEntities(result.voucherRegistrationController().findAllMemos(), ID_FIELD_NAME); // Memo 출력
        printAllEntities(result.voucherRegistrationController().findAllVouchers(), ID_FIELD_NAME); // Voucher 출력
        printAllEntities(result.voucherRegistrationController().findAllVoucherTypes(), ID_FIELD_NAME); // VoucherType 출력

        printAllEntities(result.accountingLedgerController().findAllCashBooks(), ID_FIELD_NAME); // CashBook 출력
        printAllEntities(result.accountingLedgerController().findAllGeneralLedgers(), ID_FIELD_NAME); // GeneralLedger 출력
    }

    private static createControllerInstance getCreateControllerInstance(DependencyInjector injector) {
        AccountInformationController accountInformationController = injector.getInstance(AccountInformationController.class);
        CompanyRegistrationController companyRegistrationController = injector.getInstance(CompanyRegistrationController.class);
        PurchaseSalesSlipController purchaseSalesSlipController = injector.getInstance(PurchaseSalesSlipController.class);
        TaxInvoiceController taxInvoiceController = injector.getInstance(TaxInvoiceController.class);
        VendorRegistrationController vendorRegistrationController = injector.getInstance(VendorRegistrationController.class);
        VoucherRegistrationController voucherRegistrationController = injector.getInstance(VoucherRegistrationController.class);
        AccountingLedgerController accountingLedgerController = injector.getInstance(AccountingLedgerController.class);



        createControllerInstance result = new createControllerInstance(purchaseSalesSlipController, accountingLedgerController,
                taxInvoiceController, accountInformationController, companyRegistrationController, vendorRegistrationController,
                voucherRegistrationController);
        return result;
    }

    private record createControllerInstance(PurchaseSalesSlipController purchaseSalesSlipController,
                                            AccountingLedgerController accountingLedgerController,
                                            TaxInvoiceController taxInvoiceController,
                                            AccountInformationController accountInformationController,
                                            CompanyRegistrationController companyRegistrationController,
                                            VendorRegistrationController vendorRegistrationController,
                                            VoucherRegistrationController voucherRegistrationController) {
    }

    private static void hashJoinTest(PurchaseSalesSlipController purchaseSalesSlipController) {
        List<PurchaseSalesSlip> purchaseSalesSlip = purchaseSalesSlipController.findAllPurchaseSalesSlip().stream().toList(); // 조인할 엔티티 List 1
        List<Entry> entries = purchaseSalesSlipController.findAllEntries().stream().toList(); // 조인할 엔티티 List 2
        List<VatType> vatTypes = purchaseSalesSlipController.findAllVatTypes().stream().toList(); // 조인할 엔티티 List 3

        List<Map<String, Object>> joinedList = HashJoin.hashJoin(purchaseSalesSlip, entries, PurchaseSalesSlip::getId, Entry::getId); // 엔티티 1 and 엔티티 2 hash 조인
        joinedList.forEach(System.out::println); // 결과 출력

        List<Map<String, Object>> secondJoinResults = HashJoin.hashJoin(joinedList, vatTypes, map -> (String) map.get("vatTypeId"), VatType::getId); // 조인된 결과 and 엔티티 3 hash 조인
        secondJoinResults.forEach(System.out::println); // 결과 출력
    }

    private static void serviceTest(DependencyInjector injector) {
        CompanyRegistrationService c = injector.getInstance(CompanyRegistrationService.class);
        c.register("외투법인", "내국법인");
    }

    private static void modifyBuilderPatternTest(AccountInformationController accountInformationController, DependencyInjector injector) {
        BankAccount BA = new BankAccount.Builder()
                .bankName("original")
                .branchLocation("this.branchLocation")
                .number("this.number")
                .owner("this.owner")
                .depositType("this.depositType")
                .openingDate(LocalDate.parse("2021-05-01"))
                .build();
        BankAccount BA2 = new BankAccount.Builder()
                .bankName("original")
                .branchLocation("this.branchLocation")
                .number("this.number")
                .owner("this.owner")
                .depositType("this.depositType")
                .openingDate(LocalDate.parse("2021-05-01"))
                .build();
        BankAccount BA3 = new BankAccount.Builder()
                .bankName("original")
                .branchLocation("this.branchLocation")
                .number("this.number")
                .owner("this.owner")
                .depositType("this.depositType")
                .openingDate(LocalDate.parse("2021-05-01"))
                .build();

        // 저장
        accountInformationController.saveBankAccount(BA);
        accountInformationController.saveBankAccount(BA2);
        accountInformationController.saveBankAccount(BA3);

        // 수정 전 조회
        printAllEntities(accountInformationController.findAllBankAccounts(), ID_FIELD_NAME);

        BankAccountRepository bankAccountRepository = injector.getInstance(BankAccountRepository.class);

        // 객체 수정
        BankAccount bankAccount = bankAccountRepository.findById("1").get();
        bankAccount = bankAccount.tobuild().bankName("수정").build();

        // 수정된 객체 업데이트
        bankAccountRepository.update(bankAccount);

        // 수정 후 조회
        printAllEntities(accountInformationController.findAllBankAccounts(), ID_FIELD_NAME);
    }
}