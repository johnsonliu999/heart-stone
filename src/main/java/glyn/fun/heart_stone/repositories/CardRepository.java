package glyn.fun.heart_stone.repositories;

import glyn.fun.heart_stone.domains.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends MongoRepository<Card, String> {
    Page<Card> findAll(Pageable pageable);
    List<Card> findByPlayerClass(String className);
    List<Card> findByRace(String race);
    List<Card> findByDurability(int durability);
    List<Card> findByCardSet(String cardSet);
    List<Card> findByType(String type);
    List<Card> findByRarity(String rarity);
    List<Card> findByFaction(String faction);
}
