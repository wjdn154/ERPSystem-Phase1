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
import java.time.YearMonth;
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
    public void registerBankAccount(String userCompanyId, AccountInformationDto accountInformationDto) {
        try {

        BankAccount bankAccount = new BankAccount.Builder()
                .userCompanyId(userCompanyId)
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
                    .description(accountInformationDto.getDescription())
                    .debit(accountInformationDto.getDebit())
                    .carriedOverDebit(accountInformationDto.getCarriedOverDebit())
                    .credit(accountInformationDto.getCredit())
                    .carriedOverCredit(accountInformationDto.getCarriedOverCredit())
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
     * @param userCompanyId 조회할 ERP 회사의 ID.
     * @param date 조회할 날짜.
     * @return 조회된 입금 잔액 목록과 총 잔액을 포함한 Map을 반환.
     */
    @Override
    public Map<String, Object> getDepositBalance(String userCompanyId, LocalDate date) {
        List<BankAccount> bankAccounts = getBankAccountsForCompany(userCompanyId);
        List<String> accountIds = extractAccountIds(bankAccounts);
        List<BankTransaction> bankTransactions = getTransactionsForDate(accountIds, date);
        List<Map<String, Object>> joinedList = HashJoin.hashJoin(bankAccounts, bankTransactions, BankAccount::getId, BankTransaction::getAccountId);

        BigDecimal totalBalance = calculateTotalBalance(joinedList);
        List<Map<String, Object>> results = buildResultsList(joinedList);

        return createResultMap(results, totalBalance);
    }

    /**
     * 지정된 ERP 회사 ID와 날짜 범위에 따른 입금 잔액을 조회함.
     *
     * @param userCompanyId 조회할 ERP 회사의 ID
     * @param startDate 조회 시작 날짜
     * @param endDate 조회 종료 날짜
     * @return 조회된 입금 잔액 목록과 총 잔액을 포함한 Map을 반환함
     */
    @Override
    public Map<String, Object> getDepositLedgerDetails(String userCompanyId, LocalDate startDate, LocalDate endDate) {
        List<BankAccount> bankAccounts = getBankAccountsForCompany(userCompanyId); // ERPId에 해당하는 모든 bankAccount
        List<String> accountIds = extractAccountIds(bankAccounts); // 위 bankAccount 의 id 추출
        List<BankTransaction> bankTransactions = getTransactionsForDate(accountIds, startDate, endDate); // 기간 중 발생한 모든 bankTransaction && id = accountId
        Map<String, List<BankTransaction>> transactionsByAccountId = bankTransactions.stream().collect(Collectors.groupingBy(BankTransaction::getAccountId)); // group by accountId
        System.out.println("transactionsByAccountId = " + transactionsByAccountId);

        List<Map<String, Object>> accountDetailsList = buildAccountDetails(bankAccounts); // 계좌정보
        List<Map<String, Object>> carriedOverAmountsList = calculateCarriedOverAmounts(transactionsByAccountId); // 계좌별 이월금액
        List<Map<String, Object>> transactionDetailsList = buildTransactionDetails(transactionsByAccountId); // 계좌별 거래내역
        List<Map<String, Object>> monthlySummaryList = calculateMonthlySummary(transactionsByAccountId); // 계좌별 월계
        List<Map<String, Object>> cumulativeSummaryList = calculateCumulativeSummary(transactionsByAccountId, carriedOverAmountsList); // 계좌별 누계

        Map<String, Object> results = new HashMap<>();
        results.put("계좌정보", accountDetailsList);
        results.put("이월금액", carriedOverAmountsList);
        results.put("거래내역", transactionDetailsList);
        results.put("월계", monthlySummaryList);
        results.put("누계", cumulativeSummaryList);

        return results;
    }

    /**
     * 주어진 ERP 회사 ID에 해당하는 모든 은행 계좌를 조회.
     *
     * @param userCompanyId 조회할 ERP 회사의 ID.
     * @return 조회된 은행 계좌 목록.
     */
    private List<BankAccount> getBankAccountsForCompany(String userCompanyId) {
        return bankAccountRepository.findAll()
                .stream()
                .filter(bankAccount -> bankAccount.getUserCompanyId().equals(userCompanyId))
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
     * 지정된 계좌 ID와 날짜에 해당하는 거래 내역을 조회.
     *
     * @param accountIds 조회할 계좌 ID 목록.
     * @param startDate 조회할 날짜 시작일.
     * @param endDate 조회할 날짜 종료일.
     * @return 조회된 거래 내역 목록.
     */
    private List<BankTransaction> getTransactionsForDate(List<String> accountIds, LocalDate startDate, LocalDate endDate) {
        return bankTransactionRepository.findAll()
                .stream()
                .filter(transaction -> accountIds.contains(transaction.getAccountId()) &&
                        !transaction.getDate().isBefore(startDate) &&
                        !transaction.getDate().isAfter(endDate))
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
        resultMap.put("합계", totalBalance);
        return resultMap;
    }


    /**
     * 계좌의 기본 정보를 리스트 형태로 구성.
     *
     * @param bankAccounts 계좌 목록
     * @return 계좌 기본 정보가 담긴 Map 리스트
     */
    private List<Map<String, Object>> buildAccountDetails(List<BankAccount> bankAccounts) {
        return bankAccounts.stream().map(account -> {
            Map<String, Object> details = new HashMap<>();
            details.put("계좌ID", account.getId());
            details.put("계좌명", account.getBankName());
            details.put("계좌번호", account.getNumber());
            return details;
        }).collect(Collectors.toList());
    }

    /**
     * 계좌별 이월 금액을 계산.
     *
     * @param transactionsByAccountId 계좌 ID별 거래 목록
     * @return 계좌별 이월 금액이 담긴 Map 리스트
     */
    private List<Map<String, Object>> calculateCarriedOverAmounts(Map<String, List<BankTransaction>> transactionsByAccountId) {
        return transactionsByAccountId.entrySet().stream().map(entry -> {
            Map<String, Object> carriedOver = new HashMap<>();
            String accountId = entry.getKey();
            List<BankTransaction> transactions = entry.getValue();
            BigDecimal carriedOverDebit = transactions.isEmpty() ? BigDecimal.ZERO : transactions.get(0).getCarriedOverDebit();
            BigDecimal carriedOverCredit = transactions.isEmpty() ? BigDecimal.ZERO : transactions.get(0).getCarriedOverCredit();
            BigDecimal carriedOverBalance = carriedOverDebit.subtract(carriedOverCredit);

            carriedOver.put("계좌ID", accountId);
            carriedOver.put("차변 이월금액", carriedOverDebit);
            carriedOver.put("대변 이월금액", carriedOverCredit);
            carriedOver.put("잔액 이월금액", carriedOverBalance);
            return carriedOver;
        }).collect(Collectors.toList());
    }

    /**
     * 거래 내역을 구성.
     *
     * @param transactionsByAccountId 계좌 ID별 거래 목록
     * @return 거래 내역이 담긴 Map 리스트
     */
    private List<Map<String, Object>> buildTransactionDetails(Map<String, List<BankTransaction>> transactionsByAccountId) {
        List<Map<String, Object>> transactionDetails = new ArrayList<>();
        transactionsByAccountId.forEach((accountId, transactions) -> {
            transactions.forEach(transaction -> {
                Map<String, Object> detail = new HashMap<>();
                detail.put("계좌ID", accountId);
                detail.put("거래일자", transaction.getDate());
                detail.put("적요", transaction.getDescription());
                detail.put("차변", transaction.getDebit());
                detail.put("대변", transaction.getCredit());
                detail.put("잔액", transaction.getCurrentBalance());
                transactionDetails.add(detail);
            });
        });
        return transactionDetails;
    }

    /**
     * 월별 차변과 대변의 누계를 계산.
     *
     * @param transactionsByAccountId 계좌 ID별 거래 목록
     * @return 월별 차변과 대변의 누계가 담긴 Map 리스트
     */
    private List<Map<String, Object>> calculateMonthlySummary(Map<String, List<BankTransaction>> transactionsByAccountId) {
        Map<String, Map<YearMonth, BigDecimal>> monthlyDebits = new HashMap<>();
        Map<String, Map<YearMonth, BigDecimal>> monthlyCredits = new HashMap<>();

        transactionsByAccountId.forEach((accountId, transactions) -> {
            transactions.forEach(transaction -> {
                YearMonth ym = YearMonth.from(transaction.getDate());
                monthlyDebits.computeIfAbsent(accountId, k -> new HashMap<>()).merge(ym, transaction.getDebit(), BigDecimal::add);
                monthlyCredits.computeIfAbsent(accountId, k -> new HashMap<>()).merge(ym, transaction.getCredit(), BigDecimal::add);
            });
        });

        List<Map<String, Object>> monthlySummaryList = new ArrayList<>();
        monthlyDebits.forEach((accountId, monthlyMap) -> {
            monthlyMap.forEach((ym, totalDebit) -> {
                BigDecimal totalCredit = monthlyCredits.getOrDefault(accountId, new HashMap<>()).getOrDefault(ym, BigDecimal.ZERO);
                Map<String, Object> monthlySummary = new HashMap<>();
                monthlySummary.put("계좌ID", accountId);
                monthlySummary.put("월", ym);
                monthlySummary.put("월계 차변", totalDebit);
                monthlySummary.put("월계 대변", totalCredit);
                monthlySummaryList.add(monthlySummary);
            });
        });
        return monthlySummaryList;
    }

    /**
     * 이월 금액과 월별 누계 합을 계산하여 누적 집계를 제공.
     *
     * @param transactionsByAccountId 계좌 ID별 거래 목록
     * @param carriedOverAmountsList 이월 금액 목록
     * @return 누적 집계 정보가 담긴 Map 리스트
     */
    private List<Map<String, Object>> calculateCumulativeSummary(Map<String, List<BankTransaction>> transactionsByAccountId, List<Map<String, Object>> carriedOverAmountsList) {

        List<Map<String, Object>> cumulativeSummaryList = new ArrayList<>();
        transactionsByAccountId.forEach((accountId, transactions) -> {
            BigDecimal carriedOverDebit = transactions.isEmpty() ? BigDecimal.ZERO : transactions.get(0).getCarriedOverDebit();
            BigDecimal carriedOverCredit = transactions.isEmpty() ? BigDecimal.ZERO : transactions.get(0).getCarriedOverCredit();
            BigDecimal cumulativeDebit = transactions.stream().map(BankTransaction::getDebit).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal cumulativeCredit = transactions.stream().map(BankTransaction::getCredit).reduce(BigDecimal.ZERO, BigDecimal::add);


            Map<String, Object> cumulativeSummary = new HashMap<>();
            cumulativeSummary.put("계좌ID", accountId);
            cumulativeSummary.put("누계 차변", carriedOverDebit.add(cumulativeDebit));
            cumulativeSummary.put("누계 대변", carriedOverCredit.add(cumulativeCredit));
            cumulativeSummaryList.add(cumulativeSummary);
        });
        return cumulativeSummaryList;
    }

}