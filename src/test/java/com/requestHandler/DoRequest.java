package com.requestHandler;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.org.glassfish.gmbal.Description;

public class DoRequest extends PrepareToRequest
{

    @Before
    public void before()
    {


    }

    @Test
    @Description("")
    public void testImdbID()
    {
        searchWithID(getSpesificFilmID(1));
    }

    @Description("")
    public String getSpesificFilmID(int filmIndex)
    {
        Response response = requestDataSearch().when().get(baseURI).then().extract().response();
        String findFilm = new StringBuilder().append("Search[").append(filmIndex).append("].imdbID").toString();
        return response.jsonPath().getString(findFilm);
    }

    @Description("")
    private void searchWithID(String imdbID)
    {
        requestDataID(imdbID).when().get(baseURI).then()
                .statusCode(200).and().body("artists.items.name",notEqual(true));
    }

    @Description("")
    private RequestSpecification requestDataSearch()
    {
        requestSpecification = given().
                param("apikey", "5343c842").
                param("s", "Harry Potter").
                param("type", "movie").
                param("y", "").
                param("r", "json").
                param("page", "1").
                param("callback", "").
                param("v", "1");
        return requestSpecification;
    }

    @Description("")
    private RequestSpecification requestDataID(String id)
    {
        requestSpecification = given().
                param("apikey", "5343c842").
                param("i", id).
                param("t", "").
                param("type", "").
                param("y", "").
                param("plot", "short").
                param("r", "json").
                param("callback", "").
                param("v", "1");
        return requestSpecification;
    }


}