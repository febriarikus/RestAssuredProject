package test.PaymentSepulsaKredit;

import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;
import utils.Endpoints;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;


import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PaymentSepulsaKreditSteps implements Endpoints {
    String TokenLogin;
    String TokenLoginNol,TokenLogin1;
    String orderId,ambil;
    public void loginSuccess(){
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email_or_phone_number", "julinuranita7@gmail.com");
        jsonAsMap.put("password", "julinuranita");

        TokenLogin= SerenityRest
                .given()
                .contentType("application/json")
                .header("User-Agent","alta")
                .header("Source","phoenix")
                .body(jsonAsMap)
                .when()
                .post(Endpoints.login)
                .then()
                .log()
                .ifValidationFails()
                .statusCode(200)
                .extract().path("data.access_token");

        System.out.println(TokenLogin);
    }
    public void validationJSONSchemaLoginSuccess(){
        SerenityRest.then().body(matchesJsonSchemaInClasspath("JSONSchema/login.json"));
    }

    public void addToCartSuccess(String ID, String phone) {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("type", "mobile_prepaid");
        jsonAsMap.put("product_id", ID);
        jsonAsMap.put("phone_number", phone);
        jsonAsMap.put("provider","");

        SerenityRest
                .given()
                .contentType("application/json")
                .accept("application/json")
                .header("User-Agent","alta")
                .header("Authorization","Bearer "+TokenLogin)
                .header("Source","phoenix")
                .body(jsonAsMap)
                .when()
                .post(Endpoints.add_to_cart)
                .then()
                .log()
                .ifValidationFails()
                .statusCode(200);
    }
    public void validationJSONSchemaAddToCartSuccess() {
        SerenityRest.then().body(matchesJsonSchemaInClasspath("JSONSchema/addtocart.json"));
    }

    public void processSuccess() {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("payment_method", "payment_commerce_2|commerce_payment_payment_commerce_2");

        orderId = SerenityRest
                .given()
                .contentType("application/json")
                .accept("application/json")
                .header("User-Agent","alta")
                .header("Authorization","Bearer "+TokenLogin)
                .header("Source","phoenix")
                .body(jsonAsMap)
                .when()
                .post(Endpoints.post_process)
                .then()
                .log()
                .ifValidationFails()
                .statusCode(200)
                .extract().path("data.order_id");
    }
    public void validationJSONSchemaProcessSuccess() {
        SerenityRest.then().body(matchesJsonSchemaInClasspath("JSONSchema/process.json"));
    }
    public void completeSuccess() {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("order_id", orderId);
        SerenityRest
                .given()
                .contentType("application/json")
                .accept("application/json")
                .header("User-Agent","alta")
                .header("Authorization","Bearer "+TokenLogin)
                .header("Source","phoenix")
                .body(jsonAsMap)
                .when()
                .post(Endpoints.post_complete)
                .then()
                .log()
                .ifValidationFails()
                .statusCode(200);
    }
    public void validationJSONSchemaCompleteSuccess() {
        SerenityRest.then().body(matchesJsonSchemaInClasspath("JSONSchema/complete.json"));
    }

    public void HaveBeenLogged(){
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email_or_phone_number", "febri@alphatech.id");
        jsonAsMap.put("password", "magetan02");

        TokenLoginNol= SerenityRest
                .given()
                .contentType("application/json")
                .header("User-Agent","alta")
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
    public void isAddProduct(String ID, String phone){
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("type", "mobile_prepaid");
        jsonAsMap.put("product_id", ID);
        jsonAsMap.put("phone_number", phone);
        jsonAsMap.put("provider","");

        ambil=SerenityRest
                .given()
                .contentType("application/json")
                .accept("application/json")
                .header("User-Agent","alta")
                .header("Authorization","Bearer "+TokenLoginNol)
                .header("Source","phoenix")
                .body(jsonAsMap)
                .when()
                .post(Endpoints.add_to_cart)
                .then()
                .log()
                .ifValidationFails()
                .statusCode(200)
                .extract().path("rescode");
        System.out.println(ambil);
    }
        public void HaveBeenLoggedIn(){
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email_or_phone_number", "febri@alphatech.id");
        jsonAsMap.put("password", "magetan02");

        TokenLogin1= SerenityRest
                .given()
                .contentType("application/json")
                .header("User-Agent","alta")
                .header("Source","phoenix")
                .body(jsonAsMap)
                .when()
                .post(Endpoints.login)
                .then()
                .log()
                .ifValidationFails()
                .statusCode(200)
                .extract().path("data.access_token");
        System.out.println(TokenLogin1);
    }
    public void getPaymentList(){
        SerenityRest
                .given()
                .contentType("application/json")
                .accept("application/json")
                .header("User-Agent","alta")
                .header("Authorization","Bearer "+TokenLogin)
                .header("Source","phoenix")
                .when()
                .get(Endpoints.get_payment_list)
                .then()
                .log()
                .ifValidationFails()
                .statusCode(200);
    }

//    public void getPaymentList(){
//        SerenityRest
//                .given()
//                .contentType("application/json")
//                .accept("application/json")
//                .header("User-Agent","alta")
//                .header("Authorization","Bearer "+TokenLogin)
//                .header("Source","phoenix")
//                .when()
//                .get(Endpoints.get_payment_list)
//                .then()
//                .log()
//                .ifValidationFails()
//                .statusCode(200)
//                .extract().path("rescode");
//        System.out.println(ambil);
//    }
//    public void validationMessage(){
//        String message =
//                SerenityRest
//                        .then()
//                        .extract()
//                        .path("data.payment_tittle");
//        Assert.assertFalse(message.contains("Sepulsa Kredit"));
//    }

}
