package frapp.parent.service;



import frapp.parent.dto.HobbyDTO;
import frapp.parent.dto.LoginDTO;
import frapp.parent.dto.UserDTO;
import frapp.parent.entity.Hobby;
import frapp.parent.entity.User;
import frapp.parent.exception.FrapException;
import frapp.parent.exception.FrapExceptions;
import frapp.parent.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.apache.logging.log4j.core.util.PasswordDecryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {


    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private PasswordDecryptor passwordDecryptor;
    public UserDTO create(UserDTO userDTO) {
        var user = convertDTOtoUser(userDTO);
        user = save(user);
        return convertUserToDTO(user);
    }

    private User save(@NonNull User user) {
        return userRepository.save(user);
    }

    public UserDTO getUserById(UUID userId)  {

        return userRepository.findUserByUserId(userId);
    }



    private  UserDTO convertUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(user.getUserName());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(passwordEncoder.encode(user.getPassword()));
        userDTO.setCreatedTime(user.getCreatedTime());

        Set<HobbyDTO> hobbiesDTO = new HashSet<>();
        for (Hobby hobby : user.getHobbies()) {
            HobbyDTO hobbyDTO = new HobbyDTO();
            hobbyDTO.setHobbyId(hobby.getHobbyId());
            hobbyDTO.setHobbyName(hobby.getHobbyName());
            hobbiesDTO.add(hobbyDTO);
        }
        userDTO.setHobbies(hobbiesDTO);

        return userDTO;
    }

    public static User convertDTOtoUser(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setUserName(userDTO.getUserName());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setCreatedTime(userDTO.getCreatedTime());
        user.setGender(user.getGender());

        Set<Hobby> hobbies = new HashSet<>();
        for (HobbyDTO hobbyDTO : userDTO.getHobbies()) {
            Hobby hobby = new Hobby();
            hobby.setHobbyId(hobbyDTO.getHobbyId());
            hobby.setHobbyName(hobbyDTO.getHobbyName());
            hobbies.add(hobby);
        }
        //user.setHobbies(hobbies);

        return user;
    }

    private HobbyDTO convertHobbyToDTO(Hobby hobby) {
        HobbyDTO hobbyDTO = new HobbyDTO();
        hobbyDTO.setHobbyId(hobby.getHobbyId());
        hobbyDTO.setHobbyName(hobby.getHobbyName());
        hobbyDTO.setHobbyDescription(hobby.getHobbyDescription());
        return hobbyDTO;
    }

    private Hobby convertDTOToHobby(HobbyDTO hobbyDTO) {
        Hobby hobby = new Hobby();
        hobby.setHobbyId(hobbyDTO.getHobbyId());
        hobby.setHobbyName(hobbyDTO.getHobbyName());
        hobby.setHobbyDescription(hobbyDTO.getHobbyDescription());
        return hobby;
    }

    public LoginDTO login(LoginDTO loginDTO) throws FrapException {

        var user = userRepository.findByName(loginDTO.getUserName());
        if (!user.isPresent()){
            throw FrapExceptions.USER_NOT_FOUND_EXCEPTION;
        }
        if(passwordDecryptor.decryptPassword(loginDTO.getPassword()).equals(user.get().getPassword())){
            throw FrapExceptions.WRONG_USER_PASSWORD;
        }

        return loginDTO;
    }
}
