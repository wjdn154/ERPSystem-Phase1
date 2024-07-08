package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.HashJoin;
import com.erp.system.common.annotation.Component;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccount;
import com.erp.system.financial.model.basic_information_management.account_information.BankTransaction;
import com.erp.system.financial.model.basic_information_management.account_information.Deposit;
import com.erp.system.financial.model.dto.AccountInformationDto;
import com.erp.system.financial.repository.basic_information_management.account_information.BankAccountRepository;
import com.erp.system.financial.repository.basic_information_management.account_information.BankTransactionRepository;
import com.erp.system.financial.repository.basic_information_management.account_information.DepositRepository;
import com.erp.system.financial.service.basic_information_management.AccountInformationService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class AccountInformationServiceImpl implements AccountInformationService {
    private final BankAccountRepository bankAccountRepository;
    private final BankTransactionRepository bankTransactionRepository;
    private final DepositRepository depositRepository;

    public AccountInformationServiceImpl(BankAccountRepository bankAccountRepository,
                                         BankTransactionRepository bankTransactionRepository,
                                         DepositRepository depositRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankTransactionRepository = bankTransactionRepository;
        this.depositRepository = depositRepository;
    }


    /**
     * 은행 계좌 등록 메소드.
     * @param accountInformationDto 은행 계좌 등록을 위한 정보가 담긴 DTO
     * @throws RuntimeException 등록 중 발생한 예외를 처리함
     */
    @Override
    public void registerBankAccount(AccountInformationDto accountInformationDto) {
        try {

        BankAccount bankAccount = new BankAccount.Builder()
                .ERPCompanyId(accountInformationDto.getERPCompanyId())
                .openingDate(accountInformationDto.getOpeningDate())
                .bankName(accountInformationDto.getBankName())
                .branchLocation(accountInformationDto.getBranchLocation())
                .number(accountInformationDto.getNumber())
                .owner(accountInformationDto.getOwner())
                .depositType(accountInformationDto.getDepositType())
                .build();

        bankAccountRepository.save(bankAccount);

        } catch (Exception e) {
            System.err.println("은행 계좌 등록 중 에러 발생: " + e.getMessage());
            throw new RuntimeException("등록 실패", e);
        }
    }

    /**
     * 은행 거래 등록 메소드.
     * @param accountInformationDto 은행 거래 등록을 위한 정보가 담긴 DTO
     * @throws RuntimeException 등록 중 발생한 예외를 처리함
     */
    @Override
    public void registerBankTransaction(AccountInformationDto accountInformationDto) {
        try {
            BankTransaction bankTransaction = new BankTransaction.Builder()
                    .accountId(accountInformationDto.getId())
                    .type(accountInformationDto.getType())
                    .credit(accountInformationDto.getCredit())
                    .debit(accountInformationDto.getDebit())
                    .date(accountInformationDto.getDate())
                    .currentBalance(accountInformationDto.getCurrentBalance())
                    .build();

            bankTransactionRepository.save(bankTransaction);

        } catch (Exception e) {
            System.err.println("은행 거래 등록 중 에러 발생: " + e.getMessage());
            throw new RuntimeException("등록 실패", e);
        }
    }

    /**
     * 지정된 ERP 회사 ID와 날짜에 해당하는 입금 잔액을 조회.
     *
     * @param ERPCompanyId 조회할 ERP 회사의 ID.
     * @param date 조회할 날짜.
     * @return 조회된 입금 잔액 목록과 총 잔액을 포함한 Map을 반환.
     */
    @Override
    public Map<String, Object> getDepositBalance(String ERPCompanyId, LocalDate date) {
        List<BankAccount> bankAccounts = getBankAccountsForCompany(ERPCompanyId);
        List<String> accountIds = extractAccountIds(bankAccounts);
        List<BankTransaction> bankTransactions = getTransactionsForDate(accountIds, date);
        List<Map<String, Object>> joinedList = HashJoin.hashJoin(bankAccounts, bankTransactions, BankAccount::getId, BankTransaction::getAccountId);

        BigDecimal totalBalance = calculateTotalBalance(joinedList);
        List<Map<String, Object>> results = buildResultsList(joinedList);

        return createResultMap(results, totalBalance);
    }

    @Override
    public List<Deposit> getDepositLedgerDetails(String ERPCompanyId, LocalDate startDate, LocalDate endDate) {
        return null;
    }

    /**
     * 주어진 ERP 회사 ID에 해당하는 모든 은행 계좌를 조회.
     *
     * @param ERPCompanyId 조회할 ERP 회사의 ID.
     * @return 조회된 은행 계좌 목록.
     */
    private List<BankAccount> getBankAccountsForCompany(String ERPCompanyId) {
        return bankAccountRepository.findAll()
                .stream()
                .filter(bankAccount -> bankAccount.getERPCompanyId().equals(ERPCompanyId))
                .collect(Collectors.toList());
    }

    /**
     * 은행 계좌 목록에서 계좌 ID를 추출.
     *
     * @param bankAccounts 은행 계좌 목록.
     * @return 계좌 ID 목록.
     */
    private List<String> extractAccountIds(List<BankAccount> bankAccounts) {
        return bankAccounts.stream()
                .map(BankAccount::getId)
                .collect(Collectors.toList());
    }

    /**
     * 지정된 계좌 ID와 날짜에 해당하는 거래 내역을 조회.
     *
     * @param accountIds 조회할 계좌 ID 목록.
     * @param date 조회할 날짜.
     * @return 조회된 거래 내역 목록.
     */
    private List<BankTransaction> getTransactionsForDate(List<String> accountIds, LocalDate date) {
        return bankTransactionRepository.findAll()
                .stream()
                .filter(transaction -> accountIds.contains(transaction.getAccountId()) && transaction.getDate().isEqual(date))
                .collect(Collectors.toList());
    }

    /**
     * 조인된 리스트에서 총 잔액을 계산.
     *
     * @param joinedList 조인된 은행 계좌와 거래 내역 목록.
     * @return 계산된 총 잔액.
     */
    private BigDecimal calculateTotalBalance(List<Map<String, Object>> joinedList) {
        return joinedList.stream()
                .map(joinedItem -> (BigDecimal) joinedItem.get("BankTransaction.currentBalance"))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * 조인된 리스트를 기반으로 최종 결과 목록을 생성.
     *
     * @param joinedList 조인된 은행 계좌와 거래 내역 목록.
     * @return 결과 목록임, 각 항목은 계좌 정보와 거래 내역을 포함.
     */
    private List<Map<String, Object>> buildResultsList(List<Map<String, Object>> joinedList) {
        return joinedList.stream().map(joinedItem -> {
            Map<String, Object> result = new HashMap<>();
            result.put("코드", joinedItem.get("id"));
            result.put("계좌명", joinedItem.get("owner"));
            result.put("계좌번호", joinedItem.get("number"));
            result.put("예금종류", joinedItem.get("depositType"));
            result.put("잔액", joinedItem.get("BankTransaction.currentBalance"));
            result.put("개설일", joinedItem.get("openingDate"));
            result.put("만기일", "N/A");
            result.put("금융기관", joinedItem.get("bankName"));
            result.put("계좌개설점", joinedItem.get("branchLocation"));
            return result;
        }).collect(Collectors.toList());
    }

    /**
     * 최종 결과와 총 잔액을 포함하는 Map을 생성.
     *
     * @param results 결과 목록.
     * @param totalBalance 총 잔액.
     * @return 결과와 총 잔액을 포함한 Map.
     */
    private Map<String, Object> createResultMap(List<Map<String, Object>> results, BigDecimal totalBalance) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("results", results);
        resultMap.put("totalBalance", totalBalance);
        return resultMap;
    }
}