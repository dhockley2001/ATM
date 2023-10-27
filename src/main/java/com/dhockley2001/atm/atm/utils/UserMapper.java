package com.dhockley2001.atm.atm.utils;

import org.springframework.stereotype.Component;

import com.dhockley2001.atm.atm.models.User;
import com.dhockley2001.atm.atm.models.UserDTO;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getAccountNumber(), user.getAccounts());
    }
}
