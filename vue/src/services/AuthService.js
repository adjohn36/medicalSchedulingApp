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
  }
  

}
