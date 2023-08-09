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
    <footer>
    </footer> 
  </div>
</template>

<style scoped>
  #app {     
    height: 100vh;
    width: 100vw;
    background-color: rgb(177, 212, 248);   
  }
#mainLogo{
  height: 220px;
  width: 220px;
  padding-right: 20px;
}
.header-content {
/* display: flex;
flex-direction: row;
width: 100%; */
/* border-bottom: 1px solid #e3e3e3; */
}
#nav{  
  /* flex-grow: 1; */
  text-align: right;
  padding: 10px 10px;
}
.main-view{
  /* padding-left: 50px;  */
  text-align: center;
}
</style>