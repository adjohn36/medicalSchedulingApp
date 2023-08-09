<template>
  <div class="home">
  <header>
     <img id="mainLogo" src="../img/SmartBookingLogo.png" alt="SmartBookingLogo" />      
  </header>
  <div>
     <h3>Links for Doctor</h3>
        <router-link >View Upcoming Appointments</router-link>&nbsp;|&nbsp;
        <router-link >Schedule Availability</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'update-office-info' }" >Update Office Info</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'profile' }">Manage Profile</router-link>&nbsp;|&nbsp;
         <h3>Links for Patient</h3>
        <router-link >Book Appointment</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'office-info' }">View Available Doctors</router-link>&nbsp;|&nbsp;
        <router-link >Manage Appointments</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'profile' }">Manage Profile</router-link>&nbsp;|&nbsp;
  </div>
   <main>
   </main>
   <footer>
    <!-- 
     
      <div class="column">
        <h2>Section 1</h2>
        <ul>
          <li v-for="item in section1Data" :key="item.Id">{{ item.Title }}</li>
        </ul>
      </div>

     
      <div class="column">
        <h2>Section 2</h2>
        <ul>
          <li v-for="item in section2Data" :key="item.Id">{{ item.Title }}</li>
        </ul>
      </div>

      
      <div class="column">
        <h2>Section 3</h2>
        <ul>
          <li v-for="item in section3Data" :key="item.Id">{{ item.Title }}</li>
        </ul>
      </div>
    </div> -->
   </footer>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "home",
  data() {
    return {
      section1Data: [],
      section2Data: [],
      section3Data: [],
    };
  },
  created() {
    this.fetchApiData();
  },
  methods: {
    fetchApiData() {
      axios
        .get("https://health.gov/myhealthfinder/api/v3/itemlist.json?Type=topic") 
        .then((response) => {
          const { Item } = response.data.Result.Items;
          // You can use Item array to divide the data into three sections.
          this.section1Data = Item.slice(0, 1);
          this.section2Data = Item.slice(10, 11);
          this.section3Data = Item.slice(20, 21);
        })
        .catch((error) => {
          console.error("Error fetching API data:", error);
        });
    },
  },
};
</script>

<style>
#mainLogo{
  height: 150px;
  width: 150px;
  padding-right: 20px;
  
}
.columns {
  display: flex;
  justify-content: space-between;
}

.column {
  flex: 1;
  margin: 10px;
  padding: 10px;
  border: 1px solid #ccc;
}
header #mainLogo{
  text-align: start;
}
</style>
