package com.example.back.service;


import com.example.back.dto.JoinDto;
import com.example.back.entity.Member;
import com.example.back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDto joinDto) {
        String username = joinDto.getUsername();
        String email = joinDto.getEmail();
        String password = joinDto.getPassword();
        String gender = joinDto.getGender();
        if (userRepository.existsByUsername(username)) return;

        Member data = new Member();

        data.setUsername(username);
        data.setEmail(email);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");
        data.setGender(gender);

        userRepository.save(data);
    }


}
