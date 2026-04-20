USE airplane_management_system;

-- for "roles"
INSERT INTO roles (role_name) VALUES
('Admin'),
('Receptionist'),
('Passenger');

-- for "users"
INSERT INTO users (full_name, email, phone, password, role_id) VALUES
('Admin User', 'admin@gmail.com', '9800000001', 'admi?22!3', 1),
('Reception User', 'reception@gmail.com', '9800010201', 'rece!22?#', 2),
('Passenger User', 'passenger@gmail.com', '9800000033', 'p!ass?23', 3);

-- for "airplanes
INSERT INTO airplanes (airplane_name, model, capacity, status) VALUES
('Buddha Air', 'ATR 72', 6, 'Available'),
('Yeti Airlines', 'ATR 72' , 6, 'Available');

-- for "flights"
INSERT INTO flights (airplane_id, flight_number, departure_city, arrival_city, departure_time, arrival_time, price, flight_status) VALUES
(1, 'FL101', 'Kathmandu', 'Pokhara', '2026-4-25 08:00:00','2026-04-25 08:45:00', 4500.00, 'Scheduled'),
(2, 'FL102', 'Kathmandu', 'Biratnagar', '2026-4-25 10:00:00','2026-04-25 10:45:00', 5000.00, 'Scheduled'),

-- for "seats"
INSERT INTO seats (airplane_id, seat_number, seat_class, seat_status) VALUES
(1, 'A1' 'Economy', 'Available'),
(1, 'A2' 'Economy', 'Available'),
(1, 'B1' 'Economy', 'Available'),
(1, 'B2' 'Economy', 'Available'),
(1, 'C1' 'Business', 'Available'),
(1, 'C2' 'Business', 'Available'),
(2, 'A1' 'Economy', 'Available'),
(2, 'A2' 'Economy', 'Available'),
(2, 'B1' 'Economy', 'Available'),
(2, 'B2' 'Economy', 'Available'),
(2, 'C1' 'Business', 'Available'),
(2, 'C2' 'Business', 'Available');

-- for "bookings"
INSERT INTO bookings (user_id, flight_id, booking_status, total_amount) VALUES
(3, 1, 'Booked', 4500.00),
(3, 2, 'Booked', 5000.00);

-- for "booking_seats"
INSERT INTO booking_seats (booking_id, seat_id) VALUES
(1, 1),
(2, 7);

-- for "payments"
INSERT INTO payments (booking_id, payment_method, payment_status, amount)
(1, 'Cash', 'Paid', 4500.00),
(2, 'Card', 'Paid', 5000.00);
