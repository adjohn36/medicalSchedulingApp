<template>
  <div>
     <div id="nav-for-patient" >
        <router-link >Book Appointment</router-link>&nbsp;|&nbsp;
        <router-link >Manage Appointments</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'profile' }">Manage Profile</router-link>&nbsp;|&nbsp;
     </div>
     <h1>Doctor Information</h1>   
        <div v-for="doctor in doctorFacilityInfo" v-bind:key="doctor.id" class="doctor-info">
          <div id="doc-info">{{doctor.doctorName}}</div>
          <div id="address">{{doctor.Address}}</div>
        </div>     
  </div>
</template>

<script>
export default {
    name:'office-info', 
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
  height: 100px;
  display: flex;
  flex-direction: row;
  margin-left: 10px;
  margin-right: 10px;
}
#doc-info{ 
  text-align: left;
  flex-grow: 1;
  margin-left: 20px;
  margin-top: 10px;
}
#address{
  text-align: right;
  flex-grow: 1;
  margin-right: 20px;
  margin-top: 10px;
}
h1{
  text-align: center;
}
</style>