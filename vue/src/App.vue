<template>
  <div id="app">
    <header class="header-content">
      <!-- <img id="mainLogo" src="./img/SmartBookingLogo.png" alt="SmartBookingLogo" /> -->
      <div id="nav" >     
        <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
    </header>
    <main class="main-view">
      <router-view />
    </main>
    
  </div>
</template>

<style scoped>
  #app {     
    height: auto;
    width: 100vw;
    background-color: rgb(177, 212, 248);   
    background-size: contain;
  }
#mainLogo{
  height: 220px;
  width: 220px;
  padding-right: 20px;
}
#nav{    
  text-align: right;
  padding: 20px 30px;
}
</style>