package com.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInsert {
    private String userName;
    private String firstName;
    private String lastName;

    public UserInsert() {}

    public UserInsert(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
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
