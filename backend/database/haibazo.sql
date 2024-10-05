-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 05, 2024 at 08:24 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `haibazo`
--

-- --------------------------------------------------------

--
-- Table structure for table `carts`
--

CREATE TABLE `carts` (
  `id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `product_detail_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `carts`
--

INSERT INTO `carts` (`id`, `created_at`, `quantity`, `updated_at`, `product_detail_id`) VALUES
(2, NULL, 10, NULL, 3),
(3, NULL, 10, NULL, 2);

-- --------------------------------------------------------

--
-- Table structure for table `constants`
--

CREATE TABLE `constants` (
  `id` int(11) NOT NULL,
  `type` enum('CATEGORY','COLOR','SIZE','STYLE') DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `constants`
--

INSERT INTO `constants` (`id`, `type`, `value`) VALUES
(1, 'CATEGORY', 'Home & Decor'),
(2, 'CATEGORY', 'Cloting'),
(3, 'CATEGORY', 'Accessories'),
(4, 'CATEGORY', 'Outdoor'),
(5, 'STYLE', 'Morden'),
(6, 'STYLE', 'Sweetwear'),
(7, 'STYLE', 'ColorFull'),
(8, 'STYLE', 'Patchwork'),
(9, 'STYLE', 'Bohemiam'),
(10, 'STYLE', 'Vintage'),
(11, 'COLOR', '#21c89a'),
(12, 'COLOR', '#ae83f7'),
(13, 'COLOR', '#e05564'),
(14, 'COLOR', '#121212'),
(15, 'SIZE', 'S'),
(16, 'SIZE', 'M'),
(17, 'SIZE', 'L'),
(18, 'SIZE', 'XL'),
(19, 'SIZE', '2XL'),
(21, 'COLOR', '#fff'),
(22, 'SIZE', 'SM'),
(23, 'COLOR', '#000');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `discount_to` date DEFAULT NULL,
  `gender` enum('FEMALE','MALE','UNISEX') DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `rating_count` int(11) DEFAULT NULL,
  `viewed_count` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `style_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `description`, `discount`, `discount_to`, `gender`, `is_deleted`, `name`, `price`, `rating`, `rating_count`, `viewed_count`, `category_id`, `style_id`) VALUES
(1, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 51, '2025-03-26', 'MALE', b'1', 'Sang trọng Áo khoác', 82008, 5, 0, 6, 1, 5),
(2, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 23, '2025-03-13', 'UNISEX', b'0', 'Thoải mái Áo khoác', 51659, 5, 0, 0, 1, 6),
(3, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 32, '2025-03-22', 'FEMALE', b'0', 'Mới Áo thun', 93007, 5, 0, 0, 1, 7),
(4, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 68, '2024-11-01', 'UNISEX', b'0', 'Mới Áo khoác', 70130, 5, 0, 0, 1, 8),
(5, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 90, '2024-12-25', 'MALE', b'0', 'Phong cách Áo khoác', 88800, 5, 0, 0, 1, 9),
(6, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 34, '2025-04-14', 'MALE', b'0', 'Sang trọng Váy', 64617, 5, 0, 0, 1, 10),
(7, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 96, '2024-12-14', 'MALE', b'0', 'Mới Váy', 80198, 5, 0, 0, 2, 5),
(8, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 32, '2025-03-27', 'MALE', b'0', 'Thoải mái Quần short', 75705, 5, 0, 0, 2, 6),
(9, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 44, '2025-07-26', 'UNISEX', b'0', 'Phong cách Áo thun', 91383, 5, 0, 0, 2, 7),
(10, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 22, '2025-01-11', 'FEMALE', b'0', 'Sang trọng Áo sơ mi', 50186, 5, 0, 0, 2, 8),
(11, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 82, '2024-11-20', 'UNISEX', b'0', 'Thoải mái Áo khoác', 60763, 5, 0, 0, 2, 9),
(12, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 49, '2025-09-10', 'MALE', b'0', 'Thời trang Quần short', 52002, 5, 0, 2, 2, 10),
(13, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 69, '2025-06-06', 'FEMALE', b'0', 'Thời trang Áo khoác', 54390, 5, 0, 0, 3, 5),
(14, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 79, '2024-11-18', 'UNISEX', b'0', 'Sang trọng Áo thun', 92425, 5, 0, 0, 3, 6),
(15, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 3, '2024-11-14', 'UNISEX', b'0', 'Sang trọng Áo sơ mi', 73306, 5, 0, 0, 3, 7),
(16, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 83, '2025-05-01', 'FEMALE', b'0', 'Thoải mái Quần jeans', 93656, 5, 0, 0, 3, 8),
(17, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 40, '2025-04-25', 'MALE', b'0', 'Phong cách Váy', 73033, 5, 0, 0, 3, 9),
(18, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 58, '2025-08-26', 'UNISEX', b'0', 'Thời trang Quần jeans', 58092, 5, 0, 0, 3, 10),
(19, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 82, '2025-09-24', 'UNISEX', b'0', 'Sang trọng Áo thun', 93274, 5, 0, 0, 4, 5),
(20, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 64, '2025-03-06', 'UNISEX', b'0', 'Sang trọng Quần short', 60537, 5, 0, 0, 4, 6),
(21, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 80, '2025-08-31', 'UNISEX', b'0', 'Năng động Áo sơ mi', 77938, 5, 0, 0, 4, 7),
(22, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 79, '2025-07-18', 'UNISEX', b'0', 'Sang trọng Quần jeans', 55033, 5, 0, 0, 4, 8),
(23, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 31, '2025-08-23', 'FEMALE', b'0', 'Thoải mái Quần short', 80651, 5, 0, 0, 4, 9),
(24, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 47, '2025-02-23', 'MALE', b'0', 'Phong cách Quần short', 69296, 5, 0, 0, 4, 10),
(25, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', 0, '2025-09-10', 'MALE', b'0', 'Áo khoác sáng', 7000, 5, 0, 2, 2, 10);

-- --------------------------------------------------------

--
-- Table structure for table `product_details`
--

CREATE TABLE `product_details` (
  `id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `color_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `size_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product_details`
--

INSERT INTO `product_details` (`id`, `quantity`, `color_id`, `product_id`, `size_id`) VALUES
(1, 3, 11, 1, 15),
(2, 24, 11, 1, 16),
(3, 17, 11, 1, 17),
(4, 6, 11, 1, 18),
(5, 5, 11, 1, 19),
(6, 3, 12, 1, 15),
(7, 15, 12, 1, 16),
(8, 22, 12, 1, 17),
(9, 25, 12, 1, 18),
(10, 27, 12, 1, 19),
(11, 12, 13, 1, 15),
(12, 14, 13, 1, 16),
(13, 15, 13, 1, 17),
(14, 10, 13, 1, 18),
(15, 22, 13, 1, 19),
(16, 10, 14, 1, 15),
(17, 10, 14, 1, 16),
(18, 11, 14, 1, 17),
(19, 11, 14, 1, 18),
(20, 11, 14, 1, 19),
(21, 27, 11, 2, 15),
(22, 25, 11, 2, 16),
(23, 15, 11, 2, 17),
(24, 22, 11, 2, 18),
(25, 13, 11, 2, 19),
(26, 0, 12, 2, 15),
(27, 10, 12, 2, 16),
(28, 28, 12, 2, 17),
(29, 14, 12, 2, 18),
(30, 0, 12, 2, 19),
(31, 19, 13, 2, 15),
(32, 18, 13, 2, 16),
(33, 24, 13, 2, 17),
(34, 2, 13, 2, 18),
(35, 25, 13, 2, 19),
(36, 4, 14, 2, 15),
(37, 9, 14, 2, 16),
(38, 16, 14, 2, 17),
(39, 24, 14, 2, 18),
(40, 2, 14, 2, 19),
(41, 3, 11, 3, 15),
(42, 23, 11, 3, 16),
(43, 24, 11, 3, 17),
(44, 27, 11, 3, 18),
(45, 15, 11, 3, 19),
(46, 15, 12, 3, 15),
(47, 7, 12, 3, 16),
(48, 12, 12, 3, 17),
(49, 9, 12, 3, 18),
(50, 19, 12, 3, 19),
(51, 4, 13, 3, 15),
(52, 21, 13, 3, 16),
(53, 8, 13, 3, 17),
(54, 17, 13, 3, 18),
(55, 11, 13, 3, 19),
(56, 25, 14, 3, 15),
(57, 7, 14, 3, 16),
(58, 14, 14, 3, 17),
(59, 9, 14, 3, 18),
(60, 5, 14, 3, 19),
(61, 9, 11, 4, 15),
(62, 15, 11, 4, 16),
(63, 13, 11, 4, 17),
(64, 6, 11, 4, 18),
(65, 25, 11, 4, 19),
(66, 10, 12, 4, 15),
(67, 14, 12, 4, 16),
(68, 7, 12, 4, 17),
(69, 3, 12, 4, 18),
(70, 16, 12, 4, 19),
(71, 24, 13, 4, 15),
(72, 6, 13, 4, 16),
(73, 13, 13, 4, 17),
(74, 7, 13, 4, 18),
(75, 6, 13, 4, 19),
(76, 21, 14, 4, 15),
(77, 21, 14, 4, 16),
(78, 0, 14, 4, 17),
(79, 25, 14, 4, 18),
(80, 18, 14, 4, 19),
(81, 17, 11, 5, 15),
(82, 18, 11, 5, 16),
(83, 10, 11, 5, 17),
(84, 23, 11, 5, 18),
(85, 24, 11, 5, 19),
(86, 9, 12, 5, 15),
(87, 23, 12, 5, 16),
(88, 19, 12, 5, 17),
(89, 0, 12, 5, 18),
(90, 12, 12, 5, 19),
(91, 3, 13, 5, 15),
(92, 20, 13, 5, 16),
(93, 27, 13, 5, 17),
(94, 22, 13, 5, 18),
(95, 14, 13, 5, 19),
(96, 21, 14, 5, 15),
(97, 1, 14, 5, 16),
(98, 13, 14, 5, 17),
(99, 10, 14, 5, 18),
(100, 11, 14, 5, 19),
(101, 22, 11, 6, 15),
(102, 3, 11, 6, 16),
(103, 22, 11, 6, 17),
(104, 3, 11, 6, 18),
(105, 22, 11, 6, 19),
(106, 28, 12, 6, 15),
(107, 19, 12, 6, 16),
(108, 16, 12, 6, 17),
(109, 20, 12, 6, 18),
(110, 11, 12, 6, 19),
(111, 6, 13, 6, 15),
(112, 21, 13, 6, 16),
(113, 0, 13, 6, 17),
(114, 12, 13, 6, 18),
(115, 14, 13, 6, 19),
(116, 4, 14, 6, 15),
(117, 23, 14, 6, 16),
(118, 17, 14, 6, 17),
(119, 17, 14, 6, 18),
(120, 9, 14, 6, 19),
(121, 21, 11, 7, 15),
(122, 27, 11, 7, 16),
(123, 27, 11, 7, 17),
(124, 8, 11, 7, 18),
(125, 16, 11, 7, 19),
(126, 20, 12, 7, 15),
(127, 21, 12, 7, 16),
(128, 4, 12, 7, 17),
(129, 1, 12, 7, 18),
(130, 25, 12, 7, 19),
(131, 14, 13, 7, 15),
(132, 6, 13, 7, 16),
(133, 27, 13, 7, 17),
(134, 7, 13, 7, 18),
(135, 16, 13, 7, 19),
(136, 10, 14, 7, 15),
(137, 28, 14, 7, 16),
(138, 10, 14, 7, 17),
(139, 24, 14, 7, 18),
(140, 20, 14, 7, 19),
(141, 10, 11, 8, 15),
(142, 17, 11, 8, 16),
(143, 4, 11, 8, 17),
(144, 25, 11, 8, 18),
(145, 8, 11, 8, 19),
(146, 17, 12, 8, 15),
(147, 7, 12, 8, 16),
(148, 3, 12, 8, 17),
(149, 20, 12, 8, 18),
(150, 24, 12, 8, 19),
(151, 27, 13, 8, 15),
(152, 8, 13, 8, 16),
(153, 3, 13, 8, 17),
(154, 26, 13, 8, 18),
(155, 17, 13, 8, 19),
(156, 6, 14, 8, 15),
(157, 23, 14, 8, 16),
(158, 11, 14, 8, 17),
(159, 14, 14, 8, 18),
(160, 12, 14, 8, 19),
(161, 0, 11, 9, 15),
(162, 24, 11, 9, 16),
(163, 4, 11, 9, 17),
(164, 21, 11, 9, 18),
(165, 10, 11, 9, 19),
(166, 19, 12, 9, 15),
(167, 9, 12, 9, 16),
(168, 22, 12, 9, 17),
(169, 10, 12, 9, 18),
(170, 14, 12, 9, 19),
(171, 27, 13, 9, 15),
(172, 10, 13, 9, 16),
(173, 18, 13, 9, 17),
(174, 1, 13, 9, 18),
(175, 10, 13, 9, 19),
(176, 3, 14, 9, 15),
(177, 18, 14, 9, 16),
(178, 23, 14, 9, 17),
(179, 5, 14, 9, 18),
(180, 23, 14, 9, 19),
(181, 28, 11, 10, 15),
(182, 20, 11, 10, 16),
(183, 20, 11, 10, 17),
(184, 23, 11, 10, 18),
(185, 15, 11, 10, 19),
(186, 1, 12, 10, 15),
(187, 24, 12, 10, 16),
(188, 14, 12, 10, 17),
(189, 5, 12, 10, 18),
(190, 14, 12, 10, 19),
(191, 16, 13, 10, 15),
(192, 18, 13, 10, 16),
(193, 9, 13, 10, 17),
(194, 4, 13, 10, 18),
(195, 5, 13, 10, 19),
(196, 12, 14, 10, 15),
(197, 14, 14, 10, 16),
(198, 23, 14, 10, 17),
(199, 11, 14, 10, 18),
(200, 11, 14, 10, 19),
(201, 10, 11, 11, 15),
(202, 21, 11, 11, 16),
(203, 12, 11, 11, 17),
(204, 23, 11, 11, 18),
(205, 16, 11, 11, 19),
(206, 6, 12, 11, 15),
(207, 11, 12, 11, 16),
(208, 19, 12, 11, 17),
(209, 0, 12, 11, 18),
(210, 6, 12, 11, 19),
(211, 17, 13, 11, 15),
(212, 6, 13, 11, 16),
(213, 23, 13, 11, 17),
(214, 13, 13, 11, 18),
(215, 13, 13, 11, 19),
(216, 16, 14, 11, 15),
(217, 21, 14, 11, 16),
(218, 24, 14, 11, 17),
(219, 14, 14, 11, 18),
(220, 11, 14, 11, 19),
(221, 4, 11, 12, 15),
(222, 6, 11, 12, 16),
(223, 21, 11, 12, 17),
(224, 17, 11, 12, 18),
(225, 6, 11, 12, 19),
(226, 10, 12, 12, 15),
(227, 8, 12, 12, 16),
(228, 24, 12, 12, 17),
(229, 13, 12, 12, 18),
(230, 9, 12, 12, 19),
(231, 18, 13, 12, 15),
(232, 19, 13, 12, 16),
(233, 21, 13, 12, 17),
(234, 12, 13, 12, 18),
(235, 2, 13, 12, 19),
(236, 18, 14, 12, 15),
(237, 2, 14, 12, 16),
(238, 15, 14, 12, 17),
(239, 24, 14, 12, 18),
(240, 15, 14, 12, 19),
(241, 9, 11, 13, 15),
(242, 10, 11, 13, 16),
(243, 23, 11, 13, 17),
(244, 14, 11, 13, 18),
(245, 0, 11, 13, 19),
(246, 22, 12, 13, 15),
(247, 12, 12, 13, 16),
(248, 1, 12, 13, 17),
(249, 24, 12, 13, 18),
(250, 19, 12, 13, 19),
(251, 17, 13, 13, 15),
(252, 13, 13, 13, 16),
(253, 6, 13, 13, 17),
(254, 27, 13, 13, 18),
(255, 27, 13, 13, 19),
(256, 19, 14, 13, 15),
(257, 20, 14, 13, 16),
(258, 13, 14, 13, 17),
(259, 4, 14, 13, 18),
(260, 25, 14, 13, 19),
(261, 25, 11, 14, 15),
(262, 17, 11, 14, 16),
(263, 4, 11, 14, 17),
(264, 16, 11, 14, 18),
(265, 5, 11, 14, 19),
(266, 17, 12, 14, 15),
(267, 10, 12, 14, 16),
(268, 22, 12, 14, 17),
(269, 19, 12, 14, 18),
(270, 14, 12, 14, 19),
(271, 28, 13, 14, 15),
(272, 20, 13, 14, 16),
(273, 7, 13, 14, 17),
(274, 26, 13, 14, 18),
(275, 16, 13, 14, 19),
(276, 22, 14, 14, 15),
(277, 3, 14, 14, 16),
(278, 0, 14, 14, 17),
(279, 15, 14, 14, 18),
(280, 9, 14, 14, 19),
(281, 26, 11, 15, 15),
(282, 10, 11, 15, 16),
(283, 16, 11, 15, 17),
(284, 23, 11, 15, 18),
(285, 11, 11, 15, 19),
(286, 2, 12, 15, 15),
(287, 25, 12, 15, 16),
(288, 0, 12, 15, 17),
(289, 11, 12, 15, 18),
(290, 23, 12, 15, 19),
(291, 5, 13, 15, 15),
(292, 9, 13, 15, 16),
(293, 8, 13, 15, 17),
(294, 6, 13, 15, 18),
(295, 23, 13, 15, 19),
(296, 2, 14, 15, 15),
(297, 16, 14, 15, 16),
(298, 17, 14, 15, 17),
(299, 16, 14, 15, 18),
(300, 21, 14, 15, 19),
(301, 9, 11, 16, 15),
(302, 22, 11, 16, 16),
(303, 7, 11, 16, 17),
(304, 14, 11, 16, 18),
(305, 16, 11, 16, 19),
(306, 17, 12, 16, 15),
(307, 28, 12, 16, 16),
(308, 27, 12, 16, 17),
(309, 11, 12, 16, 18),
(310, 20, 12, 16, 19),
(311, 1, 13, 16, 15),
(312, 6, 13, 16, 16),
(313, 9, 13, 16, 17),
(314, 17, 13, 16, 18),
(315, 0, 13, 16, 19),
(316, 22, 14, 16, 15),
(317, 1, 14, 16, 16),
(318, 3, 14, 16, 17),
(319, 18, 14, 16, 18),
(320, 19, 14, 16, 19),
(321, 27, 11, 17, 15),
(322, 21, 11, 17, 16),
(323, 10, 11, 17, 17),
(324, 4, 11, 17, 18),
(325, 25, 11, 17, 19),
(326, 9, 12, 17, 15),
(327, 12, 12, 17, 16),
(328, 28, 12, 17, 17),
(329, 23, 12, 17, 18),
(330, 16, 12, 17, 19),
(331, 20, 13, 17, 15),
(332, 1, 13, 17, 16),
(333, 12, 13, 17, 17),
(334, 16, 13, 17, 18),
(335, 6, 13, 17, 19),
(336, 0, 14, 17, 15),
(337, 10, 14, 17, 16),
(338, 21, 14, 17, 17),
(339, 16, 14, 17, 18),
(340, 10, 14, 17, 19),
(341, 20, 11, 18, 15),
(342, 1, 11, 18, 16),
(343, 3, 11, 18, 17),
(344, 4, 11, 18, 18),
(345, 21, 11, 18, 19),
(346, 21, 12, 18, 15),
(347, 3, 12, 18, 16),
(348, 17, 12, 18, 17),
(349, 22, 12, 18, 18),
(350, 3, 12, 18, 19),
(351, 0, 13, 18, 15),
(352, 5, 13, 18, 16),
(353, 1, 13, 18, 17),
(354, 10, 13, 18, 18),
(355, 14, 13, 18, 19),
(356, 14, 14, 18, 15),
(357, 20, 14, 18, 16),
(358, 8, 14, 18, 17),
(359, 9, 14, 18, 18),
(360, 9, 14, 18, 19),
(361, 4, 11, 19, 15),
(362, 9, 11, 19, 16),
(363, 23, 11, 19, 17),
(364, 8, 11, 19, 18),
(365, 6, 11, 19, 19),
(366, 26, 12, 19, 15),
(367, 20, 12, 19, 16),
(368, 6, 12, 19, 17),
(369, 1, 12, 19, 18),
(370, 3, 12, 19, 19),
(371, 14, 13, 19, 15),
(372, 6, 13, 19, 16),
(373, 10, 13, 19, 17),
(374, 19, 13, 19, 18),
(375, 16, 13, 19, 19),
(376, 0, 14, 19, 15),
(377, 16, 14, 19, 16),
(378, 5, 14, 19, 17),
(379, 10, 14, 19, 18),
(380, 13, 14, 19, 19),
(381, 13, 11, 20, 15),
(382, 1, 11, 20, 16),
(383, 9, 11, 20, 17),
(384, 5, 11, 20, 18),
(385, 24, 11, 20, 19),
(386, 16, 12, 20, 15),
(387, 18, 12, 20, 16),
(388, 10, 12, 20, 17),
(389, 21, 12, 20, 18),
(390, 15, 12, 20, 19),
(391, 16, 13, 20, 15),
(392, 14, 13, 20, 16),
(393, 8, 13, 20, 17),
(394, 18, 13, 20, 18),
(395, 11, 13, 20, 19),
(396, 3, 14, 20, 15),
(397, 10, 14, 20, 16),
(398, 22, 14, 20, 17),
(399, 5, 14, 20, 18),
(400, 12, 14, 20, 19),
(401, 2, 11, 21, 15),
(402, 2, 11, 21, 16),
(403, 6, 11, 21, 17),
(404, 28, 11, 21, 18),
(405, 1, 11, 21, 19),
(406, 23, 12, 21, 15),
(407, 13, 12, 21, 16),
(408, 4, 12, 21, 17),
(409, 18, 12, 21, 18),
(410, 20, 12, 21, 19),
(411, 16, 13, 21, 15),
(412, 12, 13, 21, 16),
(413, 1, 13, 21, 17),
(414, 13, 13, 21, 18),
(415, 24, 13, 21, 19),
(416, 0, 14, 21, 15),
(417, 6, 14, 21, 16),
(418, 18, 14, 21, 17),
(419, 19, 14, 21, 18),
(420, 19, 14, 21, 19),
(421, 19, 11, 22, 15),
(422, 25, 11, 22, 16),
(423, 25, 11, 22, 17),
(424, 21, 11, 22, 18),
(425, 25, 11, 22, 19),
(426, 7, 12, 22, 15),
(427, 26, 12, 22, 16),
(428, 26, 12, 22, 17),
(429, 22, 12, 22, 18),
(430, 24, 12, 22, 19),
(431, 11, 13, 22, 15),
(432, 17, 13, 22, 16),
(433, 23, 13, 22, 17),
(434, 16, 13, 22, 18),
(435, 24, 13, 22, 19),
(436, 12, 14, 22, 15),
(437, 6, 14, 22, 16),
(438, 25, 14, 22, 17),
(439, 5, 14, 22, 18),
(440, 17, 14, 22, 19),
(441, 22, 11, 23, 15),
(442, 0, 11, 23, 16),
(443, 20, 11, 23, 17),
(444, 24, 11, 23, 18),
(445, 16, 11, 23, 19),
(446, 2, 12, 23, 15),
(447, 8, 12, 23, 16),
(448, 19, 12, 23, 17),
(449, 20, 12, 23, 18),
(450, 3, 12, 23, 19),
(451, 23, 13, 23, 15),
(452, 16, 13, 23, 16),
(453, 4, 13, 23, 17),
(454, 27, 13, 23, 18),
(455, 25, 13, 23, 19),
(456, 10, 14, 23, 15),
(457, 25, 14, 23, 16),
(458, 5, 14, 23, 17),
(459, 16, 14, 23, 18),
(460, 11, 14, 23, 19),
(461, 4, 11, 24, 15),
(462, 20, 11, 24, 16),
(463, 8, 11, 24, 17),
(464, 4, 11, 24, 18),
(465, 8, 11, 24, 19),
(466, 11, 12, 24, 15),
(467, 10, 12, 24, 16),
(468, 12, 12, 24, 17),
(469, 27, 12, 24, 18),
(470, 22, 12, 24, 19),
(471, 25, 13, 24, 15),
(472, 13, 13, 24, 16),
(473, 0, 13, 24, 17),
(474, 3, 13, 24, 18),
(475, 6, 13, 24, 19),
(476, 12, 14, 24, 15),
(477, 3, 14, 24, 16),
(478, 11, 14, 24, 17),
(479, 26, 14, 24, 18),
(480, 17, 14, 24, 19),
(481, 100, 23, 25, 22),
(482, 20, 21, 25, 19);

-- --------------------------------------------------------

--
-- Table structure for table `product_images`
--

CREATE TABLE `product_images` (
  `id` int(11) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product_images`
--

INSERT INTO `product_images` (`id`, `url`, `product_id`) VALUES
(1, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 1),
(2, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 1),
(3, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 1),
(4, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 1),
(5, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 1),
(6, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 2),
(7, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 2),
(8, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 2),
(9, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 2),
(10, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 2),
(11, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 3),
(12, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 3),
(13, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 3),
(14, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 3),
(15, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 3),
(16, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 4),
(17, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 4),
(18, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 4),
(19, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 4),
(20, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 4),
(21, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 5),
(22, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 5),
(23, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 5),
(24, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 5),
(25, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 5),
(26, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 6),
(27, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 6),
(28, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 6),
(29, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 6),
(30, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 6),
(31, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 7),
(32, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 7),
(33, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 7),
(34, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 7),
(35, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 7),
(36, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 8),
(37, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 8),
(38, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 8),
(39, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 8),
(40, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 8),
(41, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 9),
(42, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 9),
(43, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 9),
(44, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 9),
(45, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 9),
(46, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 10),
(47, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 10),
(48, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 10),
(49, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 10),
(50, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 10),
(51, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 11),
(52, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 11),
(53, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 11),
(54, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 11),
(55, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 11),
(56, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 12),
(57, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 12),
(58, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 12),
(59, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 12),
(60, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 12),
(61, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 13),
(62, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 13),
(63, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 13),
(64, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 13),
(65, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 13),
(66, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 14),
(67, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 14),
(68, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 14),
(69, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 14),
(70, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 14),
(71, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 15),
(72, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 15),
(73, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 15),
(74, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 15),
(75, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 15),
(76, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 16),
(77, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 16),
(78, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 16),
(79, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 16),
(80, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 16),
(81, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 17),
(82, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 17),
(83, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 17),
(84, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 17),
(85, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 17),
(86, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 18),
(87, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 18),
(88, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 18),
(89, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 18),
(90, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 18),
(91, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 19),
(92, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 19),
(93, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 19),
(94, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 19),
(95, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 19),
(96, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 20),
(97, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 20),
(98, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 20),
(99, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 20),
(100, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 20),
(101, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 21),
(102, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 21),
(103, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 21),
(104, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 21),
(105, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 21),
(106, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 22),
(107, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 22),
(108, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 22),
(109, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 22),
(110, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 22),
(111, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 23),
(112, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 23),
(113, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 23),
(114, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 23),
(115, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 23),
(116, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 24),
(117, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 24),
(118, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 24),
(119, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 24),
(120, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 24),
(121, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/3_pva2f1.jpg', 25),
(122, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/5_lhahp6.jpg', 25),
(123, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/1_rg9qi2.jpg', 25),
(124, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/2_gw1gt9.jpg', 25),
(125, 'https://res.cloudinary.com/deei5izfg/image/upload/v1728060614/4_vwro7d.jpg', 25);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carts`
--
ALTER TABLE `carts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj8j61gj24w8k2p6g785urq9o6` (`product_detail_id`);

--
-- Indexes for table `constants`
--
ALTER TABLE `constants`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKocrlf0h1l9lyyl0xh410ugkqw` (`category_id`),
  ADD KEY `FKe7ek6uav3vbghtddq11bjum1l` (`style_id`);

--
-- Indexes for table `product_details`
--
ALTER TABLE `product_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlytxaw2mcjsm352822q7e84gq` (`color_id`),
  ADD KEY `FKnfvvq3meg4ha3u1bju9k4is3r` (`product_id`),
  ADD KEY `FKmwcrtdilum47ovwxlybbgpldl` (`size_id`);

--
-- Indexes for table `product_images`
--
ALTER TABLE `product_images`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqnq71xsohugpqwf3c9gxmsuy` (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `carts`
--
ALTER TABLE `carts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `constants`
--
ALTER TABLE `constants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `product_details`
--
ALTER TABLE `product_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=483;

--
-- AUTO_INCREMENT for table `product_images`
--
ALTER TABLE `product_images`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=126;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `carts`
--
ALTER TABLE `carts`
  ADD CONSTRAINT `FKj8j61gj24w8k2p6g785urq9o6` FOREIGN KEY (`product_detail_id`) REFERENCES `product_details` (`id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FKe7ek6uav3vbghtddq11bjum1l` FOREIGN KEY (`style_id`) REFERENCES `constants` (`id`),
  ADD CONSTRAINT `FKocrlf0h1l9lyyl0xh410ugkqw` FOREIGN KEY (`category_id`) REFERENCES `constants` (`id`);

--
-- Constraints for table `product_details`
--
ALTER TABLE `product_details`
  ADD CONSTRAINT `FKlytxaw2mcjsm352822q7e84gq` FOREIGN KEY (`color_id`) REFERENCES `constants` (`id`),
  ADD CONSTRAINT `FKmwcrtdilum47ovwxlybbgpldl` FOREIGN KEY (`size_id`) REFERENCES `constants` (`id`),
  ADD CONSTRAINT `FKnfvvq3meg4ha3u1bju9k4is3r` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `product_images`
--
ALTER TABLE `product_images`
  ADD CONSTRAINT `FKqnq71xsohugpqwf3c9gxmsuy` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
