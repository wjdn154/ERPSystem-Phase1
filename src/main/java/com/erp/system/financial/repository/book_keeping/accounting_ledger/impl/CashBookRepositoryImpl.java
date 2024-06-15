package com.erp.system.financial.repository.book_keeping.accounting_ledger.impl;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.book_keeping.accounting_ledger.CashBook;
import com.erp.system.financial.repository.book_keeping.accounting_ledger.CashBookRepository;

@Component
@Priority(1)
public class CashBookRepositoryImpl extends GenericRepositoryImpl<CashBook> implements CashBookRepository {
    private static CashBookRepositoryImpl instance; // 싱글톤 인스턴스를 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return CashBookRepositoryImpl 인스턴스
     */
    public static synchronized CashBookRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CashBookRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private CashBookRepositoryImpl() {
        super(CashBook.class); // 부모 클래스의 생성자를 호출
    }

}