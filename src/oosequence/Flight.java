package oosequence;

public class Flight extends TripComponent {
    private String departureAirport;
    private String arrivalAirport;

    public Flight() {
        super();
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        if (departureAirport != null && departureAirport.length() == 3) {
            this.departureAirport = departureAirport;
        } else {
            this.departureAirport = "";
        }
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        if (arrivalAirport != null && arrivalAirport.length() == 3) {
            this.arrivalAirport = arrivalAirport;
        } else {
            this.arrivalAirport = "";
        }
    }

    public String getDuration() {
        long durationInSeconds = lengthInSeconds();
        long durationInMinutes = durationInSeconds / 60;
        return String.format("%d minutes", durationInMinutes);
    }
}
