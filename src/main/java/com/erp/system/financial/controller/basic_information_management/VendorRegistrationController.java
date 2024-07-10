package com.erp.system.financial.controller.basic_information_management;

import com.erp.system.common.annotation.Component;
import com.erp.system.financial.model.basic_information_management.vendor_registration.Vendor;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorRepository;
import com.erp.system.financial.service.basic_information_management.VendorRegistrationService;

import java.util.Collection;
import java.util.Optional;

@Component
public class VendorRegistrationController {
    private final VendorRegistrationService vendorRegistrationService;
    private final VendorRepository vendorRepository;
    public VendorRegistrationController(VendorRegistrationService vendorRegistrationService,
                                        VendorRepository vendorRepository) {
        this.vendorRegistrationService = vendorRegistrationService;
        this.vendorRepository = vendorRepository;
    }
    /**
     * 공급업체를 저장함
     * @param vendor 저장할 공급업체
     */
    public void saveVendor(Vendor vendor) {
        vendorRepository.save(vendor);
    }

    /**
     * ID로 공급업체를 조회함
     * @param id 공급업체의 ID
     * @return 조회된 공급업체를 Optional로 반환
     */
    public Optional<Vendor> findVendorById(String id) {
        return vendorRepository.findById(id);
    }


    /**
     * 모든 공급업체를 조회함
     * @return 저장된 모든 공급업체의 컬렉션
     */
    public Collection<Vendor> findAllVendors() {
        return vendorRepository.findAll();
    }

}