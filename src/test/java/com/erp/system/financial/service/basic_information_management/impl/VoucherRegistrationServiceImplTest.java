package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.DependencyInjector;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Voucher;
import com.erp.system.financial.model.dto.VoucherDto;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.AccountRepository;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.MemoRepository;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.VoucherRepository;
import com.erp.system.financial.service.basic_information_management.VoucherRegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoucherRegistrationServiceImplTest {
    private VoucherRegistrationService voucherRegistrationService;
    private AccountRepository accountRepository;
    private MemoRepository memoRepository;
    private VoucherRepository voucherRepository;

    // 테스트 실행 전 초기 설정
    @BeforeEach
    void setUp() {
        // 싱글톤 인스턴스를 사용하여 저장소 초기화
        DependencyInjector injector = DependencyInjector.getInstance();

        voucherRegistrationService = injector.getInstance(VoucherRegistrationService.class);
        accountRepository = injector.getInstance(AccountRepository.class);
        memoRepository = injector.getInstance(MemoRepository.class);
        voucherRepository = injector.getInstance(VoucherRepository.class);

        accountRepository.reset();
        memoRepository.reset();
        voucherRepository.reset();
    }

    @Test
    public void registerVoucherTest() {
        // Given: 테스트 데이터 설정
        VoucherDto voucherDto = new VoucherDto();
        voucherDto.setAccountId("1");
        voucherDto.setCredit(BigDecimal.valueOf(0));
        voucherDto.setDate(LocalDate.of(24,7,2));
        voucherDto.setDebit(BigDecimal.valueOf(50000000));
        voucherDto.setDescription("테스트거래 입니다.");
        voucherDto.setVoucherType(Voucher.VoucherType.DISBURSEMENT);
        voucherDto.setUserCompanyId("1");
        voucherDto.setMemoId("1");
        voucherDto.setVendorId("1");
        voucherDto.setDepartmentId("1");

        // When: 매출매입전표 등록
        voucherRegistrationService.registerVoucher(voucherDto);

        // Then: 매출매입전표가 등록되었는지 확인

        voucherRepository.findById(String.valueOf(Voucher.idIndex-1)).ifPresent(voucher -> {
            assertEquals(Voucher.idIndex-1, Integer.parseInt(voucher.getId()));
            assertEquals(voucherDto.getAccountId(),voucher.getAccountId());
            assertEquals(voucherDto.getCredit(),voucher.getCredit());
            assertEquals(voucherDto.getDate(),voucher.getDate());
            assertEquals(voucherDto.getDebit(),voucher.getDebit());
            assertEquals(voucherDto.getDescription(),voucher.getDescription());
            assertEquals(voucherDto.getVoucherType(),voucher.getVoucherType());
            assertEquals(voucherDto.getUserCompanyId(),voucher.getUserCompanyId());
            assertEquals(voucherDto.getMemoId(),voucher.getMemoId());
            assertEquals(voucherDto.getVendorId(),voucher.getVendorId());
            assertEquals(voucherDto.getDepartmentId(),voucher.getDepartmentId());
        });

    }
}
