<template>
  <div>
    <nav :class="{'sticky': isSticky}">
      <div class="nav-content">
        <div class="logo">
          <a href="#">
            <img src="../img/NavBarLogo.png" alt="Logo">
          </a>
        </div>
        <div class="nav-links">
          <div id="nav-for-doctor">
            <router-link >Schedule Availability</router-link>&nbsp; &nbsp;
            <router-link v-bind:to="{ name: 'update-office-info' }">Update Office Info</router-link>&nbsp;&nbsp;
            <router-link v-bind:to="{ name: 'profile' }">Manage Profile</router-link>&nbsp;&nbsp;
          </div>
        </div>
      </div>
    </nav>
    <div class="upcoming-appointments">
      <h2>Upcoming Appointments</h2>
      <ul class="appointment-list">
        <li v-for="appointment in upcomingAppointments" :key="appointment.id">
          <div class="appointment-details">
            <div class="patient-name">{{ appointment.patientName }}</div>
            <div class="appointment-time">{{ appointment.time }}</div>
          </div>
          <button class="cancel-button" @click="cancelAppointment(appointment.id)">Cancel</button>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'upcoming-appointment',
  data() {
    return {
      isSticky: false,
      upcomingAppointments: [
        { id: 1, patientName: "John Doe", time: "10:00 AM" },
        { id: 2, patientName: "Jane Smith", time: "11:00 AM" },
        // ... sample data will be removed
      ],
    };
  },
  methods: {
    cancelAppointment(appointmentId) {
      // Simulate appointment cancellation logic 
      //make API request
      console.log("Canceling appointment ID:", appointmentId);
    },
  },
  created() {
    window.addEventListener("scroll", this.handleScroll);
  },
  beforeDestroy() {

window.removeEventListener("scroll", this.handleScroll);
  },
    handleScroll() {
      this.isSticky = window.scrollY > 20;
  },
};
</script>

<style scoped>


.nav-links a {
  text-decoration: none;
  color: #0E2431;
  font-size: 18px;
  font-weight: 500;
  padding: 10px 4px;
  transition: all 0.3s ease;
}

.nav-links a:hover {
  color: #4070f4;
}

.nav-links a.router-link-active {
  color: #4070f4;
}

.upcoming-appointments {
  max-width: 600px;
  margin:  auto;
  padding: 10px;
  margin-top: 100px;
}

.appointment-list {
  list-style: none;
  padding: 0;
}

.appointment-list li {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 10px;
  border: 1px solid #ccc;
  margin-bottom: 10px;
}

.appointment-details {
  display: flex;
  flex-direction: column;
}

.patient-name {
  font-weight: bold;
}

.cancel-button {
  background-color: #ff6b6b;
  color: white;
  border: none;
  padding: 5px 10px;
  cursor: pointer;
}
</style>
