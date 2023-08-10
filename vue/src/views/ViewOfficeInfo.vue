<template>
  <div>
    <view-office-info v-bind:facilityId="parseLong($route.params.id)" />
    
  </div>
</template>

<script>

import ViewOfficeInfo from '../components/OfficeInfo.vue'

export default {
    name:'view-office-info',
    components:{        
        ViewOfficeInfo
    } 
}
</script>

<style>

</style>    