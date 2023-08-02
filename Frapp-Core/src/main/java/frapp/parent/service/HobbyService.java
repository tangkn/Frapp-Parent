package frapp.parent.service;

import frapp.parent.entity.Hobby;
import frapp.parent.repository.HobbyRepository;
import lombok.NonNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HobbyService {

    @Autowired
    private HobbyRepository hobbyRepository;

    Logger logger = LogManager.getLogger();

    public Hobby save(@NonNull Hobby hobby){
        return hobbyRepository.save(hobby);
    }
    public List<Hobby> getAllHobby(){
        logger.info("get all user");
        return hobbyRepository.findHobbies();
    }
    public void delete(UUID id){
        hobbyRepository.deleteById(id);
    }
}
