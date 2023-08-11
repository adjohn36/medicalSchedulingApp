<template>
  <div>
    <nav :class="{'sticky': isSticky}">
      <div class="nav-content">
        <div class="logo">
          <a href="#">
            <img src="../img/NavBarLogo.png" alt="Logo">
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
    <!-- <div id="nav-for-patient">
      <router-link to="/book-appointment">Book Appointment</router-link>&nbsp;|&nbsp;
      <router-link to="/manage-appointments">Manage Appointments</router-link>&nbsp;|&nbsp;
      <router-link to="/profile">Manage Profile</router-link>&nbsp;|&nbsp;
    </div> -->
    <h1>Doctor Information</h1>
    <div v-for="facility in doctorFacilityInfo" :key="facility.id" class="doctor-info">
      <div class="doctor-details">
        <span>{{ facility.doctorName }}</span>
        <img src="../img/doctorImage.png" alt="Doctor Image" class="doctor-image">
        <div class="row button">
          <router-link :to="{ name: 'office-info', params: { id: facility.id } }">
            <button>View Office Details</button>
          </router-link>
        </div>
      </div>

      <div class="address">
        {{ facility.Address }}
        <br>
        <span>{{ facility.City }},</span>&nbsp;
        <span>{{ facility.State }}</span>&nbsp;
        <span>{{ facility.ZipCode }}</span>
      </div>
    </div>
  </div>
</template>

<script>


export default {
   
    name: 'doctor-info',
    data(){
        return{
            doctorFacilityInfo:[]
        }        
    },
    created(){
       this.doctorFacilityInfo =  
            this.$store.state.DoctorFacility;        
    }
}
</script>

<style scoped>
    .doctor-info{
  border: 1px solid #e3e3e3;  
  height: 200px;
  display: flex;
  flex-direction: row;
  margin-left: 10px;
  margin-right: 10px;
}
#doc-facility-info{ 
  text-align: left;
  flex-grow: 1;
  margin-left: 20px;
  margin-top: 10px;
}
.address{
  text-align: right;
  flex-grow: 1;
  margin-right: 20px;
  margin-top: 10px;
}
h1{
  text-align: center;
  margin-bottom: 10px;
  padding: 50px;
}
p {
  display: block;
}

.button {
  text-align: center;
}

.button button {
  background-color: #007bff;
  color: white;
  padding: 10px 30px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 15px;
  display: flex;
  margin-left: 1px;
  flex-direction: row;
}
.doctor-details {
  display: flex;
  flex-direction: column;
  align-items: left;
}

.doctor-image {
  width: 100px; 
  height: auto;
  margin-top: 10px;
  padding: 10px;
}
</style>