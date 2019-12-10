package com.springwebmvc.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by motaleb on 7/8/17.
 */
@Entity
public class User implements Serializable {
    @Id
    private String email;
    private String password;
    private String TorS;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTorS() {
        return TorS;
    }

    public void setTorS(String torS) {
        TorS = torS;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", TorS='" + TorS + '\'' +
                '}';
    }
}
