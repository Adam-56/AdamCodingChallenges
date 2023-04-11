package oosequence;

import java.util.Date;

public class Flight {
    private Date departure;
    private Date arrival;

    public Flight(Date departure, Date arrival) {
        if ((departure != null && arrival != null) && (departure.equals(arrival) || departure.after(arrival))) {
            this.departure = null;
            this.arrival = null;
        } else {
            this.departure = departure != null ? new Date(departure.getTime()) : null;
            this.arrival = arrival != null ? new Date(arrival.getTime()) : null;
        }
    }



    public Flight(Flight flight) {
        this.departure = flight.getDeparture() != null ? new Date(flight.getDeparture().getTime()) : null;
        this.arrival = flight.getArrival() != null ? new Date(flight.getArrival().getTime()) : null;
    }

    public Date getDeparture() {
        return departure != null ? new Date(departure.getTime()) : null;
    }

    public void setDeparture(Date departure) {
        if (departure == null || (arrival != null && departure.after(arrival))) {
            return;
        }
        this.departure = new Date(departure.getTime());
    }

    public Date getArrival() {
        return arrival != null ? new Date(arrival.getTime()) : null;
    }

    public void setArrival(Date arrival) {
        if (arrival == null || (departure != null && arrival.before(departure))) {
            return;
        }
        this.arrival = new Date(arrival.getTime());
    }

    public long length() {
        if (departure == null || arrival == null) {
            return 0;
        }
        return (arrival.getTime() - departure.getTime()) / (60 * 1000);
    }
}
