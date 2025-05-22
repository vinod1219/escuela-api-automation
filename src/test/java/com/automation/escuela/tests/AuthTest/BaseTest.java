package com.automation.escuela.tests.AuthTest;

import com.automation.escuela.base.AuthService;
import com.automation.escuela.models.request.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.io.InputStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners({com.automation.escuela.listeners.TestListener.class})
public class BaseTest extends AuthService {
    public static String access_token;
    public static String refresh_token;
    protected Response response;

    @BeforeSuite(description = "Login Test with valid credentials", alwaysRun = true)
    public void loginTest() throws IOException {
        //Response response = login("maria@mail.com", "12345");

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("data/jsonfiles/Login.json");

        // Deserialize the JSON file to LoginRequest
        ObjectMapper objectMapper = new ObjectMapper();
        LoginRequest loginRequest = objectMapper.readValue(inputStream, LoginRequest.class);

        // Create an instance of AuthService
        response = login(loginRequest.getEmail(), loginRequest.getPassword());

        assertEquals(response.getStatusCode(), 201, "Status code is not 201");
        assertTrue(response.jsonPath().getString("access_token") !=null, "Access token is null");
        access_token = response.jsonPath().getString("access_token");
        refresh_token = response.jsonPath().getString("refresh_token");
        System.out.println("Login Response: " + response.asPrettyString());
    }
}
