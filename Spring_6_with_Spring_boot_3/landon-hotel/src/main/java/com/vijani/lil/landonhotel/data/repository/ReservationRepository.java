package com.vijani.lil.landonhotel.data.repository;

import com.vijani.lil.landonhotel.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByReservationDate(Date reservationDate);

}
