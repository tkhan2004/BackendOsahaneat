package com.backend.osahaneat.Reponsitory;


import com.backend.osahaneat.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantReponsitory extends JpaRepository<Restaurant, Integer> {
}
