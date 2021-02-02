-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Feb 02, 2021 at 11:56 AM
-- Server version: 5.7.26
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `jeuloto`
--

-- --------------------------------------------------------

--
-- Table structure for table `GRILLE`
--

CREATE TABLE `GRILLE` (
  `id` int(11) NOT NULL,
  `n1` int(11) DEFAULT NULL,
  `n2` int(11) DEFAULT NULL,
  `n3` int(11) DEFAULT NULL,
  `n4` int(11) DEFAULT NULL,
  `n5` int(11) DEFAULT NULL,
  `numChance` int(11) DEFAULT NULL,
  `iduser` int(11) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `dateJour` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `GRILLE`
--

INSERT INTO `GRILLE` (`id`, `n1`, `n2`, `n3`, `n4`, `n5`, `numChance`, `iduser`, `date`, `dateJour`) VALUES
(29, 1, 2, 4, 6, 8, 8, 1, 'Samedi', '02/02/2021 10:39'),
(30, 1, 2, 3, 6, 7, 8, 1, 'Lundi', '02/02/2021 10:54'),
(31, 1, 2, 34, 6, 7, 8, 1, 'Samedi', '02/02/2021 12:47');

-- --------------------------------------------------------

--
-- Table structure for table `STATCHANCE`
--

CREATE TABLE `STATCHANCE` (
  `id` int(11) NOT NULL,
  `total` int(11) DEFAULT NULL,
  `recent` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `STATCHANCE`
--

INSERT INTO `STATCHANCE` (`id`, `total`, `recent`) VALUES
(1, 19, 2),
(2, 18, 0),
(3, 18, 0),
(4, 20, 0),
(5, 21, 3),
(6, 15, 0),
(7, 21, 1),
(8, 19, 1),
(9, 26, 2),
(10, 11, 1);

-- --------------------------------------------------------

--
-- Table structure for table `STATISTIQUE`
--

CREATE TABLE `STATISTIQUE` (
  `id` int(11) NOT NULL,
  `total` int(11) DEFAULT NULL,
  `recent` int(11) DEFAULT NULL,
  `ecartMax` int(11) DEFAULT NULL,
  `ecartActuel` int(11) DEFAULT NULL,
  `bestAffinity` int(11) DEFAULT NULL,
  `badAffinity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `STATISTIQUE`
--

INSERT INTO `STATISTIQUE` (`id`, `total`, `recent`, `ecartMax`, `ecartActuel`, `bestAffinity`, `badAffinity`) VALUES
(1, 34, 4, 25, 2, 3, 13),
(2, 34, 1, 20, 9, 7, 35),
(3, 29, 1, 27, 9, 1, 48),
(4, 37, 0, 16, 17, 3, 6),
(5, 46, 4, 15, 6, 2, 7),
(6, 36, 0, 17, 13, 25, 12),
(7, 45, 3, 9, 3, 10, 5),
(8, 33, 2, 21, 2, 3, 33),
(9, 48, 1, 18, 15, 44, 16),
(10, 30, 1, 27, 11, 1, 26),
(11, 18, 2, 34, 3, 1, 7),
(12, 17, 1, 24, 3, 2, 6),
(13, 16, 1, 40, 7, 1, 2),
(14, 22, 0, 26, 15, 1, 10),
(15, 17, 0, 33, 23, 2, 24),
(16, 19, 0, 37, 13, 3, 17),
(17, 25, 2, 17, 1, 9, 30),
(18, 12, 0, 45, 20, 2, 29),
(19, 21, 1, 30, 5, 1, 22),
(20, 15, 1, 34, 7, 1, 9),
(21, 15, 1, 38, 4, 3, 16),
(22, 22, 1, 24, 8, 1, 19),
(23, 22, 0, 27, 12, 1, 14),
(24, 22, 1, 21, 6, 1, 26),
(25, 18, 0, 31, 21, 6, 5),
(26, 27, 0, 30, 20, 1, 42),
(27, 15, 2, 32, 3, 2, 23),
(28, 22, 0, 21, 20, 1, 22),
(29, 19, 0, 30, 12, 2, 10),
(30, 25, 2, 23, 1, 3, 17),
(31, 23, 3, 26, 5, 2, 38),
(32, 18, 2, 35, 1, 4, 11),
(33, 20, 1, 26, 2, 2, 1),
(34, 11, 1, 45, 8, 2, 22),
(35, 25, 1, 21, 9, 5, 2),
(36, 14, 1, 40, 7, 2, 9),
(37, 14, 0, 33, 11, 4, 7),
(38, 22, 1, 25, 7, 1, 31),
(39, 20, 1, 26, 5, 3, 42),
(40, 16, 1, 33, 9, 3, 35),
(41, 21, 4, 38, 1, 6, 5),
(42, 27, 2, 21, 1, 4, 26),
(43, 15, 0, 36, 25, 1, 30),
(44, 20, 0, 30, 11, 2, 29),
(45, 16, 0, 28, 15, 1, 4),
(46, 18, 1, 31, 2, 1, 19),
(47, 20, 1, 41, 4, 1, 7),
(48, 27, 0, 25, 14, 9, 1),
(49, 20, 2, 22, 3, 11, 30);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`iduser`, `username`, `password`, `email`) VALUES
(1, 'maha', 'maha', 'maha@elkourdi.fr'),
(2, 'jean', 'jean', 'jean@jean.fr');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `GRILLE`
--
ALTER TABLE `GRILLE`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fkgrille` (`iduser`);

--
-- Indexes for table `STATCHANCE`
--
ALTER TABLE `STATCHANCE`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `STATISTIQUE`
--
ALTER TABLE `STATISTIQUE`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`iduser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `GRILLE`
--
ALTER TABLE `GRILLE`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `GRILLE`
--
ALTER TABLE `GRILLE`
  ADD CONSTRAINT `Fkgrille` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`);
