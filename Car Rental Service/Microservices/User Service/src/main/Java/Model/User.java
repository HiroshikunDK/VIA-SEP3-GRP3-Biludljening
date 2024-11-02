package Model;

public class User {
  private int id;
  private String userFirstname;
  private String userLastname;
  private String title;
  private String email;
  private int phonenr;
  private String username;
  private String password;
  private String userpermission;

  public User(int id, String userFirstname, String userLastname, String title,
      String email, int phonenr, String username, String password,
      String userpermission)
  {
    this.id = id;
    this.userFirstname = userFirstname;
    this.userLastname = userLastname;
    this.title = title;
    this.email = email;
    this.phonenr = phonenr;
    this.username = username;
    this.password = password;
    this.userpermission = userpermission;
  }

  public String getUserpermission()
  {
    return userpermission;
  }

  public void setUserpermission(String userpermission)
  {
    this.userpermission = userpermission;
  }

  public String getUserFirstname()
  {
    return userFirstname;
  }

  public void setUserFirstname(String userFirstname)
  {
    this.userFirstname = userFirstname;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getUserLastname()
  {
    return userLastname;
  }

  public void setUserLastname(String userLastname)
  {
    this.userLastname = userLastname;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public int getPhonenr()
  {
    return phonenr;
  }

  public void setPhonenr(int phonenr)
  {
    this.phonenr = phonenr;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }
}
