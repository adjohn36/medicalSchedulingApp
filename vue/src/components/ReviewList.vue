<template>
  <div class="container">
    <nav v-show="this.$store.state.isDoctor === true">
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
    <div class="row">
      <div class="col-md-8 course-details-content">
        <div class="course-details-card mt--40">
          <div class="course-content">
            <h5 class="mb--20">Review</h5>
            <div class="row row--30">
              <div class="col-lg-4">
                <div class="rating-box">
                  <div class="rating-number">5.0</div>
                  <div class="rating">
                    <i class="fa fa-star" aria-hidden="true"></i>
                    <i class="fa fa-star" aria-hidden="true"></i>
                    <i class="fa fa-star" aria-hidden="true"></i>
                    <i class="fa fa-star" aria-hidden="true"></i>
                    <i class="fa fa-star" aria-hidden="true"></i>
                  </div>
                  <span>(25 Review)</span>
                </div>
              </div>
              <div class="col-lg-8">
                <div class="review-wrapper">
                  <!-- Your rating progress bars here -->
                </div>
              </div>
            </div>
            <div class="comment-wrapper pt--40">
              <div class="section-title">
                <h5 class="mb--25">Reviews</h5>
              </div>
              <!-- Comment boxes -->
              <div
                class="edu-comment"
                v-for="review in reviewList"
                :key="review.reviewId"
              >
                <div class="thumbnail">
                  <img src="../img/patient.png" alt="Comment Images" class="patient-image"> 
                </div>
                <div class="comment-content">
                  <div class="comment-top">
                    <h6 class="title">{{ review.reviewer }}</h6>
                    <div class="rating">
                      <i
                        v-for="star in fullStars(review.reviewRating)"
                        :key="star"
                        class="fa fa-star"
                        aria-hidden="true"
                      ></i>
                    </div>
                  </div>
                  <span class="subtitle">{{ review.reviewTitle }}</span>
                  <p>{{ review.reviewContent }}</p>
                </div>
              </div>
            </div>
          </div>
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
      console.log("Is the user a doctor?", this.$store.state.isDoctor);
      if (this.$store.state.isDoctor === true) {
        console.log("doctor hit");
        authService.getOfficeInfoById(this.officeId).then((response) => {
          console.log("response info", response.data);
          this.officeId = response.data.id;
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
  },
  computed: {
    // define the computed property
    fullStars() {
      return function (reviewRating) {
        return new Array(parseInt(reviewRating)).fill();
      };
    },
  },
  created() {
    this.isDoctor = this.$store.state.isDoctor;
    this.getReviewList();
  },
};
</script>

<style scoped>
* {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}
article,
aside,
details,
figcaption,
figure,
footer,
header,
nav,
section,
summary {
  display: block;
}
audio,
canvas,
video {
  display: inline-block;
}
audio:not([controls]) {
  display: none;
  height: 0;
}
[hidden] {
  display: none;
}
a {
  color: #231f40;
  text-decoration: none;
  outline: none;
}
a:hover,
a:focus,
a:active {
  text-decoration: none;
  outline: none;
  color: #525fe1;
}
a:focus {
  outline: none;
}
address {
  margin: 0 0 24px;
}
abbr[title] {
  border-bottom: 1px dotted;
}
b,
strong {
  font-weight: bold;
}
p {
  font-size: 16px;
  line-height: 1.63;
  font-weight: 500;
  color: #6f6b80;
  margin: 0 0 30px;
}
h5,
.h5 {
  font-weight: 700;
}
.mt--40 {
  margin-top: 40px !important;
}
.mb--20 {
  margin-bottom: 20px !important;
}
.pt--40 {
  padding-top: 40px !important;
}
.mb--25 {
  margin-bottom: 25px !important;
}
.fa-star {
  color: #ffa41b;
}
.course-details-card {
  border-radius: 8px;
  border: 1px solid #eeeeee;
  padding: 30px;
}
.course-details-card .course-details-two-content p:last-child {
  margin-bottom: 0;
}
.row--30 {
  margin-left: -30px;
  margin-right: -30px;
}
.row--30 > [class*="col"],
.row--30 > [class*="col-"] {
  padding-left: 30px;
  padding-right: 30px;
}
.course-details-content .rating-box {
  background: #ffffff;
  box-shadow: 0px 10px 25px rgba(0, 0, 0, 0.07);
  border-radius: 5px;
  text-align: center;
  min-width: 200px;
  padding: 29px 10px;
}
.course-details-content .rating-box .rating-number {
  font-weight: 800;
  font-size: 72px;
  line-height: 90px;
  color: #231f40;
}
.course-details-content .rating-box span {
  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
}
.course-details-content .course-tab-content {
  margin-top: 40px;
}
.course-details-content .rating-box {
  background: #ffffff;
  box-shadow: 0px 10px 25px rgba(0, 0, 0, 0.07);
  border-radius: 5px;
  text-align: center;
  min-width: 200px;
  padding: 29px 10px;
}
.course-details-content .rating-box .rating-number {
  font-weight: 800;
  font-size: 72px;
  line-height: 90px;
  color: #231f40;
}
.course-details-content .rating-box span {
  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
}
.review-wrapper .single-progress-bar {
  position: relative;
}
.review-wrapper .rating-text {
  display: inline-block;
  position: relative;
  top: 19px;
}
.review-wrapper .progress {
  max-width: 83%;
  margin-left: 38px;
  height: 12px;
  background: #eeeeee;
}
.review-wrapper .progress .progress-bar {
  background-color: #ffa41b;
}
.review-wrapper span.rating-value {
  position: absolute;
  right: 0;
  top: 50%;
}
.edu-comment {
  display: flex;
}
.edu-comment .thumbnail {
  min-width: 70px;
  width: 70px;
  max-height: 70px;
  border-radius: 100%;
  margin-right: 25px;
}
.edu-comment .thumbnail img {
  border-radius: 100%;
  width: 100%;
}
.edu-comment .comment-content .comment-top {
  display: flex;
  align-items: center;
}
.edu-comment .comment-content .title {
  font-weight: 700;
  font-size: 20px;
  line-height: 32px;
  margin-bottom: 10px;
  margin-right: 15px;
}
.edu-comment .comment-content .subtitle {
  font-weight: 700;
  font-size: 16px;
  line-height: 26px;
  display: block;
  margin-bottom: 10px;
  color: #231f40;
}
.edu-comment + .edu-comment {
  border-top: 1px solid #eeeeee;
  padding-top: 30px;
  margin-top: 30px;
}
</style>
