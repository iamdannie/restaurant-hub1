package org.launchcode.RestaurantHub.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Locale;

@Entity
public class User extends AbstractEntity {


  @Id
  @GeneratedValue
  private int id;

  @NotNull
  private String username;
  @NotNull
  private String pwHash;
  @NotNull
  private String type;
  
  public User(String username, String password, String type) {
    this.username = username;
    this.pwHash = encoder.encode(password);
    if (type == null || type == "")
      this.type = "guest";
    else
      this.type = type;
  }
  public User(String username, String password) {
    this(username, password, "user");
  }
  public User (String username) {
    this(username, "");
  }
  public User() {
  
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
