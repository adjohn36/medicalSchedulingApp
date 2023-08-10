package com.techelevator.model;

public class Patient {


    private int patientId;
    private int userId;
    private String patientFirstName;
    private String patientLastName;
    private String patientStreetAddress;
    private String patientCity;
    private String patientZipCode;
    private String patientPhoneNumber;
    private String patientEmail;
    private String patientDob;
    public Patient() { }
    public Patient(int patientId, int userId, String patientFirstName, String patientLastName, String patientStreetAddress, String patientCity,
                   String patientZipCode, String patientPhoneNumber, String patientEmail, String patientDob) {
        this.patientId = patientId;
        this.userId = userId;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientStreetAddress = patientStreetAddress;
        this.patientCity = patientCity;
        this.patientZipCode = patientZipCode;
        this.patientPhoneNumber = patientPhoneNumber;
        this.patientEmail = patientEmail;
        this.patientDob = patientDob;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPatientStreetAddress() {
        return patientStreetAddress;
    }

    public void setPatientStreetAddress(String patientStreetAddress) {
        this.patientStreetAddress = patientStreetAddress;
    }

    public String getPatientCity() {
        return patientCity;
    }

    public void setPatientCity(String patientCity) {
        this.patientCity = patientCity;
    }

    public String getPatientZipCode() {
        return patientZipCode;
    }

    public void setPatientZipCode(String patientZipCode) {
        this.patientZipCode = patientZipCode;
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientDob() {
        return patientDob;
    }

    public void setPatientDob(String patientDob) {
        this.patientDob = patientDob;
    }
}


