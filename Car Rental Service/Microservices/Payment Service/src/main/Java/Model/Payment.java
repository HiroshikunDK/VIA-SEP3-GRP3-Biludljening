package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customer;
    private int bookingType;
    private Long booking;
    private String status;
    private Long creditcardref;

    public Payment() {}

    public Payment(Long id, Long customer, int bookingType, Long booking, String status, Long creditcardref) {
        this.id = id;
        this.customer = customer;
        this.bookingType = bookingType;
        this.booking = booking;
        this.status = status;
        this.creditcardref = creditcardref;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getCustomer()
    {
        return customer;
    }

    public void setCustomer(Long customer)
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

    public Long getBooking()
    {
        return booking;
    }

    public void setBooking(Long booking)
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

    public Long getCreditcardref()
    {
        return creditcardref;
    }

    public void setCreditcardref(Long creditcardref)
    {
        this.creditcardref = creditcardref;
    }
}