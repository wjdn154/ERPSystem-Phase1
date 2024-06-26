package com.erp.system.financial.repository.book_keeping.accounting_ledger.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.book_keeping.accounting_ledger.CashBook;
import com.erp.system.financial.repository.book_keeping.accounting_ledger.CashBookRepository;

@Component
public class CashBookRepositoryImpl extends GenericRepositoryImpl<CashBook> implements CashBookRepository {
    private CashBookRepositoryImpl() {
        super(CashBook.class); // 부모 클래스의 생성자를 호출
    }

}