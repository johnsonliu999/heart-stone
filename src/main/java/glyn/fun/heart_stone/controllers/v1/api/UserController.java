package glyn.fun.heart_stone.controllers.v1.api;

import glyn.fun.heart_stone.domains.User;
import glyn.fun.heart_stone.exceptions.NotFoundException;
import glyn.fun.heart_stone.repositories.UserRepository;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers(OAuth2AuthenticationToken token) {
        return userRepository.findAll();
    }

    @GetMapping("/")
    public User getUserByEmails(@RequestParam("email") String email) {
        return userRepository.findByEmail(email).orElseThrow(NotFoundException::new);
    }
}
