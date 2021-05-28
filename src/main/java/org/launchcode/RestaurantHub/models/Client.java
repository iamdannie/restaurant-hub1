package org.launchcode.RestaurantHub.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private int id;

    private String username;

    private String pwHash;

    private String type;

    public Client(String username, String password, String type) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        if (type == null || type == "")
            this.type = "guest";
        else
            this.type = type;
    }
    public Client(String username, String password) {
        this(username, password, "user");
    }
    public Client (String username) {
        this(username, "");
    }
    public Client() {

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

}
