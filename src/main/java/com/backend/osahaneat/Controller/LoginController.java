package com.backend.osahaneat.Controller;

import com.backend.osahaneat.payload.Request.SignupRequest;
import com.backend.osahaneat.payload.ResponseData;
import com.backend.osahaneat.service.LoginService;
import com.backend.osahaneat.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginServiceImp loginServiceImp; // tương tự như LoginServiceImp loginServiceImp = new LoginService(); vì LgSv kế thừa LgSvImp
    // api được gọi đầu tiên ở đây
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username, String password){
        ResponseData responseData = new ResponseData();

        //kích họạt SvImp
        if(loginServiceImp.checkLogin(username, password)){
            responseData.setData(true);
        }
        else {
            responseData.setData(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }@PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest){
        ResponseData responseData = new ResponseData();
        responseData.setData(loginServiceImp.addUser(signupRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


}
