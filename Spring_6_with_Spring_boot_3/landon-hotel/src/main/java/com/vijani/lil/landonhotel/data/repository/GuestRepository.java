package com.vijani.lil.landonhotel.data.repository;

import com.vijani.lil.landonhotel.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
