package hotelreservation.entities;

public class Reservation implements Comparable<Reservation> {
    
    private Integer reservationId;
    private Long created;
    private Long startDate;
    private Long endDate;
    private String contact;

    public Reservation(Integer reservationId, Long created, Long startDate, Long endDate, String contact)  {
        this.reservationId = reservationId;
        this.created = created;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contact = contact;
    }

    @Override
    public int compareTo(Reservation o) {
        return (int)(o.getDateFrom() - this.getDateFrom());
    }

    public String getAllString() {
        String allInfo = "";
        allInfo += "Date from: " + this.dateFrom + "\n";
        allInfo += "Date to: " + this.dateTo + "\n";
        allInfo += "Customer name: " + this.customerName + "\n";
        allInfo += "Customer email: " + this.customerEmail + "\n";
        allInfo += "Customer phone nr: " + this.customerPhoneNr + "\n";
        allInfo += "Number of costumers: " + this.numCostumers + "\n";
        return allInfo;
    }
    
    public Integer getReservationId() {
		return this.reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public Long getCreated() {
		return this.created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public Long getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}

	public Long getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
