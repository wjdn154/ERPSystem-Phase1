package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.DependencyInjector;
import com.erp.system.common.ERPDataInitializer;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccount;
import com.erp.system.financial.model.basic_information_management.account_information.BankTransaction;
import com.erp.system.financial.model.basic_information_management.company_registration.Address;
import com.erp.system.financial.model.dto.AccountInformationDto;
import com.erp.system.financial.repository.basic_information_management.account_information.BankAccountRepository;
import com.erp.system.financial.repository.basic_information_management.account_information.BankTransactionRepository;
import com.erp.system.financial.repository.basic_information_management.account_information.DepositRepository;
import com.erp.system.financial.repository.basic_information_management.company_registration.*;
import com.erp.system.financial.service.basic_information_management.AccountInformationService;
import com.erp.system.financial.service.basic_information_management.CompanyRegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AccountInformationServiceImplTest {
    private AccountInformationService accountInformationService;
    private BankAccountRepository bankAccountRepository;
    private BankTransactionRepository bankTransactionRepository;
    private DepositRepository depositRepository;

    /**
     * 각 테스트 실행 전에 필요한 구성요소를 초기화.
     */
    @BeforeEach
    void setUp() {
        DependencyInjector injector = DependencyInjector.getInstance();

        accountInformationService = injector.getInstance(AccountInformationService.class);
        bankAccountRepository = injector.getInstance(BankAccountRepository.class);
        bankTransactionRepository = injector.getInstance(BankTransactionRepository.class);
        depositRepository = injector.getInstance(DepositRepository.class);

        bankAccountRepository.reset();
        bankTransactionRepository.reset();
        depositRepository.reset();
    }

    /**
     * 은행 계좌 등록 기능을 테스트.
     */
    @Test
    public void registeringBankAccountTest() {
        // Given: 테스트 데이터 설정
        AccountInformationDto accountDto = createAccountInformationDto();
        String ERPCompanyId = "1";

        // When: 은행 계좌 등록
        accountInformationService.registerBankAccount(ERPCompanyId, accountDto);

        // Then: 은행 계좌가 등록되었는지 확인
        bankAccountRepository.findById("1").ifPresent(bankAccount -> {
            assertEquals(accountDto.getOpeningDate(), bankAccount.getOpeningDate());
            assertEquals(accountDto.getBankName(), bankAccount.getBankName());
            assertEquals(accountDto.getBranchLocation(), bankAccount.getBranchLocation());
            assertEquals(accountDto.getNumber(), bankAccount.getNumber());
            assertEquals(accountDto.getOwner(), bankAccount.getOwner());
            assertEquals(accountDto.getDepositType(), bankAccount.getDepositType());
        });
    }

    /**
     * 은행 거래 등록 기능을 테스트.
     */
    @Test
    public void RegisteringBankTransactionTest() {
        // Given: 테스트 데이터 설정
        AccountInformationDto transactionDto = createTransactionDto();
        System.out.println("transactionDto.getCarriedOverDebit() = " + transactionDto.getCarriedOverDebit());

        // When: 은행 계좌 등록
        accountInformationService.registerBankTransaction(transactionDto);

        // Then: 은행 계좌가 등록되었는지 확인
        bankTransactionRepository.findById("1").ifPresent(bankTransaction -> {
            assertEquals(transactionDto.getType(), bankTransaction.getType());
            assertEquals(transactionDto.getDebit(), bankTransaction.getDebit());
            assertEquals(transactionDto.getCredit(), bankTransaction.getCredit());
            assertEquals(transactionDto.getDate(), bankTransaction.getDate());
            assertEquals(transactionDto.getCurrentBalance(), bankTransaction.getCurrentBalance());
        });
    }

    /**
     * 예적금 현황 잔액 조회 기능을 테스트.
     */
    @Test
    public void RetrievingDepositBalanceTest() {
        // Given: 테스트 데이터 설정
        prepareTestData();

        // When: 은행 계좌 등록
        Map<String, Object> results = accountInformationService.getDepositBalance("1", LocalDate.of(2024, 1, 1));

        // Then: 은행 계좌가 등록되었는지 확인
        assertFalse(results.isEmpty());
        assertNotNull(results.get("results"));
        assertNotNull(results.get("합계"));
    }

    /**
     * 예적금 현황 원장 세부 정보 조회 기능을 테스트.
     */
    @Test
    public void depositLedgerDetailsTest() {
        // Given: 테스트 데이터 설정
        new ERPDataInitializer();

        // When: 은행 계좌 등록
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 1, 31);
        Map<String, Object> results = accountInformationService.getDepositLedgerDetails("1", startDate, endDate);
        System.out.println("results = " + results.get("계좌정보"));
        System.out.println("results = " + results.get("이월금액"));
        System.out.println("results = " + results.get("거래내역"));
        System.out.println("results = " + results.get("월계"));
        System.out.println("results = " + results.get("누계"));

        // Then: 은행 계좌가 등록되었는지 확인
        assertNotNull(results);
        assertFalse(((List<?>) results.get("계좌정보")).isEmpty());
        assertFalse(((List<?>) results.get("이월금액")).isEmpty());
        assertFalse(((List<?>) results.get("거래내역")).isEmpty());
        assertFalse(((List<?>) results.get("월계")).isEmpty());
        assertFalse(((List<?>) results.get("누계")).isEmpty());
    }

    /**
     * 예적금 현황 원장 세부 정보 조회 기능을 테스트.
     */
    @Test
    public void depositLedgerDetailsTest2() {
        // Given: 테스트 데이터 설정
        prepareTestData();

        // When: 은행 계좌 등록
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 1, 31);
        Map<String, Object> results = accountInformationService.getDepositLedgerDetails("1", startDate, endDate);

        // Then: 은행 계좌가 등록되었는지 확인
        assertNotNull(results);
        assertFalse(((List<?>) results.get("계좌정보")).isEmpty());
        assertFalse(((List<?>) results.get("이월금액")).isEmpty());
        assertFalse(((List<?>) results.get("거래내역")).isEmpty());
        assertFalse(((List<?>) results.get("월계")).isEmpty());
        assertFalse(((List<?>) results.get("누계")).isEmpty());
    }

    /**
     * 테스트를 위한 초기 데이터를 준비.
     */
    private void prepareTestData() {
        BankAccount account = new BankAccount.Builder()
                .ERPCompanyId("1")
                .openingDate(LocalDate.of(2024, 1, 1))
                .bankName("국민은행")
                .branchLocation("부산")
                .number("123-456-789")
                .owner("홍길동")
                .depositType("예금")
                .build();
        bankAccountRepository.save(account);

        BankTransaction transaction = new BankTransaction.Builder()
                .accountId("2")
                .type("Deposit")
                .debit(BigDecimal.valueOf(500000))
                .carriedOverDebit(BigDecimal.ZERO)
                .credit(BigDecimal.ZERO)
                .carriedOverCredit(BigDecimal.ZERO)
                .date(LocalDate.of(2024, 2, 1))
                .currentBalance(BigDecimal.valueOf(500000))
                .build();
        bankTransactionRepository.save(transaction);
    }

    /**
     * 은행 계좌 정보 DTO를 생성하여 반환함.
     */
    private AccountInformationDto createAccountInformationDto() {
        AccountInformationDto accountDto = new AccountInformationDto();
        accountDto.setOpeningDate(LocalDate.of(2021, 1, 1));
        accountDto.setBankName("국민은행");
        accountDto.setBranchLocation("부산");
        accountDto.setNumber("123-456-789");
        accountDto.setOwner("홍길동");
        accountDto.setDepositType("예금");
        return accountDto;
    }

    /**
     * 은행 거래 정보 DTO를 생성하여 반환함.
     */
    private AccountInformationDto createTransactionDto() {
        AccountInformationDto transactionDto = new AccountInformationDto();
        transactionDto.setId("1");
        transactionDto.setType("입금");
        transactionDto.setDebit(BigDecimal.valueOf(1000000));
        transactionDto.setCarriedOverDebit(BigDecimal.ZERO);
        transactionDto.setCredit(BigDecimal.ZERO);
        transactionDto.setCarriedOverCredit(BigDecimal.ZERO);
        transactionDto.setDate(LocalDate.of(2021, 1, 1));
        transactionDto.setCurrentBalance(BigDecimal.valueOf(1000000));
        return transactionDto;
    }

}