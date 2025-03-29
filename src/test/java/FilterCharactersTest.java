import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

public class FilterCharactersTest extends BaseTest {
    @Test
    public void filterCharacterByName_character() {
        BaseService baseService = new BaseService();
        String characterName = "Pascal";
        Character character = new Character(5149, List.of("Tangled", "Zootopia", "Tangled: Before Ever After", "Ralph Breaks the Internet"), List.of("Tangled Ever After"), List.of("Tangled: The Series"), List.of("Disney Universe", "Disney Princess: My Fairytale Adventure", "Epic Mickey: Power of Illusion", "disney:Hidden Worlds", "Disney Crossy Road", "Disney Tsum Tsum (game)", "Disney Emoji Blitz", "Kingdom Hearts III", "Disney Magic Kingdoms", "Disney Princess Majestic Quest"), List.of("Mickey's Soundsational Parade"), List.of(), List.of(), "https://disney.fandom.com/wiki/Pascal", characterName, "https://static.wikia.nocookie.net/disney/images/b/ba/Profile_-_Pascal.png", "2021-04-12T02:39:01.223Z", "2021-12-20T20:40:09.135Z", "https://api.disneyapi.dev/characters/5149", 0);
        Response response = baseService.sendGetRequestWithParams("/character", Map.of("name", characterName));

        verifyOKStatusCode(response);
        verifyInfo(response, 1, 1, "null", "null");
        verifyData(response, character);
    }

    @Test
    public void filterCharacterByName_characters() {
        BaseService baseService = new BaseService();
        String characterNameValue = "Sven";
        Response response = baseService.sendGetRequestWithParams("/character", Map.of("name", characterNameValue));
        List<Character> expectedCharacters = List.of(new Character(3516, List.of(), List.of(), List.of("Hercules: The Animated Series"), List.of(), List.of(), List.of(), List.of(), "https://disney.fandom.com/wiki/Jorgen_Svenson_and_Sven_Jorgenson", "Jorgen Svenson and Sven Jorgenson", "https://static.wikia.nocookie.net/disney/images/6/67/Jorgen_Svenson_and_Sven_Jorgenson.png", "2021-04-12T02:17:06.395Z","2021-12-20T20:39:52.549Z","https://api.disneyapi.dev/characters/3516",0), new Character(6526, List.of(), List.of(), List.of("Sofia the First"), List.of(), List.of(), List.of(), List.of(),"https://disney.fandom.com/wiki/Sven_(Sofia_the_First)","Sven","https://static.wikia.nocookie.net/disney/images/1/11/Sofia-the-First-The-Floating-Palace-26.png","2021-04-12T02:58:15.053Z","2021-12-20T20:40:22.701Z","https://api.disneyapi.dev/characters/6526",0), new Character(6525, List.of("Frozen", "Frozen II", "Moana (film)"), List.of("Frozen Fever", "Olaf's Frozen Adventure", "Once Upon a Snowman"), List.of("Once Upon a Time", "Frozen: Northern Lights"), List.of("Frozen: Olaf's Quest", "Frozen Free Fall", "Disney Infinity (series)", "Disney Tsum Tsum (game)", "Disney Emoji Blitz", "Disney Magic Kingdoms", "Disney Crossy Road", "Disney Magical Dice", "Kingdom Hearts III", "Disney Heroes: Battle Mode", "Disney Sorcerer's Arena"), List.of("World of Color", "Frozen Summer Fun!", "Disney Dreams!", "Frozen Ever After", "Frozen: Live at the Hyperion", "Once Upon a Time (Tokyo Disneyland)", "Disney Stars on Parade", "Frozen Forever"), List.of(), List.of(),"https://disney.fandom.com/wiki/Sven","Sven","https://static.wikia.nocookie.net/disney/images/0/0b/Profile_-_Sven.jpeg","2021-04-12T02:58:14.409Z","2021-12-20T20:40:22.701Z","https://api.disneyapi.dev/characters/6525", 0));

        verifyOKStatusCode(response);
        verifyInfo(response, 3, 1, "null", "null");
        verifyDataList(response, expectedCharacters);
    }

    @Test
    public void filterCharacterByNameAndFilm_character() {
        BaseService baseService = new BaseService();
        String characterName = "Sven";
        String film = "Frozen";
        Character character = new Character(6525, List.of("Frozen", "Frozen II", "Moana (film)"), List.of("Frozen Fever", "Olaf's Frozen Adventure", "Once Upon a Snowman"), List.of("Once Upon a Time", "Frozen: Northern Lights"), List.of("Frozen: Olaf's Quest", "Frozen Free Fall", "Disney Infinity (series)", "Disney Tsum Tsum (game)", "Disney Emoji Blitz", "Disney Magic Kingdoms", "Disney Crossy Road", "Disney Magical Dice", "Kingdom Hearts III", "Disney Heroes: Battle Mode", "Disney Sorcerer's Arena"), List.of("World of Color", "Frozen Summer Fun!", "Disney Dreams!", "Frozen Ever After", "Frozen: Live at the Hyperion", "Once Upon a Time (Tokyo Disneyland)", "Disney Stars on Parade", "Frozen Forever"), List.of(), List.of(), "https://disney.fandom.com/wiki/Sven", characterName, "https://static.wikia.nocookie.net/disney/images/0/0b/Profile_-_Sven.jpeg", "2021-04-12T02:58:14.409Z", "2021-12-20T20:40:22.701Z", "https://api.disneyapi.dev/characters/6525", 0);
        Response response = baseService.sendGetRequestWithParams("/character", Map.of("name", characterName, "films", film));

        verifyOKStatusCode(response);
        verifyInfo(response, 1, 1, "null", "null");
        verifyData(response, character);
    }

    @Test
    public void filterCharacterByInvalidName_noMatchEmpty() {
        BaseService baseService = new BaseService();
        Response response = baseService.sendGetRequestWithParams("/character", Map.of("name", "Hello Kitty"));

        verifyOKStatusCode(response);
        verifyInfo(response, 0,0, "null", "null");
        assertThat(response.path("data"), empty());
    }
}
