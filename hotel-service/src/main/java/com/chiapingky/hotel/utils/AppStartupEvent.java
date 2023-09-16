package com.chiapingky.hotel.utils;

import com.chiapingky.hotel.business.ReservationService;
import com.chiapingky.hotel.business.RoomReservation;
import com.chiapingky.hotel.repository.room.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationService reservationService;
    private final DateUtils dateUtils;

    public AppStartupEvent(
            RoomRepository roomRepository,
            GuestRepository guestRepository,
            ReservationRepository reservationRepository,
            ReservationService reservationService,
            DateUtils dateUtils
    ) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = roomRepository.findAll();
        rooms.forEach(System.out::println);
        Iterable<Guest> guests = guestRepository.findAll();
        guests.forEach(System.out::println);
        Iterable<Reservation> reservations = reservationRepository.findAll();
        reservations.forEach(System.out::println);
        List<RoomReservation> roomReservationList = reservationService.getRoomReservationsForDate(dateUtils.createDateFromDateString("2022-01-01"));
        roomReservationList.forEach(System.out::println);
    }
}
