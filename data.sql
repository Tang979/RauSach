-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for rausach
CREATE DATABASE IF NOT EXISTS `rausach` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rausach`;

-- Dumping structure for table rausach.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table rausach.category: ~7 rows (approximately)
INSERT INTO `category` (`id`, `name`) VALUES
	('05f0dbed-3795-4316-95b8-b17f6cb461e8', 'Rau rừng'),
	('088f428e-6805-470e-9771-4f9aee86b6d5', 'Rau rừng'),
	('34ec3244-c7b6-4784-8405-aecce2511146', 'Rau xà lách'),
	('417010f3-a06b-4c41-bd29-0602eb2b9a1f', 'Rau ăn thân - lá'),
	('6131ed5b-1e32-48cd-a5fa-800cb5b767f3', 'Rau gia vị - Rau sống'),
	('6843c11d-49a4-4819-bfb2-01766eea4904', 'Rau cải'),
	('bbff9cc0-20c3-4074-bd73-412433bbe664', 'Rau lấy bông');

-- Dumping structure for table rausach.discount_code
CREATE TABLE IF NOT EXISTS `discount_code` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `discount_percentage` double NOT NULL,
  `is_active` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table rausach.discount_code: ~0 rows (approximately)

-- Dumping structure for table rausach.oder
CREATE TABLE IF NOT EXISTS `oder` (
  `id` varchar(255) NOT NULL,
  `oder_date` date DEFAULT NULL,
  `total_amount` bigint DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table rausach.oder: ~0 rows (approximately)
INSERT INTO `oder` (`id`, `oder_date`, `total_amount`, `customer_name`) VALUES
	('0eb290ff-712e-457d-a8ea-69268919e368', NULL, NULL, 'min'),
	('67d18da1-decb-46ca-aa87-65bb54e5ad7b', NULL, NULL, 'du');

-- Dumping structure for table rausach.order_details
CREATE TABLE IF NOT EXISTS `order_details` (
  `id` varchar(255) NOT NULL,
  `quantity` int NOT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsxk1v5no3jd1qjv01ocsf9ak3` (`order_id`),
  KEY `FKinivj2k1370kw224lavkm3rqm` (`product_id`),
  CONSTRAINT `FKinivj2k1370kw224lavkm3rqm` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKsxk1v5no3jd1qjv01ocsf9ak3` FOREIGN KEY (`order_id`) REFERENCES `oder` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table rausach.order_details: ~0 rows (approximately)
INSERT INTO `order_details` (`id`, `quantity`, `order_id`, `product_id`) VALUES
	('1', 1, '0eb290ff-712e-457d-a8ea-69268919e368', '0b14fdf6-f40b-4b7f-a154-4cff5c7a131e'),
	('2', 1, '67d18da1-decb-46ca-aa87-65bb54e5ad7b', '0b14fdf6-f40b-4b7f-a154-4cff5c7a131e');

-- Dumping structure for table rausach.password_reset_token
CREATE TABLE IF NOT EXISTS `password_reset_token` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `expiry_date` datetime(6) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKf90ivichjaokvmovxpnlm5nin` (`user_id`),
  CONSTRAINT `FK5lwtbncug84d4ero33v3cfxvl` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table rausach.password_reset_token: ~0 rows (approximately)

