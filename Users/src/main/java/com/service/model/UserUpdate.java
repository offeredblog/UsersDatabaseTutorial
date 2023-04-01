package com.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserUpdate {
    private int userId;
    private String userName;
    private String firstName;
    private String lastName;

    public UserUpdate() {}

    public UserUpdate(int userId, String userName, String firstName, String lastName) {
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @JsonProperty
    public int getUserId() {
        return userId;
    }

    @JsonProperty
    public String getUserName() {
        return userName;
    }

    @JsonProperty
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty
    public String getLastName() {
        return lastName;
    }
}
