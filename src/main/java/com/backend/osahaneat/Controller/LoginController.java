package com.backend.osahaneat.Controller;

import com.backend.osahaneat.payload.Request.SignupRequest;
import com.backend.osahaneat.payload.ResponseData;
import com.backend.osahaneat.service.imp.LoginServiceImp;
import com.backend.osahaneat.utill.JwtUtillHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
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

    @Autowired
    JwtUtillHelper jwtUtillHelper;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username, String password){

        ResponseData responseData = new ResponseData();

//        SecretKey key = Jwts.SIG.HS256.key().build(); //or HS384.key() or HS512.key()
//        String secretString = Encoders.BASE64.encode(key.getEncoded());
//        System.out.println(secretString);

        //kích họạt SvImp
        if(loginServiceImp.checkLogin(username, password)){
            String token = jwtUtillHelper.generateToken(username);
            responseData.setData(token);
        }
        else {
            responseData.setData("");
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }@PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest){
        ResponseData responseData = new ResponseData();
        responseData.setData(loginServiceImp.addUser(signupRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


}
