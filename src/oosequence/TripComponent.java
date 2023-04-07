package oosequence;

import java.util.Date;

public class TripComponent {
    private Date start;
    private Date end;

    public TripComponent(Date startDate, Date endDate) {
        if (startDate != null && endDate != null && !startDate.before(endDate)) {
            this.start = startDate;
            this.end = null;
        } else {
            this.start = startDate;
            this.end = endDate;
        }
    }

    public TripComponent(TripComponent toCopy) {
        this.start = toCopy.start;
        this.end = toCopy.end;
    }

    public String getStart() {
        return start == null ? "" : start.toString();
    }

    public String getEnd() {
        return end == null ? "" : end.toString();
    }

    public void setStart(Date startDate) {
        if (startDate == null || this.end == null || startDate.before(this.end)) {
            this.start = startDate;
        }
    }

    public void setEnd(Date endDate) {
        if (endDate == null || this.start == null || endDate.after(this.start)) {
            this.end = endDate;
        }
    }

    protected long lengthInSeconds() {
        if (start == null || end == null) {
            return 0;
        }
        return (end.getTime() - start.getTime()) / 1000;
    }

    public boolean isBefore(TripComponent otherComponent) {
        return this.end != null && otherComponent.start != null && this.end.before(otherComponent.start);
    }

    public boolean overlapsWith(TripComponent otherComponent) {
        if (this.start == null || this.end == null || otherComponent.start == null || otherComponent.end == null) {
            return false;
        }
        return this.start.before(otherComponent.end) && this.end.after(otherComponent.start);
    }

}

