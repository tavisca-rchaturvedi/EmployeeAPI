package com.tavisca.UsersApi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passwords")
public class Password {
    @Id
    public long id;
    public String password;



    public Password(){

    }

    public Password(long id, String password) {
        this.id = id;
        this.password = password;
    }
}
