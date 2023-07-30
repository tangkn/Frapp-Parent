package frapp.parent.Controller;

import frapp.parent.common.RestResponse;
import frapp.parent.common.RestResponseUtils;
import frapp.parent.entity.Hobby;
import frapp.parent.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hobby")
public class HobbyRestController {
    @Autowired
    private HobbyService hobbyService;
    @PostMapping("/save")
    public RestResponse<Hobby> save(@RequestBody Hobby hobby){
        return RestResponseUtils.success(hobbyService.save(hobby));
    }

}
