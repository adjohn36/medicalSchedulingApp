<template>
  <div>
        <h2>Office Details</h2>
        <label id='facility-name'>{{facilityInfo.FacilityName}}</label>
        <label id='doctor-name'>{{facilityInfo.doctorName}}</label>
        <label id='address'>{{facilityInfo.Address}}</label>
        <label id='city'>{{facilityInfo.City}}</label>
        <label id='state'>{{facilityInfo.State}}</label>
         <label id='Zipcode'>{{facilityInfo.ZipCode}}</label>
          <label id='phoneNumber'>{{facilityInfo.PhoneNumber}}</label>
        <label id='opening-hours'>{{facilityInfo.OpenTime}}</label>
        <label id='closing-hours'>{{facilityInfo.CloseTime}}</label>
        <label id='opening-days'>{{facilityInfo.OpenDays}}</label>
  </div>
</template>

<script>

export default {
    name:'office-info', 
    props:['facilityId'],          
    data(){
      return{
        facilityInfo:{
          id: this.facilityId,
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
    methods:{
      getFacilityInfo(){
        this.facilityInfo = this.$store.state.DoctorFacility[this.facilityId-1];

        // this.facilityInfo = this.$store.state.DoctorFacility.filter((facility) => {
        //       return (facility.id === this.facilityId)              
        //       });        
      }
    },
      created(){
        this.getFacilityInfo();
        
    //  this.facilityInfo = this.$store.state.DoctorFacility.filter((facility) => {
    //           return (facility.id === this.facilityId)
              
    //           });           
    //           alert(this.facilityInfo.FacilityName)  ;     
    }    
}
</script>

<style scoped>

</style>