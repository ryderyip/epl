package ict.data_objects.entities;

import java.time.LocalDateTime;

public class TimeSlot {
    private int id;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;

    public TimeSlot(int id, LocalDateTime beginTime, LocalDateTime endTime) {
        this.id = id;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
