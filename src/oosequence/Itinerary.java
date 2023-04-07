package oosequence;

import java.util.ArrayList;
import java.util.Date;

public class Itinerary {
    private String name;
    private Date start;
    private ArrayList<TripComponent> tripComponents;

    public Itinerary(String aName) {
        this.name = aName;
        this.tripComponents = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public boolean addTripComponent(TripComponent newTripComponent) {
        for (TripComponent tripComponent : tripComponents) {
            if (tripComponent.overlapsWith(newTripComponent)) {
                return false;
            }
        }
        tripComponents.add(newTripComponent);
        tripComponents.sort((tc1, tc2) -> tc1.getStart().compareTo(tc2.getStart()));
        return true;
    }

    public ArrayList<TripComponent> getTripComponents() {
        return this.tripComponents;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");

        for (int i = 0; i < tripComponents.size(); i++) {
            sb.append(i)
                .append("\t")
                .append(tripComponents.get(i).getStart())
                .append("\t")
                .append(tripComponents.get(i).getEnd())
                .append("\n");
        }

        return sb.toString();
    }

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}
}
