package com.tan.frap.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class HobbyDTO {
    private UUID hobbyId;
    private String hobbyName;
    private String hobbyDescription;
}
