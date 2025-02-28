package com.backend.osahaneat.Reponsitory;

import com.backend.osahaneat.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReponsitory extends JpaRepository<Users, Integer> {
    List<Users> findByUsernameAndPassword(String username, String password);
}
