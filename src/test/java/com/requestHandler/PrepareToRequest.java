package com.requestHandler;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import javafx.scene.chart.PieChart.Data;

import static io.restassured.RestAssured.given;

import org.junit.After;
import org.junit.Before;

import com.DataManager;

public class PrepareToRequest
{
    RequestSpecification requestSpecification;

    @Before
    public void setUp() throws Exception
    {
        init();
    }

    private void init() throws Exception
    {
    }

    @After
    public void tearDown()
    {

    }

}
