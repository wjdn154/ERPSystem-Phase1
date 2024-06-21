package com.erp.system.common.generic_repository;

import com.erp.system.common.DependencyInjector;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GenericRepositoryImplTest {
    private EntryRepository entryRepository;

    // 테스트 실행 전 초기 설정
    @BeforeEach
    void setUp() {
        // 싱글톤 인스턴스를 사용하여 저장소 초기화
        DependencyInjector di = DependencyInjector.getInstance();

        entryRepository = di.getInstance(EntryRepository.class);
        entryRepository.reset();
    }

    // 저장 및 ID 또는 코드로 조회 테스트
    @Test
    void saveAndFindByIdOrCode() {
        // Given: 새로운 엔트리를 저장
        Entry entry = new Entry.Builder()
                .name("Entry 1")
                .build();
        entryRepository.save(entry);

        // When: 저장된 객체를 ID 또는 코드로 조회
        Optional<Entry> foundById = entryRepository.findById(entry.getId());


        // Then: 객체는 null이 아니며 속성이 일치해야 함
        assertTrue(foundById.isPresent(), "조회된 객체는 null이 아니어야 함.");
        assertEquals(entry.getId(), foundById.get().getId(), "조회된 객체의 ID가 일치해야 함.");
    }

    // 업데이트 테스트
    @Test
    void updateEntry() {
        // Given: 새로운 엔트리를 저장하고, 업데이트할 정보 설정
        Entry entry = new Entry.Builder()
                .name("Entry 1")
                .build();
        entryRepository.save(entry);

        // When: 엔트리를 업데이트하고 조회
        Entry updatedEntry = entry
                .tobuild()
                .name("Updated Entry")
                .build();

        entryRepository.update(updatedEntry);
        Optional<Entry> found = entryRepository.findById(entry.getId());

        // Then: 변경된 정보가 반영되어야 함
        assertTrue(found.isPresent(), "업데이트된 객체는 null이 아니어야 함.");
        assertEquals("Updated Entry", found.get().getName(), "업데이트된 이름이 반영되어야 함.");
    }

    // 삭제 테스트
    @Test
    void deleteEntry() {
        // Given: 새로운 엔트리를 저장하고, 삭제할 ID 설정
        Entry entry = new Entry.Builder()
                .name("Entry 1")
                .build();
        entryRepository.save(entry);

        // When: 엔트리를 삭제하고 조회
        entryRepository.delete(entry.getId());
        Optional<Entry> found = entryRepository.findById(entry.getId());

        // Then: 삭제 후 조회 시 null이어야 함
        assertFalse(found.isPresent(), "삭제된 객체는 조회되어서는 안됨.");
    }

    // 모든 엔트리 찾기 테스트
    @Test
    void findAllEntries() {
        // Given: 여러 Entries 객체를 저장
        Entry entry1 = new Entry.Builder()
                .name("Entry 2")
                .build();
        Entry entry2 = new Entry.Builder()
                .name("Entry 3")
                .build();
        entryRepository.save(entry1);
        entryRepository.save(entry2);

        // When: findAll 메소드를 호출하여 모든 객체를 검색
        Collection<Entry> allEntries = entryRepository.findAll();

        // Then: 저장된 모든 객체가 실제로 포함되어 있는지 확인
        assertTrue(allEntries.contains(entry1), "entry1가 포함되어 있어야 함.");
        assertTrue(allEntries.contains(entry2), "entry2가 포함되어 있어야 함.");
    }
}
