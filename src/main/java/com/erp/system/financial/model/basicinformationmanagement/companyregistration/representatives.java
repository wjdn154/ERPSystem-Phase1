package com.erp.system.financial.model.basicinformationmanagement.companyregistration;

import java.util.UUID;

public class representatives {
    private final String id; // 고유 식별자
    private final String company_id; // 연결된 회사 ID
    private String name; // 대표자명
    private String id_number; // 대표자 주민번호
    private boolean foreign; // 대표자 외국인여부

    public representatives(String company_id) {
        this.id = UUID.randomUUID().toString();
        this.company_id = company_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public void setForeign(boolean foreign) {
        this.foreign = foreign;
    }

    public String getId() {
        return id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public String getName() {
        return name;
    }

    public String getId_number() {
        return id_number;
    }

    public boolean isForeign() {
        return foreign;
    }
}
