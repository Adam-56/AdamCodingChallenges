package oosequence;

import java.util.ArrayList;

public class Itinerary {
    private ArrayList<Flight> flights;
    private String name;

    public Itinerary(String name) {
        this.name = name;
        this.flights = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void addFlight(Flight flight) {
        if (flights.isEmpty()) {
            flights.add(flight);
            return;
        }

        for (int i = 0; i < flights.size(); i++) {
            if (flight.getArrival().before(flights.get(i).getDeparture())) {
                if (i == 0 || flight.getDeparture().after(flights.get(i - 1).getArrival())) {
                    flights.add(i, flight);
                    return;
                }
            }
        }

        Flight lastFlight = flights.get(flights.size() - 1);
        if (flight.getDeparture().after(lastFlight.getArrival())) {
            flights.add(flight);
        }
    }


    public long getTotalLayover() {
        long totalLayover = 0;
        for (int i = 1; i < flights.size(); i++) {
            Flight previousFlight = flights.get(i - 1);
            Flight currentFlight = flights.get(i);
            long layover = currentFlight.getDeparture().getTime() - previousFlight.getArrival().getTime();
            totalLayover += layover;
        }
        return totalLayover / 60000;
    }
}


