package com.erp.system.financial.service.basic_information_management;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Account;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Memo;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Voucher;
import com.erp.system.financial.model.basic_information_management.voucher_registration.VoucherType;

import java.util.Collection;
import java.util.Optional;

public interface VoucherRegistrationService {

    void saveAccount(Account account);
    void saveMemo(Memo memo);
    void saveVoucher(Voucher voucher);
    void saveVoucherType(VoucherType voucherType);

    Optional<Account> findAccountById(String id);
    Optional<Account> findAccountByCode(String code);
    Optional<Memo> findMemoById(String id);
    Optional<Memo> findMemoByCode(String code);
    Optional<Voucher> findVoucherById(String id);
    Optional<Voucher> findVoucherByCode(String code);
    Optional<VoucherType> findVoucherTypeById(String id);
    Optional<VoucherType> findVoucherTypeByCode(String code);

    Collection<Account> findAllAccounts();
    Collection<Memo> findAllMemos();
    Collection<Voucher> findAllVouchers();
    Collection<VoucherType> findAllVoucherTypes();
}