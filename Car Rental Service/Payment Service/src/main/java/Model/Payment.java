package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int customer;
    private int bookingType;
    private int booking;
    private String status;
    private int creditcardref;

    public Payment() {}

    public Payment(int customer, int bookingType, int booking, String status, int creditcardref) {
        this.customer = customer;
        this.bookingType = bookingType;
        this.booking = booking;
        this.status = status;
        this.creditcardref = creditcardref;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getCustomer()
    {
        return customer;
    }

    public void setCustomer(int customer)
    {
        this.customer = customer;
    }

    public int getBookingType()
    {
        return bookingType;
    }

    public void setBookingType(int bookingType)
    {
        this.bookingType = bookingType;
    }

    public int getBooking()
    {
        return booking;
    }

    public void setBooking(int booking)
    {
        this.booking = booking;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public int getCreditcardref()
    {
        return creditcardref;
    }

    public void setCreditcardref(int creditcardref)
    {
        this.creditcardref = creditcardref;
    }
}