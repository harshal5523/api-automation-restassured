import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class CreateUser {


@Test(priority = 1)
    public  void createUserAdmin(){
    RestAssured.baseURI="https://apiv2.stage-hubengage.com";
DynamicJson ds=new DynamicJson();
    String userCreateResponse=  given().log().all()
            .header("Authorization","").
            header("content-type","application/json")
            .header("tenant","stage")
            .header("accept","application/json, text/plain, */*").
            body(ds.userCreate("Bruce","Wayne","harshal.a+wayne0@hubengage.com","Wayne0")).
            when().post("/admin/user")
            .then().log().all().extract().response().asString();
    JsonPath js= new JsonPath(userCreateResponse);
    int userID=js.getInt("data.id");
    System.out.println("User id is "+userID);


//Delete User
//    given().log().all().header("Authorization","")
//            .header("content-type","application/json")
//            .header("tenant","stage")
//            .header("accept","application/json, text/plain, */*")
//            .body("{\"ids\":["+userID+"]}").when().delete("/admin/user/all")
//            .then().log().all().extract().response();


    }

}
