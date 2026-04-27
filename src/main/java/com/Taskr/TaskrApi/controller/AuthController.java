package com.Taskr.TaskrApi.controller;

import com.Taskr.TaskrApi.dto.AuthenticationResponse;
import com.Taskr.TaskrApi.dto.LoginRequest;
import com.Taskr.TaskrApi.dto.UserRegisterRequest;
import com.Taskr.TaskrApi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody UserRegisterRequest newUserRequest){
        return ResponseEntity.ok(authService.registerUser(newUserRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> userLogin(@RequestBody LoginRequest newLoginRequest){
        return ResponseEntity.ok(authService.login(newLoginRequest));
    }
}
