package com.chiapingky.hotel.repository.room;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESERVATION_ID")
    private long id;
    @Column(name = "ROOM_ID")
    private long roomId;
    @Column(name = "GUEST_ID")
    private long guestId;
    @Column(name = "RES_DATE")
    private Date reservationDate;

    private Reservation() {
    }

    public long getId() {
        return id;
    }

    public long getRoomId() {
        return roomId;
    }

    public long getGuestId() {
        return guestId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation:{" +
                "id:" + id +
                ",roomId:" + roomId +
                ",guestId:" + guestId +
                ",reservationDate:" + reservationDate +
                "}";
    }
}
