import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseService {
    final String baseURL = "https://api.disneyapi.dev";

    public Response sendGetRequest(String endpoint) {
        return given().
                when().
                        get(baseURL + endpoint);
    }

    public Response sendGetRequest(RequestSpecification requestSpecification, String endpoint) {
        return requestSpecification.
                when().
                        get(baseURL + endpoint);
    }

    public Response sendGetRequestWithParams(String endpoint, Map<String, Object> queries) {
        RequestSpecification requestSpecification =
                given().
                        params(queries);

        return sendGetRequest(requestSpecification, endpoint);
    }
}
