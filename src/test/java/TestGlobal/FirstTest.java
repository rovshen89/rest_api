package TestGlobal;

import com.sun.source.tree.AssertTree;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class FirstTest {

    @Test
    public void getRequest(){
        String url = "https://reqres.in/api/users?page=2";

        Response response = get(url);
        Assert.assertEquals(response.getStatusCode(), 200, "Response code mismatch");

        int total_pages = response.jsonPath().get("total_pages");
        Assert.assertEquals(total_pages, 2, "total_pages value mismatch");
        String body = response.getBody().asString();
        System.out.println(body);
        System.out.println(response.getStatusCode());

    }

    @Test
    public void postRequest(){
        String url = "https://reqres.in/api/users";
        String contentType = "application/json";
        String bodyData = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        Response response = given().
                contentType(contentType).
                body(bodyData).
                when().
                post(url).
                then().
                extract().
                response();

        Assert.assertEquals(response.getStatusCode(), 201 , "Response code mismatch");

        String name = response.jsonPath().get("name");
        Assert.assertEquals(name, "morpheus", "name value mismatch");

    }

    @Test
    public void directPrint(){
        given().get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).body("data.id[0]", equalTo(7));
    }


}
