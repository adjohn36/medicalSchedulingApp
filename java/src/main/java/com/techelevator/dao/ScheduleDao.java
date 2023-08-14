package com.techelevator.dao;

import com.techelevator.model.Schedule;
import com.techelevator.model.DoctorSchedule;

import java.security.Principal;

public interface ScheduleDao {
Schedule createSchedule(Principal principal);
//start with all checked as available except timeslots for 1pm and 1:30 pm
    //select day and time from doctor_schedule joined on schedule where doctor_id=?
Schedule updateSchedule(Principal principal, DoctorSchedule doctorScheduleId);
// on change the slot available in doctor_schedule changes true/false status.
}
