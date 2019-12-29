package com.requestHandler;


import static io.restassured.RestAssured.given;

import org.junit.After;
import org.junit.Before;

import com.DataManager;
import com.sun.org.glassfish.gmbal.Description;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class PrepareToRequest
{
    RequestSpecification requestSpecification;
    public String searchData;

    @Before
    public void setUp() throws Exception
    {
        init();
    }

    private void init() throws Exception
    {
        RestAssured.baseURI="http://www.omdbapi.com/";
        searchData="Harry Potter";
    }


    @After
    public void tearDown()
    {

    }

}
