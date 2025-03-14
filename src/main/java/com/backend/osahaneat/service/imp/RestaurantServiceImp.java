package com.backend.osahaneat.service.imp;

import com.backend.osahaneat.dto.RestaurantDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RestaurantServiceImp {

    boolean insertRestaurant(MultipartFile file, String title, String subTitle, String desc, boolean isFreship, String address, String openDate);
    List<RestaurantDTO> getRestaurants();
}
