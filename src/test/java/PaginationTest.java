import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PaginationTest extends BaseTest {
    @Test
    public void paginationTest() {
        BaseService baseService = new BaseService();

        int queryValue = 2;
        int expectedPrevPageNum = queryValue - 1;
        int expectedNextPageNum = queryValue + 1;

        Response response = baseService.sendGetRequestWithParams("/character", Map.of("page", queryValue));
        int prevPageNum = extractPageNum(response.path("info.previousPage"));
        int nextPageNum = extractPageNum(response.path("info.nextPage"));

        verifyStatusCode(response, OK_STATUS_CODE);

        assertThat(prevPageNum, equalTo(expectedPrevPageNum));

        assertThat(nextPageNum, equalTo(expectedNextPageNum));
    }

    public int extractPageNum(String url) {
        int start = url.indexOf("page=") + 5;
        int end = url.indexOf("&");

        return Integer.valueOf(url.substring(start, end));
    }
}
