package com.requestHandler;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import org.apache.http.HttpStatus;
import org.junit.Test;
import com.DataManager;
import com.sun.org.glassfish.gmbal.Description;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DoRequest extends PrepareToRequest
{
    @Test
    @Description("Search movie for taken imdb id")
    public void testImdbID()
    {
        searchWithID(getSpesificFilmID(1));
    }

    @Description("Get movie in chosen index")
    public String getSpesificFilmID(int filmIndex)
    {
        Response response = requestDataSearch(searchData).when().get(baseURI).then().extract().response();
        String findFilm = new StringBuilder().append("Search[").append(filmIndex).append("].imdbID").toString();
        return response.jsonPath().getString(findFilm);
    }

    @Description("")
    private void searchWithID(String imdbID)
    {
        requestDataID(imdbID).when().get(baseURI).then()
                .statusCode(HttpStatus.SC_OK).and()
                .body("Title", equalTo("Harry Potter and the Sorcerer's Stone")).and()
                .body("Year",equalTo("2001")).and()
                .body("Released",equalTo("16 Nov 2001"));
    }

    @Description("initialize request body with search")
    private RequestSpecification requestDataSearch(String searchData)
    {
        requestSpecification = given().
                param(DataManager.API_KEY.getData(), "5343c842").
                param(DataManager.FILM_NAME.getData(), searchData).
                param(DataManager.TYPE.getData(), "movie").
                param(DataManager.YEAR.getData(), "").
                param(DataManager.DATA_TYPE.getData(), "json").
                param(DataManager.PAGE.getData(), "1").
                param(DataManager.CALLBACK.getData(), "").
                param(DataManager.APIVERSION.getData(), "1");
        return requestSpecification;
    }

    @Description("initialize request body with id")
    public RequestSpecification requestDataID(String id)
    {
        requestSpecification = given().
                param(DataManager.API_KEY.getData(), "5343c842").
                param(DataManager.ID.getData(), id).
                param(DataManager.TITLE.getData(), "").
                param(DataManager.TYPE.getData(), "").
                param(DataManager.YEAR.getData(), "").
                param(DataManager.PLOT.getData(), "short").
                param(DataManager.DATA_TYPE.getData(), "json").
                param(DataManager.CALLBACK.getData(), "").
                param(DataManager.APIVERSION.getData(), "1");
        return requestSpecification;
    }


}