package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.BookAppointViewDto;
import com.techelevator.dao.BookAppointmentDao;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBookAppointmentDao implements BookAppointmentDao {
    private final JdbcTemplate jdbcTemplate;
    public JdbcBookAppointmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<BookAppointViewDto> getAvailableAppointmentLists() {
                List<BookAppointViewDto> appointmentLists = new ArrayList<>();
        try {
            String sql = "SELECT doctor_schedule.doctor_schedule_id, doctor_schedule.schedule_id, " +
                            " doctor.doctor_id, doctor.doctor_first_name, doctor.doctor_last_name " +
                            " FROM doctor_schedule " +
                            " JOIN doctor ON doctor_schedule.doctor_id = doctor.doctor_id ";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                BookAppointViewDto appointment = mapRowToAppointmentView(results);
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
    // Maps a row from Database result to Book Appointment Response Model object
    private BookAppointViewDto mapRowToAppointmentView(SqlRowSet rs) {
        BookAppointViewDto appointment = new BookAppointViewDto();
        appointment.setDoctorScheduleId(rs.getInt("doctor_schedule_id"));
        appointment.setScheduleId(rs.getInt("schedule_id"));
        appointment.setDoctor_id(rs.getInt("doctor_id"));
        appointment.setDoctorFirstName(rs.getString("doctor_first_name"));
        appointment.setDoctorLastName(rs.getString("doctor_last_name"));
        return appointment;
    }


}
