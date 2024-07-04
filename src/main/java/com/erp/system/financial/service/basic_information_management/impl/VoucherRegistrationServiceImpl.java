package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Voucher;
import com.erp.system.financial.model.dto.VoucherDto;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.AccountRepository;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.MemoRepository;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.VoucherRepository;
import com.erp.system.financial.service.basic_information_management.VoucherRegistrationService;

@Component
public class VoucherRegistrationServiceImpl implements VoucherRegistrationService {
    private final AccountRepository accountRepository;
    private final MemoRepository memoRepository;
    private final VoucherRepository voucherRepository;
    public VoucherRegistrationServiceImpl(AccountRepository accountRepository,
                                          MemoRepository memoRepository,
                                          VoucherRepository voucherRepository) {
        this.accountRepository = accountRepository;
        this.memoRepository = memoRepository;
        this.voucherRepository = voucherRepository;
    }

    /**
     * 전표 등록 메소드 DTO를 바탕으로 전표 와 관련된 모든 정보를 생성하고 저장함
     * @param dto 전표등록을 위한 정보가 담긴 전달 객체
     * @throws RuntimeException 등록 중 발생한 예외를 처리함
     */
    @Override
    public void registerVoucher(VoucherDto dto) {
        try {
            Voucher voucher = createVoucher(dto);
            voucherRepository.save(voucher);
        } catch (Exception e) {
            System.err.println("전표 등록 중 에러 발생: " + e.getMessage());
            throw new RuntimeException("등록 실패", e);
        }
    }

    /**
     * @param dto 전표정보를 생성
     * @return 저장된 전표정보 객체반환
     */
    public Voucher createVoucher(VoucherDto dto) {
        return new Voucher.Builder()
                .accountId(dto.getAccountId())
                .date(dto.getDate())
                .voucherType(dto.getVoucherType())
                .credit(dto.getCredit())
                .description(dto.getDescription())
                .debit(dto.getDebit())
                .userCompanyId(dto.getUserCompanyId())
                .memoId(dto.getMemoId())
                .departmentId(dto.getDepartmentId())
                .vendorId(dto.getVendorId())
                .build();
    }

}