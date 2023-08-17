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
            v-bind:value="time.scheduleId" v-on:change="getUpdatedList"
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
      unSelectedTimeSlot: [],
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
      ]
    };
  },
  methods: {
    getDoctorSchedule() {
      alert(this.selectedDay);

      this.schedule = [];
      this.selectedSlotId = [];
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
    },  

    updateAvailability() {
      if (this.selectedSlotId.length != 0) {
        for (let id in this.selectedSlotId) {         
          this.unSelectedTimeSlot = this.schedule.filter(
            (time) => { return (time.scheduleId === this.selectedSlotId[id])}
          );
         // alert(this.selectedSlotId[id]);
          //this.selectedTimeSlot.push(userTimeSlot[0].slot);
        }
      }
      alert(this.unSelectedTimeSlot[0].scheduleId);
      this.unSelectedTimeSlot = [];
              //   this.availability.push({day:this.selectedDay,slot:this.selectedTimeSlot})
              //      this.selectedSlotId = [];
              //  this.selectedTimeSlot = [];
              // this.selectedDay = '';
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