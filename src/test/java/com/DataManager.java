package com;

public enum DataManager
{
    API_KEY("apikey"),
    FILM_NAME("s"),
    TYPE("type"),
    YEAR("y"),
    PLOT("plot"),
    DATA_TYPE("r"),
    CALLBACK("callback"),
    APIVERSION("v"),
    PAGE("page"),
    ID("i"),
    TITLE("t");

    private String data;

    DataManager(String data)
    {
        this.data = data;
    }

    public String getData()
    {
        return data;
    }
}
