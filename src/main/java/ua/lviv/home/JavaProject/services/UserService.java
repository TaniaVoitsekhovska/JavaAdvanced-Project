package ua.lviv.home.JavaProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.lviv.home.JavaProject.daos.UserRepository;
import ua.lviv.home.JavaProject.domain.AccessLevel;
import ua.lviv.home.JavaProject.domain.User;
import ua.lviv.home.JavaProject.dtos.UserRegisterRequest;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {
    private static final Set<AccessLevel> DEFAULT_USER_ROLES = Collections.singleton(AccessLevel.ROLE_USER);
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private EmailSendingService emailSendingService;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, EmailSendingService emailSendingService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailSendingService = emailSendingService;
    }

    public void save(UserRegisterRequest userRegisterRequest) {
        User user = new User();
        user.setFirstName(userRegisterRequest.getFirstName());
        user.setLastName(userRegisterRequest.getLastName());
        user.setEmail(userRegisterRequest.getEmail());

        user.setRoles(DEFAULT_USER_ROLES);
        user.setUsername(userRegisterRequest.getUsername());

        String encodePassword = passwordEncoder.encode(userRegisterRequest.getPassword());
        user.setPassword(encodePassword);
        user.setEmailVerified(false);

        UUID uuid = UUID.randomUUID();
        user.setVerifyEmailHash(uuid.toString());

        userRepository.save(user);
        emailSendingService.sendVerificationEmail(userRegisterRequest.getEmail(), uuid.toString());
    }

    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void confirmEmail(String hash) {
        userRepository.findByVerifyEmailHash(hash)
                .ifPresent(user -> userRepository.confirmEmail(user.getId()));
    }
}
