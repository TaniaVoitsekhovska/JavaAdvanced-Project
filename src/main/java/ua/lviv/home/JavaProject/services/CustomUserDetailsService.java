package ua.lviv.home.JavaProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.home.JavaProject.daos.UserRepository;
import ua.lviv.home.JavaProject.domain.User;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userCheck = userRepository.findByUsername(username);
        return userCheck
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("No user present with username: " + username));
    }
}
