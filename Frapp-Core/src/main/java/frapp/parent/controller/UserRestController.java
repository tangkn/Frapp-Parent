package frapp.parent.Controller;

import frapp.parent.common.RestResponse;
import frapp.parent.common.RestResponseUtils;
import frapp.parent.dto.UserDTO;
import frapp.parent.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("api/portal/users")
public class UserRestController {
    private UserService userService;

    @PostMapping("/save")
    public RestResponse<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return RestResponseUtils.success(userService.create(userDTO));
    }

    @GetMapping("/{id}")
    public RestResponse<UserDTO> getUserById(UUID userId) {
        return RestResponseUtils.success(userService.getUserById(userId));
    }



}
