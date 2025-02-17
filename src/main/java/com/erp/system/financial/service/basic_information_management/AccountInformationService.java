package com.erp.system.financial.service.basic_information_management;

import com.erp.system.financial.model.basic_information_management.account_information.Deposit;
import com.erp.system.financial.model.dto.AccountInformationDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AccountInformationService {
    void registerBankAccount(String userCompanyId, AccountInformationDto accountInformationDto);
    void registerBankTransaction(AccountInformationDto accountInformationDto);
    Map<String, Object> getDepositBalance(String userCompanyId, LocalDate date);
    Map<String, Object>  getDepositLedgerDetails(String userCompanyId, LocalDate startDate, LocalDate endDate);
}