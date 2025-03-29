import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PaginationTest extends BaseTest {
    @Test
    public void pagination_prevNumNextNum() {
        BaseService baseService = new BaseService();
        int pageNum = 2;
        Response response = baseService.sendGetRequestWithParams("/character", Map.of("page", pageNum));

        verifyOKStatusCode(response);
        assertThat(extractPageNum(response.path("info.previousPage")), equalTo(pageNum - 1));
        assertThat(extractPageNum(response.path("info.nextPage")), equalTo(pageNum + 1));
    }

    @Test
    public void paginationFirstPage_prevNullNextNum() {
        BaseService baseService = new BaseService();
        int pageNum = 1;
        Response response = baseService.sendGetRequestWithParams("/character", Map.of("page", pageNum));

        verifyOKStatusCode(response);
        assertThat(response.path("info.previousPage"), nullValue());
        assertThat(extractPageNum(response.path("info.nextPage")), equalTo(pageNum + 1));
    }

    @Test
    public void paginationLastPage_prevNumNextNull() {
        BaseService baseService = new BaseService();
        int pageNum = 149;
        Response response = baseService.sendGetRequestWithParams("/character", Map.of("page", pageNum));

        verifyOKStatusCode(response);
        assertThat(extractPageNum(response.path("info.previousPage")), equalTo(pageNum - 1));
        assertThat(response.path("info.nextPage"), nullValue());
    }

    public int extractPageNum(String url) {
        int start = url.indexOf("page=") + 5;
        int end = url.indexOf("&");

        return Integer.parseInt(url.substring(start, end));
    }
}
