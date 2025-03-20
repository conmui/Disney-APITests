import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FilterCharactersTest extends BaseTest {
    @Test
    public void filterCharacterByParam_Name() {
        BaseService baseService = new BaseService();
        String characterNameValue = "Sven";
//        String characterNameValue = "Mulan";
        Map<String, Object> param = Map.of("name", characterNameValue);
        Response response = baseService.sendGetRequestWithParams("/character", param);

        verifyOKStatusCode(response);

        verifyData(response, characterNameValue);
    }

    public void verifyData(Response response, String expectedName) {
        Object data = response.path("data");

        //data returns as a list when there are multiple matching results
        if (data instanceof List) {
            List<Map<String, Object>> dataList = (List<Map<String, Object>>) data;

            for (Map<String, Object> character : dataList) {
                String characterName = (String) character.get("name");
                assertThat(characterName, containsString(expectedName));
            }
        } else {
            String characterName = response.path("data.name");
            assertThat(characterName, containsString(expectedName));
        }
    }
}
