package oosequence;

import java.util.ArrayList;

public class Itinerary {
    private ArrayList<Flight> flightList;
    private String name;

    public Itinerary(String name) {
        this.name = name;
        this.flightList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Flight> getFlightList() {
        ArrayList<Flight> copyList = new ArrayList<>();
        for (Flight flight : flightList) {
            copyList.add(new Flight(flight));
        }
        return copyList;
    }


    public void addFlight(Flight flight) {
        Flight flightCopy = new Flight(flight.getDeparture(), flight.getArrival());
        if (flightList.isEmpty()) {
            flightList.add(flightCopy);
        } else {
            int index = 0;
            for (Flight f : flightList) {
                if (f.getDeparture().compareTo(flightCopy.getDeparture()) > 0) {
                    break;
                }
                index++;
            }
            flightList.add(index, flightCopy);
        }
    }



    public long getTotalLayover() {
        long totalLayover = 0;
        for (int i = 0; i < flightList.size() - 1; i++) {
            Flight currentFlight = flightList.get(i);
            Flight nextFlight = flightList.get(i + 1);
            totalLayover += (nextFlight.getDeparture().getTime() - currentFlight.getArrival().getTime()) / 1000 / 60;
        }
        return totalLayover;
    }
}
