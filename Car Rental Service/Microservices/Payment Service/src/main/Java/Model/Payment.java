package Model;

public class Payment {
  private Long id;            // Primærnøgle
  private Long customer;      // Kunde ID
  private int bookingType;    // Type af booking (0 for 'car', 1 for 'greenshare')
  private Long booking;       // Booking ID
  private String status;      // Betalingsstatus, fx 'paid' eller 'not paid'
  private Long creditcardref; // Kreditkort reference ID



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
