<template>
  <div class="container1">
    <div class="header">
      <nav v-show="isDoctor">
        <div class="nav-content">
          <div class="logo">
            <a href="#">
              <img src="../img/NavBarLogo.png" alt="Logo" />
            </a>
          </div>
          <div class="welcome-title">
            <h1></h1>
          </div>
          <ul class="nav-links">
            <li><router-link to="/doctor-portal">My Agenda</router-link></li>
            <li>
              <router-link to="/schedule-availability"
                >Update My Availability</router-link
              >
            </li>
            <li>
              <router-link to="/update-office-info"
                >Update Office Info</router-link
              >
            </li>
            <li>
              <router-link v-bind:to="{ name: 'doctor-profile' }"
                >My Doctor Profile</router-link
              >
            </li>
            <li><router-link to="/reviews">My Reviews</router-link></li>
          </ul>
        </div>
      </nav>
    </div>
    <div class="reviews">
      <h2>My Office Reviews</h2>
      <div
        v-for="review in reviewList"
        :key="review.reviewId"
        class="review-card"
      >
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
          <span
            class="star"
            v-for="n in Math.round(review.reviewRating)"
            :key="n"
          >
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
  props: ["facilityId"],
  data() {
    return {
      reviewList: [],
      isDoctor: false,
      officeId: 0,
      reviewInfo: {
        reviewId: 0,
        reviewer: "",
        officeId: "",
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
    getReviewList() {
      console.log("Is the user a doctor?", this.$store.state.isDoctor)
      if (this.$store.state.isDoctor === true) {
        console.log("doctor hit");
        //get user id
        //get doctor id
        //get office id
        //**possibly doctor table?? */


        //call authservice to do the above ^

        
        //assign office ID here, should change 0 to something else:
        this.officeId = 0;


        //do not touch:
        authService.getOfficeDetail(this.officeId).then((response) => {
          if (response.status == 200) {
            authService
              .getReviewsByReviewedOffice(response.data.id)
              .then((response) => {
                if (response.status == 200) {
                  this.reviewList = response.data;
                }
              });
          }
        });
      } else {
        console.log("not a doctor hit");
        console.log("isprops working: ", this.facilityId);
        this.officeId = this.facilityId;
        authService.getOfficeDetail(this.officeId).then((response) => {
          if (response.status == 200) {
            console.log(response.data);
            console.log("office Id is: ", response.data.id);
            this.officeId = response.data.id;
            authService
              .getReviewsByReviewedOffice(this.officeId)
              .then((response) => {
               
                  this.reviewList = response.data;
                
              });
          }
        });
      }
    },
    // getAllReviews() {

    //     authService.getAllReviews().then((response) => {
    //       if (response.status == 200) {
    //         this.reviewList = response.data;

    //         }
    //     });
    //   },
  },
  created() {
    this.isDoctor = this.$store.state.isDoctor;
    this.getReviewList();
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
