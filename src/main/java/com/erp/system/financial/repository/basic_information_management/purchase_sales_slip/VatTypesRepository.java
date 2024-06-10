package com.erp.system.financial.repository.basic_information_management.purchase_sales_slip;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatTypes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VatTypesRepository {
    private static VatTypesRepository instance; // 싱글톤 인스턴스를 저장할 변수
    private java.util.Map<String, VatTypes> Map = new HashMap<>();

    // 생성자: 외부 인스턴스화 방지
    private VatTypesRepository() { }

    /**
     * 싱글톤 인스턴스를 반환함.
     * @return 현재 인스턴스
     */
    public static synchronized VatTypesRepository getInstance() {
        if (instance == null) {
            instance = new VatTypesRepository();
        }
        return instance;
    }

    /**
     * 객체 저장
     * @param vatTypes 저장할 객체
     */
    public void save(VatTypes vatTypes) {
        String key = generateKey(vatTypes.getId(), vatTypes.getCode());
        Map.put(key, vatTypes);
    }

    /**
     * ID 또는 Code로 객체 검색
     * @param idOrCode 객체의 ID 또는 Code
     * @return 검색된 객체, 없으면 null
     */
    public VatTypes findByIdOrCode(String idOrCode) {
        for (String key : Map.keySet()) {
            if (key.startsWith(idOrCode + ":") || key.endsWith(":" + idOrCode)) {
                return Map.get(key);
            }
        }
        return null; // 해당 ID 또는 Code를 찾을 수 없음
    }

    /**
     * 객체 업데이트
     * @param vatTypes 업데이트할 객체
     */
    public void update(VatTypes vatTypes) {
        String key = generateKey(vatTypes.getId(), vatTypes.getCode());
        if (Map.containsKey(key)) {
            Map.put(key, vatTypes);
        } else {
            throw new IllegalArgumentException("ID 또는 코드와 일치하는 항목을 찾을 수 없습니다.");
        }
    }

    /**
     * 객체 삭제
     * @param vatTypes 삭제할 객체
     */
    public void delete(VatTypes vatTypes) {
        String key = generateKey(vatTypes.getId(), vatTypes.getCode());
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
    public Collection<VatTypes> findAll() {
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