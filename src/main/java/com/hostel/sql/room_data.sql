booking_seqbookings
#USE hostel_db;

#SELECT * FROM room WHERE available = true;

#INSERT INTO room (id, available, gender, price, type) VALUES
#(1, true, 'Female', 250, 'Single'),
#(2, true, 'Male', 400, 'Double'),
#(3, false, 'Male', 300, 'Shared');

#INSERT INTO room_amenities (room_id, amenities) VALUES
#(1, 'Wi-Fi'),
#(1, 'Study Desk'),
#(2, 'Fan'),
#(2, 'Balcony');

INSERT INTO room (id, available, gender, price, type) VALUES
(4, true, 'Female', 380, 'Shared'),
(5, true, 'Male', 270, 'Shared'),
(6, true, 'Female', 600, 'Executive');

-- Room 4 Amenities (Twin, Female)
INSERT INTO room_amenities (room_id, amenities) VALUES
(4, 'Wi-Fi'),
(4, 'Mini Fridge'),
(4, 'Bookshelf'),
(4, 'Private Sink');

-- Room 5 Amenities (Shared, Male)
INSERT INTO room_amenities (room_id, amenities) VALUES
(5, 'Shared Kitchen'),
(5, 'Lockers'),
(5, 'Laundry Access'),
(5, 'Ceiling Fan');

-- Room 6 Amenities (Executive, Female)
INSERT INTO room_amenities (room_id, amenities) VALUES
(6, 'Private Bathroom'),
(6, 'Balcony'),
(6, 'Smart TV'),
(6, 'AC'),
(6, 'Closet');