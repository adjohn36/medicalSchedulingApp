package com.techelevator.model;

public class AppointmentResponseModel {
    private String patientFirstName;
    private String patientLastName;
    private String dateSelected;
    private String timeSlot;

    public AppointmentResponseModel() { }

    public AppointmentResponseModel(String patientFirstName, String patientLastName, String dateSelected, String timeSlot){
           this.patientFirstName =patientFirstName;
           this.patientLastName = patientLastName;
           this.dateSelected = dateSelected;
           this.timeSlot = timeSlot;
        }
   public String getDateSelected() {
        return dateSelected;
    }
    public void setDateSelected(String dateSelected) {
        this.dateSelected = dateSelected;
    }
    public String getPatientFirstName() {
        return patientFirstName;
    }
    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }
    public String getPatientLastName() {
        return patientLastName;
    }
    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }
    public String getTimeSlot() {
        return timeSlot;
    }
    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
}


