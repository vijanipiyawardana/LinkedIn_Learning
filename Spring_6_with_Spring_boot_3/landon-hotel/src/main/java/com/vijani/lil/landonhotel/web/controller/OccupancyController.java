package com.vijani.lil.landonhotel.web.controller;

import com.vijani.lil.landonhotel.service.RoomReservationService;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequiredArgsConstructor
@RequestMapping("/occupancy")
public class OccupancyController {

    private final RoomReservationService service;

    @GetMapping
    public String getOccupancy(Model model, @RequestParam(value = "date", required = false) String dateString) {
        Date date = new Date();
        if(StringUtils.isNotBlank(dateString)) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                date = format.parse(dateString);
            } catch (Exception ex) {
                // do nothing
            }
        }
        model.addAttribute("date", date);
        model.addAttribute("reservations", service.getRoomReservationsForDate(dateString));
        return "occupancy";
    }

}
