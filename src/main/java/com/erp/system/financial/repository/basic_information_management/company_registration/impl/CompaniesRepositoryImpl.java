package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.Company;
import com.erp.system.financial.repository.basic_information_management.company_registration.CompanyRepository;


@Component
@Priority(1)
public class CompaniesRepositoryImpl extends GenericRepositoryImpl<Company> implements CompanyRepository {
    private static volatile CompaniesRepositoryImpl instance; // 싱글톤 인스턴스를 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return CompaniesRepositoryImpl 인스턴스
     */
    public static synchronized CompaniesRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CompaniesRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private CompaniesRepositoryImpl() {
        super(Company.class);
    }
}