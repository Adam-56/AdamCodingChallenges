package oosequence;

import java.util.Date;

public class Flight {
	Date departure;
    Date arrival;

	public Flight(Date departure, Date arrival) {
		// TODO Auto-generated constructor stub
		if (departure == null || arrival == null) {
            this.departure = null;
            this.arrival = null;
        } else if (departure.before(arrival)) {
            this.departure = departure;
            this.arrival = arrival;
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
}
