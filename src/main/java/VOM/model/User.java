package VOM.model;

import lombok.Getter;
import lombok.Setter;

import javax.security.auth.callback.PasswordCallback;

@Getter
public class User {
  private String name;
  @Setter
  private String email;
  @Setter
  private String password;

  public User setName(String name) {
    this.name = name;
    return this;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }
}
