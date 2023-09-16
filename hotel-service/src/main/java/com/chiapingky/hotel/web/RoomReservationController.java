package com.chiapingky.hotel.web;

import com.chiapingky.hotel.business.ReservationService;
import com.chiapingky.hotel.business.RoomReservation;
import com.chiapingky.hotel.utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public RoomReservationController(
            DateUtils dateUtils,
            ReservationService reservationService
    ) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getReservations(
            @RequestParam(value = "date", required = false) String stringDate,
            Model model
    ) {
        Date date = dateUtils.createDateFromDateString(stringDate);
        List<RoomReservation> roomReservations = reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", roomReservations);
        return "roomRes";
    }
}
