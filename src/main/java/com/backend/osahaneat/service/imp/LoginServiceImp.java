package com.backend.osahaneat.service.imp;

import com.backend.osahaneat.dto.UsersDTO;
import com.backend.osahaneat.payload.Request.SignupRequest;


import java.util.List;

public interface LoginServiceImp {
    List<UsersDTO> getAllUsers();
    Boolean checkLogin(String username, String password);
    Boolean addUser(SignupRequest signupRequest);
}
