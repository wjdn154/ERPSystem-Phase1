package com.erp.system.common;

import com.erp.system.financial.controller.basic_information_management.PurchaseSalesSlipController;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HashJoinTest {
    private PurchaseSalesSlipController purchaseSalesSlipController;

    @BeforeEach
    void Setup() {
        // DI 컨테이너 생성
        DependencyInjector injector = DependencyInjector.getInstance();

        // ERPSystem 초기 데이터 생성
        new ERPDataInitializer();

        // Controller 인스턴스 생성
        purchaseSalesSlipController = injector.getInstance(PurchaseSalesSlipController.class);
    }

    @Test
    void testPerformJoin() {
        // Given: 공통 조인 키가 있는 세 데이터 집합
        List<PurchaseSalesSlip> purchaseSalesSlip = purchaseSalesSlipController.findAllPurchaseSalesSlip().stream().toList(); // 조인할 엔티티 List 1
        List<Entry> entries = purchaseSalesSlipController.findAllEntries().stream().toList(); // 조인할 엔티티 List 2
        List<VatType> vatTypes = purchaseSalesSlipController.findAllVatTypes().stream().toList(); // 조인할 엔티티 List 3

        // When: 해시 조인 수행
        List<Map<String, Object>> joinedList = HashJoin.hashJoin(purchaseSalesSlip, entries, PurchaseSalesSlip::getId, Entry::getId); // 엔티티 1 and 엔티티 2 hash 조인
        List<Map<String, Object>> secondJoinResults = HashJoin.hashJoin(joinedList, vatTypes, map -> (String) map.get("vatTypeId"), VatType::getId); // 조인된 결과 and 엔티티 3 hash 조인

        // Then: 조인된 결과가 예상 결과와 일치하는지 확인.
        joinedList.forEach(System.out::println);
        secondJoinResults.forEach(System.out::println);
    }

    @Test
    void testPerformJoin2() {
        // Given: 공통 조인 키가 있는 두 데이터 집합
        List<Map<String, Object>> table1 = Arrays.asList(
                Map.of("id", "1", "JoinId", "1", "name", "Alice"),
                Map.of("id", "2", "JoinId", "2","name", "Bob")
        );
        List<Map<String, Object>> table2 = Arrays.asList(
                Map.of("id", "1", "age", 24),
                Map.of("id", "2", "age", 30)
        );

        // When: 해시 조인 수행
        List<Map<String, Object>> result = HashJoin.hashJoin(table1, table2, map1 -> (String) map1.get("JoinId"), map2 -> (String) map2.get("id"));

        // Then: 조인된 결과가 예상 결과와 일치하는지 확인.
        List<Map<String, Object>> expected = Arrays.asList(
                Map.of("id", "1", "JoinId", "1", "name", "Alice", "MapN.id", "1", "MapN.age", 24),
                Map.of("id", "2", "JoinId", "2", "name", "Bob", "MapN.id", "2","MapN.age", 30)
        );

        assertEquals(expected, result);
    }

}