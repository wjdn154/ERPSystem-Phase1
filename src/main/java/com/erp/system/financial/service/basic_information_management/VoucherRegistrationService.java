package com.erp.system.financial.service.basic_information_management;

import com.erp.system.financial.model.dto.VoucherDto;

public interface VoucherRegistrationService {
    void registerVoucher(VoucherDto dto);
}