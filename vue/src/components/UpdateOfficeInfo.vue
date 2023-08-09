<template>
  <div id="updateOfficeInfo" class="text-center">
    <form >
      <h1>Update Office Information</h1>
     <!-- <div role="alert" v-if="updateOfficeErrors">
        {{ updateOfficeErrorMsg }}
      </div> -->

    <div class="form-input-group">
           <label for="facilityName">Facility Name</label>
           <input type="text" id="facilityName" v-model="doctorFacilityInfo.facilityName"/>
       </div>


    <div class="form-input-group">
        <label for="officeStreet">Street</label>
        <input type="text" id="officeStreet" v-model="doctorFacilityInfo.officeStreet"/>
      </div>

      <div class="form-input-group">
        <label for="officeCity">City</label>
        <input type="text" id="officeCity" v-model="doctorFacilityInfo.officeCity"/>
      </div>

      <div class="form-input-group">
        <label for="officeState">State</label>
        <input type="text" id="officeState" v-model="doctorFacilityInfo.officeState"/>
      </div>

    

       <div class="form-input-group">
        <label for="officeStateZipCode">Zip</label>
        <input type="text" id="officeStateZipCode" v-model="doctorFacilityInfo.officeStateZipCode" />
      </div>

       <div class="form-input-group">
           <label for="phoneNumber">Phone Number</label>
           <input type="text" id="phoneNumber" v-model="doctorFacilityInfo.phoneNumber"/>
       </div>

      <div class="form-input-group">
           <label for="officeOpenTime">Start Time</label>
           <input type="text" id="officeOpenTime" v-model="doctorFacilityInfo.officeOpenTime"/>
       </div>

       <div class="form-input-group">
           <label for="officeCloseTime">Close Time</label>
           <input type="text" id="officeCloseTime" v-model="doctorFacilityInfo.officeCloseTime"/>
       </div>
    
      
       

      <button type="submit">Update Information</button>
     
    </form>
  </div>
</template>

<script>


export default {
  name: 'update-office-information',
  data() {
    return {
      doctorFacilityInfo: {
          facilityName:'',
          officeStreet: '',
          officeCity: '',
          officeState: '',
          officeStateZipCode: '',
          phoneNumber:'',
          officeOpenTime:'',
          officeCloseTime:''
          
      }
    }
  }
};
  
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

</style>
