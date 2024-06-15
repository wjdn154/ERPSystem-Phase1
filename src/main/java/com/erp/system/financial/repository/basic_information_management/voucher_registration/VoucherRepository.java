package com.erp.system.financial.repository.basic_information_management.voucher_registration;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Voucher;

/**
 * 전표 엔티티에 대한 리포지토리 인터페이스.
 */
public interface VoucherRepository extends GenericRepository<Voucher> {
    @Override
    void save(Voucher entity);
}