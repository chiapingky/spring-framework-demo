package com.chiapingky.hotel.webservice;

import com.chiapingky.hotel.business.ReservationService;
import com.chiapingky.hotel.business.RoomReservation;
import com.chiapingky.hotel.repository.room.Guest;
import com.chiapingky.hotel.repository.room.GuestRepository;
import com.chiapingky.hotel.repository.room.Room;
import com.chiapingky.hotel.repository.room.RoomRepository;
import com.chiapingky.hotel.utils.DateUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class WebServiceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    public WebServiceController(
            DateUtils dateUtils,
            ReservationService reservationService,
            RoomRepository roomRepository,
            GuestRepository guestRepository
    ) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false) String stringDate) {
        Date date = dateUtils.createDateFromDateString(stringDate);
        return reservationService.getRoomReservationsForDate(date);
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public List<Room> getRooms() {
        List<Room> result = new ArrayList<>();
        roomRepository.findAll().forEach(result::add);
        return result;
    }

    @RequestMapping(value = "/guests", method = RequestMethod.GET)
    public List<Guest> getGuests() {
        return new ArrayList<>(guestRepository.findAll());
    }

    @RequestMapping(value = "/guests", method = RequestMethod.POST)
    public boolean addGuests(@RequestBody Guest guest) {
        try {
            guestRepository.save(Objects.requireNonNull(guest));
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            return false;
        }
        return true;
    }
}
