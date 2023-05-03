import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import org.hamcrest.Matchers;
import org.junit.Test;


public class CatTest {
    @Test
    public void putTest() {
        var body = RestAssured.given()
                .queryParam("title","cat")
                .filter(new RequestLoggingFilter())
                .get("https://api.publicapis.org/entries")
                .then().statusCode(200)
                .body(Matchers.anything())
                .extract()
                .body()
                .asString()
                .contains("cat");
    }

}
