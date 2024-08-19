package alpca.tier.controller;

import alpca.tier.dto.JoinDto;
import alpca.tier.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class JoinController{

    private final JoinService joinService;

    @PostMapping("/join")
    public String joinProcess(JoinDto joinDto){
        joinService.joinProcess(joinDto);
        return "ok";
    }
}
