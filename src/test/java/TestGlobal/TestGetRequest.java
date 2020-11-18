package TestGlobal;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class TestGetRequest {
    @Test
    public void test_01(){
        String url = "https://reqres.in/api/users?page=2";
        given().
                get(url)
                .then().statusCode(200)
                .body("data.id[1]", equalTo(8))
                .body("data.first_name", hasItems("Michael", "Lindsay"))
                .log();
                //header("Content-type", "application/json")
                //.param("key", "value").  - as per requirement we can add

    }

}
