package ua.lviv.home.JavaProject.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.lviv.home.JavaProject.daos.UserRepository;
import ua.lviv.home.JavaProject.domain.AccessLevel;
import ua.lviv.home.JavaProject.domain.User;
import ua.lviv.home.JavaProject.dtos.UserRegisterRequest;

import java.util.*;

@Service
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private static final Set<AccessLevel> DEFAULT_USER_ROLES = Collections.singleton(AccessLevel.ROLE_USER);
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private EmailSendingService emailSendingService;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       EmailSendingService emailSendingService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailSendingService = emailSendingService;
    }

    public void save(UserRegisterRequest userRegisterRequest) {
        LOG.trace("Creating new User");
        User user = new User();
        user.setFirstName(userRegisterRequest.getFirstName());
        user.setLastName(userRegisterRequest.getLastName());
        user.setEmail(userRegisterRequest.getEmail());
        user.setAddress(userRegisterRequest.getAddress());
        user.setDateOfBirth(userRegisterRequest.getDateOfBirth());
        user.setPhoneNumber(userRegisterRequest.getPhoneNumber());
        user.setGender(userRegisterRequest.getGender());

        user.setRoles(DEFAULT_USER_ROLES);
        user.setUsername(userRegisterRequest.getUsername());

        String encodePassword = passwordEncoder.encode(userRegisterRequest.getPassword());
        user.setPassword(encodePassword);

        user.setEmailVerified(false);

        UUID uuid = UUID.randomUUID();
        user.setVerifyEmailHash(uuid.toString());

        userRepository.save(user);
        emailSendingService.sendVerificationEmail(userRegisterRequest.getEmail(), uuid.toString());
        LOG.info(String.format("Successfully created new User with username %s . Sent email for verification ",user.getUsername()));
    }

    public Optional<User> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void confirmEmail(String hash) {
        userRepository.findByVerifyEmailHash(hash)
                .ifPresent(user -> userRepository.confirmEmail(user.getId()));
    }
    public  void saveImage(String image, int id){
        userRepository.updateImageByUserId(image,id);
        LOG.info(String.format("Successfully added image for User with id %d ",id));
    }

    public void updateUser(User user) {

        userRepository.updateUser(user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getDateOfBirth(), user.getPhoneNumber(), user.getAddress(), user.getUsername(), user.getGender(),
                user.getId());
    }
}
