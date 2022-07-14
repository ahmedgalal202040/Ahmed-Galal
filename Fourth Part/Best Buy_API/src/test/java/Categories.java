import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class Categories {
    @Test
    public void Validate_ResponseStatus()
    {
        Response Status_Response = RestAssured.get("http://localhost:3030/categories/");
        Assert.assertEquals(Status_Response.statusCode(),200);
    }
    @Test
    public void Validate_ResponseStatuswithwrongURL ()
    {
        Response Status_Response = RestAssured.get("http://localhost:3030/categories/10");
        Assert.assertEquals(Status_Response.statusCode(),404);
    }
    @Test
    public void Validate_GetData ()
    {
        given().get("http://localhost:3030/categories/").then().assertThat().body("data[0].id", equalTo("abcat0010000")).and().
                assertThat().body("data[0].'createdAt'", equalTo("2016-11-17T17:57:04.285Z")).and().
                assertThat().body("data[0].'updatedAt'", equalTo("2016-11-17T17:57:04.285Z")).and().
                assertThat().body("data[0].subCategories[0].id", equalTo("abcat0020004")).and().
                assertThat().body("data[0].subCategories[0].'name'", equalTo("Unique Gifts")).and().
                assertThat().body("data[0].subCategories[0].'createdAt'", equalTo("2016-11-17T17:57:04.285Z")).and().
                assertThat().body("data[0].subCategories[0].'updatedAt'", equalTo("2016-11-17T17:57:04.285Z")).and().
                assertThat().body("data[0].subCategories[1].id", equalTo("pcmcat748300579354")).and().
                assertThat().body("data[0].subCategories[1].'name'", equalTo("Family Gift Ideas")).and().
                assertThat().body("data[0].subCategories[1].'createdAt'", equalTo("2016-11-17T17:57:04.899Z")).and().
                assertThat().body("data[0].subCategories[1].'updatedAt'", equalTo("2016-11-17T17:57:04.899Z")).and().
                assertThat().body("data[0].subCategories[2].id", equalTo("pcmcat748301108075")).and().
                assertThat().body("data[0].subCategories[2].'name'", equalTo("Stocking Stuffers")).and().
                assertThat().body("data[0].subCategories[2].'createdAt'", equalTo("2016-11-17T17:57:04.899Z")).and().
                assertThat().body("data[0].subCategories[2].'updatedAt'", equalTo("2016-11-17T17:57:04.899Z")).and().
                assertThat().body("data[0].subCategories[3].id", equalTo("pcmcat84000050000")).and().
                assertThat().body("data[0].subCategories[3].'name'", equalTo("Weddings")).and().
                assertThat().body("data[0].subCategories[3].'createdAt'", equalTo("2016-11-17T17:57:05.399Z")).and().
                assertThat().body("data[0].subCategories[3].'updatedAt'", equalTo("2016-11-17T17:57:05.399Z")).and().
                assertThat().body("data[0].subCategories[4].id", equalTo("pcmcat84000050001")).and().
                assertThat().body("data[0].subCategories[4].'name'", equalTo("Anniversaries")).and().
                assertThat().body("data[0].subCategories[4].'createdAt'", equalTo("2016-11-17T17:57:05.399Z")).and().
                assertThat().body("data[0].subCategories[4].'updatedAt'", equalTo("2016-11-17T17:57:05.399Z")).and().
                assertThat().body("data[0].subCategories[5].id", equalTo("pcmcat84000050002")).and().
                assertThat().body("data[0].subCategories[5].'name'", equalTo("Business Gifts")).and().
                assertThat().body("data[0].subCategories[5].'createdAt'", equalTo("2016-11-17T17:57:05.399Z")).and().
                assertThat().body("data[0].subCategories[5].'updatedAt'", equalTo("2016-11-17T17:57:05.399Z")).and().
                assertThat().body("data[0].subCategories[6].id", equalTo("pcmcat84000050004")).and().
                assertThat().body("data[0].subCategories[6].'name'", equalTo("Baby Showers")).and().
                assertThat().body("data[0].subCategories[6].'createdAt'", equalTo("2016-11-17T17:57:05.399Z")).and().
                assertThat().body("data[0].subCategories[6].'updatedAt'", equalTo("2016-11-17T17:57:05.399Z")).and().
                assertThat().body("data[0].subCategories[7].id", equalTo("pcmcat94300050028")).and().
                assertThat().body("data[0].subCategories[7].'name'", equalTo("Birthdays")).and().
                assertThat().body("data[0].subCategories[7].'createdAt'", equalTo("2016-11-17T17:57:05.399Z")).and().
                assertThat().body("data[0].subCategories[7].'updatedAt'", equalTo("2016-11-17T17:57:05.399Z")).and().
                assertThat().body("data[0].categoryPath[0].id", equalTo("abcat0010000")).and().
                assertThat().body("data[0].categoryPath[0].'name'", equalTo("Gift Ideas")).and().
                assertThat().body("data[0].categoryPath[0].'createdAt'", equalTo("2016-11-17T17:57:04.285Z")).and().
                assertThat().body("data[0].categoryPath[0].'updatedAt'", equalTo("2016-11-17T17:57:04.285Z"));
    }

    @Test
    public void Post_Categories() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/categories";
        Category categories = new Category();
        categories.setName("Ahmed Galal");
        categories.setID("AG01009434961");
        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(categories)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
    public void Put_categories() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/categories";
        Category categories = new Category();
        categories.setName("Ahmed Galal U");
        categories.setID("AhmedG01009434961");
        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(categories)
                .when()
                .put("/AG01009434961");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void Negative_Put_categories() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/categories";
        Category categories = new Category();
        categories.setName("Ahmed Galal U");
        categories.setID("AhmedG01009434961");
        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(categories)
                .when()
                .put("/AG01009434961iiii");
        response.then().statusCode(404);
        response.prettyPrint();
    }
    @Test
    public void Patch_categories() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/categories";
        Category categories = new Category();
        categories.setName("Ahmed Galal U2");
        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(categories)
                .when()
                .patch("/AG01009434961");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void Negative_Patch_categories() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/categories";
        Category categories = new Category();
        categories.setName("Ahmed Galal U");
        categories.setID("AhmedG01009434961");
        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(categories)
                .when()
                .patch("/AG01009434961888");
        response.then().statusCode(404);
        response.prettyPrint();
    }
    @Test
    public void Delete_Data ()
    {
        when().delete("http://localhost:3030/categories/abcat0102005");
        given().get("http://localhost:3030/categories/").then().assertThat().body("total", equalTo(4305));
    }


    }
