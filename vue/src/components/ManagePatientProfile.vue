<template>
  <div>
    <form id="patient-profile-form" @submit.prevent="savePatientProfile">
      <h1>Create Patient Profile</h1>
      <div class="form-element">
        <label for="firstName">First Name:</label>
        <input
          id="firstName"
          type="text"
          v-model="patientProfile.patientFirstName"
        />
      </div>
      <div class="form-element">
        <label for="lastName">Last Name:</label>
        <input
          id="lastName"
          type="text"
          v-model="patientProfile.patientLastName"
        />
      </div>
       <div class="form-element">
        <label for="streetAddress">Street Address:</label>
        <input
          id="streetAddress"
          type="text"
          v-model="patientProfile.streetAddress"
        />
      </div>
      <div class="form-element">
        <label for="city">City:</label>
        <input
          id="city"
          type="text"
          v-model="patientProfile.city"
        />
      </div>
      <div class="form-element">
        <label for="state">State:</label>
        <input
          id="state"
          type="text"
          v-model="patientProfile.state"
        />
      </div>
      <div class="form-element">
        <label for="zipcode">Zip Code:</label>
        <input
          id="zipcode"
          type="text"
          v-model="patientProfile.patientZipCode"
        />
      </div>
      <div class="form-element">
        <label for="phoneNumber">Phone Number:</label>
        <input
          id="phoneNumber"
          type="number"
          v-model="patientProfile.patientPhoneNumber"
        />
      </div>
      <div class="form-element">
        <label for="email">Email Address:</label>
        <input
          id="email"
          type="email"
          v-model="patientProfile.patientEmail"
        />
      </div>
      <div class="form-element">
        <label for="date-of-birth">Date Of Birth:</label>
        <input
          id="date-of-birth"
          type="date"
          v-model="patientProfile.patientDob"
        />
      </div>
     
      <div class="row button">
        <button type="submit">Save</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
    name:'manage-patient-profile',

    data(){
        return{

            patientProfile:{
                patientFirstName:'',
                patientLastName:'',
                patientStreetAddress:'',
                patientCity:'',
                patientState:'',
                patientZipCode:'',
                patientPhoneNumber:'',
                patientEmail:'',
                patientDob:''
            }
        }
    }
}
</script>

<style>

</style>