import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetUsersTest {

    @Test
    public void getUsers() {
        RestAssured
                .given()
                .baseUri("https://reqres.in")
                .when()
                .get("/api/users?page=2")
                .then()
                .statusCode(200);
    }
}
