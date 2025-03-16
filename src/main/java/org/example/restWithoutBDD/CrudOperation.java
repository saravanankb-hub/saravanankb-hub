package org.example.restWithoutBDD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CrudOperation {

    private static final Logger log = LoggerFactory.getLogger(CrudOperation.class);
    int statusCode, id;

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    public void getData() {
        given().when().get("api/users?page=2").then().statusCode(200).log().all();
        given().contentType(ContentType.JSON).log();

    }

    @Test
    public void postData() {
        Map<String, Object> reqPayload = new HashMap<>();
        reqPayload.put("name", "Dane");
        reqPayload.put("job", "QA Automation");
        Response res = given().contentType(ContentType.JSON).body(reqPayload).when().post("api/users");
        System.out.println(res.then().log().all());
        statusCode = res.then().statusCode(201).extract().statusCode();
        id = res.then().statusCode(201).extract().jsonPath().getInt("id");//to print CreatedAt - use getString

        System.out.println("Status code: " + statusCode + "\nId: " + id);
    }

    @Test(dependsOnMethods = "postData")
    public void putData() {
        Map<String, Object> reqPayload = new HashMap<>();
        reqPayload.put("name", "Balaji");
        reqPayload.put("job", "Murugan");
        given().contentType(ContentType.JSON).body(reqPayload)
                .when().put("api/users/" + id)
                .then().statusCode(200).log().all();

        System.out.println("Id in put method: " + id);
    }

    @Test(dependsOnMethods = {"postData", "putData"})
    public void deleteData() {
        given().contentType(ContentType.JSON)
                .when().delete("api/users/" + id)
                .then().statusCode(204).log().all();
    }

}