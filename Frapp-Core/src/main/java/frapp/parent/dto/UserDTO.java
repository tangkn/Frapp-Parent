package com.tan.frap.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class UserDTO {
    private UUID userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Timestamp createdTime;
    private Timestamp updatedTime;
    private Set<HobbyDTO> hobbies;


}