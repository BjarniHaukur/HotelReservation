package hotelreservation.entities;

import java.text.SimpleDateFormat;  

public class Reservation implements Comparable<Reservation> {
     
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String reservationId;
    private String created;
    private String startDate;
    private String endDate;
	private String customerName;
	private String customerEmail;
	private String customerPhone;
	private Integer numCustomers;
    private Integer roomNum;
    private Integer hotelId;
    
    

    public Reservation(String reservationId, String created, String startDate, String endDate,
					   String customerName, String customerEmail, String customerPhone,
					   Integer numCustomers, Integer roomNum, Integer hotelId) {
        this.reservationId = reservationId;
        this.created = created;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.numCustomers = numCustomers;
        this.roomNum = roomNum;
        this.hotelId = hotelId;
    }
 
    @Override
    public int compareTo(Reservation o) {
        return this.sdf.format(this.startDate).compareTo(this.sdf.format(o.getStartDate()));
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
	public String getReservationId() {
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

    public Integer getHotelId() {
        return this.hotelId;
    }

    public Integer getRoomNum() {
        return this.roomNum;
    }
    
    // Setters
    public void setReservationId(String reservationId) {
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

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

}
