<template>
  <div id="updateOfficeInfo" class="text-center">
    <form v-on:submit.prevent="updateOffice">
      <h1>Update Office Information</h1>
     <!-- <div role="alert" v-if="updateOfficeErrors">
        {{ updateOfficeErrorMsg }}
      </div> -->
      <office-info v-bind:doctorFacilityInfo="doctorFacilityInfo"/>
    <div class="form-input-group">
           <label for="officeName">Facility Name:</label>
           <input type="text" id="officeName" v-model="doctorFacilityInfo.officeName"/>
       </div>


    <div class="form-input-group">
        <label for="streetAddress">Street:</label>
        <input type="text" id="streetAddress" v-model="doctorFacilityInfo.streetAddress"/>
      </div>

      <div class="form-input-group">
        <label for="city">City:</label>
        <input type="text" id="city" v-model="doctorFacilityInfo.city"/>
      </div>

      <div class="form-input-group">
        <label for="state">State:</label>
        <input type="text" id="state" v-model="doctorFacilityInfo.state"/>
      </div>

       <div class="form-input-group">
        <label for="zipCode">Zip:</label>
        <input type="text" id="zipCode" v-model="doctorFacilityInfo.zipCode" placeholder ="ex: 19702" />
      </div>

       <div class="form-input-group">
           <label for="phone">Phone Number:</label>
           <input type="text" id="phone" v-model="doctorFacilityInfo.phone" placeholder ="ex: (302) 999 - 9999"/>
       </div>

      <div class="form-input-group">
           <label for="openTime">Start Time:</label>
           <input type="time" id="openTime" v-model="doctorFacilityInfo.openTime" />
       </div>

       <div class="form-input-group">
           <label for="closeTime">Close Time:</label>
           <input type="time" id="closeTime" v-model="doctorFacilityInfo.closeTime"/>
       </div>
      <div class="form-input-group">
           <label for="openDays">Days Open:</label>
           <input type="text" id="openDays" v-model="doctorFacilityInfo.openDays" placeholder ="Monday - Friday"/>
      </div>
    
      
       

      <button type="submit">Update Information</button>
     
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";
// import OfficeInfo from "../components/OfficeInfo.vue";

export default {
  name: 'update-office-information',
  // components: {OfficeInfo},
  data() {
    return {
      
      doctorFacilityInfo: {
          id: 0,
          officeName:'',
          streetAddress: '',
    city: '',
    state: '',
    zipCode: '',
    phone: '',
    openTime: '',
    closeTime: '',
    openDays: ''
      }
    }
  },
  methods: {
    // getDoctorFacilityInfo, call updateOffice method
  getDoctorFacilityInfo() {
    

      authService.getOfficeDetail(0).then((response) => {
        if (response.status == 200) {
          this.doctorFacilityInfo = response.data;
        }
      });
    
   },
  updateOffice() {
    alert("hello")
   authService.updateOffice(this.doctorFacilityInfo).then((response) => {
         if (response.status == 200) {
           
           this.doctorFacilityInfo.push();
         }
      
   });
}

  },
  created() {
    this.getDoctorFacilityInfo();
    //this.updateOffice();
  }

}
  
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

</style>
}