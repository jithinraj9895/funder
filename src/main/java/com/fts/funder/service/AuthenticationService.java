package com.fts.funder.service;

import com.fts.funder.model.AuthenticationResponse;
import com.fts.funder.model.Dto.LoginDto;
import com.fts.funder.model.User;
import com.fts.funder.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public final UserRepository userRepository;
    public final JwtService jwtService;
    public final PasswordEncoder passwordEncoder;
    public final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(User request){
        if(userRepository.findByUsername(request.getUsername()).isPresent()){
            return new AuthenticationResponse("user exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        String token = jwtService.generateToken(user);

        user = userRepository.save(user);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(LoginDto request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }


}
