package frapp.parent.Controller;

import frapp.parent.common.RestResponse;
import frapp.parent.common.RestResponseUtils;
import frapp.parent.entity.Hobby;
import frapp.parent.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/portal/hobby")
public class HobbyRestController {
    @Autowired
    private HobbyService hobbyService;
    @PostMapping("/save")
    public RestResponse<Hobby> save(@RequestBody Hobby hobby){
        return RestResponseUtils.success(hobbyService.save(hobby));
    }

    @GetMapping("/getAll")
    public RestResponse<List<Hobby>> getAll(){
        return RestResponseUtils.success(hobbyService.getAllHobby());
    }
    @DeleteMapping("/id")
    public String delete(@RequestParam UUID id){
        // TODO: parametresiz RestResponseUtils success metodu yaz.
        hobbyService.delete(id);
        return "ok";
    }

}
