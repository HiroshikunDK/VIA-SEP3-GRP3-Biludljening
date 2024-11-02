package Model;

public class Customer
{
  private int customer_id;
  private String first_name;
  private String last_name;
  private String username;
  private String password;
  private String email;
  private String phonenr;

  public Customer(int customer_id, String first_name, String last_name,
      String username, String password, String email, String phonenr)
  {
    this.customer_id = customer_id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.username = username;
    this.password = password;
    this.email = email;
    this.phonenr = phonenr;
  }

  public int getCustomer_id()
  {
    return customer_id;
  }

  public void setCustomer_id(int customer_id)
  {
    this.customer_id = customer_id;
  }

  public String getFirst_name()
  {
    return first_name;
  }

  public void setFirst_name(String first_name)
  {
    this.first_name = first_name;
  }

  public String getLast_name()
  {
    return last_name;
  }

  public void setLast_name(String last_name)
  {
    this.last_name = last_name;
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

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPhonenr()
  {
    return phonenr;
  }

  public void setPhonenr(String phonenr)
  {
    this.phonenr = phonenr;
  }
}
