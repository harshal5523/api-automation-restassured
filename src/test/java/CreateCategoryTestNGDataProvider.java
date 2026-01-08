import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class CreateCategoryTestNGDataProvider {
    DynamicJson ds = new DynamicJson();

    @Test(dataProvider = "createCategory")
    void createCategory(String name) {
        RestAssured.baseURI = "https://apiv2.qa-hubengage.com";
        String createCategory = given().header("Authorization","Q")
                .header("content-type","application/json")
                .header("tenant","h")
                .header("accept","application/json, text/plain, */*")
                .body(ds.createCategory(name)).post("/admin/content-category/")
                .then().log().all().extract().response().asString();

    }

    @DataProvider(name = "createCategory")
    public Object[][] categoryDetails() {

        int count = 20;   // how many test data you want
        Object[][] data = new Object[count][1];

        for (int i = 0; i < count; i++) {
            data[i][0] = "Category Test 1" + (i + 1);
        }

        return data;
    }


}
