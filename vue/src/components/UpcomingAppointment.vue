<template>
  <div class="container">
    <nav :class="{'sticky': isSticky}">
      <div class="nav-content">
        <div class="logo">
          <a href="#">
            <img src="../img/NavBarLogo.png" alt="Logo">
          </a>
        </div>
        <ul class="nav-links">
          <li><router-link to="/schedule-availability">Schedule Availability</router-link></li>
          <li><router-link to="/update-office-info">Update Office Info</router-link></li>
          <li><router-link to="/manage-profile">Manage Profile</router-link></li>
        </ul>
      </div>
    </nav>
    <div class="content">
      <h2>Upcoming Appointments</h2>
      <ul class="appointment-list">
        <li v-for="appointment in upcomingAppointments" :key="appointment.id" class="appointment-item">
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
  name: 'UpcomingAppointments',
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
      // Make API request
      console.log("Canceling appointment ID:", appointmentId);
    },
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
  padding: 20px 0;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
}

.content {
  background-color: #ffffff;
  padding: 10px 20px;
  width: 100%;
  max-width: 1500px;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
  margin-top: 20px;
}

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
