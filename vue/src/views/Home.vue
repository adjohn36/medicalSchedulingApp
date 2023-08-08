<template>
  <div class="home">
    <div class="columns">
      <!-- Section 1 Data -->
      <div class="column">
        <h2>Section 1</h2>
        <ul>
          <li v-for="item in section1Data" :key="item.Id">{{ item.Title }}</li>
        </ul>
      </div>

      <!-- Section 2 Data -->
      <div class="column">
        <h2>Section 2</h2>
        <ul>
          <li v-for="item in section2Data" :key="item.Id">{{ item.Title }}</li>
        </ul>
      </div>

      <!-- Section 3 Data -->
      <div class="column">
        <h2>Section 3</h2>
        <ul>
          <li v-for="item in section3Data" :key="item.Id">{{ item.Title }}</li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "home",
  data() {
    return {
      section1Data: [],
      section2Data: [],
      section3Data: [],
    };
  },
  created() {
    this.fetchApiData();
  },
  methods: {
    fetchApiData() {
      axios
        .get("https://health.gov/myhealthfinder/api/v3/itemlist.json?Type=topic") 
        .then((response) => {
          const { Item } = response.data.Result.Items;
          // You can use Item array to divide the data into three sections.
          this.section1Data = Item.slice(0, 10);
          this.section2Data = Item.slice(10, 20);
          this.section3Data = Item.slice(20, 30);
        })
        .catch((error) => {
          console.error("Error fetching API data:", error);
        });
    },
  },
};
</script>

<style>

.columns {
  display: flex;
  justify-content: space-between;
}

.column {
  flex: 1;
  margin: 10px;
  padding: 10px;
  border: 1px solid #ccc;
}
</style>
