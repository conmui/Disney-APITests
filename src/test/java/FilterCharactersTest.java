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
        String queryValue = "Sven";
//        String queryValue = "Mulan";
        Response response = baseService.sendGetRequestWithParam("/character", "name", queryValue);

        verifyStatusCode(response, OK_STATUS_CODE);

        verifyData(response, queryValue);
    }

    public void verifyData(Response response, String queryValue) {
        Object data = response.path("data");

        //data returns as a list when there are multiple matching results
        if (data instanceof List) {
            List<Map<String, Object>> dataList = (List<Map<String, Object>>) data;

            for (Map<String, Object> character : dataList) {
                String characterName = (String) character.get("name");
                assertThat(characterName, containsString(queryValue));
            }
        } else {
            String characterName = response.path("data.name");
            assertThat(characterName, containsString(queryValue));
        }
    }
}
