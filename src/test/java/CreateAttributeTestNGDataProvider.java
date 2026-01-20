import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateAttributeTestNGDataProvider {


@Test(dataProvider =                                                                  "attributeName")
   public void createAttribute(String attributeName,String hint){
        RestAssured.baseURI="https://apiv2.stage-hubengage.com";
        DynamicJson ds = new DynamicJson()                        ;
    String createAttributeResponse=    given().log().all()
            .header("Authorization","Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJmaXJzdE5hbWUiOiJIciIsImxhc3ROYW1lIjoic2hhcm1hIiwiaWQiOjI2MDUwNiwiZW1haWwiOiJoYXJzaGFsLmFAaHViZW5nYWdlLmNvbSIsInN1YiI6ImtNejNNcEVPIiwiYWRtaW5fdHlwZSI6MSwibGFuZ0NvZGUiOiJlbiIsImlzQWRtaW4iOnRydWUsImlzRmlyc3RMb2dpbiI6ZmFsc2UsInByZWZlcnJlZE5hbWUiOiJociIsImV4cCI6MTc2ODIzMDc0MH0.TMWuAyiQS7ODdxV2kE4S0ZwIu_5EzbSdH8z5rgzNgu1ZKlSDIzimyXi-SD5iJRVavZtHXlKypiU4OPRjc7e46g")
            .header("accept","application/json, text/plain, */*").header("accept-language","en")
            .header("content-type","application/json")
                .header("tenant","pte").body(ds.createAttribute( attributeName,  hint))
                .when().post("/admin/attribute/").
                then().log().all().extract().response().asString();

        JsonPath js= new JsonPath(createAttributeResponse);
        int attributeId= js.getInt("data.id");
        System.out.println(attributeId);

given().header("Authorization","Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJmaXJzdE5hbWUiOiJIciIsImxhc3ROYW1lIjoic2hhcm1hIiwiaWQiOjI2MDUwNiwiZW1haWwiOiJoYXJzaGFsLmFAaHViZW5nYWdlLmNvbSIsInN1YiI6ImtNejNNcEVPIiwiYWRtaW5fdHlwZSI6MSwibGFuZ0NvZGUiOiJlbiIsImlzQWRtaW4iOnRydWUsImlzRmlyc3RMb2dpbiI6ZmFsc2UsInByZWZlcnJlZE5hbWUiOiJociIsImV4cCI6MTc2ODIzMDc0MH0.TMWuAyiQS7ODdxV2kE4S0ZwIu_5EzbSdH8z5rgzNgu1ZKlSDIzimyXi-SD5iJRVavZtHXlKypiU4OPRjc7e46g")
            .header("accept","application/json, text/plain, */*").header("accept-language","en")
            .header("content-type","application/json")
            .header("tenant","pte").body(ds.createAttribute( attributeName,  hint))
            .body("{\"ids\":["+attributeId+"]}").
        when().delete("/admin/attribute/all").
        then().log().all().extract().response();

    }

@DataProvider(name="attributeName")
    public Object[][] dataProviderForCreateAttribute(){
       return new Object[][] {{"Text Attribute1","Hint Text 1"},{"Text Attribute2","Hint Text 2"}};

    }
}
