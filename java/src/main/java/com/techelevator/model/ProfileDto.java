package com.techelevator.model;
public class ProfileDto {
    private boolean isDoctor;
    private boolean isVerifiedDoctor;

    public ProfileDto() {
    }

    public ProfileDto(boolean isDoctor, boolean isVerifiedDoctor) {
        this.isDoctor = isDoctor;
        this.isVerifiedDoctor = isVerifiedDoctor;
    }

    public boolean isDoctor() {
        return isDoctor;
    }

    public void setDoctor(boolean doctor) {
        isDoctor = doctor;
    }

    public boolean isVerifiedDoctor() {
        return isVerifiedDoctor;
    }

    public void setVerifiedDoctor(boolean verifiedDoctor) {
        isVerifiedDoctor = verifiedDoctor;
    }
}
