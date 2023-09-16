package com.chiapingky.hotel.web;

import com.chiapingky.hotel.repository.room.Guest;
import com.chiapingky.hotel.repository.room.GuestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestListController {
    private final GuestRepository guestRepository;

    public GuestListController(
            GuestRepository guestRepository
    ) {
        this.guestRepository = guestRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(Model model) {
        List<Guest> guests = guestRepository.findAll();
        model.addAttribute("guestsList", guests);
        return "guests-list";
    }
}
