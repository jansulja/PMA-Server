INSERT INTO `address`(`id`,`street`,`number`,`city`,`country`,`latitude`,`longitude`)VALUES(1,'Bulevar Oslobodjenja',26,'Novi Sad','Srbija',45.2525476,19.8347287);
INSERT INTO `address`(`id`,`street`,`number`,`city`,`country`,`latitude`,`longitude`)VALUES(2,'Narodnog Fronta',78,'Novi Sad','Srbija',45.239512, 19.835272);

INSERT INTO `hotel`(`id`,`name`,`description`,`website`,`phone`,`stars`,`rating`,`address_id`,`number_of_reviews`,`image_filename`)
VALUES(1,'Plaza','Opis hotela Plaza','www.plaza.com','021/6654-568',4,9.1,1,250,'hotel1');

INSERT INTO `hotel`(`id`,`name`,`description`,`website`,`phone`,`stars`,`rating`,`address_id`,`number_of_reviews`,`image_filename`)
VALUES(2,'NS Hotel','Opis hotela NS Hotel','www.nshotel.com','021/4568-123',3,7.5,2,352,'hotel2');

INSERT INTO `price` (`id`, `start_date`, `end_date`, `value`) VALUES (1, '2001-01-01', '2020-01-01', '53.21');
INSERT INTO `price` (`id`, `start_date`, `end_date`, `value`) VALUES (2, '2001-01-01', '2020-01-01', '68.21');
INSERT INTO `price` (`id`, `start_date`, `end_date`, `value`) VALUES (3, '2001-01-01', '2020-01-01', '100.21');
INSERT INTO `price` (`id`, `start_date`, `end_date`, `value`) VALUES (4, '2001-01-01', '2020-01-01', '200.21');

INSERT INTO `room` (`id`, `hotel_id`, `name`, `price_id`, `count`, `available`, `description`) VALUES (1, 1, 'Soba 1', 1,6,6,'Description of room');
INSERT INTO `room` (`id`, `hotel_id`, `name`, `price_id`, `count`, `available`, `description`) VALUES (2, 1, 'Soba 2', 2,9,9,'Description of room');

INSERT INTO `room` (`id`, `hotel_id`, `name`, `price_id`, `count`, `available`, `description`) VALUES (3, 2, 'Big room', 4,6,6,'Description of room');
INSERT INTO `room` (`id`, `hotel_id`, `name`, `price_id`, `count`, `available`, `description`) VALUES (4, 2, 'Small room', 3,9,9,'Description of room');


INSERT INTO `amenity` (`id`, `name`, `description`,`icon`) VALUES (1, 'Free WiFi', 'Free Wireless network','wifi');
INSERT INTO `amenity` (`id`, `name`, `description`,`icon`) VALUES (2, 'Free Parking', 'Free Parking','parking');

INSERT INTO `room_amenities` (`room_id`, `amenity_id`) VALUES (1, 1);

INSERT INTO `hotel_amenities` (`hotel_id`, `amenity_id`) VALUES (1, 2);

INSERT INTO `bed` (`id`, `name`,`icon`) VALUES (1, 'King size','king_size');
INSERT INTO `bed` (`id`, `name`,`icon`) VALUES (2, 'Full extra long','full_extra_long');
INSERT INTO `bed` (`id`, `name`,`icon`) VALUES (3, 'Cot size','cot_size');

INSERT INTO `room_bed` (`id`,`room_id`, `bed_id`,`count`) VALUES (1, 1, 1, 2);
INSERT INTO `room_bed` (`id`,`room_id`, `bed_id`,`count`) VALUES (2, 2, 3, 2);
