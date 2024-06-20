package com.erp.system.financial.controller.basic_information_management;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
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
@Priority(3)
public class VoucherRegistrationController {
    private final VoucherRegistrationService voucherRegistrationService;
    private final AccountRepository accountRepository;
    private final MemoRepository memoRepository;
    private final VoucherRepository voucherRepository;
    private final VoucherTypeRepository voucherTypeRepository;

    public VoucherRegistrationController(VoucherRegistrationService voucherRegistrationService,
                                         AccountRepository accountRepository,
                                         MemoRepository memoRepository,
                                         VoucherRepository voucherRepository,
                                         VoucherTypeRepository voucherTypeRepository) {
        this.voucherRegistrationService = voucherRegistrationService;
        this.accountRepository = accountRepository;
        this.memoRepository = memoRepository;
        this.voucherRepository = voucherRepository;
        this.voucherTypeRepository = voucherTypeRepository;
    }
    /**
     * 계좌를 저장함
     * @param account 저장할 계좌
     */
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    /**
     * 메모를 저장함
     * @param memo 저장할 메모
     */
    public void saveMemo(Memo memo) {
        memoRepository.save(memo);
    }

    /**
     * 바우처를 저장함
     * @param voucher 저장할 바우처
     */
    public void saveVoucher(Voucher voucher) {
        voucherRepository.save(voucher);
    }

    /**
     * 바우처 유형을 저장함
     * @param voucherType 저장할 바우처 유형
     */
    public void saveVoucherType(VoucherType voucherType) {
        voucherTypeRepository.save(voucherType);
    }

    /**
     * ID로 계좌를 조회함
     * @param id 계좌의 ID
     * @return 조회된 계좌를 Optional로 반환
     */
    public Optional<Account> findAccountById(String id) {
        return accountRepository.findById(id);
    }

    /**
     * ID로 메모를 조회함
     * @param id 메모의 ID
     * @return 조회된 메모를 Optional로 반환
     */
    public Optional<Memo> findMemoById(String id) {
        return memoRepository.findById(id);
    }

    /**
     * ID로 바우처를 조회함
     * @param id 바우처의 ID
     * @return 조회된 바우처를 Optional로 반환
     */
    public Optional<Voucher> findVoucherById(String id) {
        return voucherRepository.findById(id);
    }

    /**
     * ID로 바우처 유형을 조회함
     * @param id 바우처 유형의 ID
     * @return 조회된 바우처 유형을 Optional로 반환
     */
    public Optional<VoucherType> findVoucherTypeById(String id) {
        return voucherTypeRepository.findById(id);
    }

    /**
     * 모든 계좌를 조회함
     * @return 저장된 모든 계좌의 컬렉션
     */
    public Collection<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * 모든 메모를 조회함
     * @return 저장된 모든 메모의 컬렉션
     */
    public Collection<Memo> findAllMemos() {
        return memoRepository.findAll();
    }

    /**
     * 모든 바우처를 조회함
     * @return 저장된 모든 바우처의 컬렉션
     */
    public Collection<Voucher> findAllVouchers() {
        return voucherRepository.findAll();
    }

    /**
     * 모든 바우처 유형을 조회함
     * @return 저장된 모든 바우처 유형의 컬렉션
     */
    public Collection<VoucherType> findAllVoucherTypes() {
        return voucherTypeRepository.findAll();
    }
}