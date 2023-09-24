package test.Login;

import net.serenitybdd.rest.SerenityRest;
import utils.Endpoints;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class LoginStep implements Endpoints{
    String TokenLogin;
    public void loginSuccess(){


        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email_or_phone_number", "febri@alphatech.id");
        jsonAsMap.put("password", "magetan02");

        TokenLogin=SerenityRest
                .given()
                .contentType("application/json")
                .header("User-Agent","Alta")
                .header("Source","phoenix")
                .body(jsonAsMap)
                .when()
                .post(Endpoints.login)
                .then()
                .log()
                .ifValidationFails()
                .statusCode(200)
                .extract().path("data.access_token");

    }
    public String setTokenLogin(){
        return TokenLogin;
    }
    public void validationJSONSchemaLoginSuccess(){
        SerenityRest.then().body(matchesJsonSchemaInClasspath("JSONSchema/login.json"));
    }
}
