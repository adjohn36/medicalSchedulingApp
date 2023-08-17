
import axios from 'axios';
//axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
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
  getAllReviews(){
    return axios.get('/reviews/all')
  },
  getReviewsByReviewedOffice(officeId)
    return axios.get(`/reviews/all/${officeId}`)  
  },
  getListBookAppointments(){
    return axios.get('/agenda/listbookappointments')
  },
  postBookAnAppointment(appointment){
    return axios.post('/agenda/bookanappointment', appointment)
  },
  getDoctorList(){
  return axios.get('/doctors/all')

  },
  getReviewById(reviewId){
    return axios.get(`/reviews/${reviewId}`)
  },
  updateOffice(doctorFacilityInfo)
    return axios.put(`/office-info/update/${doctorFacilityInfo.officeId}`, doctorFacilityInfo)
  },

  getDoctorSchedule(doctorId){
    return axios.get(`/update-availability/${doctorId}`)
  }
}
