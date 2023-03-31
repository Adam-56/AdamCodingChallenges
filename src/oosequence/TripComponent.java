package oosequence;

import java.util.Date;

public class TripComponent {
    private Date start;
    private Date end;

    public TripComponent() {
        start = new Date();
        end = new Date(start.getTime() + 60 * 60 * 1000);
    }

    public TripComponent(Date start, Date end) {
        if (start == null || end == null || start.before(end)) {
            this.start = start == null ? null : new Date(start.getTime());
            this.end = end == null ? null : new Date(end.getTime());
        } else {
            this.start = new Date(start.getTime());
            this.end = null;
        }
    }


    public TripComponent(TripComponent toCopy) {
        this.start = toCopy.start;
        this.end = toCopy.end;
    }

    public Date getStart() {
        return start != null ? new Date(start.getTime()) : null;
    }

    public void setStart(Date start) {
        if (start != null && (end == null || start.before(end))) {
            this.start = new Date(start.getTime());
        }
    }

    public Date getEnd() {
        return end != null ? new Date(end.getTime()) : null;
    }

    public void setEnd(Date end) {
        if (end != null && (start == null || end.after(start))) {
            this.end = new Date(end.getTime());
        }
    }

    public long lengthInSeconds() {
        if (start == null || end == null) {
            return 0;
        }

        long milliseconds = end.getTime() - start.getTime();
        return milliseconds / 1000;
    }
}
