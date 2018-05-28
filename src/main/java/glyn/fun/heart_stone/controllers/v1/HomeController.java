package glyn.fun.heart_stone.controllers.v1;

import glyn.fun.heart_stone.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {

    private final UserRepository userRepository;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = {"collections/**", ""})
    public String index(Model model, OAuth2AuthenticationToken token) {
        log.debug("index", token);
        log.debug(String.valueOf(token.getPrincipal().getAttributes()));

        String email = (String)token.getPrincipal().getAttributes().get("email");
        model.addAttribute("user", userRepository.findByEmail(email).get());
        return "index";
    }
}
