package com.automation.escuela.base;
import io.restassured.response.Response;

public class AuthService extends BaseService{
    private static final String AUTH_ENDPOINT = "/auth";

    public Response login(String email, String password) {
        String payload = String.format("{\"email\": \"%s\", \"password\": \"%s\"}", email, password);
        return postRequest(AUTH_ENDPOINT+"/login", payload);
    }

    public Response profile(String token) {
        setAuthToken(token);
        return getRequest(AUTH_ENDPOINT+ "/profile");
    }

    public Response refershToken(String token) {
        setAuthToken(token);
        String payload = String.format("{\"refreshToken\": \"%s\"}", token);
        return postRequest(AUTH_ENDPOINT+ "/refresh-token", payload);
    }
}
