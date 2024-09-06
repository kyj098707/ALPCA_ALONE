package com.example.back.controller;


import com.example.back.dto.JoinDto;
import com.example.back.dto.ProductDto;
import com.example.back.dto.TierCreateDto;
import com.example.back.dto.TierListDto;
import com.example.back.repository.TierRepository;
import com.example.back.service.TierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TierApiController {
    private final TierService tierService;

    @PostMapping("/tier")
    public void createTier(@RequestBody TierCreateDto tierCreateDto) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        tierService.createTier(tierCreateDto, username);
    }

    @GetMapping("/tier/me")
    public TierListDto readMyTier() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return tierService.readTierByUsername(username);
    }
}
