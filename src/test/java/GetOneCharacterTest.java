import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetOneCharacterTest extends BaseTest {
    @Test
    public void getOneCharacterByEndpointId_character() {
        BaseService baseService = new BaseService();
        int characterId = 5507;
        Character character = new Character(characterId, List.of("Moana (film)"), List.of(), List.of(), List.of("Moana: Island Life", "Disney Emoji Blitz", "Disney Crossy Road", "Disney Magic Kingdoms"), List.of("It's a Small World"), List.of(), List.of(), "https://disney.fandom.com/wiki/Pua_(Moana)", "Pua", "https://static.wikia.nocookie.net/disney/images/9/97/Profile_-_Pua.jpeg", "2021-04-12T02:43:51.258Z", "2021-12-20T20:40:12.609Z", "https://api.disneyapi.dev/characters/5507", 0);
        Response response = baseService.sendGetRequest("/character/" + characterId);

        verifyOKStatusCode(response);
        verifyInfo(response, 1,1, "null", "null");
        verifyData(response, character);
    }

    @Test
    public void getOneCharacterByEndpointInvalidId_noMatchEmpty() {
        BaseService baseService = new BaseService();
        Response response = baseService.sendGetRequest("/character/" + 5507777);

        verifyOKStatusCode(response);
        verifyInfo(response, 0,0, "null", "null");
        assertThat(response.path("data"), empty());
    }
}