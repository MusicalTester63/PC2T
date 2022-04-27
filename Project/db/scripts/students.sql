-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hostiteľ: 127.0.0.1
-- Čas generovania: Út 26.Apr 2022, 21:37
-- Verzia serveru: 10.4.18-MariaDB
-- Verzia PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databáza: `students`
--

-- --------------------------------------------------------

--
-- Štruktúra tabuľky pre tabuľku `combinedstudents`
--

CREATE TABLE `combinedstudents` (
  `id_combinedStudent` int(4) NOT NULL,
  `firstName_combinedStudent` varchar(6) NOT NULL,
  `lastnameName_combinedStudent` varchar(12) NOT NULL,
  `isLeap_combinedStudent` tinyint(1) NOT NULL,
  `zodiac_combinedStudent` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Štruktúra tabuľky pre tabuľku `humanstudents`
--

CREATE TABLE `humanstudents` (
  `id_humanStudent` int(4) NOT NULL,
  `firstName_humanStudent` varchar(6) NOT NULL,
  `lastnameName_humanStudent` varchar(12) NOT NULL,
  `zodiac_humanStudent` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Štruktúra tabuľky pre tabuľku `techstudents`
--

CREATE TABLE `techstudents` (
  `id_techStudent` int(4) NOT NULL,
  `firstName_techStudent` varchar(6) NOT NULL,
  `lastnameName_techStudent` varchar(12) NOT NULL,
  `isLeap_techStudent` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Štruktúra tabuľky pre tabuľku `znamky`
--

CREATE TABLE `znamky` (
  `id_Student` int(4) NOT NULL,
  `grade` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
