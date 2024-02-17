package com.vijani.lil.landonhotel.web.controller;

import com.vijani.lil.landonhotel.data.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    private final RoomRepository roomRepository;

    @GetMapping
    public String getRooms(Model model) {
        model.addAttribute("rooms", roomRepository.findAll());
        return "room-list";
    }

}
