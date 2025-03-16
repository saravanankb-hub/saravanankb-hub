package org.example.restWithoutBDD;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GetData {

    @Test
    public void testGetMtd() {
        Response res = RestAssured.get("https://reqres.in/api/users/3");

        res.body().prettyPrint();
        assertEquals(res.getStatusCode(), 200);
        assertEquals(getString(res, "data.first_name"), "Emma");
        assertEquals(getString(res, "data.last_name"), "Wong");
        assertEquals(getString(res, "data.email"), "emma.wong@reqres.in");
        assertEquals(getString(res, "data.avatar"), "https://reqres.in/img/faces/3-image.jpg");
        assertEquals(getInt(res, "data.id"), "3");
        String urlFromRes = getString(res, "support.url");
        System.out.println(urlFromRes);
        assertEquals(urlFromRes, "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral");
//        assertEquals(res.getHeaders().getValue("Host")," ");
    }

    private static String getString(Response res, String str) {
        return res.jsonPath().getString(str);
    }

    private static String getInt(Response res, String str) {
        return res.jsonPath().getString(str);
    }
}