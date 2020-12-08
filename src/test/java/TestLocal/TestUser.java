package TestLocal;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class TestUser {
    @Test
    public void getRequest(){
         baseURI = "http://localhost:3000";
        given()
                .get("/users")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void postRequest(){
        baseURI = "http://localhost:3000";
        JSONObject postBody = new JSONObject();

        postBody.put("firstName", "Tom");
        postBody.put("lastName", "Cruz");
        postBody.put("subjectId", 2);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(postBody.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log().all();

    }


    @Test
    public void patchRequest(){
        baseURI = "http://localhost:3000";

        JSONObject putRequest = new JSONObject();
        putRequest.put("firstName", "Jeff");
        putRequest.put("lastName", "Bezos");
        putRequest.put("subjectId", 2);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(putRequest.toJSONString())
                .when()
                .patch("/users/5")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void putRequest(){
        baseURI = "http://localhost:3000";

        JSONObject putRequest = new JSONObject();
        putRequest.put("firsName", "Melinda");
        putRequest.put("lastName", "Bezos");

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(putRequest.toJSONString())
                .when()
                .put("/users/4")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void deleteRequest(){
        baseURI = "http://localhost:3000";

        when()
                .delete("/users/4")
                .then()
                .statusCode(200)
                .log().all();

    }
}
