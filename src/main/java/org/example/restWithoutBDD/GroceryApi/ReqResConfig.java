package org.example.restWithoutBDD.GroceryApi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class ReqResConfig {

    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;

    @BeforeClass
    public void reqResSpecBuilder() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://simple-grocery-store-api.glitch.me/")
                .setContentType("application/json\r\n").build();
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(anyOf(is(200), is(201), is(204)))
                .expectContentType(ContentType.JSON).build();
    }
}