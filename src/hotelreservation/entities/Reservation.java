package hotelreservation.entities;

import java.util.Date;  
import java.text.SimpleDateFormat;  

public class Reservation implements Comparable<Reservation> {
    
    private Integer reservationId;
    private String created;
    private String startDate;
    private String endDate;
	private String customerName;
	private String customerEmail;
	private String customerPhoneNr;
	private Integer numCostumers;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer reservationId, String created, String startDate, String endDate,
					   String customerName, String customerEmail, String customerPhoneNr,
					   Integer numCostumers) {
        this.reservationId = reservationId;
        this.created = created;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhoneNr = customerPhoneNr;
		this.numCostumers = numCostumers;
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
		allInfo += "customerPhoneNr: " + this.customerPhoneNr + "\n";
		allInfo += "numCostumers: " + this.numCostumers + "\n";
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
    
    public String getCustomerPhoneNr() {
        return this.customerPhoneNr;
    }
    
    public Integer getNumCostumers() {
        return this.numCostumers;
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
    
    public void setCustomerPhoneNr(String customerPhoneNr) {
        this.customerPhoneNr = customerPhoneNr;
    }
    
    public void setNumCostumers(Integer numCostumers) {
        this.numCostumers = numCostumers;
    }

}
