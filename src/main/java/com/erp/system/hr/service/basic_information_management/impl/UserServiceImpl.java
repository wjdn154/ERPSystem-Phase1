package com.erp.system.hr.service.basic_information_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.hr.Model.basic_information_management.User;
import com.erp.system.hr.Model.dto.UserDto;
import com.erp.system.hr.respository.UserRepository;
import com.erp.system.hr.service.basic_information_management.UserService;

@Component
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }
    @Override
    public void User(UserDto userdto) {

        try {
            User user = createUser(userdto);

            userRepository.save(user);
        } catch (Exception e) {
            System.err.println("사용자 등록 중 에러 발생: " + e.getMessage());
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
