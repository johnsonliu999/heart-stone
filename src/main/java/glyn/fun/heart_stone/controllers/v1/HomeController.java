package glyn.fun.heart_stone.controllers.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value = {"collections/**", ""})
    public String index() {
        return "index";
    }
}
