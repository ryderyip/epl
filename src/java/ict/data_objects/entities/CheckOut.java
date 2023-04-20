package ict.data_objects.entities;

import java.time.LocalDateTime;

public class CheckOut {
    private int id;
    private LocalDateTime time;
    private String staffRemarks;

    public CheckOut(int id, LocalDateTime time, String staffRemarks) {
        this.id = id;
        this.time = time;
        this.staffRemarks = staffRemarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getStaffRemarks() {
        return staffRemarks;
    }

    public void setStaffRemarks(String staffRemarks) {
        this.staffRemarks = staffRemarks;
    }
}
