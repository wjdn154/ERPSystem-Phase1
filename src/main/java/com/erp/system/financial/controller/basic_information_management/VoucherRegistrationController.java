package com.erp.system.financial.controller.basic_information_management;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Account;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Memo;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Voucher;
import com.erp.system.financial.model.basic_information_management.voucher_registration.VoucherType;
import com.erp.system.financial.service.basic_information_management.VoucherRegistrationService;

import java.util.Collection;
import java.util.Optional;

@Component
@Priority(3)
public class VoucherRegistrationController {
    private final VoucherRegistrationService voucherRegistrationService;

    public VoucherRegistrationController(VoucherRegistrationService voucherRegistrationService) {
        this.voucherRegistrationService = voucherRegistrationService;
    }
    /**
     * 계좌를 저장함
     * @param account 저장할 계좌
     */
    public void saveAccount(Account account) {
        voucherRegistrationService.saveAccount(account);
    }

    /**
     * 메모를 저장함
     * @param memo 저장할 메모
     */
    public void saveMemo(Memo memo) {
        voucherRegistrationService.saveMemo(memo);
    }

    /**
     * 바우처를 저장함
     * @param voucher 저장할 바우처
     */
    public void saveVoucher(Voucher voucher) {
        voucherRegistrationService.saveVoucher(voucher);
    }

    /**
     * 바우처 유형을 저장함
     * @param voucherType 저장할 바우처 유형
     */
    public void saveVoucherType(VoucherType voucherType) {
        voucherRegistrationService.saveVoucherType(voucherType);
    }

    /**
     * ID로 계좌를 조회함
     * @param id 계좌의 ID
     * @return 조회된 계좌를 Optional로 반환
     */
    public Optional<Account> findAccountById(String id) {
        return voucherRegistrationService.findAccountById(id);
    }

    /**
     * 코드로 계좌를 조회함
     * @param code 계좌의 코드
     * @return 조회된 계좌를 Optional로 반환
     */
    public Optional<Account> findAccountByCode(String code) {
        return voucherRegistrationService.findAccountByCode(code);
    }

    /**
     * ID로 메모를 조회함
     * @param id 메모의 ID
     * @return 조회된 메모를 Optional로 반환
     */
    public Optional<Memo> findMemoById(String id) {
        return voucherRegistrationService.findMemoById(id);
    }

    /**
     * 코드로 메모를 조회함
     * @param code 메모의 코드
     * @return 조회된 메모를 Optional로 반환
     */
    public Optional<Memo> findMemoByCode(String code) {
        return voucherRegistrationService.findMemoByCode(code);
    }

    /**
     * ID로 바우처를 조회함
     * @param id 바우처의 ID
     * @return 조회된 바우처를 Optional로 반환
     */
    public Optional<Voucher> findVoucherById(String id) {
        return voucherRegistrationService.findVoucherById(id);
    }

    /**
     * 코드로 바우처를 조회함
     * @param code 바우처의 코드
     * @return 조회된 바우처를 Optional로 반환
     */
    public Optional<Voucher> findVoucherByCode(String code) {
        return voucherRegistrationService.findVoucherByCode(code);
    }

    /**
     * ID로 바우처 유형을 조회함
     * @param id 바우처 유형의 ID
     * @return 조회된 바우처 유형을 Optional로 반환
     */
    public Optional<VoucherType> findVoucherTypeById(String id) {
        return voucherRegistrationService.findVoucherTypeById(id);
    }

    /**
     * 코드로 바우처 유형을 조회함
     * @param code 바우처 유형의 코드
     * @return 조회된 바우처 유형을 Optional로 반환
     */
    public Optional<VoucherType> findVoucherTypeByCode(String code) {
        return voucherRegistrationService.findVoucherTypeByCode(code);
    }

    /**
     * 모든 계좌를 조회함
     * @return 저장된 모든 계좌의 컬렉션
     */
    public Collection<Account> findAllAccounts() {
        return voucherRegistrationService.findAllAccounts();
    }

    /**
     * 모든 메모를 조회함
     * @return 저장된 모든 메모의 컬렉션
     */
    public Collection<Memo> findAllMemos() {
        return voucherRegistrationService.findAllMemos();
    }

    /**
     * 모든 바우처를 조회함
     * @return 저장된 모든 바우처의 컬렉션
     */
    public Collection<Voucher> findAllVouchers() {
        return voucherRegistrationService.findAllVouchers();
    }

    /**
     * 모든 바우처 유형을 조회함
     * @return 저장된 모든 바우처 유형의 컬렉션
     */
    public Collection<VoucherType> findAllVoucherTypes() {
        return voucherRegistrationService.findAllVoucherTypes();
    }
}