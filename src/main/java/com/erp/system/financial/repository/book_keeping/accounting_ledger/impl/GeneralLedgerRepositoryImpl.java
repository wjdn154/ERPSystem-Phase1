package com.erp.system.financial.repository.book_keeping.accounting_ledger.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.book_keeping.accounting_ledger.GeneralLedger;
import com.erp.system.financial.repository.book_keeping.accounting_ledger.GeneralLedgerRepository;

@Component
public class GeneralLedgerRepositoryImpl extends GenericRepositoryImpl<GeneralLedger> implements GeneralLedgerRepository {
    private GeneralLedgerRepositoryImpl() {
        super(GeneralLedger.class); // 부모 클래스의 생성자를 호출
    }
}