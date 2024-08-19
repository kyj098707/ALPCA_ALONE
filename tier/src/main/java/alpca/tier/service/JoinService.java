package alpca.tier.service;


import alpca.tier.dto.JoinDto;
import alpca.tier.entity.UserEntity;
import alpca.tier.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDto joinDto){
        String username = joinDto.getUsername();
        String password = joinDto.getPassword();
        String gender = joinDto.getGender();

        Boolean isExist = userRepository.existsByUsername(username);

        if (isExist) return;
        UserEntity data = new UserEntity();
        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setGender(gender);
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);
    }
}
