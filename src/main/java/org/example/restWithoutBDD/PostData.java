package org.example.restWithoutBDD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostData {
    int id;

    @BeforeTest
    public void baseUri() {
        RestAssured.baseURI = "https://fakerestapi.azurewebsites.net/api/v1";
    }

    @Test
    public void postMtd() {
        HashMap<String, Object> reqPayload = new HashMap<>();
        reqPayload.put("id", 3);
        reqPayload.put("title", "sarav");
        reqPayload.put("dueDate", "2025-02-27");
        reqPayload.put("completed", true);
        Response res = given().contentType(ContentType.JSON).body(reqPayload).when().post("/Activities");
        res.body().prettyPrint();
        id = res.then().statusCode(200).extract().jsonPath().getInt("id");
    }

    @Test(dependsOnMethods = "postMtd")
    public void pathParamMtd() {
        Response res = given().when().get("/Activities/" + id);
        System.out.println(id);
        res.prettyPrint();
    }
}