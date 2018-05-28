package glyn.fun.heart_stone.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
@Data
public class Deck {

    @Data
    class Creator {
        private String id;
        private String name;
    }

    @Id
    private String id;
    private String name;
    private Creator creator;
    private List<Card> cards;
    private Date createdDate;
    private int voteNumber;
    private int totalScore;

}
