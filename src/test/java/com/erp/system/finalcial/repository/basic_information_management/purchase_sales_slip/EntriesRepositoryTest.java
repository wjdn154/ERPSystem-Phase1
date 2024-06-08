package com.erp.system.finalcial.repository.basic_information_management.purchase_sales_slip;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntriesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class EntriesRepositoryTest {
    private EntriesRepository repository;
    private Entries entry;

    // 테스트 실행 전 초기 설정
    @BeforeEach
    void setUp() {
        repository = new EntriesRepository();
        entry = new Entries("0001"); // 예시 생성자, ID, 설명, 금액
        entry.setName("Entry 1");
        repository.save(entry);
    }

    // 저장 및 ID로 조회 테스트
    @Test
    void saveAndFindById() {
        // When: 저장된 객체 조회
        Entries foundId = repository.findByIdOrCode(entry.getId());
        Entries foundCode = repository.findByIdOrCode(entry.getCode());

        // Then: 객체는 null이 아니며 속성이 일치해야 함
        assertNotNull(foundId, "조회된 객체는 null이 아니어야 함.");
        assertNotNull(foundCode, "조회된 객체는 null이 아니어야 함.");
        assertEquals(entry.getId(), foundId.getId(), "조회된 객체의 ID가 일치해야 함.");
    }

    // 업데이트 테스트
    @Test
    void updateEntry() {
        // Given: 새 정보로 업데이트
        entry.setName("Updated Entry");
        repository.update(entry);

        // When: 업데이트된 객체 조회
        Entries found = repository.findByIdOrCode(entry.getId());

        // Then: 변경된 정보 반영 검증
        assertEquals("Updated Entry", found.getName(), "업데이트된 이름이 반영되어야 함.");
    }

    // 삭제 테스트
    @Test
    void deleteEntry() {
        // Given: 객체 삭제
        repository.delete(entry);

        // When & Then: 삭제 후 조회 시 null 확인
        assertNull(repository.findByIdOrCode(entry.getId()), "삭제된 객체는 조회되어서는 안됨.");
    }

    // 삭제 테스트
    @Test
    void findAllEntry() {
        // Given: 여러 Entries 객체를 저장
        Entries entry1 = new Entries("0001");
        Entries entry2 = new Entries("0002");
        Entries entry3 = new Entries("0003");
        repository.save(entry1);
        repository.save(entry3);
        repository.save(entry2);

        // When: findAll 메소드를 호출하여 모든 객체를 검색
        Collection<Entries> allEntries = repository.findAll();

        // Then: 저장된 모든 객체가 실제로 포함되어 있는지 확인
        assertTrue(allEntries.stream().anyMatch(e -> e.getId().equals(entry1.getId()) && e.getCode().equals(entry1.getCode())),
                "entry1.id, code:0001을 가진 객체가 포함되어 있어야 함.");
        assertTrue(allEntries.stream().anyMatch(e -> e.getId().equals(entry2.getId()) && e.getCode().equals(entry2.getCode())),
                "entry2.id, code:0002을 가진 객체가 포함되어 있어야 함.");
        assertTrue(allEntries.stream().anyMatch(e -> e.getId().equals(entry3.getId()) && e.getCode().equals(entry3.getCode())),
                "entry3.id, code:0003을 가진 객체가 포함되어 있어야 함.");
    }
}