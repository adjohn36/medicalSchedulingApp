<template>
  <div>
       <h1>Office Information</h1>
      <thead><tr>
      <th>
          Doctors Name
      </th>
        <th>
          Location
      </th>
      </tr>
      </thead>
      <tbody>
        <tr v-for="doctor in doctorFacilityInfo" v-bind:key="doctor.id" >
            <td>{{doctor.doctorName}}</td>
            <td>{{doctor.Address}}</td>
        </tr> 
      </tbody>
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

</style>