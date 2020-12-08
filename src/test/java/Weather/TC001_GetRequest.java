package Weather;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
public class TC001_GetRequest {


    @Test
    public void getWeatherDetails(){
        RestAssured.baseURI = "http://localhost:3000";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET, "/users");
        String responseBody = response.getBody().asString();
        System.out.println("Response body: " + responseBody);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Code mismatch");
    }


}
