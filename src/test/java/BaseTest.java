import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BaseTest {
    final int OK_STATUS_CODE = 200;

    public void verifyOKStatusCode(Response response) {
        assertThat(response.getStatusCode(), equalTo(OK_STATUS_CODE));
    }

    public void verifyInfo(Response response, int count, int totalPages, String previousPage, String nextPage) {
        boolean isPrevPageNull = previousPage.equals("null");
        boolean isNextPageNull = nextPage.equals("null");

        assertThat(response.path("info.count"), equalTo(count));
        assertThat(response.path("info.totalPages"), equalTo(totalPages));
        assertThat(response.path("info.previousPage"), isPrevPageNull ? nullValue() : equalTo(previousPage));
        assertThat(response.path("info.nextPage"), isNextPageNull ? nullValue() : equalTo(nextPage));
    }

    public void verifyData(Response response, Character character){
        assertThat(response.path("data._id"), equalTo(character.getCharacterId()));
        assertThat(response.path("data.films"), equalTo(character.getFilms()));
        assertThat(response.path("data.shortFilms"), equalTo(character.getShortFilms()));
        assertThat(response.path("data.tvShows"), equalTo(character.getTVShows()));
        assertThat(response.path("data.videoGames"), equalTo(character.getVideoGames()));
        assertThat(response.path("data.parkAttractions"), equalTo(character.getParkAttractions()));
        assertThat(response.path("data.allies"), equalTo(character.getAllies()));
        assertThat(response.path("data.enemies"), equalTo(character.getEnemies()));
        assertThat(response.path("data.sourceUrl"), equalTo(character.getSourceUrl()));
        assertThat(response.path("data.name"), equalTo(character.getName()));
        assertThat(response.path("data.imageUrl"), equalTo(character.getImageUrl()));
        assertThat(response.path("data.createdAt"), equalTo(character.getCreatedAt()));
        assertThat(response.path("data.updatedAt"), equalTo(character.getUpdatedAt()));
        assertThat(response.path("data.url"), equalTo(character.getUrl()));
        assertThat(response.path("data.\"__v\""), equalTo(character.getVersion()));
    }

    public void verifyDataList(Response response, List<Character> expectedCharacters) {
        List<Map<String, Object>> data = response.path("data");

        for (int i = 0; i < data.size(); i++) {
            Map<String, Object> character = data.get(i);
            Character expectedCharacter = expectedCharacters.get(i);

            assertThat(character.get("_id"), equalTo(expectedCharacter.getCharacterId()));
            assertThat(character.get("films"), equalTo(expectedCharacter.getFilms()));
            assertThat(character.get("shortFilms"), equalTo(expectedCharacter.getShortFilms()));
            assertThat(character.get("tvShows"), equalTo(expectedCharacter.getTVShows()));
            assertThat(character.get("videoGames"), equalTo(expectedCharacter.getVideoGames()));
            assertThat(character.get("parkAttractions"), equalTo(expectedCharacter.getParkAttractions()));
            assertThat(character.get("allies"), equalTo(expectedCharacter.getAllies()));
            assertThat(character.get("enemies"), equalTo(expectedCharacter.getEnemies()));
            assertThat(character.get("sourceUrl"), equalTo(expectedCharacter.getSourceUrl()));
            assertThat(character.get("name"), equalTo(expectedCharacter.getName()));
            assertThat(character.get("imageUrl"), equalTo(expectedCharacter.getImageUrl()));
            assertThat(character.get("createdAt"), equalTo(expectedCharacter.getCreatedAt()));
            assertThat(character.get("updatedAt"), equalTo(expectedCharacter.getUpdatedAt()));
            assertThat(character.get("url"), equalTo(expectedCharacter.getUrl()));
            assertThat(character.get("__v"), equalTo(expectedCharacter.getVersion()));
        }
    }
}