package com.erp.system.hr.service.basic_information_management;

import com.erp.system.hr.model.basic_information_management.User;
import com.erp.system.hr.model.dto.UserDto;

public interface  UserService {
    void User(UserDto dto);

    User createUser(UserDto userDto);

}
