package glyn.fun.heart_stone.controllers.v1.api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import glyn.fun.heart_stone.domains.Card;
import glyn.fun.heart_stone.exceptions.CardNotFoundException;
import glyn.fun.heart_stone.repositories.CardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/v1/cards")
public class CardController {

    private final String API_URL = "https://omgvamp-hearthstone-v1.p.mashape.com";
    private final CardRepository cardRepository;

    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
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
    @ResponseBody
//    public @ResponseBody String getByClass(@PathVariable String className) throws UnirestException {
//        System.out.println("className: " + className);
//        HttpResponse<String> resp =  Unirest.get(API_URL + "/cards/classes/" + className)
//                .queryString("collectible",1)
//                .asString();
//        return resp.getStatus() == 500 ? "" : resp.getBody();
//    }
    public List<Card> getByClass(@PathVariable String className) {
        return cardRepository.findByPlayerClass(className);
    }


    @GetMapping("/types/{type}")
    @ResponseBody
    public  List<Card> getByType(@PathVariable String type) throws UnirestException {
        return cardRepository.findByType(type);
    }

    @GetMapping("/races/{race}")
    @ResponseBody
    public List<Card> getByRace(@PathVariable String race) throws UnirestException {
        System.out.println("keyWord: " + race);
        return cardRepository.findByRace(race);
    }

    @GetMapping("/sets/{set}")
    @ResponseBody
    public List<Card> getByPlayerSet(@PathVariable String set) throws UnirestException {
        System.out.println("keyWord: " + set);
        return cardRepository.findByCardSet(set);
    }

    @GetMapping("/qualities/{quality}")
    @ResponseBody
    public List<Card> getByQuality(@PathVariable String quality) throws UnirestException {
        System.out.println("keyWord: " + quality);
        return cardRepository.findByRarity(quality);
    }

    @GetMapping("/factions/{faction}")
    @ResponseBody
    public List<Card> getByFaction(@PathVariable String faction) throws UnirestException {
        System.out.println("keyWord: " + faction);
        return cardRepository.findByFaction(faction);
    }

    @GetMapping("/info")
    public @ResponseBody String getInfo() throws UnirestException {
        HttpResponse<String> resp = Unirest.get(API_URL + "/info").asString();
        if (resp.getStatus() != 200) throw new UnirestException("info not get");
        return resp.getBody();
    }
}
