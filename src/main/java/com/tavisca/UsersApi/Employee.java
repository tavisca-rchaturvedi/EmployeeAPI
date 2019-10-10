package com.tavisca.UsersApi;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    public long id;
    public String firstName;
    public String lastName;
    public String hobbies;

    public Employee(){

    }

    public Employee(long id, String firstName, String lastName, String hobbies){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobbies = hobbies;
    }
}
