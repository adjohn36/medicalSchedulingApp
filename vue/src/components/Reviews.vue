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
            <li><router-link to="/reviews">Reviews</router-link></li>
          </ul>
        </div>
      </nav>
    </div>
    <div class="content">
      <h1>Doctor Reviews</h1>
      <div v-for="review in reviews" :key="review.id" class="review-card"> 
        <div class="review-details">
          <!-- <h2>{{ review. }}</h2> -->
          <!-- <p>Reviewed by: {{ review.reviewer }}</p>
          <p>Rating: {{ review.rating }}/5</p>
          <p>{{ review. }}</p> -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>


export default {
  name: 'Reviews',
  data() {
    return {
    };
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
  background-color: #A1DE81;
  width: 100%;
  padding: 0px 0;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
}

.content {
  background-color: #ffffff;
  padding: 10px 20px;
  width: 100%;
  max-width: 1500px;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
  margin-top: 20px;
}
</style>
