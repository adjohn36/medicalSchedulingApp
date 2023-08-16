<template>
  <div class="container">
    <div class="header">
      <nav>
        <div class="nav-content">
          <div class="logo">
            <a href="#">
              <img src="../img/NavBarLogo.png" alt="Logo">
            </a>
          </div>
          <div class="welcome-title">
            <h1>Welcome to Your Doctor Portal</h1>
          </div>
          <ul class="nav-links">
          <li><router-link to="/schedule-availability">Update My Availability</router-link></li>
          <li><router-link to="/update-office-info">Update Office Info</router-link></li>
          <li><router-link v-bind:to="{name:'doctor-profile'}">My Doctor Profile</router-link></li>
          <li><router-link to="/reviews">My Reviews</router-link></li>
        </ul>
      </div>
    </nav>
    </div>
    <div class="content">
      <h2 class="page-title">Upcoming Appointments</h2>
      <ul class="appointment-list">
        <li v-for="appointment in upcomingAppointments" :key="appointment.id" class="appointment-item">
          <div class="appointment-details">
            <div class="patient-name">{{ appointment.patientName }}</div>
            <div class="appointment-date">{{ formatDate(appointment.date) }}</div>
            <div class="appointment-time">{{ appointment.time }}</div>
          </div>
          <!-- <button class="cancel-button" @click="cancelAppointment(appointment.id)">Cancel</button> -->
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
// import AuthService from '../services/AuthService';

export default {
  name: 'UpcomingAppointments',
  data() {
    return {
      upcomingAppointments: [],
    };
  },
  methods: {
    formatDate(date) {
      const options = { year: 'numeric', month: 'long', day: 'numeric'};
      return new Date(date).toLocaleDateString(undefined, options);
    },
    // cancelAppointment(appointmentId) {
    //   // Simulate appointment cancellation logic
    //   // Make API request
    //   console.log("Canceling appointment ID:", appointmentId);
    // },
  created() {
    window.addEventListener("scroll", this.handleScroll);
  },
  beforeDestroy() {
    window.removeEventListener("scroll", this.handleScroll);
  },
  },
};
</script>


<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 150vh;
}

.header {
  background-color: #A1DE81;
  width: 100%;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
  /* border: 1px solid white */
}

.content {
  background-color: #ffffff;
  padding: 10px 20px;
  width: 100%;
  max-width: 1500px;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
  margin-top: 20px;
  border: 1px solid white

}

.nav-links {
  text-decoration: none;
  color: #0E2431;
  font-size: 18px;
  font-weight: 500;
  padding: 10px 4px;
  transition: all 0.3s ease;
  /* border: 1px solid white */
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
.welcome-title {
  color: #0D1FE0;
}
</style>
