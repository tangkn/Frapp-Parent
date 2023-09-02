package frapp.parent.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/portal/home")
public class HomeRestController {

    @GetMapping("/login")
    public String home(){
        return "home page test";
    }
}
