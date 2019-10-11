package com.tavisca.UsersApi;

public class PasswordResponse {
    public long id;
    public String firstName;
    public String lastName;
    public String password;

    public PasswordResponse(long id, String firstName, String lastName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
}
