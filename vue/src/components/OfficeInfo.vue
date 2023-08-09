<template>
  <div>
       <h1>Doctor Information</h1>   
        <div v-for="doctor in doctorFacilityInfo" v-bind:key="doctor.id" class="doctor-info">
          <div id="doc-info">{{doctor.doctorName}}</div>
          <div id="address">{{doctor.Address}}</div>
        </div>

      <!-- <tbody>
        <tr v-for="doctor in doctorFacilityInfo" v-bind:key="doctor.id" >
            <td>{{doctor.doctorName}}</td>
            <td>{{doctor.City}}</td>
            <td>{{doctor.State}}</td>
            <td>{{doctor.ZipCode}}</td>
        </tr> 
      </tbody> -->
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

<style>
.doctor-info{
  border-bottom: 1px solid #e3e3e3;
  border-top: 1px solid #e3e3e3;
  height: 100px;
  display: flex;
  flex-direction: row;

}
#doc-info{
  justify-content: left;
}
#address{
  justify-content: right;
}
</style>