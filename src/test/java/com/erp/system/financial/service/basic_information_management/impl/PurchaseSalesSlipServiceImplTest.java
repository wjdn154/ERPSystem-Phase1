package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.DependencyInjector;
import com.erp.system.common.ERPDataInitializer;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.dto.PurchaseSalesSlipDto;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntryRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.PurchaseSalesSlipRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.VatTypeRepository;
import com.erp.system.financial.service.basic_information_management.PurchaseSalesSlipService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
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
            PurchaseSalesSlipDto purchaseSalesSlipDto = new PurchaseSalesSlipDto();
            purchaseSalesSlipDto.setElectronicTaxInvoiceIssued(true);
            purchaseSalesSlipDto.setDate(LocalDate.of(24,7,2));
            purchaseSalesSlipDto.setEntryId("2");
            purchaseSalesSlipDto.setDepartmentId("1");
            purchaseSalesSlipDto.setQuantity(BigDecimal.valueOf(50));
            purchaseSalesSlipDto.setUserCompanyId("1");
            purchaseSalesSlipDto.setItemName("김밥");
            purchaseSalesSlipDto.setSupplyValue(BigDecimal.valueOf(10000));
            purchaseSalesSlipDto.setUnitPrice(BigDecimal.valueOf(1000));
            purchaseSalesSlipDto.setVat(BigDecimal.valueOf(100000));
            purchaseSalesSlipDto.setVatTypeId("2");
            purchaseSalesSlipDto.setVendorId("1");

            // When: 매출매입전표 등록
            purchaseSalesSlipService.registerPurchaseSalesSlip(purchaseSalesSlipDto);

            // Then: 매출매입전표가 등록되었는지 확인
            purchaseSalesSlipRepository.findById(String.valueOf(PurchaseSalesSlip.idIndex-1)).ifPresent(purchaseSalesSlip -> {
                assertEquals(purchaseSalesSlipDto.getElectronicTaxInvoiceIssued(), purchaseSalesSlip.getElectronicTaxInvoiceIssued());
                assertEquals(purchaseSalesSlipDto.getDate(), purchaseSalesSlip.getDate());
                assertEquals(purchaseSalesSlipDto.getEntryId(), purchaseSalesSlip.getEntryId());
                assertEquals(purchaseSalesSlipDto.getDepartmentId(), purchaseSalesSlip.getDepartmentId());
                assertEquals(purchaseSalesSlipDto.getQuantity(),purchaseSalesSlip.getQuantity());
                assertEquals(purchaseSalesSlipDto.getUserCompanyId(),purchaseSalesSlip.getUserCompanyId());
                assertEquals(purchaseSalesSlipDto.getItemName(),purchaseSalesSlip.getItemName());
                assertEquals(purchaseSalesSlipDto.getSupplyValue(),purchaseSalesSlip.getSupplyValue());
                assertEquals(purchaseSalesSlipDto.getUnitPrice(),purchaseSalesSlip.getUnitPrice());
                assertEquals(purchaseSalesSlipDto.getVat(),purchaseSalesSlip.getVat());
                assertEquals(purchaseSalesSlipDto.getVatTypeId(),purchaseSalesSlip.getVatTypeId());
                assertEquals(purchaseSalesSlipDto.getVendorId(),purchaseSalesSlip.getVendorId());
            });
        }

}
