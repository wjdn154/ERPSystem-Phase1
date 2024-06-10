package com.erp.system.common.generic_repository;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GenericRepositoryImplTest {
    private GenericRepositoryImpl<Entries, String, String> repository;
    private Entries entry;

    // 테스트 실행 전 초기 설정
    @BeforeEach
    void setUp() {
        // 싱글톤 인스턴스를 사용하여 저장소 초기화
        repository = GenericRepositoryImpl.getInstance(Entries.class);
        entry = new Entries("0001"); // 예시 생성자, ID를 사용
        entry.setName("Entry 1");
        repository.save(entry); // 초기 객체 저장
    }

    // 저장 및 ID 또는 코드로 조회 테스트
    @Test
    void saveAndFindByIdOrCode() {
        // When: 저장된 객체를 ID 또는 코드로 조회
        Optional<Entries> foundById = repository.findByIdOrCode(entry.getId(), null);
        Optional<Entries> foundByCode = repository.findByIdOrCode(null, entry.getCode());

        // Then: 객체는 null이 아니며 속성이 일치해야 함
        assertTrue(foundById.isPresent(), "조회된 객체는 null이 아니어야 함.");
        assertTrue(foundByCode.isPresent(), "조회된 객체는 null이 아니어야 함.");
        assertEquals(entry.getId(), foundById.get().getId(), "조회된 객체의 ID가 일치해야 함.");
        assertEquals(entry.getCode(), foundByCode.get().getCode(), "조회된 객체의 코드가 일치해야 함.");
    }

    // 업데이트 테스트
    @Test
    void updateEntry() {
        // Given: 객체의 이름을 새 정보로 업데이트
        System.out.println("entry = " + entry.getName());
        entry.setName("Updated Entry");
        repository.update(entry);

        // When: 업데이트된 객체를 조회
        Optional<Entries> found = repository.findByIdOrCode(entry.getId(), null);
        System.out.println("found = " + found.get().getName());

        // Then: 변경된 정보가 반영되어야 함
        assertTrue(found.isPresent(), "업데이트된 객체는 null이 아니어야 함.");
        assertEquals("Updated Entry", found.get().getName(), "업데이트된 이름이 반영되어야 함.");
    }

    // 삭제 테스트
    @Test
    void deleteEntry() {
        // Given: 객체를 삭제
        repository.delete(entry.getId());

        // When & Then: 삭제 후 조회 시 null이어야 함
        Optional<Entries> found = repository.findByIdOrCode(entry.getId(), null);
        assertFalse(found.isPresent(), "삭제된 객체는 조회되어서는 안됨.");
    }

    // 모든 엔트리 찾기 테스트
    @Test
    void findAllEntries() {
        // Given: 여러 Entries 객체를 저장
        Entries entry1 = new Entries("0002");
        entry1.setName("Entry 2");
        Entries entry2 = new Entries("0003");
        entry2.setName("Entry 3");
        repository.save(entry1);
        repository.save(entry2);

        // When: findAll 메소드를 호출하여 모든 객체를 검색
        Collection<Entries> allEntries = repository.findAll();

        // Then: 저장된 모든 객체가 실제로 포함되어 있는지 확인
        assertTrue(allEntries.contains(entry), "entry가 포함되어 있어야 함.");
        assertTrue(allEntries.contains(entry1), "entry1가 포함되어 있어야 함.");
        assertTrue(allEntries.contains(entry2), "entry2가 포함되어 있어야 함.");
    }
}