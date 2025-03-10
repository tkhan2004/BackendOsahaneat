package com.backend.osahaneat.service;

import com.backend.osahaneat.Entity.Restaurant;
import com.backend.osahaneat.Reponsitory.RestaurantReponsitory;
import com.backend.osahaneat.service.imp.FileServiceImp;
import com.backend.osahaneat.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RestaurantService implements RestaurantServiceImp {
    @Autowired
    RestaurantReponsitory restaurantReponsitory;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public boolean insertRestaurant(MultipartFile file, String title, String subTitle, String desc, boolean isFreeship, String address, String openDate) {
        boolean isInsertRestaurant = false;
        boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
        if(isSaveFileSuccess){
            Restaurant restaurant = new Restaurant();
            restaurant.setTitle(title);
            restaurant.setSubtitle(subTitle);
            restaurant.setAddress(address);
            restaurant.setDesc(desc);
            restaurant.setImage(file.getOriginalFilename());
            restaurant.setFreeship(isFreeship);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            try {
                Date OpenDate = sdf.parse(openDate);
                restaurant.setOpenDate(OpenDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            restaurantReponsitory.save(restaurant);
            isInsertRestaurant = true;

        }
        return isInsertRestaurant;
    }
}
