package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Doctor;
import com.techelevator.model.User;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.Objects;

public class JdbcDoctorDao implements DoctorDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcDoctorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // if user id is present in doctors table
    public Doctor getDoctorByUserId(int userId) {
        Doctor doctor = null;
        String sql = "SELECT * FROM doctor WHERE user_id = ";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            if (results.next()) {
                doctor = mapRowToDoctor(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return doctor;

    }

    private Doctor mapRowToDoctor(SqlRowSet rs) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(rs.getInt("doctor_id"));
        doctor.setDoctorFirstName(rs.getString("doctor_first_name"));
        doctor.setDoctorLastName(rs.getString("doctor_last_name"));
        doctor.setDoctorEmail(Objects.requireNonNull(rs.getString("doctor_email")));
        doctor.setDoctorNpi(rs.getString("doctor_npi"));
        return doctor;
    }
}
