package frapp.parent.repository;

import frapp.parent.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HobbyRepository extends JpaRepository<Hobby, UUID> {

    @Query(value = "select * from t_hobby",nativeQuery = true)
    List<Hobby> findHobbies();
}
