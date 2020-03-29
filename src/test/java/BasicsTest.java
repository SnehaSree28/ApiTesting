import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by lovel on 14-Mar-20.
 */
public class BasicsTest {
    //Given--All Input Details
    //When--Submit the API Request -- Http Method
    //Then--Validate the response


    @Test
    public void addData() {
        RestAssured.baseURI = "https://rahulshettyacademy.com/";
        String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(Payload.addPlace()).when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP")).
                header("server",equalTo("Apache/2.4.18 (Ubuntu)")).extract()
                .response().asString();
                 JsonPath jsonPath = new JsonPath(response);
                 String placeId= jsonPath.getString("place_id");
                 String address = "Hyderabad";
        //Put Request

              given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                      .body("{\n" +
                              "\"place_id\":\""+placeId+"\",\n" +
                              "\"address\":\""+address+"\",\n" +
                              "\"key\":\"qaclick123\"\n" +
                              "}\n").when().put("maps/api/place/update/json").
                                then().log().all().assertThat().statusCode(200).
                                body("msg",equalTo("Address successfully updated"));
              //Get Request

         String getPlaceResponse= given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeId).
                      header("Content-Type","application/json").when().
                      get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200)
                      .extract().response().asString();
         JsonPath jsonPath1= new JsonPath(getPlaceResponse);
         String actualAddress=  jsonPath1.getString("address");

    }

}