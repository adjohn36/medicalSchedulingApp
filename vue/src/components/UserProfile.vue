<template>
  <div>
      <form id="profile-form">
           <h1>Create Profile</h1>
          <div class="form-element">
            <label for="fullName">Full Name:</label>
            <input id="fullName" type="text"  />
          </div>
          <div class="form-element">
            <label for="address">Address:</label>
            <input id="address" type="text"  />
          </div>
          <div class="form-element">
            <label for="phoneNumber">Phone Number:</label>
            <input id="phoneNumber" type="number"  />
          </div>
          <div class="form-element">
            <label for="email">Email Address:</label>
            <input id="email" type="email"  />
          </div>
        <label for="isDoctor">A Doctor?</label>      
        <input id="isDoctor" type="checkbox" />
      
      
       <!-- <input
        type="checkbox"
        v-bind:checked="review.favorited"
        v-on:change="onFavoritedChange(review)"
      /> -->
   

          <div class="form-element">
            <label for="identificationNumber">NPI Number:</label>
            <input id="identificationNumber" type="number"  />
          </div>
          <div class="form-element">
            <label for="facility">Facilities:</label>
            <input id="facility" type="search"  />
          </div>
      </form>
      
  </div>
</template>

<script>
export default {
    name: 'user-profile'
}
</script>

<style>

</style>