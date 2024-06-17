package com.erp.system.production.model.master_data_management.bom;

import java.time.LocalDate;
import java.util.UUID;

public class Bom {
    private final String id; // Bill of Materials(자재명세표) ID
    private final String code; // Bom 코드
    private String name; // Bom 이름
    private LocalDate effectiveDate; // Bom 유효시작일
    private LocalDate expirationDate; // Bom 종료일

    // Builder 클래스 정의
    public static class Builder {
        private final String id; // Bill of Materials(자재명세표) ID
        private final String code; // Bom 코드
        private String name; // Bom 이름
        private LocalDate effectiveDate; // Bom 유효시작일
        private LocalDate expirationDate; // Bom 종료일

        // Builder 생성자, code는 필수 속성
        public Builder(String code) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
        }

        // name 설정 메서드
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        // effectiveDate 설정 메서드
        public Builder effectiveDate(LocalDate effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        // expirationDate 설정 메서드
        public Builder expirationDate(LocalDate expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        // build 메서드, Bom 객체 생성
        public Bom build() {
            return new Bom(this);
        }



    } // end of Builder

    // Bom 클래스의 private 생성자, Builder 객체를 파라미터로 받음
    private Bom(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.name = builder.name;
        this.effectiveDate = builder.effectiveDate;
        this.expirationDate = builder.expirationDate;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
