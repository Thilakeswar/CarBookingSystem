package com.knightwatch.CarBookingSystem.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Entity
@Table(name = "Cars")
@JsonDeserialize(builder = Car.Builder.class)
public class Car
{
	@Id
	@Column(name = "CarId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer carId;
	@Column(name = "CarName")
	private String carName;
	@Column(name = "CarType")
	private String carType;
	@Column(name = "Price")
	private BigDecimal price;
	@Column(name = "Stock")
	private Integer stock;
	@Column(name = "WaitingPeriod")
	private Integer waitingPeriod;

	public Integer getCarId()
	{
		return carId;
	}

	public String getCarName()
	{
		return carName;
	}

	public String getCarType()
	{
		return carType;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public Integer getStock()
	{
		return stock;
	}

	public Integer getWaitingPeriod()
	{
		return waitingPeriod;
	}

	public Car()
	{
	}

	private Car(Builder builder)
	{
		carId = builder.carId;
		carName = builder.carName;
		carType = builder.carType;
		price = builder.price;
		stock = builder.stock;
		waitingPeriod = builder.waitingPeriod;
	}

	@JsonPOJOBuilder(withPrefix = "set")
	public static class Builder
	{
		Integer carId;
		String carName;
		String carType;
		BigDecimal price;
		Integer stock;
		Integer waitingPeriod;

		public Builder setCardId(Integer carId)
		{
			this.carId = carId;
			return this;
		}

		public Builder setCarName(String carName)
		{
			this.carName = carName;
			return this;
		}

		public Builder setCarType(String carType)
		{
			this.carType = carType;
			return this;
		}

		public Builder setPrice(BigDecimal price)
		{
			this.price = price;
			return this;
		}

		public Builder setStock(Integer stock)
		{
			this.stock = stock;
			return this;
		}

		public Builder setWaitingPeriod(Integer waitingPeriod)
		{
			this.waitingPeriod = waitingPeriod;
			return this;
		}

		public Car build()
		{
			return new Car(this);
		}
	}

}
