package hotelreservation.entities;

public class Reservation implements Comparable<Reservation> {
    
    private Integer reservationId;
    private String created;
    private String startDate;
    private String endDate;
	private String customerName;
	private String customerEmail;
	private String customerPhone;
	private Integer numCustomers;

    public Reservation(Integer reservationId, String created, String startDate, String endDate,
					   String customerName, String customerEmail, String customerPhone,
					   Integer numCustomers) {
        this.reservationId = reservationId;
        this.created = created;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.numCustomers = numCustomers;
    }
 
    @Override
    public int compareTo(Reservation o) {
        return 0;
    }

	public String toString() {
		String allInfo = "";
		allInfo += "reservationId: " + this.reservationId + "\n";
		allInfo += "created: " + this.created + "\n";
		allInfo += "startDate: " + this.startDate + "\n";
		allInfo += "endDate: " + this.endDate + "\n";
		allInfo += "customerName: " + this.customerName + "\n";
		allInfo += "customerEmail: " + this.customerEmail + "\n";
		allInfo += "customerPhone: " + this.customerPhone + "\n";
		allInfo += "numCustomers: " + this.numCustomers + "\n";
		return allInfo;
	}
    
    // Getters
	public Integer getReservationId() {
        return this.reservationId;
    }
    
    public String getCreated() {
        return this.created;
    }
    
    public String getStartDate() {
        return this.startDate;
    }
    
    public String getEndDate() {
        return this.endDate;
    }
    
    public String getCustomerName() {
        return this.customerName;
    }
    
    public String getCustomerEmail() {
        return this.customerEmail;
    }
    
    public String getCustomerPhone() {
        return this.customerPhone;
    }
    
    public Integer getnumCustomers() {
        return this.numCustomers;
    }
    
    // Setters
    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }
    
    public void setCreated(String created) {
        this.created = created;
    }
    
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    
    public void setnumCustomers(Integer numCustomers) {
        this.numCustomers = numCustomers;
    }

}
