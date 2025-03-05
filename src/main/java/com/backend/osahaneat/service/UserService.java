package com.backend.osahaneat.service;

import com.backend.osahaneat.Entity.Users;
import com.backend.osahaneat.Reponsitory.UserReponsitory;
import com.backend.osahaneat.dto.UsersDTO;
import com.backend.osahaneat.service.imp.UserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService implements UserImp {

    @Autowired
    UserReponsitory userReponsitory;

    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> listUser = userReponsitory.findAll();
        List<UsersDTO> listUserDTO = new ArrayList<>();

        for (Users users : listUser) {
            UsersDTO usersDTO = new UsersDTO();
            usersDTO.setId(users.getId());
            usersDTO.setUsername(users.getUsername());
            usersDTO.setFullname(users.getFullname());
            usersDTO.setPassword(users.getPassword());
            listUserDTO.add(usersDTO);
        };
        return listUserDTO;
    }
}
