package com.knightwatch.CarBookingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.knightwatch.CarBookingSystem.model.APIResponse;
import com.knightwatch.CarBookingSystem.model.Car;
import com.knightwatch.CarBookingSystem.service.CarsService;

@RestController
public class CarsAPI
{
	@Autowired
	private CarsService carsService;

	@PostMapping(path = "api/v1/newcar")
	public ResponseEntity createCar(@RequestBody Car car)
	{
		Car createdCar = carsService.createCar(car);
		return new APIResponse.Builder()
			.setHttpStatusCode(HttpStatus.OK.value())
			.setMessage("Car created successfully")
			.setEntityData(createdCar)
			.build();
	}

	@PostMapping(path = "api/v1/bookcar/{carName}")
	public ResponseEntity bookCar(@PathVariable("carName") String carName) throws Exception
	{
		String response = carsService.bookCar(carName);
		return new APIResponse.Builder()
			.setHttpStatusCode(HttpStatus.OK.value())
			.setMessage(response)
			.build();
	}
}
