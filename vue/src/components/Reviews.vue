<template>
  <div class="container1">
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
      <h2>My Office Reviews</h2>
      <div v-for="review in reviewList" :key="review.reviewId" class="review-card">
        <div class="review-info">
          <div class="reviewer">{{ review.reviewer }}</div>
          <div class="office-name">{{ review.officeName }}</div>
          <div class="username">{{ review.username }}</div>
          <div class="title">{{ review.reviewTitle }}</div>
          <div class="review-content">{{ review.reviewContent }}</div>
          <div class="review-date">{{ review.reviewDate }}</div>
        </div>
        <div class="rating">
          <div class="rating">{{ review.reviewRating }}</div>
          <span class="star" v-for="n in Math.round(review.reviewRating)" :key="n">
            &#9733;
          </span>
        </div>
      </div>
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
.container1 {
  display: flex;
  flex-direction: column;
  justify-content: top;
  align-items: center;
  height: auto;
}

.header {
  background-color: #a1de81;
  width: 100%;
  padding: 0px 0;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
}

.reviews {
  background-color: #ffffff;
  border: 1px;
  padding: 10px 20px;
  width: 100%;
  max-width: 1500px;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
  margin-top: 20px;
}

.review-card {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 10px;
  margin: 10px 0;
  background-color: #f8f8f8;
  box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
}

.review-info {
  padding: 10px;
}

.reviewer {
  font-weight: bold;
}
.reviews h2 {
  align-content: center;
}
.rating {
  color: #ff9800; 
  font-size: 20px;
}

.star {
  display: inline-block;
  margin-right: 3px; 
}

</style>
