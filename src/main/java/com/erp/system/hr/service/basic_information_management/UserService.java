package com.erp.system.hr.service.basic_information_management;

import com.erp.system.hr.Model.basic_information_management.User;
import com.erp.system.hr.Model.dto.UserDto;

public interface  UserService {
    void User(UserDto dto);

    User createUser(UserDto userDto);

}
