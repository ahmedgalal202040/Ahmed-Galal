import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class Stores {

    @Test
    public void Validate_GetData() {
        given().get("http://localhost:3030/stores").then().
                assertThat().body("data[0].id", equalTo(4)).and().
                assertThat().body("data[0].name", equalTo("Minnetonka")).and().
                assertThat().body("data[0].type", equalTo("BigBox")).and().
                assertThat().body("data[0].address", equalTo("13513 Ridgedale Dr")).and().
                assertThat().body("data[0].address2", equalTo("")).and().
                assertThat().body("data[0].city", equalTo("Hopkins")).and().
                assertThat().body("data[0].state", equalTo("MN")).and().
                assertThat().body("data[0].zip", equalTo("55305")).and().
                assertThat().body("data[0].lat", equalTo(44.969658F)).and().
                assertThat().body("data[0].lng", equalTo(-93.449539F)).and().
                assertThat().body("data[0].hours", equalTo("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8")).and().
                assertThat().body("data[0].createdAt", equalTo("2016-11-17T17:57:05.708Z")).and().
                assertThat().body("data[0].updatedAt", equalTo("2016-11-17T17:57:05.708Z")).and().
                assertThat().body("data[0].services[0].id", equalTo(1)).and().
                assertThat().body("data[0].services[0].name", equalTo("Geek Squad Services")).and().
                assertThat().body("data[0].services[0].createdAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[0].services[0].updatedAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[0].services[0].storeservices.createdAt", equalTo("2016-11-17T17:57:09.213Z")).and().
                assertThat().body("data[0].services[0].storeservices.updatedAt", equalTo("2016-11-17T17:57:09.213Z")).and().
                assertThat().body("data[0].services[0].storeservices.storeId", equalTo(4)).and().
                assertThat().body("data[0].services[0].storeservices.serviceId", equalTo(1)).and().
                assertThat().body("data[0].services[1].id", equalTo(2)).and().
                assertThat().body("data[0].services[1].name", equalTo("Best Buy Mobile")).and().
                assertThat().body("data[0].services[1].createdAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[0].services[1].updatedAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[0].services[1].storeservices.createdAt", equalTo("2016-11-17T17:57:09.213Z")).and().
                assertThat().body("data[0].services[1].storeservices.updatedAt", equalTo("2016-11-17T17:57:09.213Z")).and().
                assertThat().body("data[0].services[1].storeservices.storeId", equalTo(4)).and().
                assertThat().body("data[0].services[1].storeservices.serviceId", equalTo(2));


    }

    @Test
    public void Post_Store() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";
        Store stores = new Store();
        stores.setName("Ahmed Galal");
        stores.setType("Test");
        stores.setAddress("Alexandria");
        stores.setAddress2("Cairo");
        stores.setCity("Alex");
        stores.setState("MN");
        stores.setZip("0303");
        stores.setLat(56.666665);
        stores.setLng(-85.06665);
        stores.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");


        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(stores
                )
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
    @Test
    public void Put_Store() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";
        Store stores = new Store();
        stores.setName("Ahmed Galal U");
        stores.setType("Test");
        stores.setAddress("Alexandria");
        stores.setAddress2("Cairo");
        stores.setCity("Alex");
        stores.setState("MN");
        stores.setZip("0303");
        stores.setLat(56.666665);
        stores.setLng(-85.06665);
        stores.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");


        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(stores
                )
                .when()
                .put("/8921");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void Negative_Put_Store() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";
        Store stores = new Store();
        stores.setName("Ahmed Galal U");
        stores.setType("Test");
        stores.setAddress("Alexandria");
        stores.setAddress2("Cairo");
        stores.setCity("Alex");
        stores.setState("MN");
        stores.setZip("0303");
        stores.setLat(56.666665);
        stores.setLng(-85.06665);
        stores.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");


        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(stores
                )
                .when()
                .put("/89213333");
        response.then().statusCode(404);
        response.prettyPrint();
    }
    @Test
    public void Patch_Store() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";
        Store stores = new Store();
        stores.setName("Ahmed Galal U2");
        stores.setType("Test U2");

        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(stores
                )
                .when()
                .patch("/8921");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void Negative_Patch_Store() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";
        Store stores = new Store();
        stores.setName("Ahmed Galal U2");
        stores.setType("Test U2");

        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(stores
                )
                .when()
                .patch("/8921444");
        response.then().statusCode(404);
        response.prettyPrint();
    }
    @Test
    public void Delete_Data ()
    {
        when().delete("http://localhost:3030/stores/6");
        given().get("http://localhost:3030/stores/").then().assertThat().body("total", equalTo(1560));
    }
}
