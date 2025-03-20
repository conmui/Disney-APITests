import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FilterCharactersByMultipleParamsTest extends BaseTest {
    @Test
    public void filterCharacterByMultipleParams_NameFilms() {
        BaseService baseService = new BaseService();
        String characterNameValue = "Sven";
        String filmsValue = "Frozen";
        Map<String, Object> params = Map.of("name", characterNameValue, "films", filmsValue);
        Response response = baseService.sendGetRequestWithParams("/character", params);

        verifyData(response, characterNameValue, filmsValue);
    }

    public void verifyData(Response response, String expectedName, String expectedFilm) {
        String characterName = response.path("data.name");
        List<String> characterFilms = response.path("data.films");

        assertThat(characterName, equalTo(expectedName));
        assertThat(characterFilms, hasItem(expectedFilm));
    }
}
