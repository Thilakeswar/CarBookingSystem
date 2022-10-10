package com.knightwatch.CarBookingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.knightwatch.CarBookingSystem.model.BookingLedger;

@Repository
public interface BookingLedgerJPARepository extends JpaRepository<BookingLedger, Integer>
{
}
