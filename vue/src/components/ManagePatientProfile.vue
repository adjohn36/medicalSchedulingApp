<template>
  <div>
    <form id="patient-profile-form" @submit.prevent="savePatientProfile">
      <h1>Create Patient Profile</h1>
      <div class="form-element">
        <label for="firstName">First Name:</label>
        <input
          id="firstName"
          type="text" required
          v-model="patient.patientProfile.patientFirstName"
        />
      </div>
      <div class="form-element">
        <label for="lastName">Last Name:</label>
        <input
          id="lastName"
          type="text" required
          v-model="patient.patientProfile.patientLastName"
        />
      </div>
      <div class="form-element">
        <label for="streetAddress">Street Address:</label>
        <input
          id="streetAddress"
          type="text" required
          v-model="patient.patientProfile.patientStreetAddress"
        />
      </div>
      <div class="form-element">
        <label for="city">City:</label>
        <input id="city" type="text" required v-model="patient.patientProfile.patientCity" />
      </div>
      <div class="form-element">
        <label for="state">State:</label>
        <input id="state" type="text" required v-model="patient.patientProfile.patientState" />
      </div>
      <div class="form-element">
        <label for="zipcode">Zip Code:</label>
        <input
          id="zipcode"
          type="number" required
          v-model="patient.patientProfile.patientZipCode"
        />
      </div>
      <div class="form-element">
        <label for="phoneNumber">Phone Number:</label>
        <input
          id="phoneNumber"
          type="number" required
          v-model="patient.patientProfile.patientPhoneNumber"
        />
      </div>
      <div class="form-element">
        <label for="email">Email Address:</label>
        <input id="email" type="email" required v-model="patient.patientProfile.patientEmail" />
      </div>
      <div class="form-element">
        <label for="date-of-birth">Date Of Birth:</label>
        <input
          id="date-of-birth" name="date"
          type="date" pattern="\d{4}-\d{2}-\d{2}" required min="1900-01-01"
          v-model="patient.patientProfile.patientDob"
        />
      </div>

      <div class="row button">
        <button type="submit">Save</button>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "manage-patient-profile",

  data() {
    return {
      
      //currentDate: new Date().toJSON().slice(0,10).replace(/-/g,'/'),
      currentDate: new Date().toJSON().slice(0,10),
      patient: {
        isDoctor: false,
        patientProfile: {
          patientFirstName: "",
          patientLastName: "",
          patientStreetAddress: "",
          patientCity: "",
          patientState: "",
          patientZipCode: "",
          patientPhoneNumber: "",
          patientEmail: "",
          patientDob: ""
        }
      }
    };
  },

  methods:{
    setMaxLimitDOB(){
      
    },

    savePatientProfile(){    
     
      this.patient.isDoctor = this.$store.state.isDoctor;
      authService.updatePatientProfile(this.patient)
       .then((response) => {
          if (response.status === 200) {
            (this.errors = false), (this.message = "Successfully Updated.");
          }
          this.clear();
        })
        .catch((error) => {
          const response = error.response;
          this.errors = true;
          if (response.status === 400) {
            this.message = "Bad Request: Validation Errors";
          }
        });     
    },

    clear(){
      this.patient.patientProfile.patientFirstName = "";
      this.patient.patientProfile.patientLastName = "";
      this.patient.patientProfile.patientStreetAddress = "";
      this.patient.patientProfile.patientCity = "";
      this.patient.patientProfile.patientState = "";
      this.patient.patientProfile.patientZipCode = "";
      this.patient.patientProfile.patientPhoneNumber = "";
      this.patient.patientProfile.patientEmail = "";
      this.patient.patientProfile.patientDob = "";         
    }
  },

  created(){
     //alert(this.currentDate);
  }

};
</script>

<style>
</style>