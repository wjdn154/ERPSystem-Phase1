package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.DependencyInjector;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.dto.PurchaseSalesSlipRegistrationDto;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntryRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.PurchaseSalesSlipRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.VatTypeRepository;
import com.erp.system.financial.service.basic_information_management.PurchaseSalesSlipService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseSalesSlipServiceImplTest {

        private PurchaseSalesSlipService purchaseSalesSlipService;
        private EntryRepository entryRepository;
        private PurchaseSalesSlipRepository purchaseSalesSlipRepository;
        private VatTypeRepository vatTypeRepository;

        // 테스트 실행 전 초기 설정
        @BeforeEach
        void setUp() {
            // 싱글톤 인스턴스를 사용하여 저장소 초기화
            DependencyInjector injector = DependencyInjector.getInstance();

            purchaseSalesSlipService = injector.getInstance(PurchaseSalesSlipService.class);
            entryRepository = injector.getInstance(EntryRepository.class);
            purchaseSalesSlipRepository = injector.getInstance(PurchaseSalesSlipRepository.class);
            vatTypeRepository = injector.getInstance(VatTypeRepository.class);

            entryRepository.reset();
            purchaseSalesSlipRepository.reset();
            vatTypeRepository.reset();
        }

        @Test
        public void registerPurchaseSalesSlipTest() {
            // Given: 테스트 데이터 설정
            PurchaseSalesSlipRegistrationDto purchaseSalesSlipRegistrationDto = new PurchaseSalesSlipRegistrationDto();
            purchaseSalesSlipRegistrationDto.setElectronicTaxInvoiceIssued(true);
            purchaseSalesSlipRegistrationDto.setDate(LocalDate.of(24,7,2));
            purchaseSalesSlipRegistrationDto.setEntryId("2");
            purchaseSalesSlipRegistrationDto.setDepartmentId("1");
            purchaseSalesSlipRegistrationDto.setQuantity(BigDecimal.valueOf(50));
            purchaseSalesSlipRegistrationDto.setUserCompanyId("1");
            purchaseSalesSlipRegistrationDto.setItemName("김밥");
            purchaseSalesSlipRegistrationDto.setSupplyValue(BigDecimal.valueOf(10000));
            purchaseSalesSlipRegistrationDto.setUnitPrice(BigDecimal.valueOf(1000));
            purchaseSalesSlipRegistrationDto.setVat(BigDecimal.valueOf(100000));
            purchaseSalesSlipRegistrationDto.setVatTypeId("2");
            purchaseSalesSlipRegistrationDto.setVendorId("1");

            // When: 매출매입전표 등록
            purchaseSalesSlipService.registerPurchaseSalesSlip(purchaseSalesSlipRegistrationDto);

            // Then: 매출매입전표가 등록되었는지 확인
            purchaseSalesSlipRepository.findById(String.valueOf(PurchaseSalesSlip.idIndex-1)).ifPresent(purchaseSalesSlip -> {
                System.out.println("전송 객체 ::: " + purchaseSalesSlipRegistrationDto.toString());
                System.out.println("저장 객체 ::: " + purchaseSalesSlip.toString());
                assertEquals(purchaseSalesSlipRegistrationDto.getElectronicTaxInvoiceIssued(), purchaseSalesSlip.getElectronicTaxInvoiceIssued());
                assertEquals(purchaseSalesSlipRegistrationDto.getDate(), purchaseSalesSlip.getDate());
                assertEquals(purchaseSalesSlipRegistrationDto.getEntryId(), purchaseSalesSlip.getEntryId());
                assertEquals(purchaseSalesSlipRegistrationDto.getDepartmentId(), purchaseSalesSlip.getDepartmentId());
                assertEquals(purchaseSalesSlipRegistrationDto.getQuantity(),purchaseSalesSlip.getQuantity());
                assertEquals(purchaseSalesSlipRegistrationDto.getUserCompanyId(),purchaseSalesSlip.getUserCompanyId());
                assertEquals(purchaseSalesSlipRegistrationDto.getItemName(),purchaseSalesSlip.getItemName());
                assertEquals(purchaseSalesSlipRegistrationDto.getSupplyValue(),purchaseSalesSlip.getSupplyValue());
                assertEquals(purchaseSalesSlipRegistrationDto.getUnitPrice(),purchaseSalesSlip.getUnitPrice());
                assertEquals(purchaseSalesSlipRegistrationDto.getVat(),purchaseSalesSlip.getVat());
                assertEquals(purchaseSalesSlipRegistrationDto.getVatTypeId(),purchaseSalesSlip.getVatTypeId());
                assertEquals(purchaseSalesSlipRegistrationDto.getVendorId(),purchaseSalesSlip.getVendorId());
            });
        }

}
