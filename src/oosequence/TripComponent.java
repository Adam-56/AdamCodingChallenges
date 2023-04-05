package oosequence;

import java.util.Date;

public class TripComponent {
    private Date start;
    private Date end;

    public TripComponent(Date startDate, Date endDate) {
        if (startDate.before(endDate)) {
            this.start = startDate;
            this.end = endDate;
        } else {
            this.start = endDate;
            this.end = startDate;
        }
    }

    public TripComponent(TripComponent toCopy) {
        this.start = toCopy.start;
        this.end = toCopy.end;
    }

    public String getStart() {
        return start.toString();
    }

    public String getEnd() {
        return end.toString();
    }

    public void setStart(Date startDate) {
        if (startDate.before(end)) {
            this.start = startDate;
        }
    }

    public void setEnd(Date endDate) {
        if (endDate.after(start)) {
            this.end = endDate;
        }
    }

    protected long lengthInSeconds() {
        return (end.getTime() - start.getTime()) / 1000;
    }

    public boolean isBefore(TripComponent otherComponent) {
        return this.end.before(otherComponent.start);
    }

    public boolean overlapsWith(TripComponent otherComponent) {
        return !this.isBefore(otherComponent) && !otherComponent.isBefore(this);
    }
}
