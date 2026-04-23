-- Create and use Database
CREATE DATABASE IF NOT EXISTS airplane_management_system;
USE airplane_management_system;

-- Drop existing tables for a clean install
DROP TABLE IF EXISTS booking_seats;
DROP TABLE IF EXISTS bookings;
DROP TABLE IF EXISTS seats;
DROP TABLE IF EXISTS flights;
DROP TABLE IF EXISTS aeroplane;
DROP TABLE IF EXISTS users;

-- Users table
CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  full_name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  phone VARCHAR(20) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  role ENUM('Admin','Customer','Receptionist') NOT NULL DEFAULT 'Customer',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Aeroplanes table
CREATE TABLE aeroplane (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  aeroplane_name VARCHAR(100) NOT NULL,
  model VARCHAR(100) NOT NULL,
  capacity INT NOT NULL,
  status VARCHAR(30) DEFAULT 'Available',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Flights table
CREATE TABLE flights (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  aeroplane_id INT NOT NULL,
  flight_number VARCHAR(50) NOT NULL UNIQUE,
  departure_city VARCHAR(100) NOT NULL,
  arrival_city VARCHAR(100) NOT NULL,
  departure_time DATETIME NOT NULL,
  arrival_time DATETIME NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  flight_status VARCHAR(30) DEFAULT 'Scheduled',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (aeroplane_id) REFERENCES aeroplane(id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);

-- Seats table
CREATE TABLE seats (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  flight_id INT NOT NULL,
  seat_number VARCHAR(10) NOT NULL,
  seat_class ENUM('Economy','Business','First') DEFAULT 'Economy',
  seat_status ENUM('Available','Reserved','Booked') DEFAULT 'Available',
  UNIQUE (flight_id, seat_number),
  FOREIGN KEY (flight_id) REFERENCES flights(id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);

-- Bookings table
CREATE TABLE bookings (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  flight_id INT NOT NULL,
  booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  booking_status ENUM('Reserved','Paid','Cancelled') DEFAULT 'Reserved',
  total_amount DECIMAL(10,2) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY (flight_id) REFERENCES flights(id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);

-- Booking seats table
CREATE TABLE booking_seats (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  booking_id INT NOT NULL,
  seat_id INT NOT NULL,
  FOREIGN KEY (booking_id) REFERENCES bookings(id)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY (seat_id) REFERENCES seats(id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);