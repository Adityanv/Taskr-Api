package com.Taskr.TaskrApi.dto;

public class AuthenticationResponse {

    private String token;
    private UserResponseRequest newUser;

    public AuthenticationResponse(String token, UserResponseRequest newUser) {
        this.token = token;
        this.newUser = newUser;
    }
}