-- Dumping structure for table rausach.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `imageurl` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `category_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `product_chk_1` CHECK ((`price` >= 1000))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table rausach.product: ~5 rows (approximately)
INSERT INTO `product` (`id`, `description`, `imageurl`, `name`, `price`, `category_id`) VALUES
	('05161db6-c418-4015-8e8a-a3c3af495fbf', '', 'cc3aa8fa-889f-46a0-965c-60df4024005b_xl lo lo.png', 'Xà lách Lo Lo', 19000, '34ec3244-c7b6-4784-8405-aecce2511146'),
	('0b14fdf6-f40b-4b7f-a154-4cff5c7a131e', '', '4cb4bc17-4139-4123-8788-ee9ee0d8cdea_xalach.jpg', 'Xà lách xanh', 19000, '34ec3244-c7b6-4784-8405-aecce2511146'),
	('10eee659-1dc7-4a3c-8df2-fa2e4a2e06d7', '', '041ac5c7-f783-496d-b84e-8fe70e1cc933_bí.png', 'Bông Bí', 15000, 'bbff9cc0-20c3-4074-bd73-412433bbe664'),
	('1157e5ba-6c08-4626-8033-b1fa773addc9', '', '8cd715d0-b733-47cd-a4d1-86b44cf76f79_bongcaixanh.jpg', 'Bông cải xanh', 30000, '6843c11d-49a4-4819-bfb2-01766eea4904'),
	('1a308602-db75-430b-b255-ccec92bab969', '', 'd128d96c-b5ba-4845-9afe-5b47e6270015_xalachtim.jpg', 'Xà lách tím', 19000, '34ec3244-c7b6-4784-8405-aecce2511146'),
	('21cbd174-9c4e-47db-9b1b-783591f16a1c', '', '08d3a77f-dc16-4ab6-95d0-fe75ad1f9ef5_tiêu.png', 'Tiêu', 25000, '6131ed5b-1e32-48cd-a5fa-800cb5b767f3'),
	('246cf726-babc-4ca6-9b5b-cf08301dbe7d', '', 'f159bb55-bcb9-404e-af05-473e73848ad3_điên điển.png', 'Bông Điên Điển', 36000, 'bbff9cc0-20c3-4074-bd73-412433bbe664'),
	('26b4bcb9-a3ef-447c-aaf9-736c1102bc91', '', '6f91955c-4264-48d0-9d7d-7abd9d414a7d_xl frisse.png', 'Xà Lách ', 30000, '34ec3244-c7b6-4784-8405-aecce2511146'),
	('2b99f73c-d8dc-4725-8109-45ac6d81c588', '', '058b6eb1-f535-4926-8e7e-319da71e1640_Thiên lý.png', 'Bông Thiên Lý', 48000, 'bbff9cc0-20c3-4074-bd73-412433bbe664'),
	('2f730d42-82a2-4fde-9ea9-ff6d6545c094', '', 'cae80250-2699-4e6f-a9e4-49e6258a8ce6_quế vị.png', 'Quế Vị', 22000, '05f0dbed-3795-4316-95b8-b17f6cb461e8'),
	('3937d9bd-ae73-40ae-a7b6-3624b3bb5649', '', '800895b5-d9d4-415d-a525-cd3f23326a09_cải thảo.png', 'Cải Thảo', 22000, '6843c11d-49a4-4819-bfb2-01766eea4904'),
	('47d79544-bb1b-47cc-9b3a-623794163a69', '', 'a8a02d80-66fe-47de-93b9-ad26d57b641d_ATISO.png', 'Atiso', 250000, 'bbff9cc0-20c3-4074-bd73-412433bbe664'),
	('4f7b6c31-6521-4e07-b27b-b8a1053b6231', '', '23eb90b2-7bef-48a0-9ddc-fba0a6c9c61a_sao nhai.png', 'Sao Nhai', 29000, '05f0dbed-3795-4316-95b8-b17f6cb461e8'),
	('5149c6df-c1b8-40a0-9083-532b7dc682c3', '', 'f8f76daa-6109-4310-8f75-e80655b14efb_so đủa.png', 'Bông So Đủa', 21000, 'bbff9cc0-20c3-4074-bd73-412433bbe664'),
	('5f4715f1-08e6-4739-8119-92f2f7f3a6a1', '', '834c2840-3082-4347-9e9b-7b156a984a6a_cải ngọt.png', 'Cải Ngọt', 15000, '6843c11d-49a4-4819-bfb2-01766eea4904'),
	('7137d164-d02f-4d62-9081-17a9a3e6ba6b', '', 'e61943cf-d9a3-4cd1-8db7-7e21ba5871ff_cai-be-xanh.jpg', 'Cải bẹ xanh', 20000, '6843c11d-49a4-4819-bfb2-01766eea4904'),
	('798fe605-81a9-437b-a9d3-e51fd04f3c65', '', 'd55e66e4-b8f6-4bdf-9597-5f653c411827_ngò.png', 'Ngò', 8000, '6131ed5b-1e32-48cd-a5fa-800cb5b767f3'),
	('7af1bc1a-d296-447e-80b0-da5bbf50c82f', '', 'f584b873-bd9e-4dc7-8a83-22b6fc1dc8a7_lá é.png', 'Lá É', 14000, '6131ed5b-1e32-48cd-a5fa-800cb5b767f3'),
	('90cbf493-99d9-4f6c-86a5-f2b5840bd261', '', '26724ac3-6a88-4e37-bb6b-1485f20a771a_cải rổ.png', 'Cải Rổ', 18000, '6843c11d-49a4-4819-bfb2-01766eea4904'),
	('9d4110da-b7d6-4836-9038-0783caf73b83', '', '3c5a328e-fcb1-46cf-96aa-eff3befc03a5_xl tím.png', 'Xà Lách Tím', 26000, '34ec3244-c7b6-4784-8405-aecce2511146'),
	('a5b8e692-d642-4d2b-8ad5-bf071d90ddf9', '', '608441e5-41e5-4aa3-94ca-6f6e24456795_hungque.jpg', 'Húng quế', 20000, '6131ed5b-1e32-48cd-a5fa-800cb5b767f3'),
	('bfb8ecc7-cf2c-436c-9111-822d5521cade', '', 'ed3a6db6-0bb4-46a8-beaa-39ad20ee3e9e_bí bái.png', 'Bí Bái', 18000, '05f0dbed-3795-4316-95b8-b17f6cb461e8'),
	('f3225dbe-f60f-4b33-8089-68452f58fb8d', '', 'a339e9b9-9912-4c52-a448-a35983022767_thì là.png', 'Thì Là', 16000, '6131ed5b-1e32-48cd-a5fa-800cb5b767f3');

-- Dumping structure for table rausach.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` varchar(255) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table rausach.role: ~3 rows (approximately)
INSERT INTO `role` (`id`, `name`) VALUES
	('08e3b19c-6a9b-4222-9171-dafa2dd50f4d', 'ADMIN'),
	('40b31cff-fc42-45b8-8121-43d4c37dec4b', 'USER'),
	('cc4c9d8c-b016-454e-9b1d-184be6910bc8', 'EMPLOYEE');

