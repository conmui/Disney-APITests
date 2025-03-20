import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BaseTest {
    final int OK_STATUS_CODE = 200;

    public void verifyOKStatusCode(Response response) {
        assertThat(response.getStatusCode(), equalTo(OK_STATUS_CODE));
    }
}