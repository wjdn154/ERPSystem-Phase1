package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Account;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Memo;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Voucher;
import com.erp.system.financial.model.basic_information_management.voucher_registration.VoucherType;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.AccountRepository;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.MemoRepository;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.VoucherRepository;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.VoucherTypeRepository;
import com.erp.system.financial.service.basic_information_management.VoucherRegistrationService;

import java.util.Collection;
import java.util.Optional;

@Component
public class VoucherRegistrationServiceImpl implements VoucherRegistrationService {
    private final AccountRepository accountRepository;
    private final MemoRepository memoRepository;
    private final VoucherRepository voucherRepository;
    private final VoucherTypeRepository voucherTypeRepository;

    public VoucherRegistrationServiceImpl(AccountRepository accountRepository,
                                          MemoRepository memoRepository,
                                          VoucherRepository voucherRepository,
                                          VoucherTypeRepository voucherTypeRepository) {
        this.accountRepository = accountRepository;
        this.memoRepository = memoRepository;
        this.voucherRepository = voucherRepository;
        this.voucherTypeRepository = voucherTypeRepository;
    }

}