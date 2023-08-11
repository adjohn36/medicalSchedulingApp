package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.AppointmentResponseDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAppointmentDao implements AppointmentDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcAppointmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AppointmentResponseDto> getAppointmentListsByDoctorId(int id) {
        List<AppointmentResponseDto> appointmentLists = new ArrayList<>();
        try {
            String sql = "SELECT patient.patient_first_name, patient.patient_last_name, appointment.date_selected, schedule.time_slot " +
                    " FROM patient " +
                    " JOIN appointment ON patient.patient_id = appointment.patient_id " +
                    " JOIN doctor_schedule ON appointment.doctor_schedule_id = doctor_schedule.doctor_schedule_id " +
                    " JOIN schedule ON doctor_schedule.schedule_id = schedule.schedule_id " +
                    " WHERE doctor_schedule.doctor_id = ?";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            while (results.next()) {
                AppointmentResponseDto appointment = mapRowToAppointment(results);
                appointmentLists.add(appointment);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (
                DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return appointmentLists;
    }

    // Maps a row from Database result to Appointment Response Model object
    private AppointmentResponseDto mapRowToAppointment(SqlRowSet rs) {
        AppointmentResponseDto appointment = new AppointmentResponseDto();
        appointment.setPatientFirstName(rs.getString("patient_first_name"));
        appointment.setPatientLastName(rs.getString("patient_last_name"));
        appointment.setDateSelected(rs.getString("date_selected"));
        appointment.setTimeSlot(rs.getString("time_slot"));
        return appointment;
    }
}
