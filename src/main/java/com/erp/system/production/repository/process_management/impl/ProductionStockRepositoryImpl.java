package com.erp.system.production.repository.process_management.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.process_management.ProductionStock;
import com.erp.system.production.repository.process_management.ProductionStockRepository;

public class ProductionStockRepositoryImpl extends GenericRepositoryImpl<ProductionStock> implements ProductionStockRepository {
    private static volatile ProductionStockRepositoryImpl instance; // 싱글톤 인스턴스 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return ProductionStockRepositoryImpl 인스턴스
     */

    public static synchronized ProductionStockRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ProductionStockRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현 (클래스가 싱글톤 패턴을 따르도록 보장하기 위해서)
     */
    private ProductionStockRepositoryImpl() { super(ProductionStock.class); }
}
