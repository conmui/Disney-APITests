import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class InvaildFilterTest extends BaseTest {
    @Test
    public void invalidFilter_Name() {
        BaseService baseService = new BaseService();
        Response response = baseService.sendGetRequestWithParams("/character", Map.of("name", "Hello Kitty"));

        verifyOKStatusCode(response);

        verifyInfoIsZeroEmpty(response);

        verifyDataIsEmpty(response);
    }

    public void verifyInfoIsZeroEmpty(Response response) {
        assertThat(response.path("info.count"), equalTo(0));
        assertThat(response.path("info.totalPages"), equalTo(0));
        assertThat(response.path("info.previousPage"), nullValue());
        assertThat(response.path("info.nextPage"), nullValue());
    }

    public void verifyDataIsEmpty(Response response) {
        assertThat(response.path("data"), empty());
    }
}
