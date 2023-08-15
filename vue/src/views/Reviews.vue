<template>
  <div>
    <Reviews v-bind:reviewId="parseInt($route.params.id)"/>
  </div>
</template>

<script>
import Reviews from '../components/Reviews.vue';

export default {
    name:'reviews',
    components:{
        Reviews
    }
}
</script>
