package glyn.fun.heart_stone.controllers.v1;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/cards")
public class ApiController {

    private final String API_URL = "https://omgvamp-hearthstone-v1.p.mashape.com/cards";

    public ApiController() {
        Unirest.setDefaultHeader("X-Mashape-Key", "OSmIorlG6amshCBEGRU7LCUXobsBp1lV49Kjsnzxp5Ny5SWIHK");
        Unirest.setDefaultHeader("X-Mashape-Host", "omgvamp-hearthstone-v1.p.mashape.com");
    }

    @GetMapping("classes/{className}")
    public @ResponseBody String getByClass(@PathVariable String className) throws UnirestException {
        System.out.println("className: " + className);
        String resp =  Unirest.get(API_URL + "/classes/" + className).asString().getBody();
        return resp;
    }

    @GetMapping("/search/{keyWord}")
    public @ResponseBody String searchCards(@PathVariable String keyWord) throws UnirestException {
        System.out.println("keyWord: " + keyWord);
        String resp = Unirest.get(API_URL + "/search/" + keyWord).asString().getBody();
        return resp;
    }
}
