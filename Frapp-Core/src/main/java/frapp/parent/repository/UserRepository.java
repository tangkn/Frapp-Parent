package frapp.parent.repository;


import frapp.parent.dto.UserDTO;
import frapp.parent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    UserDTO findUserByUserId(UUID userId);

    
}
