package frapp.parent.repository;

import frapp.parent.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HobbyRepository extends JpaRepository<Hobby, UUID> {
}
