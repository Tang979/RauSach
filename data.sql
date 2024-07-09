-- --------------------------------------------------------
-- Máy chủ:                      127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Phiên bản:           12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table rausach.category: ~6 rows (approximately)
INSERT INTO `category` (`id`, `name`) VALUES
	('088f428e-6805-470e-9771-4f9aee86b6d5', 'Rau rừng'),
	('34ec3244-c7b6-4784-8405-aecce2511146', 'Rau xà lách'),
	('417010f3-a06b-4c41-bd29-0602eb2b9a1f', 'Rau ăn thân - lá'),
	('6131ed5b-1e32-48cd-a5fa-800cb5b767f3', 'Rau gia vị - Rau sống'),
	('6843c11d-49a4-4819-bfb2-01766eea4904', 'Rau cải'),
	('bbff9cc0-20c3-4074-bd73-412433bbe664', 'Rau lấy bông');

-- Dumping data for table rausach.discount_code: ~0 rows (approximately)

-- Dumping data for table rausach.oder: ~0 rows (approximately)

-- Dumping data for table rausach.order_details: ~0 rows (approximately)

-- Dumping data for table rausach.password_reset_token: ~0 rows (approximately)

-- Dumping data for table rausach.product: ~5 rows (approximately)
INSERT INTO `product` (`id`, `description`, `imageurl`, `name`, `price`, `category_id`) VALUES
	('0b14fdf6-f40b-4b7f-a154-4cff5c7a131e', '', '4cb4bc17-4139-4123-8788-ee9ee0d8cdea_xalach.jpg', 'Xà lách xanh', 19000, '34ec3244-c7b6-4784-8405-aecce2511146'),
	('1157e5ba-6c08-4626-8033-b1fa773addc9', '', '8cd715d0-b733-47cd-a4d1-86b44cf76f79_bongcaixanh.jpg', 'Bông cải xanh', 30000, '6843c11d-49a4-4819-bfb2-01766eea4904'),
	('1a308602-db75-430b-b255-ccec92bab969', '', 'd128d96c-b5ba-4845-9afe-5b47e6270015_xalachtim.jpg', 'Xà lách tím', 19000, '34ec3244-c7b6-4784-8405-aecce2511146'),
	('7137d164-d02f-4d62-9081-17a9a3e6ba6b', '', 'e61943cf-d9a3-4cd1-8db7-7e21ba5871ff_cai-be-xanh.jpg', 'Cải bẹ xanh', 20000, '6843c11d-49a4-4819-bfb2-01766eea4904'),
	('79da8fae-8ecb-4bd8-a1e3-a975a8ae29bc', '', '870ef448-917e-4379-b265-d172cf5e89a3_xalachfrisse.jpg', 'Xà lách frisse', 30000, '34ec3244-c7b6-4784-8405-aecce2511146'),
	('a5b8e692-d642-4d2b-8ad5-bf071d90ddf9', '', '608441e5-41e5-4aa3-94ca-6f6e24456795_hungque.jpg', 'Húng quế', 20000, '6131ed5b-1e32-48cd-a5fa-800cb5b767f3'),
	('bb309351-bde1-4790-a241-5f7a95661498', '', '909b728b-2de3-4d96-a200-478da858ef21_xalachbup.jpg', 'Xà lách búp', 24500, '34ec3244-c7b6-4784-8405-aecce2511146'),
	('d375365e-a007-408e-a274-1955d24273b0', '', 'e8be6223-fdf1-4fe8-b542-80a722bc7a95_Xalachmo.jpg', 'Xà lách mỡ', 25000, '34ec3244-c7b6-4784-8405-aecce2511146');

-- Dumping data for table rausach.role: ~2 rows (approximately)
INSERT INTO `role` (`id`, `name`) VALUES
	('08e3b19c-6a9b-4222-9171-dafa2dd50f4d', 'ADMIN'),
	('40b31cff-fc42-45b8-8121-43d4c37dec4b', 'USER'),
	('cc4c9d8c-b016-454e-9b1d-184be6910bc8', 'EMPLOYEE');

-- Dumping data for table rausach.user: ~2 rows (approximately)
INSERT INTO `user` (`id`, `address`, `email`, `full_name`, `password`, `phone`, `username`) VALUES
	('77884c7f-6fdc-4f99-99f6-ca1f45846dc0', NULL, 'tuankhoa542003@gmail.com', 'Tang Nguyen Tuan Khoa', '$2a$10$TO1pqQn68xNg5uSlK1uUe.qoYcu7SVf.6rB0jvPQJT1sbmhAlTpzu', '0336967745', 'user1'),
	('9114f724-9345-442e-b4a7-9b8b508511d1', NULL, 'admin@gmail.com', 'TANG NGUYEN TUAN KHOA', '$2a$10$d6vptfeEZ9UWY4hIvf0M6.1Eg79KABHl2.qlUhJF4QoDJFN4D4a0e', '3369677450', 'admin');

-- Dumping data for table rausach.user_role: ~1 rows (approximately)
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
	('9114f724-9345-442e-b4a7-9b8b508511d1', '08e3b19c-6a9b-4222-9171-dafa2dd50f4d'),
	('77884c7f-6fdc-4f99-99f6-ca1f45846dc0', '40b31cff-fc42-45b8-8121-43d4c37dec4b');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
