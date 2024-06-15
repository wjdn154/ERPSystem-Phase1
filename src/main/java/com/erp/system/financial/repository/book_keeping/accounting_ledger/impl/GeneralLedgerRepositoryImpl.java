package com.erp.system.financial.repository.book_keeping.accounting_ledger.impl;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.book_keeping.accounting_ledger.GeneralLedger;
import com.erp.system.financial.repository.book_keeping.accounting_ledger.GeneralLedgerRepository;

@Component
@Priority(1)
public class GeneralLedgerRepositoryImpl extends GenericRepositoryImpl<GeneralLedger> implements GeneralLedgerRepository {
    private static GeneralLedgerRepositoryImpl instance; // 싱글톤 인스턴스를 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return GeneralLedgerRepositoryImpl 인스턴스
     */
    public static synchronized GeneralLedgerRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new GeneralLedgerRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private GeneralLedgerRepositoryImpl() {
        super(GeneralLedger.class); // 부모 클래스의 생성자를 호출
    }

}