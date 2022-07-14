import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class healthcheck {
    @Test
    public void Validate_ResponseStatus ()
    {
        Response Status_Response = RestAssured.get("http://localhost:3030/healthcheck");
        Assert.assertEquals(Status_Response.statusCode(),200);
    }
    @Test
    public void ResponseStatus_wrongURL ()
    {
        Response Status_Response = RestAssured.get("http://localhost:3030/healthchecks");
        Assert.assertEquals(Status_Response.statusCode(),404);
    }
    @Test
    public void Validate_GetData() {
        given().get("http://localhost:3030/healthcheck").then().
                assertThat().body("readonly", equalTo(false)).and().
                assertThat().body("documents.products", equalTo(7)).and().
                assertThat().body("documents.stores", equalTo(1562)).and().
                assertThat().body("documents.categories", equalTo(4306));

    }
    @Test
    public void Negative_GetData() {
        given().get("http://localhost:3030/healthchecks").then().
                assertThat().statusCode(404);

    }

}
