<template>
  <div>
       <h1>View Upcoming Appointments</h1>
          <div id="nav-for-doctor">
              <router-link >Schedule Availability</router-link>&nbsp;|&nbsp;
            <router-link v-bind:to="{ name: 'update-office-info' }" >Update Office Info</router-link>&nbsp;|&nbsp;
            <router-link v-bind:to="{ name: 'profile' }">Manage Profile</router-link>&nbsp;|&nbsp;
          </div>
  </div>
</template>

<script>
export default {
    name:'upcoming-appointment'
}
</script>

<style>

</style>