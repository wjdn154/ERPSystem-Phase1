package com.erp.system.financial.repository.basic_information_management.voucher_registration;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Vouchers;

/**
 * 전표 엔티티에 대한 리포지토리 인터페이스.
 */
public interface VouchersRepository extends GenericRepository<Vouchers> {
    @Override
    void save(Vouchers entity);
}