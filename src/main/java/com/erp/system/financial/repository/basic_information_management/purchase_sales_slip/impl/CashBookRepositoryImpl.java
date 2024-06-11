package com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl;

import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.book_keeping.accounting_ledger.CashBook;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.CashBookRepository;

public class CashBookRepositoryImpl extends GenericRepositoryImpl<CashBook> implements CashBookRepository {

    private static CashBookRepositoryImpl instance; // 싱글톤 인스턴스를 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return CashBookRepositoryImpl의 인스턴스
     */
    public static synchronized CashBookRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CashBookRepositoryImpl(); // 인스턴스가 없으면 새로 생성
        }
        return instance; // 인스턴스 반환
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private CashBookRepositoryImpl() {
        super(CashBook.class); // 부모 클래스의 생성자를 호출
    }

}