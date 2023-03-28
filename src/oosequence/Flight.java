package oosequence;

import java.util.Date;

public class Flight {
	Date departure;
    Date arrival;

	public Flight(Date departure, Date arrival) {
		// TODO Auto-generated constructor stub
		if (departure == null || arrival == null || departure.before(arrival)) {
	        this.departure = departure == null ? null : new Date(departure.getTime());
	        this.arrival = arrival == null ? null : new Date(arrival.getTime());
	    } else {
	        this.departure = null;
	        this.arrival = null;
	    }
	}

	public Flight(Flight flight) {
		// TODO Auto-generated constructor stub
		this.departure = flight.departure;
        this.arrival = flight.arrival;
	}

	public long length() {
        if (departure == null || arrival == null) {
            return 0;
        }

        long milliseconds = arrival.getTime() - departure.getTime();
        return milliseconds / 1000 / 60;
    }
	
	public Date getDeparture() {
        return departure != null ? new Date(departure.getTime()) : null;
    }

    // Getter for arrival date
    public Date getArrival() {
        return arrival != null ? new Date(arrival.getTime()) : null;
    }

    // Setter for departure date
    public void setDeparture(Date departure) {
        if (departure != null && (arrival == null || departure.before(arrival))) {
            this.departure = new Date(departure.getTime());
        }
    }

    // Setter for arrival date
    public void setArrival(Date arrival) {
        if (arrival != null && (departure == null || arrival.after(departure))) {
            this.arrival = new Date(arrival.getTime());
        }
    }

    
}
