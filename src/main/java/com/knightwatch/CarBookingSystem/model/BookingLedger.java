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
@Table(name = "BookingLedger")
@JsonDeserialize(builder = BookingLedger.Builder.class)
public class BookingLedger
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BookingId")
	private Integer bookingId;
	@Column(name = "CarId")
	private Integer carId;
	@Column(name = "Status")
	private Integer status;
	@Column(name = "BookedDate")
	private String bookedDate;
	@Column(name = "DeliveryDate")
	private String deliveryDate;
	@Column(name = "Price")
	private BigDecimal price;

	public BookingLedger()
	{
	}

	private BookingLedger(Builder builder)
	{
		bookingId = builder.bookingId;
		carId = builder.carId;
		status = builder.status;
		bookedDate = builder.bookedDate;
		deliveryDate = builder.deliveryDate;
		price = builder.price;
	}

	public Integer getBookingId()
	{
		return bookingId;
	}

	public Integer getCarId()
	{
		return carId;
	}

	public Integer getStatus()
	{
		return status;
	}

	public String getBookedDate()
	{
		return bookedDate;
	}

	public String getDeliveryDate()
	{
		return deliveryDate;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	@JsonPOJOBuilder(withPrefix = "set")
	public static class Builder
	{
		private Integer bookingId;
		private Integer carId;
		private Integer status;
		private String bookedDate;
		private String deliveryDate;
		private BigDecimal price;

		public Builder setBookingId(Integer bookingId)
		{
			this.bookingId = bookingId;
			return this;
		}

		public Builder setCarId(Integer carId)
		{
			this.carId = carId;
			return this;
		}

		public Builder setStatus(Integer status)
		{
			this.status = status;
			return this;
		}

		public Builder setBookedDate(String bookedDate)
		{
			this.bookedDate = bookedDate;
			return this;
		}

		public Builder setDeliveryDate(String deliveryDate)
		{
			this.deliveryDate = deliveryDate;
			return this;
		}

		public Builder setPrice(BigDecimal price)
		{
			this.price = price;
			return this;
		}

		public BookingLedger build()
		{
			return new BookingLedger(this);
		}
	}

	public enum Status
	{
		BOOKED(1, "Booked"),
		DELIVERED(2, "Delivered"),
		CANCELLED(3, "Cancelled");

		public final Integer status;
		public final String statusStr;

		Status(Integer status, String statusStr)
		{
			this.status = status;
			this.statusStr = statusStr;
		}
	}
}
