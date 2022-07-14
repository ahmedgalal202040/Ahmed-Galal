import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.specification.RequestSpecification;

public class Products {
    RequestSpecification httpRequest;
    @Test
    public void Validate_ResponseStatus ()
    {
        Response Status_Response = RestAssured.get("http://localhost:3030/products");
        Assert.assertEquals(Status_Response.statusCode(),200);
    }
    @Test
    public void ResponseStatus_wrongURL ()
    {
        Response Status_Response = RestAssured.get("http://localhost:3030/productss");
        Assert.assertEquals(Status_Response.statusCode(),404);
    }
    @Test
    public void Positive_GetData ()
    {
        given().get("http://localhost:3030/products").then().assertThat().body("data[0].id", equalTo( 9999682)).and().
                assertThat().body("data[0].'name'", equalTo("Ahmed Galal")).and().
                assertThat().body("data[0].'type'", equalTo("HardGood")).and().
                assertThat().body("data[0].price", equalTo(5)).and().
                assertThat().body("data[0].'upc'", equalTo("041333424019")).and().
                assertThat().body("data[0].'shipping'", equalTo(0)).and().
                assertThat().body("data[0].'description'", equalTo("Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack")).and().
                assertThat().body("data[0].'manufacturer'", equalTo("Duracell")).and().
                assertThat().body("data[0].'model'", equalTo("MN2400B4Z")).and().
                assertThat().body("data[0].'url'", equalTo("http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC")).and().
                assertThat().body("data[0].'image'", equalTo("http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg")).and().
                assertThat().body("data[0].'createdAt'", equalTo("2022-07-14T10:54:53.017Z")).and().
                assertThat().body("data[0].'updatedAt'", equalTo("2022-07-14T10:54:53.017Z"));
    }
    @Test
    public void NegativeGetData ()
    {
        //trying to get data from wrong URL
        given().get("http://localhost:3030/product").then().assertThat().statusCode(404);
    }
    public void Negative_GetData ()
    {
        given().get("http://localhost:3030/products").then().assertThat().body("data[0].id", equalTo( 43900)).and().
                assertThat().body("data[0].'name'", equalTo("Duracell - AAA Batteries (4-Pack)")).and().
                assertThat().body("data[0].'type'", equalTo("HardGood")).and().
                assertThat().body("data[0].price", equalTo(5.49F)).and().
                assertThat().body("data[0].'upc'", equalTo("041333424019")).and().
                assertThat().body("data[0].'shipping'", equalTo(0)).and().
                assertThat().body("data[0].'description'", equalTo("Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack")).and().
                assertThat().body("data[0].'manufacturer'", equalTo("Duracell")).and().
                assertThat().body("data[0].'model'", equalTo("MN2400B4Z")).and().
                assertThat().body("data[0].'url'", equalTo("http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC")).and().
                assertThat().body("data[0].'image'", equalTo("http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg")).and().
                assertThat().body("data[0].'createdAt'", equalTo("2016-11-17T17:58:03.298Z")).and().
                assertThat().body("data[0].'updatedAt'", equalTo("2016-11-17T17:58:03.298Z")).and().
                assertThat().body("data[0].categories[0].id", equalTo("abcat0208002")).and().
                assertThat().body("data[0].categories[0].'name'", equalTo("Alkaline Batteries")).and().
                assertThat().body("data[0].categories[0].'updatedAt'", equalTo("2016-11-17T17:57:04.285Z")).and().
                assertThat().body("data[0].categories[0].'createdAt'", equalTo("2016-11-17T17:57:04.285Z")).and().
                assertThat().body("data[0].categories[1].id", equalTo("pcmcat248700050021")).and().
                assertThat().body("data[0].categories[1].'name'", equalTo("Housewares")).and().
                assertThat().body("data[0].categories[1].'updatedAt'", equalTo("2016-11-17T17:57:05.399Z")).and().
                assertThat().body("data[0].categories[1].'createdAt'", equalTo("2016-11-17T17:57:05.399Z")).and().
                assertThat().body("data[0].categories[2].id", equalTo("pcmcat303600050001")).and().
                assertThat().body("data[0].categories[2].'name'", equalTo("Household Batteries")).and().
                assertThat().body("data[0].categories[2].'updatedAt'", equalTo("2016-11-17T17:57:04.285Z")).and().
                assertThat().body("data[0].categories[2].'createdAt'", equalTo("2016-11-17T17:57:04.285Z")).and().
                assertThat().body("data[0].categories[3].id", equalTo("pcmcat312300050015")).and().
                assertThat().body("data[0].categories[3].'name'", equalTo("Connected Home & Housewares")).and().
                assertThat().body("data[0].categories[3].'updatedAt'", equalTo("2016-11-17T17:57:04.285Z")).and().
                assertThat().body("data[0].categories[3].'createdAt'", equalTo("2016-11-17T17:57:04.285Z"));
    }

    @Test
    public void Post_product() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/products";
        Product products = new Product();
        products.setName("Duracell - AAA Batteries (4-Pack)");
        products.setType("HardGood");
        products.setPrice(5);
        products.setUpc("041333424019");
        products.setShipping(0);
        products.setDescription("Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack");
        products.setManufacturer("Duracell");
        products.setModel("MN2400B4Z");
        products.setUrl("http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC");
        products.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(products)
                .when()
                .post();
        // check that the product added according to Status Code 201 (created)
        response.then().statusCode(201);
        response.prettyPrint();
    }
    @Test
    public void Put_product() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/products";
        Product products = new Product();
        products.setName("Ahmed Galal U");
        products.setType("HardGood U");
        products.setPrice(500);
        products.setUpc("041333424019");
        products.setShipping(0);
        products.setDescription("Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack");
        products.setManufacturer("Duracell");
        products.setModel("MN2400B4Z");
        products.setUrl("http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC");
        products.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(products)
                .when()
                .put("/9999684");
        // check on status code and print result after updating
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void Negative_Put_product() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/products";
        Product products = new Product();
        products.setName("Ahmed Galal U");
        products.setType("HardGood U");
        products.setPrice(500);
        products.setUpc("041333424019");
        products.setShipping(0);
        products.setDescription("Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack");
        products.setManufacturer("Duracell");
        products.setModel("MN2400B4Z");
        products.setUrl("http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC");
        products.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(products)
                .when()
                // check on updating response when the Product id doesn't exist
                .put("/999968199");
        response.then().statusCode(404);
        response.prettyPrint();
    }
    @Test
    public void Patch_product() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/products";
        Product products = new Product();
        // select only data need to updated
        products.setName("Ahmed Galal U 2");
        products.setType("HardGood U 2");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(products)
                .when()
                .patch("/9999684");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void Negative_Patch_product() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/products";
        Product products = new Product();
        products.setName("Ahmed Galal U 2");
        products.setType("HardGood U 2");

        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(products)
                .when()
                // check on patch response when the Product id doesn't exist
                .patch("/9999684999");
        response.then().statusCode(404);
        response.prettyPrint();
    }
    @Test
    public void Delete_Data ()
    {
     when().delete("http://localhost:3030/products/9999689").then().statusCode(200);
    }

}
