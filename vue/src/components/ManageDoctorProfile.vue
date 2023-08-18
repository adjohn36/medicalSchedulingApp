<template>
  <div class="container">
    <div class="header">
      <nav>
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
    <div class="form-container">
      <form id="profile-form" @submit.prevent="saveDoctorProfile">
        <h1 class="page-title">Create Doctor Profile</h1>
        <div class="form-element">
          <label for="firstName">First Name:</label>
          <input
            id="firstName"
            type="text"
            class="form-input"
            v-model="doctor.doctorProfile.doctorFirstName"
          />
        </div>
        <div class="form-element">
          <label for="lastName">Last Name:</label>
          <input
            id="lastName"
            type="text"
            class="form-input"
            v-model="doctor.doctorProfile.doctorLastName"
          />
        </div>
        <div class="form-element">
          <label for="email">Email Address:</label>
          <input
            id="email"
            type="email"
            class="form-input"
            v-model="doctor.doctorProfile.doctorEmail"
          />
        </div>
        <div class="form-element">
          <label for="facility-input">Facility:</label>
          <select
            id="facility-input"
            class="form-input"
            v-model="facility"
          >
            <option
              v-for="office in officeList"
              :key="office.id"
              :value="office.id"
            >
              {{ office.officeName }}
            </option>
          </select>
        </div>
        <div class="form-element button">
          <button class="submit-button" type="submit">Save</button>
        </div>
      </form>
    </div>
  </div>
</template>


<script>
import authService from "../services/AuthService";

export default {
  name: "manage-doctor-profile",
  data() {
    return {
      errors: false,
      message: "",
      facility: "",
      officeList: [
        {
          id: 0,
          officeName: "",
        },
      ],
      doctor: {
        isDoctor: false,
        doctorProfile: {
          doctorFirstName: "",
          doctorLastName: "",
          doctorEmail: "",
        },
        officeId: "",
      },
    };
  },
  methods: {
    getOfficeList() {
      authService
        .getOfficeList()
        .then((response) => {
          if (response.status === 200) {
            this.officeList = response.data;
          }
        })
        .catch((error) => {
          const response = error.response;
          this.errors = true;
          if (response.status === 400) {
            this.errorMsg = "Bad Request: Validation Errors";
          }
        });
    },

    saveDoctorProfile() {
      this.doctor.isDoctor = this.$store.state.isDoctor;
      this.doctor.officeId = this.facility;

      authService
        .updateDoctorProfile(this.doctor)
        .then((response) => {
          if (response.status === 200) {
            (this.errors = false), (this.message = "Successfully Updated.");
          }
        })
        .catch((error) => {
          const response = error.response;
          this.errors = true;
          if (response.status === 400) {
            this.message = "Bad Request: Validation Errors";
          }
        });

      this.clear();
    },

    clear() {
      (this.doctor.isDoctor = false),
        (this.doctor.doctorProfile.doctorLastName = "");
      this.doctor.doctorProfile.doctorFirstName = "";
      this.doctor.doctorProfile.doctorEmail = "";
      this.doctor.officeId = "";
      this.facility = "";
    },
  },

  created() {
    this.getOfficeList();
  },
};
</script>

<style scoped>
.row {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}
.button {
  text-align: center;
}
.form-container {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  background-color: #ffffff;
  border-radius: 5px;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
}

.page-title {
  font-size: 24px;
  color: #4070f4;
  margin-bottom: 20px;
}

.form-element {
  margin-bottom: 20px;
}

.form-input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.submit-button {
  background-color: #4070f4;
  color: #ffffff;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.submit-button:hover {
  background-color: #3358c9;
}

.nav-content {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 15px;
}

.logo img {
  display: block;
}

.welcome-title {
  color: #0d1fe0;
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

.form-element {
  margin-bottom: 20px;
  display: flex;
  align-items: center;
}

.form-element label {
  margin-right: 10px;
}

.button {
  text-align: center;
}
</style>