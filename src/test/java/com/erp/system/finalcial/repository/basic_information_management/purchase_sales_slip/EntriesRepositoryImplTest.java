package com.erp.system.finalcial.repository.basic_information_management.purchase_sales_slip;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntriesRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl.EntriesRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * EntriesRepositoryImplTest 클래스는 EntriesRepositoryImpl 클래스의 단위 테스트를 수행.
 * 각 테스트는 저장소에 대한 CRUD(생성, 읽기, 업데이트, 삭제) 작업을 검증.
 */
public class EntriesRepositoryImplTest {

    private EntriesRepository repository;

    // 테스트 실행 전 초기 설정
    @BeforeEach
    void setUp() {
        // 싱글톤 인스턴스를 사용하여 저장소 초기화
        repository = EntriesRepositoryImpl.getInstance();
        repository.reset();
    }

    // 저장 및 ID 또는 코드로 조회 테스트
    @Test
    void saveAndFindByIdOrCode() {
        // Given: 새로운 엔트리를 저장
        Entries entry = new Entries("0001");
        entry.setName("Entry 1");
        repository.save(entry);

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
        // Given: 새로운 엔트리를 저장하고, 업데이트할 정보 설정
        Entries entry = new Entries("0001");
        entry.setName("Entry 1");
        repository.save(entry);

        entry.setName("Updated Entry");

        // When: 엔트리를 업데이트하고 조회
        repository.update(entry);
        Optional<Entries> found = repository.findByIdOrCode(entry.getId(), null);

        // Then: 변경된 정보가 반영되어야 함
        assertTrue(found.isPresent(), "업데이트된 객체는 null이 아니어야 함.");
        assertEquals("Updated Entry", found.get().getName(), "업데이트된 이름이 반영되어야 함.");
    }

    // 삭제 테스트
    @Test
    void deleteEntry() {
        // Given: 새로운 엔트리를 저장하고, 삭제할 ID 설정
        Entries entry = new Entries("0001");
        entry.setName("Entry 1");
        repository.save(entry);

        // When: 엔트리를 삭제하고 조회
        repository.delete(entry.getId());
        Optional<Entries> found = repository.findByIdOrCode(entry.getId(), null);

        // Then: 삭제 후 조회 시 null이어야 함
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
        assertTrue(allEntries.contains(entry1), "entry1가 포함되어 있어야 함.");
        assertTrue(allEntries.contains(entry2), "entry2가 포함되어 있어야 함.");
    }

    // 코드 중복 저장 테스트
    @Test
    void saveDuplicateCode() {
        // Given: 동일한 코드를 가진 두 번째 엔트리 생성
        Entries entry1 = new Entries("0001");
        entry1.setName("Entry 1");
        repository.save(entry1);

        Entries duplicateEntry = new Entries("0001");
        duplicateEntry.setName("Duplicate Entry");

        // When & Then: 저장 시 예외 발생 확인
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            repository.save(duplicateEntry);
        });

        // 예외 메시지 검증
        Throwable cause = exception.getCause();
        assertTrue(cause instanceof IllegalArgumentException);
        assertEquals("이미 존재하는 코드입니다: 0001", cause.getMessage());
    }
}