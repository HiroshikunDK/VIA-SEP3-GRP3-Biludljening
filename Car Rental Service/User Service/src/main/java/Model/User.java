package Model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Hibernate genererer ID automatisk
  private int id;

  @Column(nullable = false, unique = true)
  private String username;

  private String email;
  private String password;
  private int phonenr;
  private String title;
  private String userFirstname;
  private String userLastname;
  private String role;

  public User() {}

  public User(String username, String email, String password, int phonenr, String title, String userFirstname, String userLastname, String role) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.phonenr = phonenr;
    this.title = title;
    this.userFirstname = userFirstname;
    this.userLastname = userLastname;
    this.role = role;
  }

  // Getters and Setters

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

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

  public int getPhonenr() {
    return phonenr;
  }

  public void setPhonenr(int phonenr) {
    this.phonenr = phonenr;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUserFirstname() {
    return userFirstname;
  }

  public void setUserFirstname(String userFirstname) {
    this.userFirstname = userFirstname;
  }

  public String getUserLastname() {
    return userLastname;
  }

  public void setUserLastname(String userLastname) {
    this.userLastname = userLastname;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}
