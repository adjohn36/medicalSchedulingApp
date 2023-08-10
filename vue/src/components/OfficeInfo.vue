<template>
  <div>
        <h2>Office Details</h2>
        <label id='facility-name'>{{facilityInfo.FacilityName}}</label>
        <label id='doctor-name'>{{facilityInfo.doctorName}}</label>
        <label id='address'>{{facilityInfo.Address}}</label>
        <label id='opening-hours'>{{facilityInfo.OpenTime}}</label>
        <label id='opening-days'>{{facilityInfo.OpenDays}}</label>
  </div>
</template>

<script>
export default {
    name:'office-info', 
    props:[
       'facilityId'
    ]
       
    ,
    data(){
      return{
        facilityInfo:[]
      }
    },
     created(){
       this.facilityInfo =  
            this.$store.state.DoctorFacility.filter(facility => facility.id === this.facilityId);        
    }

    
}
</script>

<style scoped>

</style>