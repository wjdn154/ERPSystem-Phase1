package com.erp.system;


import com.erp.system.common.DependencyInjector;
import com.erp.system.common.HashJoin;
import com.erp.system.common.batch_scheduler.BatchController;
import com.erp.system.common.batch_scheduler.BatchScheduler;
import com.erp.system.financial.controller.basic_information_management.*;
import com.erp.system.common.ERPDataInitializer;
import com.erp.system.financial.controller.book_keeping.AccountingLedgerController;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccount;
import com.erp.system.financial.model.basic_information_management.company_registration.Company;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Voucher;
import com.erp.system.financial.model.dto.CompanyRegistrationDto;
import com.erp.system.financial.repository.basic_information_management.account_information.BankAccountRepository;
import com.erp.system.financial.service.basic_information_management.CompanyRegistrationService;
import com.erp.system.financial.service.basic_information_management.PurchaseSalesSlipService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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

        // builder 패턴 수정 테스트
        modifyBuilderPatternTest(result.accountInformationController(), injector);

    }

    private static void printAll(createControllerInstance result) {
        // 계좌정보
        printAllEntities(result.accountInformationController().findAllBankAccounts(), ID_FIELD_NAME); // BankAccount 출력
        printAllEntities(result.accountInformationController().findAllBankTransactions(), ID_FIELD_NAME); // BankTransaction 출력
        printAllEntities(result.accountInformationController().findAllDeposits(), ID_FIELD_NAME); //Deposit 출력

        // 회사등록
        printAllEntities(result.companyRegistrationController().findAllAddress(), ID_FIELD_NAME); // Address 출력
        printAllEntities(result.companyRegistrationController().findAllCompany(), ID_FIELD_NAME); // Company 출력
        printAllEntities(result.companyRegistrationController().findAllContact(), ID_FIELD_NAME); // Contact 출력
        printAllEntities(result.companyRegistrationController().findAllCorporateKind(), ID_FIELD_NAME); // CorporateKind 출력
        printAllEntities(result.companyRegistrationController().findAllCorporateType(), ID_FIELD_NAME); // CorporateType 출력
        printAllEntities(result.companyRegistrationController().findAllRepresentative(), ID_FIELD_NAME); // Representative 출력
        printAllEntities(result.companyRegistrationController().findAllTax(), ID_FIELD_NAME); // Tax 출력

        // 매출매입전표 등록
        printAllEntities(result.purchaseSalesSlipController().findAllEntries(), ID_FIELD_NAME); // Entry 출력
        printAllEntities(result.purchaseSalesSlipController().findAllPurchaseSalesSlip(), ID_FIELD_NAME); // PurchaseSalesSlip 출력
        printAllEntities(result.purchaseSalesSlipController().findAllVatTypes(), ID_FIELD_NAME); // VatType 출력

        // 전자세금계산서
        printAllEntities(result.taxInvoiceController().findAllTaxInvoices(), ID_FIELD_NAME); // TaxInvoice 출력

        // 거래처 등록
        printAllEntities(result.vendorRegistrationController().findAllVendors(), ID_FIELD_NAME); // Vendor 출력
        printAllEntities(result.vendorRegistrationController().findAllVendorTypes(), ID_FIELD_NAME); // VendorType 출력

        // 전표 입력
        printAllEntities(result.voucherRegistrationController().findAllAccounts(), ID_FIELD_NAME); // Account 출력
        printAllEntities(result.voucherRegistrationController().findAllMemos(), ID_FIELD_NAME); // Memo 출력
        printAllEntities(result.voucherRegistrationController().findAllVouchers(), ID_FIELD_NAME); // Voucher 출력
        // 장부 관리
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

    private static void modifyBuilderPatternTest(AccountInformationController accountInformationController, DependencyInjector injector) {
        System.out.println("-------------------------- 빌더 패턴 수정 Test --------------------------");
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
        System.out.println("-------------------------- 빌더 패턴 수정 Test --------------------------");
    }
}