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
      <tr v-for="time in schedule" v-bind:key="time.doctorScheduleId">
        <td v-show="schedule[0].doctorScheduleId>0">
          <input type="checkbox" v-model="selectedSlotId" v-bind:id="time.doctorScheduleId" v-bind:value="time.doctorScheduleId"/>
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
      message: "",
      selectedDay: "",
      selectedSlotId: [],
      unSelectedTimeSlot: [],
      unselectedIdList: {
        doctorScheduleIdList: [],
      },

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
    };
  },
  methods: {
    getDoctorSchedule() {
      //alert(this.selectedDay);

      this.schedule = [];
      this.selectedSlotId = [];
      this.unSelectedTimeSlot = [];

      authService.getDoctorSchedule(this.selectedDay).then((response) => {
        if (response.status === 200) {
          //this.schedule = response.data;
          const availability = response.data;
          if (availability.length > 0) {
            for (let id in availability) {
              if (availability[id].slotAvailable) {
                this.schedule.push(availability[id]);
                this.selectedSlotId.push(availability[id].doctorScheduleId);
              }
            }
          }
        }
      });
    },

    updateAvailability() {
      this.unSelectedTimeSlot = this.schedule.filter((time) => {
        return !this.selectedSlotId.includes(time.doctorScheduleId);
      });
     // let unselectedIdList = [];
      this.unSelectedTimeSlot.forEach((value) =>      
        this.unselectedIdList.doctorScheduleIdList.push(value.doctorScheduleId)
      );

      authService.updateUnavailability(this.unselectedIdList).then((response) => {
        if (response.status === 200) {
          this.message = "Successfully Updated";
           this.getDoctorSchedule();
        }
        
      });

     
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