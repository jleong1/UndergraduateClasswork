package com.example.julieleong.codingchallenge;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Julie Leong on 2/15/2015.
 */
public class ContactParse {

    private String name;
    private String employee;
    private String detailsURL;
    private String smallImageURL;
    private String birthdate;
    private String work;
    private String mobile;
    private String home;

    @JsonProperty("name")
    public String getName(){
        return name;
    }

    @JsonProperty("employee")
    public String   getEmployee(){
        return employee;
    }

    @JsonProperty("detailsURL")
    public String   getDetailsURL(){
        return detailsURL;
    }

    @JsonProperty("smallImageUrl")
    public String   getSmallImageURL(){
        return smallImageURL;
    }

    @JsonProperty("birthdate")
    public String   getBirthdate(){
        return birthdate;
    }

    @JsonProperty("work")
    public String   getWork(){
        return work;
    }

    @JsonProperty("mobile")
    public String   getMobile(){
        return mobile;
    }

    @JsonProperty("home")
    public String   getHome(){
        return employee;
    }

}