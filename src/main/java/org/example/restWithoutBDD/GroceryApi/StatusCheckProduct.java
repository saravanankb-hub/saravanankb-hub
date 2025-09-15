package org.example.restWithoutBDD.GroceryApi;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class StatusCheckProduct extends ReqResConfig {
    int productId;
    String productName, cartId;


    @Test
    public void validateStatus() {
        ResponseBody body = given().spec(requestSpecification)
                .when().get("status")
                .then().spec(responseSpecification)
                .statusCode(200)
                .and().extract().response().getBody();
        JsonPath jsonPath = body.jsonPath();
        jsonPath.prettyPrint();
    }

    @Test(priority = 1)
    public void getNProducts() {
        ResponseBody body = given().spec(requestSpecification)
                .when().get("products")
                .then().spec(responseSpecification)
                .statusCode(200).body("id", hasSize(20))
                .and().extract().response().getBody();
        JsonPath jsonPath = body.jsonPath();
        productId = jsonPath.getInt("id[8]");

        System.out.println("Product ID: " + productId);

        List<Boolean> inStockList = jsonPath.getList("inStock");
        long inStockCount = inStockList.stream().filter(inStock -> inStock).count();

        System.out.println("Count of inStock products that are true: " + inStockCount);
        jsonPath.prettyPrint();
    }

    @Test(priority = 2, dependsOnMethods = "getNProducts")
    public void validateProductDetails() {
        Product product = given().spec(requestSpecification)
                .pathParams("id", productId)
                .when().get("/products/{id}")
                .then().spec(responseSpecification)
                .statusCode(200)
                .extract().as(Product.class);

        // Now validate fields
        System.out.println("Product Name: " + product.getName());
        System.out.println("Product Category: " + product.getCategory());

        Assert.assertEquals(product.getId(), productId, "Product id Mismatch");
        Assert.assertEquals(product.getCategory(), "coffee", "Category is Mismatch");
        Assert.assertTrue(product.isInStock(), "Product should be in Stock");
        Assert.assertNotNull(product.getName(), "Product name should not be null");
        Assert.assertEquals(product.getManufacturer(), "Starbucks", "Product Manufacturer should not be null");
        Assert.assertEquals(product.getPrice() == 40.91, "Product Price is costly");
        Assert.assertTrue(product.getCurrentStock() == 14, "Product current in-stock is less");
//negative
        Assert.assertTrue(product.getPrice() > 100, "Product Price is costly");
        Assert.assertTrue(product.getCurrentStock() > 15, "Product current in-stock is less");
    }

    @Test(priority = 2)
    public void getSingleProd() {
        ResponseBody body = given().spec(requestSpecification).pathParams("productId", productId)
                .when().get("/products/{productId}")
                .then().spec(responseSpecification).statusCode(200)
                .body("name", containsString("Starbucks Coffee Variety Pack, 100% Arabica"))//use equalTo also.
                .body("id", is(productId))
                .and().extract().response().getBody();
        JsonPath jsonPath = body.jsonPath();
        productName = jsonPath.getString("name");
        System.out.println("Product Name: " + productName);
    }

    @Test(priority = 3)
    public void createCart() {
        ResponseBody res = given().spec(requestSpecification)
                .when().post("/carts")
                .then().spec(responseSpecification).statusCode(201)
                .body("created", equalTo(true))
                .and().extract().response().body();
        JsonPath jsonPath = res.jsonPath();
        cartId = jsonPath.getString("cartId");
        System.out.println("Cart created: " + jsonPath.getBoolean("created")
                + "\nCart id: " + cartId);
    }

    @Test(priority = 4)
    public void getCartSingleItem() {

        ResponseBody res = given().spec(requestSpecification)
                .pathParams("cartId", cartId)
                .when().get("carts/{cartId}")
                .then().spec(responseSpecification).statusCode(200)
                .and().extract().response().getBody();
    }

    @Test(priority = 5)
    public void addItemToCart() {
        Map<String, Object> reqPayload = new HashMap<>();
        reqPayload.put("productId", productId);
        reqPayload.put("quantity", 2);
        ResponseBody res = given().spec(requestSpecification)
                .pathParams("cartId", cartId).body(reqPayload)
                .when().post("carts/{cartId}/items")
                .then().spec(responseSpecification).statusCode(201)
                .and().extract().response().body();
        res.prettyPrint();
    }

    @Test(dependsOnMethods = "addItemToCart")
    public void getCartItems() {
        ResponseBody res = given().spec(requestSpecification)
                .pathParams("cartId", cartId)
                .when().get("carts/{cartId}/items")
                .then().spec(responseSpecification).statusCode(200)
                .and().extract().response().body();
        res.prettyPrint();
    }

    @BeforeMethod
    public void setUp() {
        // Example of setting up or resetting the productId before each test if needed
        // Or fetch productId dynamically here
        if (productId == 0) {
            // Fetch the productId only if it's not set
            ResponseBody body = given().spec(requestSpecification)
                    .when().get("products")
                    .then().spec(responseSpecification)
                    .statusCode(200).extract().response().getBody();
            JsonPath jsonPath = body.jsonPath();
            productId = jsonPath.getInt("id[1]");
            System.out.println("Setup Product ID: " + productId);
        }
    }
}