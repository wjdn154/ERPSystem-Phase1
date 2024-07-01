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
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AccountInformationServiceImplTest {
    private AccountInformationService accountInformationService;
    private BankAccountRepository bankAccountRepository;
    private BankTransactionRepository bankTransactionRepository;
    private DepositRepository depositRepository;

    // 테스트 실행 전 초기 설정
    @BeforeEach
    void setUp() {
        // 싱글톤 인스턴스를 사용하여 저장소 초기화
        DependencyInjector injector = DependencyInjector.getInstance();

        accountInformationService = injector.getInstance(AccountInformationService.class);
        bankAccountRepository = injector.getInstance(BankAccountRepository.class);
        bankTransactionRepository = injector.getInstance(BankTransactionRepository.class);
        depositRepository = injector.getInstance(DepositRepository.class);

        bankAccountRepository.reset();
        bankTransactionRepository.reset();
        depositRepository.reset();
    }

    @Test
    public void registerBankAccountTest() {
        // Given: 테스트 데이터 설정
        AccountInformationDto accountInformationDto = new AccountInformationDto();
        accountInformationDto.setOpeningDate(LocalDate.of(2021, 1, 1));
        accountInformationDto.setBankName("국민은행");
        accountInformationDto.setBranchLocation("부산");
        accountInformationDto.setNumber("123-456-789");
        accountInformationDto.setOwner("홍길동");
        accountInformationDto.setDepositType("예금");
        String ERPCompanyId = "1";

        // When: 은행 계좌 등록
        accountInformationService.registerBankAccount(ERPCompanyId, accountInformationDto);

        // Then: 은행 계좌가 등록되었는지 확인
//        System.out.println(bankAccountRepository.findById(String.valueOf(BankAccount.idIndex-1)).get().toString());
        bankAccountRepository.findById(String.valueOf(BankAccount.idIndex-1)).ifPresent(bankAccount -> {
            assertEquals(LocalDate.of(2021, 1, 1), bankAccount.getOpeningDate());
            assertEquals("국민은행", bankAccount.getBankName());
            assertEquals("부산", bankAccount.getBranchLocation());
            assertEquals("123-456-789", bankAccount.getNumber());
            assertEquals("홍길동", bankAccount.getOwner());
            assertEquals("예금", bankAccount.getDepositType());
        });
    }

    @Test
    public void registerBankTransactionTest() {
        // Given: 테스트 데이터 설정
        AccountInformationDto accountInformationDto = new AccountInformationDto();
        accountInformationDto.setId("1");
        accountInformationDto.setBankTransactionBankName("국민은행");
        accountInformationDto.setType("입금");
        accountInformationDto.setDebit(BigDecimal.valueOf(1000000));
        accountInformationDto.setCredit(BigDecimal.valueOf(0));
        accountInformationDto.setDate(LocalDate.of(2021, 1, 1));
        accountInformationDto.setCurrentBalance(BigDecimal.valueOf(1000000));

        // When: 은행 거래 등록
        accountInformationService.registerBankTransaction(accountInformationDto);

        // Then: 은행 거래가 등록되었는지 확인
//        System.out.println(bankTransactionRepository.findById(String.valueOf(BankTransaction.idIndex-1)).get().toString());
        bankTransactionRepository.findById(String.valueOf(BankTransaction.idIndex-1)).ifPresent(bankTransaction -> {
            assertEquals("입금", bankTransaction.getType());
            assertEquals(BigDecimal.valueOf(1000000), bankTransaction.getDebit());
            assertEquals(BigDecimal.valueOf(0), bankTransaction.getCredit());
            assertEquals(LocalDate.of(2021, 1, 1), bankTransaction.getDate());
            assertEquals(BigDecimal.valueOf(1000000), bankTransaction.getCurrentBalance());
        });
    }

    @Test
    public void getDepositBalanceTest() {
        new ERPDataInitializer();
        Map<String, Object> joinedList = accountInformationService.getDepositBalance("1", LocalDate.of(2024, 7, 1));


        System.out.println("joinedList.get(results) = " + joinedList.get("results"));
        System.out.println("joinedList.get(totalBalance) = " + joinedList.get("totalBalance"));
    }

    @Test
    public void getDepositBalanceTest2() {
        // Given
        BankAccount account = new BankAccount.Builder()
                .ERPCompanyId("1")
                .openingDate(LocalDate.of(2024, 6, 1))
                .bankName("국민은행")
                .branchLocation("부산")
                .number("366-394-583")
                .owner("최현우")
                .depositType("예금")
                .build();
        bankAccountRepository.save(account);

        BankTransaction transaction = new BankTransaction.Builder()
                .accountId("1")
                .type("입금")
                .date(LocalDate.of(2024, 7, 1))
                .debit(new BigDecimal("1000000"))
                .credit(BigDecimal.ZERO)
                .currentBalance(new BigDecimal("1000000"))
                .build();
        bankTransactionRepository.save(transaction);

        String ERPCompanyId = "1";
        LocalDate date = LocalDate.of(2024, 7, 1);

        // When
        Map<String, Object> results = accountInformationService.getDepositBalance(ERPCompanyId, date);

        // Then
        assertNotNull(results);
        assertFalse(((List<Map<String, Object>>) results.get("results")).isEmpty());
        assertEquals(new BigDecimal("1000000"), results.get("totalBalance"));


    }
}