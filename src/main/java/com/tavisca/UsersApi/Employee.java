package com.tavisca.UsersApi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    public long id;
    @Column(name="firstName")
    public String firstName;
    public String lastName;
    public String role;
    public String createdBy;
    public java.sql.Timestamp createdOn;

    public Employee(){

    }

    public Employee(long id, String firstName, String lastName, String role, String createdBy, java.sql.Timestamp createdOn){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
    }
}
