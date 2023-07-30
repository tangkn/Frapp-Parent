package frapp.parent.service;

import frapp.parent.dto.HobbyDTO;
import frapp.parent.entity.Hobby;
import frapp.parent.repository.HobbyRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HobbyService {

    @Autowired
    private HobbyRepository hobbyRepository;

    public Hobby save(@NonNull Hobby hobby){
        return hobbyRepository.save(hobby);
    }
}
