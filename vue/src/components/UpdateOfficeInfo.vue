<template>
  <div id="updateOfficeInfo" class="text-center">
    <form >
      <h1>Update Office Information</h1>
     <!-- <div role="alert" v-if="updateOfficeErrors">
        {{ updateOfficeErrorMsg }}
      </div> -->
    <div class="form-input-group">
        <label for="firstName">First Name</label>
        <input type="text" id="firstName" />
      </div>
    <div class="form-input-group">
        <label for="lastName">Last Name</label>
        <input type="text" id="lastName" />
      </div>
       <div class="form-input-group">
           <label for="location">Location</label>
           <input type="text" id="location"/>
       </div>
       <div class="form-input-group">
           <label for="phoneNumber">Phone Number</label>
           <input type="text" id="phoneNumber"/>
       </div>

      <div class="form-input-group">
           <label for="officeHours">Office Hours</label>
           <input type="text" id="officeHours"/>
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
        firstName: '',
        lastName: '',
        location: '',
        phoneNumber: '',
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
