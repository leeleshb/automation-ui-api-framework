package com.project.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.api.base.BaseTest;
import com.project.api.client.ReqresApiClient;
import com.project.api.config.TestDataReader;

import io.restassured.response.Response;

public class ReqresApiTest extends BaseTest{

	ReqresApiClient apiClient = new ReqresApiClient();
    private static String token;

    @Test(priority = 1)
    public void testRegisterAndGenerateToken() {

        Response response = apiClient.registerUser(
                TestDataReader.get("register.email"),
                TestDataReader.get("register.password")
        );
        Assert.assertEquals(response.getStatusCode(), 200);

        token = response.jsonPath().getString("token");
        Assert.assertNotNull(token, "Token is null");
    }

    @Test(priority = 2, dependsOnMethods = "testRegisterAndGenerateToken")
    public void testGetUserWithToken() {

        Response response = apiClient.getUserById(
                Integer.parseInt(TestDataReader.get("user.id")),
                token
        );

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("data.id"), 2);
        Assert.assertTrue(response.jsonPath().getString("data.email")
                .contains("reqres.in"));
    }
}
