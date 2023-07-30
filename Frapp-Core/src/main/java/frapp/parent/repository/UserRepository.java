package com.tan.frap.repository;

import com.tan.frap.dto.UserDTO;
import com.tan.frap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    List<User>  getAllUsers();
    UserDTO findUserByUserId(UUID userId);

    
}
