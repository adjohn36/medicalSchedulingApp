<template>
  <div id="main">
    <form v-on:submit.prevent="updateAvailability">
      <h1>Update Availability</h1>
      <br />
      <select id="selected-days" v-model="selectedDay">
        <option value="">Please select</option>
        <option value="Monday">Monday</option>
        <option value="Tuesday">Tuesday</option>
        <option value="Wednesday">Wednesday</option>
        <option value="Thursday">Thursday</option>
        <option value="Friday">Friday</option>
      </select>
      <span>{{ selectedDay }}</span>
      <br />
      <br />
      <tr v-for="time in timeSlot" v-bind:key="time.id">
        <td>
          <input
            type="checkbox"
            v-model="selectedSlotId"
            v-bind:id="time.id"
            v-bind:value="time.id"
          />
          <span>{{ selectedSlotId }}</span>
        </td>
        <td>{{ time.slot }}</td>
      </tr>
      <button type="submit" class="btn save">Save</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "update-doctor-availability",

  data() {
    return {
      selectedDay: "",
      selectedSlotId: [],
      selectedTimeSlot: [],
      availability:[
          {
              day:'',
              slot:[]
          }

      ],
      timeSlot: [
        {
          id: 10,
          slot: "9:00",
        },
        {
          id: 11,
          slot: "9:30",
        },
        {
          id: 12,
          slot: "10:00",
        },
        {
          id: 13,
          slot: "10:30",
        },
      ],
    };
  },
  methods: {
    updateAvailability() {
      if (this.selectedSlotId.length != 0) {
        for (let id in this.selectedSlotId) {
          let userTimeSlot = [];
          userTimeSlot = this.timeSlot.filter(
            (time) => { return time.id === this.selectedSlotId[id]}
          );
          this.selectedTimeSlot.push(userTimeSlot[0].slot);              
        }       
      }    
      
      this.availability.push({day:this.selectedDay,slot:this.selectedTimeSlot})
         this.selectedSlotId = [];
     this.selectedTimeSlot = [];
    this.selectedDay = '';


      //this.selectedTimeSlot.forEach((slot) => {console.log(`This number is ${slot}`);} );  
      //return this.selectedTimeSlot;
    },
  },
};
</script>

<style>
#main {
  display: flex;
  flex-direction: column;
  align-items: center;
}
form h1 {
}
</style>