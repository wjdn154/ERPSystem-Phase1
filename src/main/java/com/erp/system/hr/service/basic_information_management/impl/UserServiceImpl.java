package com.erp.system.hr.service.basic_information_management.impl;

import com.erp.system.financial.model.basic_information_management.company_registration.*;
import com.erp.system.hr.Model.basic_information_management.Department;
import com.erp.system.hr.Model.basic_information_management.User;
import com.erp.system.hr.Model.dto.UserDto;
import com.erp.system.hr.respository.UserRepository;
import com.erp.system.hr.service.basic_information_management.UserService;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(UserDto userRegistrationdto) {

        try {
            User user = createUser(userRegistrationdto);

            userRepository.save(user);
        } catch (Exception e) {
            System.err.println("회사 등록 중 에러 발생: " + e.getMessage());
            throw new RuntimeException("등록 실패", e);
        }
    }

    public User createUser(UserDto dto) {
        return new User.Builder()
                .userName(dto.getUserName())
                .departmentId(dto.getDepartmentId())
                .companyId(dto.getCompanyId())
                .password(dto.getPassword())
                .role(dto.getRole())
                .email(dto.getEmail())
                .build();

    }

}
