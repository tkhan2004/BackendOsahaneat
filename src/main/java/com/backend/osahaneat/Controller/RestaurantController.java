package com.backend.osahaneat.Controller;

import com.backend.osahaneat.payload.ResponseData;
import com.backend.osahaneat.service.FileService;
import com.backend.osahaneat.service.imp.FileServiceImp;
import com.backend.osahaneat.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    FileServiceImp fileServiceImp;

    @Autowired
    RestaurantServiceImp restaurantServiceImp;

    @PostMapping()
    public ResponseEntity<?> createRestaurant(@RequestParam("file") MultipartFile file,
                                              @RequestParam String title,
                                              @RequestParam String subTitle,
                                              @RequestParam String desc,
                                              @RequestParam Boolean isFreship,
                                              @RequestParam String address,
                                              @RequestParam String openDate) {


        ResponseData responseData = new ResponseData();
        boolean isSuccess = restaurantServiceImp.insertRestaurant(file, title, subTitle, desc, isFreship, address, openDate);
        responseData.setData(isSuccess);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<?> getFileRestaurant(@PathVariable  String filename) {
        Resource resource = fileServiceImp.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }

    @GetMapping()
    public ResponseEntity<?> getRestaurant() {

        ResponseData responseData = new ResponseData();
        responseData.setData(restaurantServiceImp.getRestaurants());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


}
