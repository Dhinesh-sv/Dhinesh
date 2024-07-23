import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.io.File;

public class DemoTest {

    public void get(){
        RestAssured.given().baseUri("https://reqres.in/api/users?page=2").when().get().prettyPrint();

    }

    public void postPet() {

        RestAssured.given().baseUri("https://reqres.in/api/users").header("Content-Type","application/json").body("{\n"
                + "  \"id\": 0,\n"
                + "  \"petId\": 0,\n"
                + "  \"quantity\": 0,\n"
                + "  \"shipDate\": \"2024-07-17T11:30:17.759Z\",\n"
                + "  \"status\": \"placed\",\n"
                + "  \"complete\": true\n"
                + "}").when().post().prettyPrint();

    }

    public void postDataFromJson(){

        File jsonFile = new File("Postdata.json");
        RestAssured.given().baseUri("https://reqres.in/api/users")
                .header("Content-Type","application/json").body(jsonFile).when().post().prettyPrint();
    }


    public void basicAuth()
    {
        RestAssured.given().auth().basic("postman","password")
                .baseUri("https://postman-echo.com").when().get("basic-auth").prettyPrint();
    }

    public void apiKeyUsingParam(){

        RestAssured.given().queryParam("q","Tenkasi")
                .queryParam("appid","5960547ac0b72cde8922b12ebb647ccd").when()
                .get("https://api.openweathermap.org/data/2.5/weather").prettyPrint();
    }

    public void apiKeyUsingHeader(){

        RestAssured.given().queryParam("q","Tenkasi")
                .header("appid","5960547ac0b72cde8922b12ebb647ccd").when()
                .get("https://api.openweathermap.org/data/2.5/weather").prettyPrint();
    }
    @Test
   public void schemaValidation(){

       File jsonFile = new File("src/test/input.json");
        File schemajson = new File("src/test/input.json");
       RestAssured.given().baseUri("https://reqres.in/api/users")
               .header("Content-Type","application/json").body(jsonFile).when().post()
               .then().body(JsonSchemaValidator.matchesJsonSchema(schemajson));

   }


    }

