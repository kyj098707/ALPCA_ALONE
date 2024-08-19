package alpca.tier.service;

import alpca.tier.dto.CustomUserDetails;
import alpca.tier.entity.UserEntity;
import alpca.tier.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userData = userRepository.findByUsername(username);
        System.out.println("dfdffd");
        System.out.println(userData.getUsername());
        if (userData != null) return new CustomUserDetails(userData);
        return null;
    }
}
