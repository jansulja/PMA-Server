INSERT INTO `sql11174073`.`address`(`address_id`,`address_street`,`address_number`,`address_city`,`address_country`)VALUES(1,'Bulevar Oslobodjenja',26,'Novi Sad','Srbija');
INSERT INTO `sql11174073`.`address`(`address_id`,`address_street`,`address_number`,`address_city`,`address_country`)VALUES(2,'Narodnog Fronta',78,'Novi Sad','Srbija');


INSERT INTO `sql11174073`.`hotel`
(`hotel_id`,
`hotel_name`,
`hotel_description`,
`hotel_website`,
`hotel_phone`,
`hotel_stars`,
`hotel_rating`,
`address_id`)
VALUES
(1,
'Plaza',
'Opis hotela Plaza',
'www.plaza.com',
'021/6654-568',
4,
9.1,
1);

INSERT INTO `sql11174073`.`hotel`
(`hotel_id`,
`hotel_name`,
`hotel_description`,
`hotel_website`,
`hotel_phone`,
`hotel_stars`,
`hotel_rating`,
`address_id`)
VALUES
(2,
'NS Hotel',
'Opis hotela NS Hotel',
'www.nshotel.com',
'021/4568-123',
3,
7.5,
2);

INSERT INTO `sql11174073`.`price` (`price_id`, `price_start_date`, `price_end_date`, `price_value`) VALUES ('1', '2001-01-01', '2020-01-01', '53.21');
INSERT INTO `sql11174073`.`price` (`price_id`, `price_start_date`, `price_end_date`, `price_value`) VALUES ('2', '2001-01-01', '2020-01-01', '68.21');

INSERT INTO `sql11174073`.`room` (`room_id`, `hotel_id`, `room_name`, `price_id`) VALUES ('1', '1', 'Soba 1', '1');
INSERT INTO `sql11174073`.`room` (`room_id`, `hotel_id`, `room_name`, `price_id`) VALUES ('2', '1', 'Soba 2', '2');

INSERT INTO `sql11174073`.`amenity` (`amenity_id`, `hotel_id`, `amenity_name`, `amenity_description`) VALUES ('1', '1', 'Free WiFi', 'Free Wireless network');
INSERT INTO `sql11174073`.`amenity` (`amenity_id`, `hotel_id`, `amenity_name`, `amenity_description`) VALUES ('2', '1', 'Free Parking', 'Free Parking');

INSERT INTO `sql11174073`.`roomamenity` (`hotel_id`, `room_id`, `ame_hotel_id`, `amenity_id`) VALUES ('1', '1', '1', '1');

INSERT INTO `sql11174073`.`reservation` (`reservation_id`, `hotel_id`, `room_id`, `reservation_start_date`, `reservation_end_date`, `reservation_price`, `reservation_firstname`, `reservation_lastname`) VALUES ('1', '1', '1', '2017-05-12', '2017-05-20', '98.21', 'Pera', 'Peric');

