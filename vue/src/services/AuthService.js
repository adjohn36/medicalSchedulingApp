import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },
  getUserProfile(){
    return axios.get('/profile')
  },
  getDoctorOfficeInfo(){
    return axios.get('/doctors/view-doctor')
  },
  getOfficeDetail(officeId){
    return axios.get(`/office-info/${officeId}`)
  },
  getOfficeList(){
    return axios.get('/office-info/all')
  },
  updateDoctorProfile(profile){
    return axios.post('/save-profile', profile)
  },
  updatePatientProfile(profile){
    return axios.post('/save-profile', profile)
  },
  getDoctorSchedule(day){    
    return axios.get(`/update-availability/schedule?dayOfTheWeek=${day}`)
  },
  getAllReviews(){
    return axios.get('/reviews/all')
  },
  getReviewById(reviewId){
    return axios.get(`/reviews/${reviewId}`)
  },
  updateOffice(doctorFacilityInfo){
    return axios.put(`/office-info/update/${doctorFacilityInfo.officeId}`, doctorFacilityInfo)
  }
  

}
