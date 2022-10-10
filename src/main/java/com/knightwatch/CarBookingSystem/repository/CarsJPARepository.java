package com.knightwatch.CarBookingSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.knightwatch.CarBookingSystem.model.Car;

@Repository
public interface CarsJPARepository extends JpaRepository<Car, Integer>
{
	Optional<Car> findByCarName(String carName);
}
