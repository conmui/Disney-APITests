import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetAllCharactersTest extends BaseTest {
    @Test
    public void getAllCharacters_fields() {
        BaseService baseService = new BaseService();
        Response response = baseService.sendGetRequest("/character");

        verifyOKStatusCode(response);
        verifyInfo(response, 50, 149, "null", "http://api.disneyapi.dev/character?page=2&pageSize=50");
        verifyDataFields(response);
    }

    public void verifyDataFields(Response response) {
        List<Map<String, Object>> data = response.path("data");

        for (Map<String, Object> character : data) {
            assertThat(character, hasKey(equalTo("_id")));
            assertThat(character, hasKey(equalTo("films")));
            assertThat(character, hasKey(equalTo("shortFilms")));
            assertThat(character, hasKey(equalTo("tvShows")));
            assertThat(character, hasKey(equalTo("videoGames")));
            assertThat(character, hasKey(equalTo("parkAttractions")));
            assertThat(character, hasKey(equalTo("allies")));
            assertThat(character, hasKey(equalTo("enemies")));
            assertThat(character, hasKey(equalTo("sourceUrl")));
            assertThat(character, hasKey(equalTo("name")));
            assertThat(character, hasKey(equalTo("createdAt")));
            assertThat(character, hasKey(equalTo("updatedAt")));
            assertThat(character, hasKey(equalTo("url")));
            assertThat(character, hasKey(equalTo("__v")));
        }
    }
}
