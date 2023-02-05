package ru.gb.com.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.com.dto.UserDto;
import ru.gb.com.entities.User;
import ru.gb.com.services.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }
}
