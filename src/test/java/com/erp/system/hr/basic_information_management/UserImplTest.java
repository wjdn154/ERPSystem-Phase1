package com.erp.system.hr.basic_information_management;

import com.erp.system.common.DependencyInjector;
import com.erp.system.hr.model.basic_information_management.User;
import com.erp.system.hr.model.dto.UserDto;
import com.erp.system.hr.respository.UserRepository;
import com.erp.system.hr.service.basic_information_management.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserImplTest {
    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        DependencyInjector injector = DependencyInjector.getInstance();
        userService = injector.getInstance(UserService.class);
        userRepository = injector.getInstance(UserRepository.class);

    }

    @Test
    public void testUserCreation() {
        UserDto userDto = new UserDto();
        userDto.setDepartmentId("1");
        userDto.setCompanyId("1");
        userDto.setUserName("김민성");
        userDto.setPassword("rlaalstjd123");
        userDto.setEmail("ckacl2512@naver.com");
        userDto.setRole(User.Role.HR_MANAGER);

        userService.createUser(userDto);

        System.out.println("전송 객체 ::: = " + userDto.toString());

        userRepository.findById(String.valueOf(User.idIndex - 1)).ifPresent(user -> {
            System.out.println("저장 객체 ::: = " + user.toString());
            assertEquals(userDto.getDepartmentId(), user.getDepartmentId());
            assertEquals(userDto.getCompanyId(), user.getCompanyId());
            assertEquals(userDto.getUserName(), user.getUserName());
            assertEquals(userDto.getPassword(), user.getPassword());
            assertEquals(userDto.getEmail(), user.getEmail());
            assertEquals(userDto.getRole(), user.getRole());
        });
    }
}
