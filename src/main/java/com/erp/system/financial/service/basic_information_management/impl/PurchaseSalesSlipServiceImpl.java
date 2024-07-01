package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.financial.model.basic_information_management.company_registration.Address;
import com.erp.system.financial.model.basic_information_management.company_registration.Company;
import com.erp.system.financial.model.basic_information_management.company_registration.Contact;
import com.erp.system.financial.model.basic_information_management.company_registration.Representative;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;
import com.erp.system.financial.model.dto.PurchaseSalesSlipDto;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntryRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.PurchaseSalesSlipRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.VatTypeRepository;
import com.erp.system.financial.service.basic_information_management.PurchaseSalesSlipService;

@Component
public class PurchaseSalesSlipServiceImpl implements PurchaseSalesSlipService {
    private static volatile PurchaseSalesSlipServiceImpl instance; // 싱글톤 인스턴스를 저장할 변수
    private final EntryRepository entryRepository;
    private final PurchaseSalesSlipRepository purchaseSalesSlipRepository;
    private final VatTypeRepository vatTypesRepository;

    public PurchaseSalesSlipServiceImpl(EntryRepository entryRepository,
                                        PurchaseSalesSlipRepository purchaseSalesSlipRepository,
                                        VatTypeRepository vatTypesRepository) {
        this.entryRepository = entryRepository;
        this.purchaseSalesSlipRepository = purchaseSalesSlipRepository;
        this.vatTypesRepository = vatTypesRepository;
    }

    /**
     * 매출매입전표 등록 메소드
     * DTO를 바탕으로 매출매입전표 와 관련된 모든 정보를 생성하고 저장함
     * @param dto 매출매입전표 등록을 위한 전달 객체
     * @throws RuntimeException 등록 중 발생한 예외를 처리함
     */
    @Override
    public void registerPurchaseSalesSlip(PurchaseSalesSlipDto dto) {
        try {
            PurchaseSalesSlip purchaseSalesSlip = createPurchaseSalesSlip(dto);
            purchaseSalesSlipRepository.save(purchaseSalesSlip);
        } catch (Exception e) {
            System.err.println("매출매입전표 등록 중 에러 발생: " + e.getMessage());
            throw new RuntimeException("등록 실패", e);
        }
    }


    /**
     * 매출매입전표 객체 생성.
     * @param dto 매출매입전표 등록을 위한 정보가 담긴 DTO
     * @return 저장된 매출매입전표 객체
     */
    public PurchaseSalesSlip createPurchaseSalesSlip(PurchaseSalesSlipDto dto) {
        return new PurchaseSalesSlip.Builder()
                .ERPCompanyId(dto.getERPCompanyId())
                .date(dto.getDate())
                .entryId(dto.getEntryId())
                .electronicTaxInvoiceIssued(dto.getElectronicTaxInvoiceIssued())
                .itemName(dto.getItemName())
                .vat(dto.getVat())
                .quantity(dto.getQuantity())
                .supplyValue(dto.getSupplyValue())
                .unitPrice(dto.getUnitPrice())
                .vatTypeId(dto.getVatTypeId())
                .vendorId(dto.getVendorId())
                .build();
    }
}