-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2024 at 09:00 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kate`
--

-- --------------------------------------------------------

--
-- Table structure for table `yang`
--

CREATE TABLE `yang` (
  `id` int(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `user` varchar(50) NOT NULL,
  `pass` varchar(250) NOT NULL,
  `status` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `yang`
--

INSERT INTO `yang` (`id`, `email`, `contact`, `user`, `pass`, `status`, `type`) VALUES
(1, '12', '12', '12', 'tA0DOG+4/X3GypxvjWgN/FjWD9bqcsY/VzzFv7sJaVdGqEnJFRfCNc3+rKTnNCCPGEvAiq4GeXdImI6Vko+AsQ==', 'active', 'ADMIN'),
(2, '3', '3', '3', 'tA0DOG+4/X3GypxvjWgN/FjWD9bqcsY/VzzFv7sJaVdGqEnJFRfCNc3+rKTnNCCPGEvAiq4GeXdImI6Vko+AsQ==', 'active', 'ADMIN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `yang`
--
ALTER TABLE `yang`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `yang`
--
ALTER TABLE `yang`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
