import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateLocation {
DynamicJson ds= new DynamicJson();

@Test(dataProvider = "createLocations")





    void createLocationAdmin(String                 locationName,String locationDesc,int locationPhone,String locationCode){
        RestAssured.baseURI    =        "https://apiv2.stage-hubengage.com";
        given().header      ("Authorization","")
                .header("content-type","application/json")
                .header("tenant","")
                .header("accept","application/json, text/plain, */*")
                .body(ds.createLocationAdmin(locationName,locationDesc,locationPhone,locationCode)).
                when().post("/admin/location/")
                .then().log().all().extract().response().asString();


    }
    @DataProvider(name="createLocations")
    Object[][] locationDetails(){
        return new Object[][]{{"Location1 Name1","Location Desc",982230410,"Location Code1"},{"Location Name2","Location Desc",928432266,"Location Code 2"}};

    }
}
