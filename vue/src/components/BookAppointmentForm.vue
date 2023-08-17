<template>
  <div class="appointment-form">
    <div class="sblogo">
      <img src="../img/NavBarLogo.png" alt="sblogo" />
    </div>
    <h2>Book an Appointment</h2>
    <form @submit.prevent="submitAppointment">
      
      <div class="profile-card"></div>
      <div class="form-group">
        <label for="doctor">Choose a Doctor:</label>
        <select id="doctor" v-model="selectedDoctor" class="form-control">
          <option v-for="doctor in doctorList" :key="doctor.id" :value="doctor.id">
            {{ doctor.doctorFirstName }} {{ doctor.doctorLastName }}
          </option>
        </select>
      </div>

      <div class="form-group">
        <label for="date">Choose a Date:</label>
        <input
          type="date"
          id="date"
          v-model="selectedDate"
          class="form-control"
          required
        />
      </div>

      <div class="form-group">
        <label for="time">Choose a Time:</label>
        <select id="time" v-model="scheduleId" :disabled="!selectedDate">
          <option
            v-for="schedule in doctorSchedule"
            v-bind:key="schedule.scheduleId"
            v-bind:value="schedule.scheduleId"
          >
            {{ schedule.timeSlot }}
          </option>
        </select>
        <div v-if="selectedTime">
          <label for="reason">Reason for Visit:</label>
          <textarea
            id="reason"
            v-model="reasonForVisit"
            rows="4"
            required
          ></textarea>
        </div>
      </div>

      <button type="submit" class="btn btn-primary">Book Appointment</button>
    </form>
  </div>
</template>

<script>

import authService from "../services/AuthService";

export default {
  name: 'book-appointment',
  props: ["appointmentList"],
  data() {
    
    return {

      doctorList:[],
      doctorSchedule:[],
      selectedDate:null,
      scheduleId: null
    //  /*doctors: [
   //     { id: 1, name: 'Dr. Smith' },
   //     { id: 2, name: 'Dr. Johnson' },
    //    // Sample Data (will be removed)
    // ],
     // selectedDoctor: null,
    //  selectedDate: null,
    //  patientId: null,
    //  availableTimes: [
    //  ],*/
      //doctors: []
    }
  },
  methods: {
    getAvailableAppointments() {
      authService.getListBookAppointments()
        .then((response) => {
          if (response.status === 200) {
            alert('getAvailableAppointments');
            this.doctors = response.data;
          }
        });
    },
submitAppointment() {
  const appointmentDetails = { patientId: 1, doctorScheduleId: this.scheduleId, dateSelected:this.selectedDate};
  //alert('patientId -- ' + appointmentDetails.patientId);
  //alert('scheduleId -- ' + appointmentDetails.doctorScheduleId);
  //alert('selectedDate -- ' + appointmentDetails.dateSelected);
  authService.postBookAnAppointment(appointmentDetails).then((response) => {
        if (response.status == 200) {
          //alert('success');
          (this.errors = false), (this.message = "Successfully Updated.");
        }
      })
        .catch((error) => {
          //alert(error);
          const response = error.response;
          this.errors = true;
          if (response.status === 400) {
            this.errorMsg = "Bad Request: Validation Errors";
          }
        });
}
    // submitAppointment() {
    //   // Handle form submission and booking logic
    //   alert('in side submitAppointment');
    //   //this.doctors.selectedDate = "2023-8-20";
    //   //this.doctors.selectedDoctor = 1;
    //   //this.doctors.patientId =1;
    //   authService
    //     .postBookAnAppointment(this.doctors)
    //     .then((response) => {
    //       if (response.status === 200) {
    //         (this.errors = false), (this.message = "Successfully Posted.");
    //       }
    //     })
    //     .catch((error) => {
    //       const response = error.response;
    //       this.errors = true;
    //       if (response.status === 400) {
    //         this.message = "Bad Request: Validation Errors";
    //       }
    //     });
    // },
    
    

  /*watch: {
    selectedDoctor() {
      // reset selectedDate and availableTimes when doctor changes
      this.selectedDate = null;
      this.availableTimes = [];
    },
    selectedDate() {
      // grt available times for the selectedDoctor and selectedDate
      // and update the availableTimes array
    },
  }*/
  },
  created(){
  //alert('created');
  
      authService.getDoctorList().then((response) => {
        if (response.status == 200) {
          //alert(response);
          this.doctorList = response.data;
        }
      })
        .catch((error) => {
          const response = error.response;
          this.errors = true;
          if (response.status === 400) {
            this.errorMsg = "Bad Request: Validation Errors";
          }
        });
      authService.getListBookAppointments().then((response) => {
        if (response.status == 200) {
          //alert(response);
          this.doctorSchedule = response.data;
        }
      })
        .catch((error) => {
          const response = error.response;
          this.errors = true;
          if (response.status === 400) {
            this.errorMsg = "Bad Request: Validation Errors";
          }
        });
    //this.getAvailableAppointments();
    }
};
</script>

<style scoped>
/* Google Font Link */
@import url("https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&family=Ubuntu:wght@400;500;700&display=swap");
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
.appointment-form input {
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
.appointment-form label {
  display: block;
  margin-top: 10px;
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
</style>
