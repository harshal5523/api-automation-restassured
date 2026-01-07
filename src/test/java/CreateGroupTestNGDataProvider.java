import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateGroupTestNGDataProvider {
    DynamicJson ds = new DynamicJson();

    @Test(dataProvider = "createGroupDetails")
    void createUserGroup(String name, String groupDesc) {
        RestAssured.baseURI = "https://apiv2.stage-hubengage.com";
        String createGroupUser = given().header("accept", "application/json, text/plain, */*")
                .header("Authorization", "fw")
                .header("accept-language", "en")
                .header("content-type", "application/json")
                .header("tenant", "pte")
                .body(ds.createGroupPayload(name, groupDesc))
                .when().post("/admin/usergroup/")
                .then().log().all().extract().response().asString();
        JsonPath js = new JsonPath(createGroupUser);
        int groupID = js.getInt("data.id");
        System.out.println(groupID);

//Delete
        given().header("accept", "application/json, text/plain, */*")
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJmaXJzdE5hbWUiOiJIciIsImxhc3ROYW1lIjoic2hhcm1hIiwiaWQiOjI2MDUwNiwiZW1haWwiOiJoYXJzaGFsLmFAaHViZW5nYWdlLmNvbSIsInN1YiI6ImtNejNNcEVPIiwiYWRtaW5fdHlwZSI6MSwibGFuZ0NvZGUiOiJlbiIsImlzQWRtaW4iOnRydWUsImlzRmlyc3RMb2dpbiI6ZmFsc2UsInByZWZlcnJlZE5hbWUiOiJociIsImV4cCI6MTc2ODQxMTIwNH0.18DGp9v5k1jaJVe__yycs4bC8eFR5AIHNtldAJMQoXclvk6kDc459J-EEYzmghVrngK__OLZFBUb2GBLLSZxfw")
                .header("accept-language", "en")
                .header("content-type", "application/json")
                .header("tenant", "pte")
                .body("{\"ids\":[" + groupID + "]}")
                .when().delete("/admin/usergroup/all")
                .then().log().all().extract().response().asString();

    }

    @DataProvider(name = "createGroupDetails")
    Object[][] dataProviderCreateGroup() {
        return new Object[][]{
                {"TestGroup1", "TestGroupDesc1"},
                {"TestGroup2", "TestGroupDesc2"}
        };

    }
}
