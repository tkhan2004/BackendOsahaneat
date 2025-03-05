package com.backend.osahaneat.Security;

import com.backend.osahaneat.Entity.Users;
import com.backend.osahaneat.Reponsitory.UserReponsitory;
import com.backend.osahaneat.service.imp.UserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserReponsitory userReponsitory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userReponsitory.findByUsername(username);
        if(users == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new User(username, users.getPassword(), new ArrayList<>());
    }

    
}
