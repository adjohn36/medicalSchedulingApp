<template>
  <div>
    <nav :class="{ sticky: isSticky }">
      <div class="nav-content">
        <div class="logo">
          <a href="#">
            <img src="../img/NavBarLogo.png" alt="Logo" />
          </a>
        </div>
        <ul class="nav-links">
          <li><a href="#">Home</a></li>
          <li><a href="#">Find a doctor</a></li>
          <li><a href="#">About Us</a></li>
          <li><a href="#">Services</a></li>
          <li><a href="#">Login</a></li>
        </ul>
      </div>
    </nav>
    <div class="office-info">
      <h2>Office Details</h2>
      <label id="facility-name">{{ facilityInfo.officeName }}</label>
      <br />
      <label id="address">{{ facilityInfo.streetAddress }}</label>
      <br />
      <label id="city">{{ facilityInfo.city }}, </label>
      <label id="state">{{ facilityInfo.state }} </label>
      <label id="Zipcode">{{ facilityInfo.zipCode }}</label>
      <br />
      <br />
      <label id="phoneNumber">{{ facilityInfo.phone }}</label>
      <br />
      <br />
      <label id="opening-days">{{ facilityInfo.openDays }}</label>
      <br />
      <label id="opening-hours">{{ facilityInfo.openTime }} - </label>
      <label id="closing-hours">{{ facilityInfo.closeTime }}</label>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "office-info",
  props: ["facilityId"],
  data() {
    return {
      facilityInfo: {
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
    getFacilityInfo() {
      authService.getOfficeDetail(this.facilityId).then((response) => {
        if (response.status == 200) {
          this.facilityInfo = response.data;
        }
      });
    },
  },
  created() {
    this.getFacilityInfo();
  },
};
</script>

<style scoped>
.office-info {
  margin-left: 100px;
}
</style>