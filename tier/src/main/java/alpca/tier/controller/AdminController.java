package alpca.tier.controller;

import alpca.tier.dto.JoinDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class AdminController {

    @PostMapping("/admin")
    public String adminP(JoinDto joinDto){

        return "Admin Controller";
    }
}