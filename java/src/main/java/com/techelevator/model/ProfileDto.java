package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfileDto {
    @JsonProperty("isDoctor")
    private boolean doctor;
    @JsonProperty("isVerifiedDoctor")
    private boolean verifiedDoctor;

    private Doctor doctorProfile;
    private Patient patientProfile;


    public ProfileDto() {
    }

    public ProfileDto(boolean isDoctor, boolean isVerifiedDoctor) {
        this.doctor = isDoctor;
        this.verifiedDoctor = isVerifiedDoctor;
    }

    public boolean isDoctor() {
        return doctor;
    }

    public void setDoctor(boolean doctor) {
        this.doctor = doctor;
    }

    public boolean isVerifiedDoctor() {
        return verifiedDoctor;
    }

    public void setVerifiedDoctor(boolean verifiedDoctor) {
        this.verifiedDoctor = verifiedDoctor;
    }

    public Doctor getDoctorProfile() {
        return doctorProfile;
    }

    public void setDoctorProfile(Doctor doctorProfile) {
        this.doctorProfile = doctorProfile;
    }

    public Patient getPatientProfile() {
        return patientProfile;
    }

    public void setPatientProfile(Patient patientProfile) {
        this.patientProfile = patientProfile;
    }
}
