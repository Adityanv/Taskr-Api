package com.Taskr.TaskrApi.service;

import com.Taskr.TaskrApi.dto.AuthenticationResponse;
import com.Taskr.TaskrApi.dto.LoginRequest;
import com.Taskr.TaskrApi.dto.UserRegisterRequest;
import com.Taskr.TaskrApi.dto.UserResponseRequest;
import com.Taskr.TaskrApi.enums.Role;
import com.Taskr.TaskrApi.model.User;
import com.Taskr.TaskrApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String username){
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public AuthenticationResponse registerUser(UserRegisterRequest newUser){

        User user = new User();

        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setRole(Role.USER);
        user.setCreated_at(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        String token =  jwtService.generateToken(user);

        UserResponseRequest userResponseRequest = new UserResponseRequest(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getRole()
        );

        return new AuthenticationResponse(token, userResponseRequest);
    }

    public AuthenticationResponse login(LoginRequest newLoginRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                newLoginRequest.getEmail(),
                newLoginRequest.getPassword())
        );

        User user = userRepository.findByEmail(newLoginRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User was not found"));

        var jwtToken = jwtService.generateToken(user);

        UserResponseRequest newUser = new UserResponseRequest(user.getId(), user.getName(), user.getEmail(), user.getRole());

        return new AuthenticationResponse(jwtToken, newUser);
    }
}
