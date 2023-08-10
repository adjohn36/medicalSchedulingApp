<template>
  <div>
      <div id="nav-for-patient" >
        <router-link >Book Appointment</router-link>&nbsp;|&nbsp;
        <router-link >Manage Appointments</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'profile' }">Manage Profile</router-link>&nbsp;|&nbsp;
     </div>
     <h1>Doctor Information</h1>   
        <div v-for="facility in doctorFacilityInfo" v-bind:key="facility.id" class="doctor-info">
          <!-- <div id="doc-info">{{facility.doctorName}}</div> -->
          <router-link id="doc-facility-info" v-bind:to="{name: 'office-info',params: {id:facility.id}}" 
             >{{facility.doctorName}}
             <!-- <office-info v-bind:facilityInfo="facility" /> -->
             </router-link>
          <div id="address">{{facility.Address}}</div>
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
  height: 100px;
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