package com.vijani.lil.landonhotel.web.api;

import com.vijani.lil.landonhotel.data.entity.Room;
import com.vijani.lil.landonhotel.data.repository.RoomRepository;
import com.vijani.lil.landonhotel.web.exception.BadRequestException;
import com.vijani.lil.landonhotel.web.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rooms")
public class RoomApiController {

    private final RoomRepository roomRepository;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Room createRoom(@RequestBody Room room) {
        roomRepository.save(room);
        return room;
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable("id") Long id) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isEmpty()) {
            throw new NotFoundException("room not found with id " + id);
        }
        return room.get();
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable("id") Long id, @RequestBody Room room) {
        if (id != room.getId()) {
            throw new BadRequestException("id on path doesn't match body");
        }
        return roomRepository.save(room);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteRoom(@PathVariable("id") Long id) {
        roomRepository.deleteById(id);
    }

}
