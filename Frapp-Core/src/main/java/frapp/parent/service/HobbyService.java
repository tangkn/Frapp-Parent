package frapp.parent.service;

import frapp.parent.entity.Hobby;
import frapp.parent.repository.HobbyRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class HobbyService {


    private HobbyRepository hobbyRepository;//--


    public Hobby save(@NonNull Hobby hobby){
        return hobbyRepository.save(hobby);
    }

    public List<Hobby> getAllHobby(){
      //  logger.info("get all user");
        return hobbyRepository.findHobbies();
    }

    public void delete(UUID id){
        hobbyRepository.deleteById(id);
    }
}
