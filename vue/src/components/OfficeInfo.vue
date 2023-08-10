<template>
  <div>
        <h2>Office Details</h2>
        <label id='facility-name'>{{facilityInfo.FacilityName}}</label>
        <label id='doctor-name'>{{facilityInfo.doctorName}}</label>
        <label id='address'>{{facilityInfo.Address}}</label>
        <label id='address'>{{facilityInfo.City}}</label>
        <label id='address'>{{facilityInfo.State}}</label>
         <label id='address'>{{facilityInfo.ZipCode}}</label>
          <label id='address'>{{facilityInfo.PhoneNumber}}</label>
        <label id='opening-hours'>{{facilityInfo.OpenTime}}</label>
        <label id='opening-hours'>{{facilityInfo.CloseTime}}</label>
        <label id='opening-days'>{{facilityInfo.OpenDays}}</label>
  </div>
</template>

<script>

export default {
    name:'office-info', 
    props:{
      facilityId:Object
    }
       
    ,
    data(){
      return{
        facilityInfo:{
          id: 0,
        doctorName: "",   
        FacilityName:"",
        Address: "",
        City:"",
        State:"",
        ZipCode :"",
        PhoneNumber: "",
        OpenTime:"",
        CloseTime:"",
        OpenDays:""

        }
      }
    },
     created(){
     this.facilityInfo =  
            this.$store.state.DoctorFacility.filter(facility => facility.id === this.facilityId); 
             alert(this.facilityId)  ;     
    }    
}
</script>

<style scoped>

</style>