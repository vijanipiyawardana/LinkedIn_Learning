package com.vijani.lil.landonhotel.web.api;

import com.vijani.lil.landonhotel.data.entity.Guest;
import com.vijani.lil.landonhotel.data.repository.GuestRepository;
import com.vijani.lil.landonhotel.web.exception.BadRequestException;
import com.vijani.lil.landonhotel.web.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/guests")
public class GuestApiController {

    private final GuestRepository guestRepository;

    @GetMapping
    public List<Guest> getAllRooms() {
        return guestRepository.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Guest addGuest(@RequestBody Guest guest) {
        guestRepository.save(guest);
        return guest;
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable("id") Long id) {
        Optional<Guest> guest = guestRepository.findById(id);
        if (guest.isEmpty()) {
            throw new NotFoundException("guest not found with id " + id);
        }
        return guest.get();
    }

    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable("id") Long id, @RequestBody Guest guest) {
        if (id != guest.getId()) {
            throw new BadRequestException("id on path doesn't match body");
        }
        return guestRepository.save(guest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteGuest(@PathVariable("id") Long id) {
        guestRepository.deleteById(id);
    }
}
