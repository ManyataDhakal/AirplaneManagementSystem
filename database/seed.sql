USE airplane_management_system;

-- for "users"
INSERT INTO users (full_name, email, phone, password, role) VALUES
('Admin User', 'admin@gmail.com', '9800000001', 'admi?22!3', 'Admin'),
('Reception User', 'reception@gmail.com', '9800010201', 'rece!22?#', 'Receptionist'),
('Customer User', 'customer@gmail.com', '9800000033', 'p!ass?23', 'Customer');

-- for "aeroplanes"
INSERT INTO aeroplane (aeroplane_name, model, capacity, status) VALUES
('Buddha Air', 'ATR 72', 70, 'Available'),
('Yeti Airlines', 'ATR 72' , 70, 'Available');

-- for "flights"
INSERT INTO flights (aeroplane_id, flight_number, departure_city, arrival_city, departure_time, arrival_time, price, flight_status) VALUES
(1, 'FL101', 'Kathmandu', 'Pokhara', '2026-04-25 08:00:00','2026-04-25 08:45:00', 4500.00, 'Scheduled'),
(2, 'FL102', 'Kathmandu', 'Biratnagar', '2026-04-25 10:00:00','2026-04-25 10:45:00', 5000.00, 'Scheduled');

-- for "seats"
INSERT INTO seats (flight_id, seat_number, seat_class, seat_status) VALUES
(1, 'A1', 'Economy', 'Available'),
(1, 'A2', 'Economy', 'Available'),
(1, 'B1', 'Economy', 'Available'),
(1, 'B2', 'Economy', 'Available'),
(1, 'C1', 'Business', 'Available'),
(1, 'C2', 'Business', 'Available'),

(2, 'A1', 'Economy', 'Available'),
(2, 'A2', 'Economy', 'Available'),
(2, 'B1', 'Economy', 'Available'),
(2, 'B2', 'Economy', 'Available'),
(2, 'C1', 'Business', 'Available'),
(2, 'C2', 'Business', 'Available');

-- for "bookings"
INSERT INTO bookings (user_id, flight_id, booking_status, total_amount) VALUES
(3, 1, 'Reserved', 4500.00),
(3, 2, 'Reserved', 5000.00);

-- for "booking_seats"
INSERT INTO booking_seats (booking_id, seat_id) VALUES
(1, 1),
(2, 7);
