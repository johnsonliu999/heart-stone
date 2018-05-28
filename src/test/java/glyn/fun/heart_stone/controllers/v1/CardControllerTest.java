package glyn.fun.heart_stone.controllers.v1;

import glyn.fun.heart_stone.controllers.v1.api.CardController;
import glyn.fun.heart_stone.exceptions.CardNotFoundException;
import glyn.fun.heart_stone.repositories.CardRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class CardControllerTest {

    private CardController cardController;

    @Mock
    private CardRepository cardRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cardController = new CardController(cardRepository);
    }


    @Test
    public void searchCards() throws Exception {
        assertNotNull(cardController.searchCards("howl"));
        try {
            cardController.searchCards("asdf");
            fail();
        } catch (RuntimeException e) {
            assertEquals(e.getClass(), CardNotFoundException.class);
        }
    }

    @Test
    public void getByClass() throws Exception {
        assertNotNull(cardRepository);
//        assertNotEquals(0, cardRepository.findByPlayerClass("Mage").size());
    }

    @Test
    public void getByType() throws Exception {
    }

    @Test
    public void getByRace() throws Exception {
    }

    @Test
    public void getBySet() throws Exception {
    }

    @Test
    public void getByQuality() throws Exception {
    }

    @Test
    public void getByFaction() throws Exception {
    }

    @Test
    public void getInfo() throws Exception {
    }

}