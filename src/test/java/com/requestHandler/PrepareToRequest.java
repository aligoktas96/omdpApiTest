package com.requestHandler;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import org.junit.After;
import org.junit.Before;

public class PrepareToRequest
{

    Response responseBody;
    String responseText;
    String imdbID;
    RequestSpecification requestSpecification;

    @Before
    public void setUp() throws Exception
    {
        init();
    }

    private void init() throws Exception
    {
        RestAssured.baseURI = "http://www.omdbapi.com/";
    }

    @After
    public void tearDown()
    {

    }

}
