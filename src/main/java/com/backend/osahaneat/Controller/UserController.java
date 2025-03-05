package com.backend.osahaneat.Controller;

import com.backend.osahaneat.service.imp.UserImp;
import com.mysql.cj.x.protobuf.Mysqlx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserImp userImp;

    @GetMapping("")
    public ResponseEntity<?> GetALlUser(){

        return new ResponseEntity<>(userImp.getAllUsers(),HttpStatus.OK);
    }
}
