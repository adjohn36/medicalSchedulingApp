<template>
  <div>
    <form id="profile-form" @submit.prevent="saveDoctorProfile">
      <h1>Create Doctor Profile</h1>
      <div class="form-element">
        <label for="firstName">First Name:</label>
        <input
          id="firstName"
          type="text"
          v-model="doctor.doctorProfile.doctorFirstName"
        />
      </div>
      <div class="form-element">
        <label for="lastName">Last Name:</label>
        <input
          id="lastName"
          type="text"
          v-model="doctor.doctorProfile.doctorLastName"
        />
      </div>
      <div class="form-element">
        <label for="email">Email Address:</label>
        <input
          id="email"
          type="email"
          v-model="doctor.doctorProfile.doctorEmail"
        />
      </div>
      <div class="form-element">
        <label for="facility-input">Facility:</label>
        <select id="facility-input" v-model="facility">
          <option
            v-for="office in officeList"
            v-bind:key="office.id"
            v-bind:value="office.id"
          >
            {{ office.officeName }}
          </option>
        </select>
      </div>
      <div class="row button">
        <button type="submit">Save</button>
      </div>
    </form>
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
</style>