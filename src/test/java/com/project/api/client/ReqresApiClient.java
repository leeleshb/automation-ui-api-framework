package com.project.api.client;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import com.project.api.config.ConfigReader;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReqresApiClient {

	public Response registerUser(String email, String password) {

        Map<String, String> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);

        return given()
                .header("x-api-key", ConfigReader.get("api.key"))
                .contentType("application/json")
                .body(body)
        .when()
                .post(ConfigReader.get("register.endpoint"));
    }

    public Response getUserById(int userId, String token) {

        String endpoint = ConfigReader.get("get.user.endpoint")
                .replace("{id}", String.valueOf(userId));

        return given()
                .header("Authorization", "Bearer " + token)
        .when()
                .get(endpoint);
    }
	
}
