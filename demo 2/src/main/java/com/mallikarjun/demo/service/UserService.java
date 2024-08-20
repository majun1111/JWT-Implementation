package com.mallikarjun.demo.service;

import com.mallikarjun.demo.model.Users;
import com.mallikarjun.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AuthenticationManager authManager;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public Users register(Users users){
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        return userRepo.save(users);
    }

    public String verify(Users users){
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(),users.getPassword()));

       if (authentication.isAuthenticated()){
            return jwtService.generateToken(users.getUsername());
       }return "fail";
    }
}
