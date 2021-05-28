package org.launchcode.RestaurantHub.models;

import org.dom4j.tree.AbstractEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


//@Entity  determines the structure of a table in our relational database
@Entity
public class User extends AbstractEntity {

//@Id denotes that an integer id field is to be used as an id in the corresponding table in the database
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

  public int getId() { return id;}

   private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
  public boolean isMatchingPassword(String password) {
    return encoder.matches(password, pwHash);
  }



}
