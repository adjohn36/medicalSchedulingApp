<template>
  <div id="main">
    <form v-on:submit.prevent="updateAvailability">
      <h1>Update Schedule</h1>
      <br />
      <select
        id="selected-days"
        v-model="selectedDay"
        v-on:change="getDoctorSchedule"
      >
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
      <tr v-for="time in schedule" v-bind:key="time.scheduleId">
        <td>
          <input
            type="checkbox"
            v-model="selectedSlotId"
            v-bind:id="time.scheduleId"
            v-bind:value="time.scheduleId"
          />
          <span>{{ selectedSlotId }}</span>
        </td>
        <td>{{ time.timeslot }}</td>
      </tr>
      <button type="submit" class="btn save">Save</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";
export default {
  name: "update-doctor-availability",

  data() {
    return {
      selectedDay: "",
      selectedSlotId: [],
      selectedTimeSlot: [],
      availability: [
        {
          day: "",
          slot: [],
        },
      ],
      // timeSlot: [
      //   {
      //     id: 10,
      //     slot: "9:00",
      //   },
      //   {
      //     id: 11,
      //     slot: "9:30",
      //   },
      //   {
      //     id: 12,
      //     slot: "10:00",
      //   },
      //   {
      //     id: 13,
      //     slot: "10:30",
      //   },
      // ],

      schedule: [
        {
          scheduleId: 0,
          dayOfTheWeek: "",
          timeslot: "",
          doctorScheduleId: 0,
          doctorId: 0,
          slotAvailable: true,
        },
      ],

      unavailableSchedule:[
        {

        }
      ]
    };
  },
  methods: {
    getDoctorSchedule() {
      alert(this.selectedDay);
      authService.getDoctorSchedule(this.selectedDay).then((response) => {
        if (response.status === 200) {
          this.schedule = response.data;
          if (this.schedule.length > 0) {
            for (let id in this.schedule) {
              if (this.schedule[id].slotAvailable) {
                this.selectedSlotId.push(this.schedule[id].scheduleId);
              }             
            }
          }
        }
      });     
     this.schedule = [];
      this.selectedSlotId = [];
    },  

    // updateAvailability() {
    //   if (this.selectedSlotId.length != 0) {
    //     for (let id in this.selectedSlotId) {
    //       let unavailableTimeSlot = [];
    //       unavailableTimeSlot = this.schedule.filter(
    //         (time) => { return time.scheduleId !== this.selectedSlotId[id]}
    //       );
    //       //this.selectedTimeSlot.push(userTimeSlot[0].slot);
    //     }
    //   }
    // //   this.availability.push({day:this.selectedDay,slot:this.selectedTimeSlot})
    // //      this.selectedSlotId = [];
    // //  this.selectedTimeSlot = [];
    // // this.selectedDay = '';
    // },
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