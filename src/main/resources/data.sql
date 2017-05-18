INSERT INTO `address`(`address_id`,`address_street`,`address_number`,`address_city`,`address_country`,`address_latitude`,`address_longitude`)VALUES(1,'Bulevar Oslobodjenja',26,'Novi Sad','Srbija',45.2525476,19.8347287);
INSERT INTO `address`(`address_id`,`address_street`,`address_number`,`address_city`,`address_country`,`address_latitude`,`address_longitude`)VALUES(2,'Narodnog Fronta',78,'Novi Sad','Srbija',45.239512, 19.835272);

INSERT INTO `hotel`
(`hotel_id`,
`hotel_name`,
`hotel_description`,
`hotel_website`,
`hotel_phone`,
`hotel_stars`,
`hotel_rating`,
`address_id`,
`hotel_reviews`,
`hotel_image_filename`)
VALUES
(1,
'Plaza',
'Opis hotela Plaza',
'www.plaza.com',
'021/6654-568',
4,
9.1,
1,
250,
'hotel1');

INSERT INTO `hotel`
(`hotel_id`,
`hotel_name`,
`hotel_description`,
`hotel_website`,
`hotel_phone`,
`hotel_stars`,
`hotel_rating`,
`address_id`,
`hotel_reviews`,
`hotel_image_filename`)
VALUES
(2,
'NS Hotel',
'Opis hotela NS Hotel',
'www.nshotel.com',
'021/4568-123',
3,
7.5,
2,
352,
'hotel2');

INSERT INTO `price` (`price_id`, `price_start_date`, `price_end_date`, `price_value`) VALUES (1, '2001-01-01', '2020-01-01', '53.21');
INSERT INTO `price` (`price_id`, `price_start_date`, `price_end_date`, `price_value`) VALUES (2, '2001-01-01', '2020-01-01', '68.21');
INSERT INTO `price` (`price_id`, `price_start_date`, `price_end_date`, `price_value`) VALUES (3, '2001-01-01', '2020-01-01', '100.21');
INSERT INTO `price` (`price_id`, `price_start_date`, `price_end_date`, `price_value`) VALUES (4, '2001-01-01', '2020-01-01', '200.21');

INSERT INTO `room` (`room_id`, `hotel_id`, `room_name`, `price_id`, `room_count`, `room_available`, `room_description`) VALUES (1, 1, 'Soba 1', 1,6,6,'Description of room');
INSERT INTO `room` (`room_id`, `hotel_id`, `room_name`, `price_id`, `room_count`, `room_available`, `room_description`) VALUES (2, 1, 'Soba 2', 2,9,9,'Description of room');

INSERT INTO `room` (`room_id`, `hotel_id`, `room_name`, `price_id`, `room_count`, `room_available`, `room_description`) VALUES (3, 2, 'Big room', 4,6,6,'Description of room');
INSERT INTO `room` (`room_id`, `hotel_id`, `room_name`, `price_id`, `room_count`, `room_available`, `room_description`) VALUES (4, 2, 'Small room', 3,9,9,'Description of room');


INSERT INTO `amenity` (`amenity_id`, `hotel_id`, `amenity_name`, `amenity_description`,`amenity_icon`) VALUES (1, 1, 'Free WiFi', 'Free Wireless network','wifi');
INSERT INTO `amenity` (`amenity_id`, `hotel_id`, `amenity_name`, `amenity_description`,`amenity_icon`) VALUES (2, 1, 'Free Parking', 'Free Parking','parking');

INSERT INTO `roomamenity` (`room_id`, `amenity_id`) VALUES (1, 1);
INSERT INTO `roomamenity` (`room_id`, `amenity_id`) VALUES (1, 2);

INSERT INTO `bed` (`bed_id`, `bed_name`,`bed_icon`) VALUES (1, 'King size','king_size');
INSERT INTO `bed` (`bed_id`, `bed_name`,`bed_icon`) VALUES (2, 'Full extra long','full_extra_long');
INSERT INTO `bed` (`bed_id`, `bed_name`,`bed_icon`) VALUES (3, 'Cot size','cot_size');

INSERT INTO `roombed` (`roombed_id`,`room_id`, `bed_id`,`roombed_count`) VALUES (1, 1, 1, 2);
INSERT INTO `roombed` (`roombed_id`,`room_id`, `bed_id`,`roombed_count`) VALUES (2, 2, 3, 2);
