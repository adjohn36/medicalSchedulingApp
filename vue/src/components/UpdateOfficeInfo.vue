<template>
  <div class="container">
    <div class="header">
      <nav v-show="isDoctor">
        <div class="nav-content">
          <div class="logo">
            <a href="#">
              <img src="../img/NavBarLogo.png" alt="Logo" />
            </a>
          </div>
          <div class="welcome-title">
            <h1></h1>
          </div>
          <ul class="nav-links">
            <li><router-link to="/doctor-portal">My Agenda</router-link></li>
            <li>
              <router-link to="/schedule-availability"
                >Update My Availability</router-link
              >
            </li>
            <li>
              <router-link to="/update-office-info"
                >Update Office Info</router-link
              >
            </li>
            <li>
              <router-link v-bind:to="{ name: 'doctor-profile' }"
                >My Doctor Profile</router-link
              >
            </li>
            <li><router-link to="/reviews">My Reviews</router-link></li>
          </ul>
        </div>
      </nav>
    </div>
    <form v-on:submit.prevent="updateOffice" class="office-form">
      <h1>Update Office Information</h1>
      <office-info v-bind:doctorFacilityInfo="doctorFacilityInfo" />
      <div class="form-input-group">
        <label for="officeName">Facility Name:</label>
        <input
          type="text"
          id="officeName"
          v-model="doctorFacilityInfo.officeName"
        />
      </div>

      <div class="form-input-group">
        <label for="streetAddress">Street:</label>
        <input
          type="text"
          id="streetAddress"
          v-model="doctorFacilityInfo.streetAddress"
        />
      </div>

      <div class="form-input-group">
        <label for="city">City:</label>
        <input type="text" id="city" v-model="doctorFacilityInfo.city" />
      </div>

      <div class="form-input-group">
        <label for="state">State:</label>
        <input type="text" id="state" v-model="doctorFacilityInfo.state" />
      </div>

      <div class="form-input-group">
        <label for="zipCode">Zip:</label>
        <input
          type="text"
          id="zipCode"
          v-model="doctorFacilityInfo.zipCode"
          placeholder="ex: 19702"
        />
      </div>

      <div class="form-input-group">
        <label for="phone">Phone Number:</label>
        <input
          type="text"
          id="phone"
          v-model="doctorFacilityInfo.phone"
          placeholder="ex: (302) 999 - 9999"
        />
      </div>

      <div class="form-input-group">
        <label for="openTime">Start Time:</label>
        <input
          type="time"
          id="openTime"
          v-model="doctorFacilityInfo.openTime"
        />
      </div>

      <div class="form-input-group">
        <label for="closeTime">Close Time:</label>
        <input
          type="time"
          id="closeTime"
          v-model="doctorFacilityInfo.closeTime"
        />
      </div>
      <div class="form-input-group">
        <label for="openDays">Days Open:</label>
        <input
          type="text"
          id="openDays"
          v-model="doctorFacilityInfo.openDays"
          placeholder="Monday - Friday"
        />
      </div>

      <button type="submit">Update Information</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";
// import OfficeInfo from "../components/OfficeInfo.vue";

export default {
  name: "update-office-information",
  // components: {OfficeInfo},
  data() {
    return {
      doctorFacilityInfo: {
        id: 0,
        officeName: "",
        streetAddress: "",
        city: "",
        state: "",
        zipCode: "",
        phone: "",
        openTime: "",
        closeTime: "",
        openDays: "",
      },
    };
  },
  methods: {
    // getDoctorFacilityInfo, call updateOffice method
    getDoctorFacilityInfo(officeId) {
      authService.getOfficeDetail(officeId).then((response) => {
        if (response.status == 200) {
          this.doctorFacilityInfo = response.data;
        }
      });
    },
    updateOffice() {
      alert("hello");
      authService.updateOffice(this.doctorFacilityInfo).then((response) => {
        if (response.status == 200) {
          this.doctorFacilityInfo.push();
        }
      });
    },
  },
  created() {
    this.getDoctorFacilityInfo();
    //this.updateOffice();
  },
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: auto;
}
.header {
  background-color: #a1de81;
  width: 100%;
  padding: 0px 0;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
}
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
.office-form {
  background-color: #ffffff;
  border: 1px solid #ccc;
  padding: 20px;
  width: 100%;
  max-width: 800px;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
  margin-top: 20px;
}

.page-title {
  font-size: 24px;
  color: #4070f4;
  margin-bottom: 20px;
}

.form-input-group {
  margin-bottom: 12px;
}

.form-input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

button[type="submit"] {
  background-color: #007bff;
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
}

button[type="submit"]:hover {
  background-color: #0056b3;
}

.nav-content {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 15px;
}

.logo {
  padding: 0;
  margin: 0;
}

.logo img {
  display: block;
}

.nav-links {
  list-style: none;
  display: flex;
  align-items: center;
}

.nav-links li {
  margin: 0 8px;
}

.nav-links a {
  text-decoration: none;
  color: #0e2431;
  font-size: 18px;
  font-weight: 500;
  padding: 10px 4px;
  transition: all 0.3s ease;
}

.nav-links a:hover {
  color: #4070f4;
}
</style>}