package com.backend.osahaneat.service;

import com.backend.osahaneat.Entity.RatingRestaurant;
import com.backend.osahaneat.Entity.Restaurant;
import com.backend.osahaneat.Reponsitory.RestaurantReponsitory;
import com.backend.osahaneat.dto.RestaurantDTO;
import com.backend.osahaneat.service.imp.FileServiceImp;
import com.backend.osahaneat.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @Override
    public List<RestaurantDTO> getRestaurants() {
        List<RestaurantDTO> restaurantsDTOS = new ArrayList<>() ;
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Restaurant> listData = restaurantReponsitory.findAll(pageRequest);
        for (Restaurant restaurant : listData.getContent()) {
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            restaurantDTO.setImage(restaurant.getImage());
            restaurantDTO.setTitle(restaurant.getTitle());
            restaurantDTO.setSubTitle(restaurant.getSubtitle());
            restaurantDTO.setRating(rating(restaurant.getListRatingRestaurant()));
            restaurantDTO.setDesc(restaurant.getDesc());
            restaurantDTO.setFreship(restaurantDTO.isFreship());
            restaurantsDTOS.add(restaurantDTO);
        }
        return restaurantsDTOS;
    }

    private double rating(Set<RatingRestaurant> listRatingRestaurant) {
        double ratingPoint = 0;
        for (RatingRestaurant ratingRestaurant : listRatingRestaurant) {
            ratingPoint += ratingRestaurant.getRatePoint();
        }
        return ratingPoint / listRatingRestaurant.size();
    }
}
