package com.techelevator.model;

import java.sql.Time;

public class Schedule {
    private int scheduleId;
    private String day;
    private Time timeslot;

public Schedule() {}

public Schedule(int scheduleId, String day, Time timeslot){
    this.scheduleId=scheduleId;
    this.day=day;
    this.timeslot=timeslot;
}

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Time getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Time timeslot) {
        this.timeslot = timeslot;
    }
}