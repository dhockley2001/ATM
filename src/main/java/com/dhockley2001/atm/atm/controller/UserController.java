package com.dhockley2001.atm.atm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dhockley2001.atm.atm.models.User;
import com.dhockley2001.atm.atm.models.UserDTO;
import com.dhockley2001.atm.atm.service.UserService;
import com.dhockley2001.atm.atm.utils.UserMapper;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/users/{id}")
    public UserDTO getUserById(@PathVariable Long userId) {

        User user = userService.getUserById(userId);

        if (user != null) {
            return userMapper.toDTO(user);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        }
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers()
            .stream()
            .map(userMapper::toDTO)
            .toList();
    }

}
