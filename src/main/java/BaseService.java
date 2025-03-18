import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseService {
    final String baseURL = "https://api.disneyapi.dev";

    public Response sendGetRequest(String endpoint) {
        return given().
                when().
                    get(baseURL + endpoint);
    }
}
