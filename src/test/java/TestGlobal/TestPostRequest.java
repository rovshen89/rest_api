package TestGlobal;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class TestPostRequest {
    @Test
    public void test_01(){

        /*
        * Use Maps to create a body of JSON. use key value pair*/

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Rovshen");
        map.put("job", "Tester");
        System.out.println(map);

        JSONObject requestPost = new JSONObject(map);
        //If you dont want to pass object, simpy use requestPost as a map
        //requestPost.put("name", "Rovshen");
        //requestPost.put("job", "Tester");

        System.out.println(requestPost);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(requestPost.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().statusCode(201)
                .log().all();

    }


    @Test
    public void test_02_put(){

        JSONObject requestPut = new JSONObject();

        requestPut.put("name", "Tester");
        requestPut.put("job", "Rovshen");

        given().
                body(requestPut.toJSONString()).
                when().
                put("https://reqres.in/api/users/2").then()
                .statusCode(200)
                .log().all();


    }
    @Test
    public void test_03_Patch(){

        JSONObject requestPatch = new JSONObject();
        requestPatch.put("name", "JasonBond");
        requestPatch.put("job", "Killer");


        given().
                body(requestPatch.toJSONString())
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void test_04_Delete9(){

        given()
                .delete("https://reqres.in/api/users")
                .then()
                .statusCode(204)
                .log().all();

    }

}
