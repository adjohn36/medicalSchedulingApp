<template>
  <div class="container">
    <div class="header">
      <nav>
        <div class="nav-content">
          <div class="logo">
            <a href="#">
              <img src="../img/NavBarLogo.png" alt="Logo">
            </a>
          </div>
          <div class="welcome-title">
            <h1></h1>
          </div>
          <ul class="nav-links">
            <li><router-link to="/patient-portal">Home</router-link></li>
            <li><router-link to="/book-appointment">Book An Appointment</router-link></li>
            <li><router-link to="/profile">My Patient Profile</router-link></li>
            <li><router-link to="/reviews">My Reviews</router-link></li>
          </ul>
        </div>
      </nav>
    </div>
    <div class="reviews">
      <h2>Reviews</h2>
      
      <tr v-for="review in reviewList" :key="review.reviewId" v-on:click:>
        <td>
          <label id="reviewer">{{ review.reviewer }}</label>
            <br/>
      </td>
      <td>
        <label id="office-name">{{ review.officeName }}</label>
      <br/>
      </td>
      <td>
          <label id="username">{{ review.username }} </label>
          <br/>
      </td>
      
      <td>
      <label id="rating">{{ review.reviewRating }} </label>
      <br/>
      </td>
      <td>
      <label id="title">{{ review.reviewTitle }}</label>
      <br/>
      </td>
      <td>
      <label id="phoneNumber">{{ review.reviewContent }}</label>
      <br/>
      </td>
      <td>
      <label id="review-date">{{ review.reviewDate }}</label>
      <br/>
      </td>
      </tr>
      </div>
  </div>
    
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "Reviews",
  props: "reviewId",
  data() {
    return {
      reviewList: [],

      reviewInfo: {
        reviewId: 0,
        reviewer: "",
        officeName: "",
        username: "",
        reviewRating: "",
        reviewTitle: "",
        reviewContent: "",
        reviewDate: "",
      },
    };
  },
  methods: {
    getReviewById() {
      authService.getReviewById(this.reviewId).then((response) => {
        if (response.status == 200) {
          this.reviewInfo = response.data;
        }
      });
    },
    getAllReviews() {
      
      authService.getAllReviews().then((response) => {
        if (response.status == 200) {
          this.reviewList = response.data;
          
          }
      });
    },
  },
  created() {
    
    this.getAllReviews();
  },
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  justify-content: top;
  align-items: center;
  height: 150vh;
}

.header {
  background-color: #a1de81;
  width: 100%;
  padding: 0px 0;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
}

.content {
  background-color: #ffffff;
  border: 1px;
  padding: 10px 20px;
  width: 100%;
  max-width: 1500px;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
  margin-top: 20px;
}
</style>
