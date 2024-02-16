package com.vijani.lil.landonhotel.data;

import com.vijani.lil.landonhotel.data.entity.Room;
import com.vijani.lil.landonhotel.data.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Room> rooms = this.roomRepository.findAll();
        Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("p1");
        System.out.println(room);
        rooms.forEach(System.out::println);
    }
}
