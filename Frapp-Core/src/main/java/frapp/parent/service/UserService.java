package org.frapp.core.service;



import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {


    private com.tan.frap.repository.UserRepository userRepository;

    public UserDTO create(UserDTO userDTO) {
        var user = convertDTOtoUser(userDTO);
        user = save(user);
        return convertUserToDTO(user);
    }

    private User save(@Nonnull User user) {

        return userRepository.save(user);
    }

    public UserDTO getUserById(UUID userId)  {

        return userRepository.findUserByUserId(userId);
    }



    private static UserDTO convertUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(user.getUserName());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setCreatedTime(user.getCreatedTime());
        userDTO.setUpdatedTime(user.getUpdatedTime());

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
        user.setUpdatedTime(userDTO.getUpdatedTime());

        Set<Hobby> hobbies = new HashSet<>();
        for (HobbyDTO hobbyDTO : userDTO.getHobbies()) {
            Hobby hobby = new Hobby();
            hobby.setHobbyId(hobbyDTO.getHobbyId());
            hobby.setHobbyName(hobbyDTO.getHobbyName());
            hobbies.add(hobby);
        }
        user.setHobbies(hobbies);

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
}
