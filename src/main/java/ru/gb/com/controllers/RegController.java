package ru.gb.com.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.com.dto.JwtRequest;
import ru.gb.com.dto.JwtResponse;
import ru.gb.com.exceptions.AppError;
import ru.gb.com.services.UserService;

@RestController
@RequiredArgsConstructor
public class RegController {

    private final UserService userService;

    @PostMapping("/reg")
    public ResponseEntity<?> createNewUser(@RequestBody JwtRequest authRequest){

        if (userService.isUserExists(authRequest.getLogin())){
            return new ResponseEntity<>(new AppError(HttpStatus.CONFLICT.value(),"Such user exists"),HttpStatus.CONFLICT);
        }

        userService
        return ResponseEntity.ok().build();


    }


}
