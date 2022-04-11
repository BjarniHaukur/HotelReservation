package hotelreservation.entities;

public class Reservation implements Comparable<Reservation> {
    
    private Long dateFrom;
    private Long dateTo;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNr;
    private int numCostumers;

    public Reservation(Long dateFrom, Long dateTo, String customerName, String customerEmail, String customerPhoneNr, int numCostumers)  {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNr = customerPhoneNr;
        this.numCostumers = numCostumers;
    }

    public Long getDateFrom() {
        return dateFrom;
    }

    public Long getDateTo() {
        return dateTo;
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

}
