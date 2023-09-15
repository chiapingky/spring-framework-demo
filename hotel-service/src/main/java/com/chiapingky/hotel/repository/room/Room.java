package com.chiapingky.hotel.repository.room;

import jakarta.persistence.*;

@Entity
@Table(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROOM_ID")
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ROOM_NUMBER")
    private String roomNumber;
    @Column(name = "BED_INFO")
    private String bedInfo;

    private Room() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getBedInfo() {
        return bedInfo;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ",name=" + name +
                ",roomNumber=" + roomNumber +
                ",bedInfo=" + bedInfo +
                "}";
    }
}
