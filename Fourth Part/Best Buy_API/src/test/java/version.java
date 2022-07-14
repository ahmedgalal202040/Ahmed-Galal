import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class version {

    @Test
    public void Validate_ResponseStatus ()
    {
        Response Status_Response = RestAssured.get("http://localhost:3030/version");
        Assert.assertEquals(Status_Response.statusCode(),200);
    }
    @Test
    public void ResponseStatus_wrongURL ()
    {
        Response Status_Response = RestAssured.get("http://localhost:3030/versions");
        Assert.assertEquals(Status_Response.statusCode(),404);
    }
    @Test
    public void Validate_GetData() {
        given().get("http://localhost:3030/version/").then().assertThat().body("version", equalTo("1.1.0"));
    }
    @Test
    public void Invalid_GetData() {
        given().get("http://localhost:3030/versions/").then().assertThat().statusCode(404);
    }

}