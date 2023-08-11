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
  <div class="office-info">
        <h2>Office Details</h2>
        <label id='facility-name'>{{facilityInfo.FacilityName}}</label>
        <br>
        <!-- <label id='doctor-name'>{{facilityInfo.doctorName}}</label> -->
        <br>
        <label id='address'>{{facilityInfo.Address}}</label>
        <br>
        <label id='city'>{{facilityInfo.City}}, </label>
        <label id='state'>{{facilityInfo.State}}  </label>
         <label id='Zipcode'>{{facilityInfo.ZipCode}}</label>
         <br>
         <br>
          <label id='phoneNumber'>{{facilityInfo.PhoneNumber}}</label>
          <br>
          <br>
          <label id='opening-days'>{{facilityInfo.OpenDays}}</label>
          <br>
        <label id='opening-hours'>{{facilityInfo.OpenTime}} - </label>
        <label id='closing-hours'>{{facilityInfo.CloseTime}}</label>
        
        
  </div>
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

.office-info {
  margin-left: 100px ;
}

</style>