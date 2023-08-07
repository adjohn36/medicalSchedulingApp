<template>
  <div id="app">
    <div class="nav-content">
      <img id="mainLogo" src="./img/SmartBookingLogo.png" alt="SmartBookingLogo" />
      <div id="nav" >     
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
    </div>
    <router-view id="view"/>
  </div>
</template>

<style scoped>
  #app {    
    height: 100vh;
    background-color: rgb(76, 187, 150);   
  }
#mainLogo{
  height: 100px;
  width: 100px;
  padding-right: 20px;
}
.nav-content {
display: flex;
flex-direction: row;
justify-content: start;
padding: 10px 30px;
align-items: center;
}

#view{
  padding-left: 50px; 
}
</style>