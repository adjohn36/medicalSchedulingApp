package com.techelevator.dao;

import com.techelevator.model.BookAppointViewDto;

import java.util.List;

public interface BookAppointmentDao {
    List<BookAppointViewDto> getAvailableAppointmentLists();
}
