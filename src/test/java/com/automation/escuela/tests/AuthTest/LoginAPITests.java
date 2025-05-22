package com.automation.escuela.tests.AuthTest;

import static org.testng.Assert.*;

import com.automation.escuela.models.response.ProfileResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStream;

@Listeners({com.automation.escuela.listeners.TestListener.class})
public class LoginAPITests extends BaseTest{

    protected Response response;

   @Test(description = "Profile Test")
   public void profileTest() throws IOException {

      // Load the JSON file from resources
      ClassLoader classLoader = getClass().getClassLoader();
      InputStream inputStream = classLoader.getResourceAsStream("data/jsonfiles/Profile.json");

      // Deserialize the JSON file to ProfileResponse
      ObjectMapper objectMapper = new ObjectMapper();
      ProfileResponse expectedResponse = objectMapper.readValue(inputStream, ProfileResponse.class);

      response = profile(access_token);
      System.out.println("Profile Response: " + response.asPrettyString());
      assertEquals(response.getStatusCode(), 200, "Status code is not 200");

      //Deserialize the response to LoginResponse
      ProfileResponse  profileResponse = response.as(ProfileResponse.class);
      assertEquals(profileResponse.getId(), 2, "ID is not 2");
      assertEquals(profileResponse.getEmail(), "maria@mail.com", "Email is not matching");

      assertEquals(profileResponse, expectedResponse, "Profile response is not matching");
   }

   @Test(description = "Refresh Token Test")
   public void refreshTokenTest(){
      response = refershToken(refresh_token);
      System.out.println("Refresh Token Response: " + response.asPrettyString());
      refresh_token = response.jsonPath().getString("refresh_token");
      assertEquals(response.getStatusCode(), 201, "Status code is not 201");
   }

}
