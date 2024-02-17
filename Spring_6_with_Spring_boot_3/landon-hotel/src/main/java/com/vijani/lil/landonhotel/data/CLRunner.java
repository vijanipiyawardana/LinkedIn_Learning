package com.vijani.lil.landonhotel.data;

import com.vijani.lil.landonhotel.data.entity.Guest;
import com.vijani.lil.landonhotel.data.entity.Reservation;
import com.vijani.lil.landonhotel.data.entity.Room;
import com.vijani.lil.landonhotel.data.repository.GuestRepository;
import com.vijani.lil.landonhotel.data.repository.ReservationRepository;
import com.vijani.lil.landonhotel.data.repository.RoomRepository;
import com.vijani.lil.landonhotel.service.RoomReservationService;
import com.vijani.lil.landonhotel.service.model.RoomReservation;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CLRunner implements CommandLineRunner {

    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;
    private final RoomReservationService roomReservationService;

    @Override
    public void run(String... args) throws Exception {
        List<RoomReservation> roomReservations = roomReservationService.getRoomReservationsForDate("2023-08-28");
        roomReservations.forEach(System.out::println);
    }

// code for Part 2: Data access in Spring
//    @Override
//    public void run(String... args) throws Exception {
//        Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("p1");
//        System.out.println(room);
//        System.out.println("===== GUESTS =====");
//        List<Guest> guests = this.guestRepository.findAll();
//        guests.forEach(System.out::println);
//        System.out.println("===== ROOMS =====");
//        List<Room> rooms = this.roomRepository.findAll();
//        rooms.forEach(System.out::println);
//        System.out.println("===== RESERVATIONS =====");
//        List<Reservation> reservations = this.reservationRepository.findAll();
//        reservations.forEach(System.out::println);
//    }
}
