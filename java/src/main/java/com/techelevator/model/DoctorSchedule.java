package com.techelevator.model;


public class DoctorSchedule{
private int doctorScheduleId;
private int scheduleId;
private int doctorId;
private boolean slotAvailable;


  public DoctorSchedule(){}

    public int getDoctorScheduleId() {
        return doctorScheduleId;
    }

    public void setDoctorScheduleId(int doctorScheduleId) {
        this.doctorScheduleId = doctorScheduleId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    public boolean isSlotAvailable() {
        return slotAvailable;
    }

    public void setSlotAvailable(boolean slotAvailable) {
        this.slotAvailable = slotAvailable;
    }

    public DoctorSchedule(int doctorScheduleId, int doctorId, int scheduleId, boolean slotAvailable){
        this.doctorScheduleId=doctorScheduleId;
        this.doctorId=doctorId;
        this.scheduleId=scheduleId;
        this.slotAvailable=true;




    }

}
