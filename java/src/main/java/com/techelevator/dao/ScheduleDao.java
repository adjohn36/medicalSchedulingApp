package com.techelevator.dao;

import com.techelevator.model.DoctorOfficeList;
import com.techelevator.model.Schedule;
import com.techelevator.model.DoctorSchedule;

import java.security.Principal;
import java.util.List;

import java.util.ArrayList;


public interface ScheduleDao {
List<DoctorSchedule> getDoctorSchedule(int doctorId);


DoctorSchedule updateSchedule(int doctorScheduleId, DoctorSchedule doctorSchedule);

//DoctorSchedule getDoctorScheduleByDrScheduleId(int doctorScheduleId){
//
//}
}
