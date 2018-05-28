package glyn.fun.heart_stone.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {

    public User() {
        this.collectedDecks = new HashSet<>();
        this.createdDecks = new HashSet<>();
    }

    @Id
    private String id;
    private String name;

    @Indexed(unique = true)
    private String email;
    private String picture;
    private Set<Deck> createdDecks;
    private Set<Deck> collectedDecks;
}
