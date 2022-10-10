package com.knightwatch.CarBookingSystem.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knightwatch.CarBookingSystem.model.BookingLedger;
import com.knightwatch.CarBookingSystem.model.Car;
import com.knightwatch.CarBookingSystem.repository.BookingLedgerJPARepository;
import com.knightwatch.CarBookingSystem.repository.CarsJPARepository;

@Service
public class CarsService
{
	@Autowired
	private CarsJPARepository carsJPARepository;
	@Autowired
	private BookingLedgerJPARepository bookingLedgerJPARepository;

	//	public CarsService(CarsJPARepository carsJPARepository)
	//	{
	//		this.carsJPARepository = carsJPARepository;
	//	}

	public Car createCar(Car car)
	{
		return carsJPARepository.save(car);
	}

	public Car getCar(String carName) throws Exception
	{
		Optional<Car> optional = carsJPARepository.findByCarName(carName);
		if(!optional.isPresent())
		{
			throw new Exception("Specified car is not present. Please enter valid car name");
		}
		return optional.get();
	}

	public String bookCar(String carName) throws Exception
	{
		Car car = getCar(carName);
		Integer stockLeft = car.getStock();
		Integer waitingPeriod = car.getWaitingPeriod();

		LocalDate currentDate = LocalDate.now();
		LocalDate deliveryDate = currentDate.plusDays(waitingPeriod);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");
		String currentDateStr = currentDate.format(formatter);
		String deliveryDateStr = deliveryDate.format(formatter);
		if(stockLeft == 0)
		{
			return "Not booked";
		}
		stockLeft--;
		Car carToUpdate = new Car.Builder()
			.setCardId(car.getCarId())
			.setCarName(car.getCarName())
			.setCarType(car.getCarType())
			.setPrice(car.getPrice())
			.setStock(stockLeft)
			.setWaitingPeriod(waitingPeriod)
			.build();

		carsJPARepository.save(carToUpdate);

		BookingLedger bookingLedger = new BookingLedger.Builder()
			.setCarId(car.getCarId())
			.setStatus(BookingLedger.Status.BOOKED.status)
			.setBookedDate(currentDateStr)
			.setDeliveryDate(deliveryDateStr)
			.setPrice(car.getPrice())
			.build();
		bookingLedgerJPARepository.save(bookingLedger);
		return "Booked " + carName + ", Expected delivery date is :" + deliveryDateStr;
	}
}
