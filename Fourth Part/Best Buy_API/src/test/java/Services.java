import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class Services
{
    @Test
    public void Validate_GetData() {
        given().get("http://localhost:3030/services").then().assertThat().body("data[0].'id'", equalTo(1)).and().
                assertThat().body("data[0].name", equalTo("Geek Squad Services")).and().
                assertThat().body("data[0].createdAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[0].updatedAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[1].id", equalTo(2)).and().
                assertThat().body("data[1].name", equalTo("Best Buy Mobile")).and().
                assertThat().body("data[1].createdAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[1].updatedAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[2].id", equalTo(3)).and().
                assertThat().body("data[2].name", equalTo("Best Buy For Business")).and().
                assertThat().body("data[2].createdAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[2].updatedAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[3].id", equalTo(4)).and().
                assertThat().body("data[3].name", equalTo("Apple Shop")).and().
                assertThat().body("data[3].createdAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[3].updatedAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[4].id", equalTo(5)).and().
                assertThat().body("data[4].name", equalTo("Hablamos Español")).and().
                assertThat().body("data[4].createdAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[4].updatedAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[5].id", equalTo(6)).and().
                assertThat().body("data[5].name", equalTo("Camera Experience Shop ")).and().
                assertThat().body("data[5].createdAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[5].updatedAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[6].id", equalTo(7)).and().
                assertThat().body("data[6].name", equalTo("Electronics Recycling")).and().
                assertThat().body("data[6].createdAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[6].updatedAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[7].id", equalTo(8)).and().
                assertThat().body("data[7].name", equalTo("Magnolia Home Theater")).and().
                assertThat().body("data[7].createdAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[7].updatedAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[8].id", equalTo(9)).and().
                assertThat().body("data[8].name", equalTo("Samsung Experience Shop")).and().
                assertThat().body("data[8].createdAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[8].updatedAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[9].id", equalTo(10)).and().
                assertThat().body("data[9].name", equalTo("Windows Store")).and().
                assertThat().body("data[9].createdAt", equalTo("2016-11-17T17:56:35.881Z")).and().
                assertThat().body("data[9].updatedAt", equalTo("2016-11-17T17:56:35.881Z"));
    }
    @Test
    public void Negative_GetData() {
        given().get("http://localhost:3030/service").then().assertThat().statusCode(404);
    }
    @Test
    public void Post_Services() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/services";
        Service stores = new Service();
        stores.setName("Ahmed Galal");

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
    public void Put_Services() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/services";
        Service stores = new Service();
        stores.setName("Ahmed Galal U");

        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(stores
                )
                .when()
                .put("/22");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void Negative_Put_Services() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/services";
        Service stores = new Service();
        stores.setName("Ahmed Galal U");

        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(stores
                )
                .when()
                .put("/22555555");
        response.then().statusCode(404);
        response.prettyPrint();
    }
    @Test
    public void Patch_Services() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/services";
        Service stores = new Service();
        stores.setName("Ahmed Galal U2");

        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(stores
                )
                .when()
                .patch("/22");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void Invalid_Patch_Services() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/services";
        Service stores = new Service();
        stores.setName("Ahmed Galal U2");

        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(stores
                )
                .when()
                .patch("/22888888");
        response.then().statusCode(404);
        response.prettyPrint();
    }
    @Test
    public void Delete_Data ()
    {
        when().delete("http://localhost:3030/services/5");
        given().get("http://localhost:3030/services/").then().assertThat().body("total", equalTo(20));
    }
}
