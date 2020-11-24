package com.projecttrack.User.Dao;


import com.projecttrack.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApplicationUserDao extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.username= :username")
    User findByUsername(@Param("username")String username);


}
