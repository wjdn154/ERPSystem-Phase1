package com.erp.system.financial.repository.basic_information_management.purchase_sales_slip;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EntriesRepository {
    private static EntriesRepository instance;
    private Map<String, Entries> Map = new HashMap<>();

    private EntriesRepository() {
    }

    public static synchronized EntriesRepository getInstance() {
        if (instance == null) {
            instance = new EntriesRepository();
        }
        return instance;
    }

    /**
     * 객체 저장
     * @param entry 저장할 객체
     */
    public void save(Entries entry) {
        String key = generateKey(entry.getId(), entry.getCode());
        Map.put(key, entry);
    }

    /**
     * ID 또는 Code로 객체 검색
     * @param idOrCode 객체의 ID 또는 Code
     * @return 검색된 객체, 없으면 null
     */
    public Entries findByIdOrCode(String idOrCode) {
        for (String key : Map.keySet()) {
            if (key.startsWith(idOrCode + ":") || key.endsWith(":" + idOrCode)) {
                return Map.get(key);
            }
        }
        return null; // 해당 ID 또는 Code를 찾을 수 없음
    }

    /**
     * 객체 업데이트
     * @param entry 업데이트할 객체
     */
    public void update(Entries entry) {
        String key = generateKey(entry.getId(), entry.getCode());
        if (Map.containsKey(key)) {
            Map.put(key, entry);
        } else {
            throw new IllegalArgumentException("ID 또는 코드와 일치하는 항목을 찾을 수 없습니다.");
        }
    }

    /**
     * 객체 삭제
     * @param entry 삭제할 객체
     */
    public void delete(Entries entry) {
        String key = generateKey(entry.getId(), entry.getCode());
        if (Map.containsKey(key)) {
            Map.remove(key);
        } else {
            throw new IllegalArgumentException("ID 또는 코드와 일치하는 항목을 찾을 수 없습니다.");
        }
    }

    /**
     * 모든 객체 검색
     * @return 저장된 모든 객체의 컬렉션
     */
    public Collection<Entries> findAll() {
        return Map.values();
    }

    /**
     * ID와 Code를 결합하여 통합 키 생성
     * @param id 객체의 ID
     * @param code 객체의 Code
     * @return 생성된 통합 키
     */
    private String generateKey(String id, String code) {
        return id + ":" + code;
    }
}