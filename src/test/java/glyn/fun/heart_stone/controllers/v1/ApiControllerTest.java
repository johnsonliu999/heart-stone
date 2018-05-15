package glyn.fun.heart_stone.controllers.v1;

import glyn.fun.heart_stone.exceptions.CardNotFoundException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApiControllerTest {

    private ApiController apiController;

    @Before
    public void setUp() {
        apiController = new ApiController();
    }


    @Test
    public void searchCards() throws Exception {
        assertNotNull(apiController.searchCards("howl"));
        try {
            apiController.searchCards("asdf");
            fail();
        } catch (RuntimeException e) {
            assertEquals(e.getClass(), CardNotFoundException.class);
        }
    }

    @Test
    public void getByClass() throws Exception {

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

}