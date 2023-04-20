package ict.data_objects.entities;

import java.time.LocalDateTime;

public class VenueUsage {
    private int id;
    private LocalDateTime checkIn;
    private CheckOut checkOut;

    public VenueUsage(int id, LocalDateTime checkIn, CheckOut checkOut) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public CheckOut getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(CheckOut checkOut) {
        this.checkOut = checkOut;
    }
}
