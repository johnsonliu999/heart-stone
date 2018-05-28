package glyn.fun.heart_stone.domains;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 */
@Data
@Document(collection = "cards")
public class Card {

    @Id
    private String id;
    private String cardId;
    private String name;
    private String cardSet;
    private String type;
    private String text;
    private String race;
    private String playerClass;
    private String faction;
    private String rarity;
    private int health;
    private int attack;
    private int cost;
    private int durability;
    private String artist;
    private String flavor;
    private String img;
    private int voteNumber;
    private int totalScore;
}
