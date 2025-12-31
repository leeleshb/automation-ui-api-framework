package com.project.api.base;

import org.testng.annotations.BeforeClass;

import com.project.api.config.ConfigReader;

import io.restassured.RestAssured;

public class BaseTest {

	@BeforeClass
    public void setupApi() {
        RestAssured.baseURI = ConfigReader.get("base.api.url");
    }

}
