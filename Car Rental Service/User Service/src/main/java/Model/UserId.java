package Model;
import java.io.Serializable;
import java.util.Objects;

public class UserId implements Serializable {
  private String username;
  private int id;

  public UserId() {}

  public UserId(String username, int id) {
    this.username = username;
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserId userId = (UserId) o;
    return id == userId.id && Objects.equals(username, userId.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, id);
  }
}