<template>
  <div class="appointment-form">
    <div class="sblogo">
      <img src="../img/NavBarLogo.png" alt="sblogo">
    </div>
    <h2>Book an Appointment</h2>
    <form @submit.prevent="submitAppointment">
      <div class="form-group">
        <label for="doctor">Choose a Doctor:</label>
        <select id="doctor" v-model="selectedDoctor" class="form-control">
          <option v-for="doctor in doctors" :key="doctor.id" :value="doctor.id">
            {{ doctor.name }}
          </option>
        </select>
      </div>

      <div class="form-group">
        <label for="date">Choose a Date:</label>
        <input type="date" id="date" v-model="selectedDate" class="form-control" required>
      </div>

      <div class="form-group">
        <label for="time">Choose an Available Time:</label>
        <select id="time" v-model="selectedTime" :disabled="!selectedDate">
          <option v-for="time in availableTimes" :key="time" :value="time">
            {{ time }}
          </option>
        </select>
      </div>

      <div class="form-group">
        <label for="reason">Reason for Visit:</label>
        <textarea id="reason" v-model="reasonForVisit" rows="4" required></textarea>
      </div>

      <div class="button">
        <button type="submit" class="btn btn-primary">Book Appointment</button>
      </div>
    </form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      doctors: [
        { id: 1, name: 'Dr. Smith' },
        { id: 2, name: 'Dr. Johnson' },
        // Sample Data (will be removed)
      ],
      selectedDoctor: null,
      selectedDate: null,
      availableTimes: [
      ],
      reasonForVisit: ''
    };
  },
  methods: {
    submitAppointment() {
      // handles form submission and booking logic
    },
  },
  watch: {
    selectedDoctor() {
      // reset selectedDate and availableTimes when doctor changes
      this.selectedDate = null;
      this.availableTimes = [];
    },
    selectedDate() {
      // get available times for the selectedDoctor and selectedDate
      // and update the availableTimes array
    },
  },
};
</script>

<style scoped>
/* Google Font Link */
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&family=Ubuntu:wght@400;500;700&display=swap');
.appointment-form {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
}

.form-group {
  margin-top: 10px;
}

.appointment-form label {
  display: block;
  font-weight: bold;
}

.appointment-form select,
.appointment-form input,
.appointment-form textarea {
  width: 100%;
  padding: 10px;
  margin-top: 5px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.appointment-form button {
  display: block;
  width: 100%;
  padding: 10px;
  margin-top: 15px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.sblogo {
  text-align: center;
  margin-bottom: 20px;
}

.sblogo img {
  width: 300px;
  height: auto;
}
</style>
