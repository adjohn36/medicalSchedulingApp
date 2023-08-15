<template>
  <div>
    <form id="profile-form" @submit.prevent="saveDoctorProfile">
      <h1>Create Doctor Profile</h1>
      <div class="form-element">
        <label for="firstName">First Name:</label>
        <input
          id="firstName"
          type="text"
          v-model="doctorProfile.doctorFirstName"
        />
      </div>
      <div class="form-element">
        <label for="lastName">Last Name:</label>
        <input
          id="lastName"
          type="text"
          v-model="doctorProfile.doctorLastName"
        />
      </div>
      <div class="form-element">
        <label for="address">Address:</label>
        <input id="address" type="text" v-model="doctorProfile.doctorAddress" />
      </div>
      <!-- <div class="form-element">
        <label for="phoneNumber">Phone Number:</label>
        <input id="phoneNumber" type="text" />
      </div> -->
      <div class="form-element">
        <label for="email">Email Address:</label>
        <input id="email" type="email" v-model="doctorProfile.doctorEmail" />
      </div>

      <!-- <input
        type="checkbox"
        v-bind:checked="review.favorited"
        v-on:change="onFavoritedChange(review)"
      /> -->

      <!-- <div class="form-element">
        <label for="identificationNumber">NPI Number:</label>
        <input id="identificationNumber" type="text" />
      </div> -->
      <div class="form-element">
        <label for="facility-input">Facility:</label>
        <select id="facility-input" v-model="facility">
          <option v-for="office in officeList" v-bind:key="office.id">
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
  name: "user-profile",
  data() {
    return {
      errors: false,
      message: "",
      facility: "",
      officeList: [
        {
          id: 1,
          officeName: "A",
        },
        {
          id: 2,
          officeName: "B",
        },
      ],
      doctorProfile: {
        officeId: "",
        isDoctor: false,
        doctorFirstName: "",
        doctorLastName: "",
        doctorEmail: "",
        doctorAddress: "",
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
      alert(this.$store.state.isDoctor);
      //this.doctorProfile.isDoctor = this.$store.state.isDoctor;
      authService
        .updateDoctorProfile(this.doctorProfile)
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
    },

    created() {
      this.getOfficeList();
    },
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