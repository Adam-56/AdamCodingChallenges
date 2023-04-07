package oosequence;

import java.util.Date;

public class Flight extends TripComponent {
    private String departureAirport;
    private String arrivalAirport;

    public Flight(Date departureTime, Date arrivalTime, String departureAirport, String arrivalAirport) {
        super(departureTime, arrivalTime);
        this.departureAirport = isValidAirportCode(departureAirport) ? departureAirport : "";
        this.arrivalAirport = isValidAirportCode(arrivalAirport) ? arrivalAirport : "";
    }

    public Flight(Flight c) {
        super(c);
        this.departureAirport = c.departureAirport;
        this.arrivalAirport = c.arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String airport) {
        this.departureAirport = isValidAirportCode(airport) ? airport : "";
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String airport) {
        this.arrivalAirport = isValidAirportCode(airport) ? airport : "";
    }

    @Override
    public String getStart() {
        return departureAirport + " " + super.getStart();
    }

    @Override
    public String getEnd() {
        return arrivalAirport + " " + super.getEnd();
    }

    private boolean isValidAirportCode(String airportCode) {
        return airportCode != null && airportCode.length() == 3;
    }
}

