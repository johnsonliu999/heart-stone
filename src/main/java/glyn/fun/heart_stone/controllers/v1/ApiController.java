package glyn.fun.heart_stone.controllers.v1;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import glyn.fun.heart_stone.exceptions.CardNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/cards")
public class ApiController {

    private final String API_URL = "https://omgvamp-hearthstone-v1.p.mashape.com";

    public ApiController() {
        Unirest.setDefaultHeader("X-Mashape-Key", "OSmIorlG6amshCBEGRU7LCUXobsBp1lV49Kjsnzxp5Ny5SWIHK");
        Unirest.setDefaultHeader("X-Mashape-Host", "omgvamp-hearthstone-v1.p.mashape.com");
    }

    @GetMapping("/search/{keyWord}")
    public @ResponseBody String searchCards(@PathVariable String keyWord) throws UnirestException {
        System.out.println("keyWord: " + keyWord);
        HttpResponse<String> resp = Unirest.get(API_URL + "/cards/search/" + keyWord)
                .queryString("collectible",1)
                .asString();
        if (resp.getStatus() != 200) throw new CardNotFoundException("card not found");
        return resp.getBody();
    }

    @GetMapping("/classes/{className}")
    public @ResponseBody String getByClass(@PathVariable String className) throws UnirestException {
        System.out.println("className: " + className);
        HttpResponse<String> resp =  Unirest.get(API_URL + "/cards/classes/" + className)
                .queryString("collectible",1)
                .asString();
        return resp.getStatus() == 500 ? "" : resp.getBody();
    }

    @GetMapping("/types/{keyWord}")
    public @ResponseBody String getByType(@PathVariable String keyWord) throws UnirestException {
        System.out.println("keyWord: " + keyWord);
        String resp = Unirest.get(API_URL + "/cards/types/" + keyWord)
                .queryString("collectible",1)
                .asString().getBody();
        return resp;
    }

    @GetMapping("/races/{keyWord}")
    public @ResponseBody String getByRace(@PathVariable String keyWord) throws UnirestException {
        System.out.println("keyWord: " + keyWord);
        String resp = Unirest.get(API_URL + "/cards/races/" + keyWord)
                .queryString("collectible",1)
                .asString().getBody();
        return resp;
    }

    @GetMapping("/sets/{keyWord}")
    public @ResponseBody String getBySet(@PathVariable String keyWord) throws UnirestException {
        System.out.println("keyWord: " + keyWord);
        String resp = Unirest.get(API_URL + "/cards/sets/" + keyWord)
                .queryString("collectible",1)
                .asString().getBody();
        return resp;
    }

    @GetMapping("/qualities/{keyWord}")
    public @ResponseBody String getByQuality(@PathVariable String keyWord) throws UnirestException {
        System.out.println("keyWord: " + keyWord);
        String resp = Unirest.get(API_URL + "/cards/qualities/" + keyWord)
                .queryString("collectible",1)
                .asString().getBody();
        return resp;
    }

    @GetMapping("/factions/{keyWord}")
    public @ResponseBody String getByFaction(@PathVariable String keyWord) throws UnirestException {
        System.out.println("keyWord: " + keyWord);
        String resp = Unirest.get(API_URL + "/cards/factions/" + keyWord)
                .queryString("collectible",1)
                .asString().getBody();
        return resp;
    }

    @GetMapping("/info")
    public @ResponseBody String getInfo() throws UnirestException {
        HttpResponse<String> resp = Unirest.get(API_URL + "/info").asString();
        if (resp.getStatus() != 200) throw new UnirestException("info not get");
        return resp.getBody();
    }
}
