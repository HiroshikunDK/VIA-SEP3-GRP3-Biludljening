package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "creditcard")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creditcard_id;

    private String creditcardnr;
    private String cc_name;
    private String cc_lastname;
    private Long customerid;

    public CreditCard() {}

    public CreditCard(Long creditcard_id, String creditcardnr, String cc_name, String cc_lastname, Long customerid) {
        this.creditcard_id = creditcard_id;
        this.creditcardnr = creditcardnr;
        this.cc_name = cc_name;
        this.cc_lastname = cc_lastname;
        this.customerid = customerid;
    }

    public Long getCreditcard_id()
    {
        return creditcard_id;
    }

    public void setCreditcard_id(Long creditcard_id)
    {
        this.creditcard_id = creditcard_id;
    }

    public String getCreditcardnr()
    {
        return creditcardnr;
    }

    public void setCreditcardnr(String creditcardnr)
    {
        this.creditcardnr = creditcardnr;
    }

    public String getCc_name()
    {
        return cc_name;
    }

    public void setCc_name(String cc_name)
    {
        this.cc_name = cc_name;
    }

    public String getCc_lastname()
    {
        return cc_lastname;
    }

    public void setCc_lastname(String cc_lastname)
    {
        this.cc_lastname = cc_lastname;
    }

    public Long getCustomerid()
    {
        return customerid;
    }

    public void setCustomerid(Long customerid)
    {
        this.customerid = customerid;
    }
}