package com.automation.escuela.base;

import groovy.beans.ListenerList;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    RequestSpecification requestSpecification;
    private static final String BASE_URI = "https://api.escuelajs.co/api/v1";

    public BaseService() {
        this.requestSpecification = RestAssured.given()
                .baseUri(BASE_URI);
    }

    public void setAuthToken(String token) {
        requestSpecification
                .header("Authorization", "Bearer " + token);
    }

    public Response postRequest(String endpoint, Object payload) {
                return requestSpecification
                        .contentType(ContentType.JSON)
                        .body(payload)
                        .post(endpoint);
    }

    public Response getRequest(String endpoint) {
        return requestSpecification
                .get(endpoint);
    }


}
