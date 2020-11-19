package DataTest;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.*;


public class DataDrivenTest extends DataProvider {



    @Test(dataProvider = "DataForPost")
    public void postRequest(String firstName, String lastName, int subjectId){

        baseURI = "http://localhost:3000";

        JSONObject postRequest = new JSONObject();

        postRequest.put("firstName", firstName);
        postRequest.put("lastName", lastName);
        postRequest.put("subjectId", subjectId);


        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(postRequest.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log().all();
    }


    @Test(dataProvider = "DataForDelete")
    public void deleteRequest(int userId){
        baseURI = "http://localhost:3000";

        when()
                .delete("/users/" + userId)
                .then()
                .statusCode(200);

    }
}
