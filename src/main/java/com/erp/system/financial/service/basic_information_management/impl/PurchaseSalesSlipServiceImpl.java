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

    @Override
    public void registerPurchaseSalesSlip(PurchaseSalesSlipDto purchaseSalesSlipDto) {
        try {
            VatType vatType = createVatType(purchaseSalesSlipDto);
            PurchaseSalesSlip purchaseSalesSlip = createPurchaseSalesSlip(purchaseSalesSlipDto);

            vatTypesRepository.save(vatType);
            purchaseSalesSlipRepository.save(purchaseSalesSlip);
        } catch (Exception e) {
            System.err.println("전표 등록 중 에러 발생: " + e.getMessage());
            throw new RuntimeException("등록 실패", e);
        }
    }

    public VatType createVatType(PurchaseSalesSlipDto dto) {
        return new VatType.Builder()
                .name(dto.getVatTypeName())
                .category(dto.getCategory())
                .build();
    }

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