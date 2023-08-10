package com.techelevator.dao;

import com.techelevator.model.Appointment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JbdcPatientDao implements PatientDao {

    private final JdbcTemplate jdbcTemplate;

    public JbdcPatientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Patient> getAppointmentListsByDoctorId(int id) {
        List<Patientt> appointmentLists = new ArrayList<>();
        String sql = "SELECT * FROM appointment where doctor_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, Integer.class, id);
        while (results.next()) {
            Patient appointment = mapRowToPatient(results);
            appointmentLists.add(appointment);
        }
        return appointmentLists;
    }

    @Override
    public List<Patient> getPatientLists() {
        List<Appointment> appointmentLists = new ArrayList<>();
        String sql = "SELECT * FROM appointment;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Patient appointment = mapRowToPatient(results);
            appointmentLists.add(appointment);
        }
        return appointmentLists;
    }


    // maps a row from database result to appointment object
    private Appointmentt mapRowToPatient(SqlRowSet rs) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(rs.getInt("appointment_Id"));
         appointment.setPatientId(rs.getInt("patient_id"));
        appointment.setDoctorScheduleId(rs.getInt("doctor_schedule_id"));
        appointment.setDateSelected(rs.getString("date_selected"));

        return appointment;
    }
}
