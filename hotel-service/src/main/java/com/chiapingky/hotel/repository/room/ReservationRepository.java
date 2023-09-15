package com.chiapingky.hotel.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Iterable<Reservation> getReservationsByDate(Date date);
}
