package com.vijani.lil.landonhotel.web.api;

import com.vijani.lil.landonhotel.data.entity.Guest;
import com.vijani.lil.landonhotel.data.entity.Reservation;
import com.vijani.lil.landonhotel.data.repository.ReservationRepository;
import com.vijani.lil.landonhotel.web.exception.BadRequestException;
import com.vijani.lil.landonhotel.web.exception.NotFoundException;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationApiController {

    private final ReservationRepository reservationRepository;

    @GetMapping
    public List<Reservation> getAllReservations(@RequestParam(value = "date", required = false) String dateString) {
        if (StringUtils.isNotBlank(dateString)) {
            Date date = new Date(new java.util.Date().getTime());
            return reservationRepository.findAllByReservationDate(date);
        }
        return reservationRepository.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation addReservation(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
        return reservation;
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable("id") Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isEmpty()) {
            throw new NotFoundException("reservation not found with id " + id);
        }
        return reservation.get();
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation) {
        if (id != reservation.getId()) {
            throw new BadRequestException("id on path doesn't match body");
        }
        return reservationRepository.save(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteReservation(@PathVariable("id") Long id) {
        reservationRepository.deleteById(id);
    }
}
