package com.example.back.controller;

import com.example.back.dto.JoinDto;
import com.example.back.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class JoinController {
    private final JoinService joinService;

    @PostMapping("/join")
    public String joinP(@RequestBody JoinDto joinDto) {

        joinService.joinProcess(joinDto);
        return "ok";
    }
}
