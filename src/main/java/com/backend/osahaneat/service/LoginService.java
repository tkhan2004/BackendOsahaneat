package com.backend.osahaneat.service;


import com.backend.osahaneat.Entity.Roles;
import com.backend.osahaneat.Entity.Users;
import com.backend.osahaneat.Reponsitory.UserReponsitory;
import com.backend.osahaneat.dto.UsersDTO;
import com.backend.osahaneat.payload.Request.SignupRequest;
import com.backend.osahaneat.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements LoginServiceImp {
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

    @Override
    public Boolean checkLogin(String username, String password) {
        List<Users> users= userReponsitory.findByUsernameAndPassword(username,password);
        return users.size()>0?true:false;
    }

    @Override
    public Boolean addUser(SignupRequest signupRequest) {
        Roles roles = new Roles();
        Users users = new Users();

        roles.setId(signupRequest.getRolesId());
        users.setUsername(signupRequest.getUsername());
        users.setPassword(signupRequest.getPassword());
        users.setFullname(signupRequest.getFullname());
        users.setRoles(roles);
        try {
            userReponsitory.save(users); // thêm dữ liệu hoặc có thể update
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
