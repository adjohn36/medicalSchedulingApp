<template>
  <div id="updateOfficeInfo" class="text-center">
    <form >
      <h1>Update Office Information</h1>
     <!-- <div role="alert" v-if="updateOfficeErrors">
        {{ updateOfficeErrorMsg }}
      </div> -->
      <office-info v-bind:doctorFacilityInfo="doctorFacilityInfo"/>
    <div class="form-input-group">
           <label for="facilityName">Facility Name:</label>
           <input type="text" id="facilityName" v-model="doctorFacilityInfo.facilityName"/>
       </div>


    <div class="form-input-group">
        <label for="officeStreet">Street:</label>
        <input type="text" id="officeStreet" v-model="doctorFacilityInfo.officeStreet"/>
      </div>

      <div class="form-input-group">
        <label for="officeCity">City:</label>
        <input type="text" id="officeCity" v-model="doctorFacilityInfo.officeCity"/>
      </div>

      <div class="form-input-group">
        <label for="officeState">State:</label>
        <input type="text" id="officeState" v-model="doctorFacilityInfo.officeState"/>
      </div>

       <div class="form-input-group">
        <label for="officeStateZipCode">Zip:</label>
        <input type="text" id="officeStateZipCode" v-model="doctorFacilityInfo.officeStateZipCode" placeholder ="ex: 19702" />
      </div>

       <div class="form-input-group">
           <label for="phoneNumber">Phone Number:</label>
           <input type="text" id="phoneNumber" v-model="doctorFacilityInfo.phoneNumber" placeholder ="ex: (302) 999 - 9999"/>
       </div>

      <div class="form-input-group">
           <label for="officeOpenTime">Start Time:</label>
           <input type="time" id="officeOpenTime" v-model="doctorFacilityInfo.officeOpenTime" />
       </div>

       <div class="form-input-group">
           <label for="officeCloseTime">Close Time:</label>
           <input type="time" id="officeCloseTime" v-model="doctorFacilityInfo.officeCloseTime"/>
       </div>
      <div class="form-input-group">
           <label for="openDays">Days Open:</label>
           <input type="text" id="openDays" v-model="doctorFacilityInfo.officeOpenDays" placeholder ="Monday - Friday"/>
      </div>
    
      
       

      <button type="submit" v-on:click="updateOffice()">Update Information</button>
     
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
          officeId: 0,
          facilityName:'',
          officeStreet: '',
          officeCity: '',
          officeState: '',
          officeStateZipCode: '',
          phoneNumber:'',
          officeOpenTime:'',
          officeCloseTime:'',
          openDays:''
      }
    }
  },
  methods: {
    // getDoctorFacilityInfo, call updateOffice method
  getDoctorFacilityInfo() {
    
    authService.updateOffice(this.officeId, this.doctorFacilityInfo).then((response) => {
        if (response.status == 200) {
          alert("hello")
          this.doctorFacilityInfo.push();
        }
      
  });
  }
  },

  created() {
    this.getDoctorFacilityInfo(this.$route.params.officeId);
    this.updateOffice();
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
