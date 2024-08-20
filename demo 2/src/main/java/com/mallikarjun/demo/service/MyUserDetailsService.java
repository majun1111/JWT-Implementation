package com.mallikarjun.demo.service;

import com.mallikarjun.demo.model.UserPrincipal;
import com.mallikarjun.demo.model.Users;
import com.mallikarjun.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;


    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepo.findByUsername(username);

        if (users == null) {
            System.out.println("User Not found");
            throw new UsernameNotFoundException("user not found");
        }

        return new UserPrincipal(users);
    }
}
