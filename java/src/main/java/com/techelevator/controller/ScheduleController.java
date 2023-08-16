package com.techelevator.controller;



import com.techelevator.model.OfficeInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.techelevator.model.Schedule;
import com.techelevator.dao.ScheduleDao;
import com.techelevator.model.DoctorSchedule;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/update-availability")
public class ScheduleController {
    private final ScheduleDao scheduleDao;


    public ScheduleController(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{doctorId}")
    public List<DoctorSchedule> getDoctorSchedule(@PathVariable int doctorId,@RequestParam(required=false) String dayOfTheWeek){
        List doctorSchedule= scheduleDao.getDoctorSchedule(doctorId, dayOfTheWeek);
        //if need day of week then add dayOfWeek above)
        if (doctorSchedule != null) {

        }else {
            System.out.println("No schedule found. Please update.");
        }
       return doctorSchedule;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{doctorScheduleId}")

    public DoctorSchedule updateSchedule(@Valid @PathVariable int doctorScheduleId, @RequestBody DoctorSchedule doctorSchedule) {
        doctorSchedule.setDoctorScheduleId(doctorSchedule.getDoctorScheduleId());
        DoctorSchedule updatedSchedule = scheduleDao.updateSchedule(doctorScheduleId, doctorSchedule);
        if (updatedSchedule != null) {

        } else {
            System.out.println("No schedule found.");
        }return updatedSchedule;


    }

}
