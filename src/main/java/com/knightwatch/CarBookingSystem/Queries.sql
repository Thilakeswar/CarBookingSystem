CREATE TABLE Cars(
	CarId INT AUTO_INCREMENT,
	CarName VARCHAR(500),
    CarType VARCHAR(500),
    Price DECIMAL,
    Stock INT,
    WaitingPeriod INT,
    primary key(CarId)
);

CREATE TABLE BookingLedger(
	BookingId INT AUTO_INCREMENT,
	CarId INT,
	BookingDate DATE,
    DeliveryDate DATE,
    Price DECIMAL,
    primary key(BookingId),
    foreign key(CarId) references CARS(CarId)
);