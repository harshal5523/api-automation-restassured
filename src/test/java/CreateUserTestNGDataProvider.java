import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTestNGDataProvider {

    @Test(priority = 1, dataProvider = "userDetails")
    public void createUserAdmin(String firstName, String lastName, String email, String empid) {
        RestAssured.baseURI = "https://apiv2.stage-hubengage.com";
        DynamicJson ds = new DynamicJson();
        String userCreateResponse = given().log().all()
                .header("Authorization", "").
                header("content-type", "application/json")
                .header("tenant", "STAGE")
                .header("accept", "application/json, text/plain, */*").
                body(ds.userCreate(firstName, lastName, email, empid)).
                when().post("/admin/user")
                .then().log().all().extract().response().asString();
        JsonPath js = new JsonPath(userCreateResponse);
        int userID = js.getInt("data.id");
        System.out.println("User id is " + userID);


//Delete User
    given().log().all().header("Authorization","")
            .header("content-type","application/json")
            .header("tenant","STAGE")
            .header("accept","application/json, text/plain, */*")
            .body("{\"ids\":["+userID+"]}").when().delete("/admin/user/all")
            .then().log().all().extract().response();


    }

    @DataProvider(name = "userDetails")
    public Object[][] userDetails() {
        return new Object[][]{
                {"Bruce", "Wayne", "harshal.a+bruce0@hubengage.com", "bruce0"},
                {"Bruce", "Wayne", "harshal.a+bruce1@hubengage.com", "bruce1"}
        };
    }


}
