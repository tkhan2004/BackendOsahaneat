package com.backend.osahaneat.service.imp;

import com.backend.osahaneat.Entity.Restaurant;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface RestaurantServiceImp {

    boolean insertRestaurant(MultipartFile file, String title, String subTitle, String desc, boolean isFreship, String address, String openDate);

}
