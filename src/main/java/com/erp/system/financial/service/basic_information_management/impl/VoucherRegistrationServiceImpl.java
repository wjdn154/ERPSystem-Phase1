package com.erp.system.financial.service.basic_information_management.impl;

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
@Priority(2)
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

    /**
     * 계좌를 저장함
     * @param account 저장할 계좌
     * @throws IllegalArgumentException 저장할 계좌가 null일 경우
     */
    @Override
    public void saveAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("저장할 계좌는 null일 수 없습니다.");
        }
        accountRepository.save(account);
    }

    /**
     * 메모를 저장함
     * @param memo 저장할 메모
     * @throws IllegalArgumentException 저장할 메모가 null일 경우
     */
    @Override
    public void saveMemo(Memo memo) {
        if (memo == null) {
            throw new IllegalArgumentException("저장할 메모는 null일 수 없습니다.");
        }
        memoRepository.save(memo);
    }

    /**
     * 바우처를 저장함
     * @param voucher 저장할 바우처
     * @throws IllegalArgumentException 저장할 바우처가 null일 경우
     */
    @Override
    public void saveVoucher(Voucher voucher) {
        if (voucher == null) {
            throw new IllegalArgumentException("저장할 바우처는 null일 수 없습니다.");
        }
        voucherRepository.save(voucher);
    }

    /**
     * 바우처 유형을 저장함
     * @param voucherType 저장할 바우처 유형
     * @throws IllegalArgumentException 저장할 바우처 유형이 null일 경우
     */
    @Override
    public void saveVoucherType(VoucherType voucherType) {
        if (voucherType == null) {
            throw new IllegalArgumentException("저장할 바우처 유형은 null일 수 없습니다.");
        }
        voucherTypeRepository.save(voucherType);
    }

    /**
     * ID로 계좌를 조회함
     * @param id 계좌의 ID
     * @return 조회된 계좌를 Optional로 반환
     */
    @Override
    public Optional<Account> findAccountById(String id) {
        return accountRepository.findById(id);
    }

    /**
     * 코드로 계좌를 조회함
     * @param code 계좌의 코드
     * @return 조회된 계좌를 Optional로 반환
     */
    @Override
    public Optional<Account> findAccountByCode(String code) {
        return accountRepository.findByCode(code);
    }

    /**
     * ID로 메모를 조회함
     * @param id 메모의 ID
     * @return 조회된 메모를 Optional로 반환
     */
    @Override
    public Optional<Memo> findMemoById(String id) {
        return memoRepository.findById(id);
    }

    /**
     * 코드로 메모를 조회함
     * @param code 메모의 코드
     * @return 조회된 메모를 Optional로 반환
     */
    @Override
    public Optional<Memo> findMemoByCode(String code) {
        return memoRepository.findByCode(code);
    }

    /**
     * ID로 바우처를 조회함
     * @param id 바우처의 ID
     * @return 조회된 바우처를 Optional로 반환
     */
    @Override
    public Optional<Voucher> findVoucherById(String id) {
        return voucherRepository.findById(id);
    }

    /**
     * 코드로 바우처를 조회함
     * @param code 바우처의 코드
     * @return 조회된 바우처를 Optional로 반환
     */
    @Override
    public Optional<Voucher> findVoucherByCode(String code) {
        return voucherRepository.findByCode(code);
    }

    /**
     * ID로 바우처 유형을 조회함
     * @param id 바우처 유형의 ID
     * @return 조회된 바우처 유형을 Optional로 반환
     */
    @Override
    public Optional<VoucherType> findVoucherTypeById(String id) {
        return voucherTypeRepository.findById(id);
    }

    /**
     * 코드로 바우처 유형을 조회함
     * @param code 바우처 유형의 코드
     * @return 조회된 바우처 유형을 Optional로 반환
     */
    @Override
    public Optional<VoucherType> findVoucherTypeByCode(String code) {
        return voucherTypeRepository.findByCode(code);
    }

    /**
     * 모든 계좌를 조회함
     * @return 저장된 모든 계좌의 컬렉션
     */
    @Override
    public Collection<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * 모든 메모를 조회함
     * @return 저장된 모든 메모의 컬렉션
     */
    @Override
    public Collection<Memo> findAllMemos() {
        return memoRepository.findAll();
    }

    /**
     * 모든 바우처를 조회함
     * @return 저장된 모든 바우처의 컬렉션
     */
    @Override
    public Collection<Voucher> findAllVouchers() {
        return voucherRepository.findAll();
    }

    /**
     * 모든 바우처 유형을 조회함
     * @return 저장된 모든 바우처 유형의 컬렉션
     */
    @Override
    public Collection<VoucherType> findAllVoucherTypes() {
        return voucherTypeRepository.findAll();
    }
}