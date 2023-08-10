package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
/*
    The acronym DTO is being used for "data transfer object". It means that this type of class is specifically
    created to transfer data between the client and the server. For example, CredentialsDto represents the data a client must
    pass to the server for a login endpoint, and TokenDto represents the object that's returned from the server
    to the client from a login endpoint.
 */
public class LoginResponseDto {

    private String token;
    private User user;
    private boolean isDoctor;
    private boolean isValidDoctor;

    public LoginResponseDto(String token, User user, boolean isDoctor, boolean isValidDoctor) {
        this.token = token;
        this.user = user;
        this.isDoctor = isDoctor;
        this.isValidDoctor = isValidDoctor;
    }

    @JsonProperty("token")
    String getToken() {
        return token;
    }

    void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isDoctor() {
        return isDoctor;
    }

    public void setDoctor(boolean doctor) {
        isDoctor = doctor;
    }

    public boolean isValidDoctor() {
        return isValidDoctor;
    }

    public void setValidDoctor(boolean validDoctor) {
        isValidDoctor = validDoctor;
    }
}
