<template>
  <div class="container">
    <div class="wrapper">
      <div class="sblogo">
        <img src="../img/NavBarLogo.png" alt="sblogo">
      </div>
      <h2>Please Login</h2>
      <form @submit.prevent="login">
        <div class="form-group">
          <label for="username">Username:</label>
          <div class="row">
            <i class="fas fa-user"></i>
            <input type="text" id="username" v-model="user.username" class="form-control" required>
          </div>
        </div>
        <div class="form-group">
          <label for="password">Password:</label>
          <div class="row">
            <i class="fas fa-lock"></i>
            <input type="password" id="password" v-model="user.password" class="form-control" required>
          </div>
        </div>
        <div class="form-group">
          <div class="row button">
            <button type="submit" class="btn btn-primary">Login</button>
          </div>
        </div>
        <div class="form-group signup-link">
          Don't have an account? <router-link to="/register">Signup now</router-link>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  data() {
    return {
      user: {
        username: "",
        password: ""
      }
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push('/processing');
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            // Handle invalid credentials
          }
        });
    }
  }
};
</script>

<style scoped>
/* Your existing CSS styles */
.container{
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
}
.form-group {
  margin-top: 15px;
}

.h2 {
  font-size: 30px;
  text-align: center;
  margin-bottom: 20px;
}

.row {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}

.row i {
  font-size: 18px;
  margin-right: 10px;
  color: #333;
}

.row input {
  flex-grow: 1;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.button {
  text-align: center;
  margin-top: 20px;
}

.button button {
  background-color: #007bff;
  color: white;
  padding: 10px 30px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 15px;
  margin-left: 10px;
}

.sblogo {
  text-align: center;
  margin-bottom: 20px;
}

.sblogo img {
  width: 300px;
  height: auto;
}
</style>
