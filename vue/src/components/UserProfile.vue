<template>
  <div>
      <form id="profile-form">
           <h1>Create Doctor Profile</h1>
          <div class="form-element">
            <label for="firstName">First Name:</label>
            <input id="firstName" type="text"  />
          </div>
          <div class="form-element">
            <label for="lastName">Last Name:</label>
            <input id="lastName" type="text"  />
          </div>
          <div class="form-element">
            <label for="address">Address:</label>
            <input id="address" type="text"  />
          </div>
          <div class="form-element">
            <label for="phoneNumber">Phone Number:</label>
            <input id="phoneNumber" type="text"  />
          </div>
          <div class="form-element">
            <label for="email">Email Address:</label>
            <input id="email" type="email"  />
          </div>
      
      
       <!-- <input
        type="checkbox"
        v-bind:checked="review.favorited"
        v-on:change="onFavoritedChange(review)"
      /> -->
   

          <div class="form-element">
            <label for="identificationNumber">NPI Number:</label>
            <input id="identificationNumber" type="text"  />
          </div>
          <div class="form-element">
            <label for="facility">Facility:</label>
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