-- Dumping structure for table rausach.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `password` varchar(250) NOT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`),
  UNIQUE KEY `UK589idila9li6a4arw1t8ht1gx` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table rausach.user: ~3 rows (approximately)
INSERT INTO `user` (`id`, `address`, `email`, `full_name`, `password`, `phone`, `username`) VALUES
	('72c1d179-f768-473e-bb1d-8a11af94d6ca', NULL, 'minhallk.vk@gmail.com', 'minh', '$2a$10$MwpsqKFqxwB.ThgmRBjI0eoX0rclZbRBAtSTFiCrdK.KcKpYSp0tK', '0987654123', 'minmin'),
	('77884c7f-6fdc-4f99-99f6-ca1f45846dc0', NULL, 'user1@gmail.com', 'Tang Nguyen Tuan Khoa', '$2a$10$jc6qQPOLSFVtalHHhBlMBOMfF4BzRdio/QO.Az5Iv6FfdW5Ysf6.C', '0336967745', 'user1'),
	('9114f724-9345-442e-b4a7-9b8b508511d1', NULL, 'admin@gmail.com', 'TANG NGUYEN TUAN KHOA', '$2a$10$d6vptfeEZ9UWY4hIvf0M6.1Eg79KABHl2.qlUhJF4QoDJFN4D4a0e', '3369677450', 'admin'),
	('c48fc738-cfcd-43d2-8628-96bff80a2cdd', NULL, 'tuankhoa542003@gmail.com', '0680_Tăng Nguyễn Tuấn Khoa', '$2a$10$3ZjGOiw4Rj3Vfine/5zivOhVYlG.MGoU75kTKo/dweY9ZmgunmQAe', NULL, '0680_Tăng Nguyễn Tuấn Khoa');

-- Dumping structure for table rausach.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table rausach.user_role: ~2 rows (approximately)
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
	('72c1d179-f768-473e-bb1d-8a11af94d6ca', '08e3b19c-6a9b-4222-9171-dafa2dd50f4d'),
	('9114f724-9345-442e-b4a7-9b8b508511d1', '08e3b19c-6a9b-4222-9171-dafa2dd50f4d'),
	('77884c7f-6fdc-4f99-99f6-ca1f45846dc0', '40b31cff-fc42-45b8-8121-43d4c37dec4b');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
