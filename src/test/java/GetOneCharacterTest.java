import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetOneCharacterTest extends BaseTest {
    @Test
    public void getOneCharacterByIdEndpoint() {
        BaseService baseService = new BaseService();
        int characterId = 2183;
        Response response = baseService.sendGetRequest("/character/" + characterId);

        verifyStatusCode(response, OK_STATUS_CODE);
        verifyData(response, characterId);
    }

    public void verifyData(Response response, int characterId) {
        assertThat(response.path("data"), notNullValue());
        assertThat(response.path("data._id"), equalTo(characterId));
    }
}
