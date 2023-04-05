package oosequence;

import java.util.ArrayList;

public class Itinerary {
    private String name;
    private ArrayList<TripComponent> tripComponents;

    public Itinerary(String aName) {
        this.name = aName;
        this.tripComponents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTripComponent(TripComponent component) {
        tripComponents.add(component);
    }

    public ArrayList<TripComponent> getTripComponents() {
        return tripComponents;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(name + "\n");

        for (int i = 0; i < tripComponents.size(); i++) {
            TripComponent component = tripComponents.get(i);
            result.append(i).append("\t").append(component.getStart()).append("\t").append(component.getEnd()).append("\n");
        }

        return result.toString();
    }
}
