-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 12 Ιουλ 2020 στις 14:43:08
-- Έκδοση διακομιστή: 10.4.11-MariaDB
-- Έκδοση PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `worldcup`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `fifaranking`
--

CREATE TABLE `fifaranking` (
  `Rank` int(3) NOT NULL COMMENT 'Potition',
  `Name` char(35) NOT NULL COMMENT 'Country Name',
  `Confederation` char(8) NOT NULL COMMENT 'Confederetion they belong',
  `Points` int(11) NOT NULL COMMENT 'Ponits they have as team',
  `Wins` int(4) NOT NULL COMMENT 'How many times they won.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `fifaranking`
--

INSERT INTO `fifaranking` (`Rank`, `Name`, `Confederation`, `Points`, `Wins`) VALUES
(149, 'Afganistan', 'AFC', 1052, 0),
(66, 'Albania', 'UEFA', 1356, 0),
(35, 'Algeria', 'CAF', 1482, 0),
(192, 'American Samoa', 'OFC', 900, 0),
(135, 'Andora', 'UEFA', 1082, 0),
(124, 'Angola', 'CAF', 1136, 0),
(210, 'Anguilla', 'CONCACAF', 821, 0),
(126, 'Antigua and Barbuda', 'CONCACAF', 1127, 0),
(9, 'Argentina', 'CONMEBOL', 1623, 2),
(102, 'Armenia', 'UEFA', 1213, 0),
(200, 'Aruba', 'CONCACAF', 867, 0),
(42, 'Australia', 'AFC', 1457, 0),
(26, 'Austria', 'UEFA', 1507, 0),
(114, 'Azerbaijan', 'UEFA', 1177, 0),
(195, 'Bahamas', 'CONCACAF', 880, 0),
(99, 'Bahrain', 'AFC', 1225, 0),
(187, 'Bangladesh', 'AFC', 914, 0),
(162, 'Barbados', 'CONCACAF', 1009, 0),
(87, 'Belarus', 'UEFA', 1283, 0),
(1, 'Belgium', 'UEFA', 1765, 0),
(170, 'Belize', 'CONCACAF', 974, 0),
(84, 'Benin', 'CAF', 1295, 0),
(168, 'Bermuda', 'CONCACAF', 983, 0),
(189, 'Bhutan', 'AFC', 911, 0),
(75, 'Bolivia', 'CONMEBOL', 1324, 0),
(148, 'Botswana', 'CAF', 1055, 0),
(49, 'Boznia and Herxegovina', 'UEFA', 1430, 0),
(3, 'Brazil', 'CONMEBOL', 1712, 5),
(208, 'British Virgin Islands', 'CONCACAF', 842, 0),
(191, 'Brunei Darussalam', 'AFC', 904, 0),
(59, 'Bulgaria', 'UEFA', 1381, 0),
(59, 'Burkina Faso', 'CAF', 1381, 0),
(149, 'Burundi', 'CAF', 1052, 0),
(78, 'Cabo Verde', 'CAF', 1318, 0),
(173, 'Cambodia', 'AFC', 964, 0),
(53, 'Cameroon', 'CAF', 1413, 0),
(73, 'Canada', 'CONCACAF', 1332, 0),
(193, 'Cayman Islands', 'CONCACAF', 897, 0),
(109, 'Central African Republic', 'CAF', 1184, 0),
(177, 'Chad', 'CAF', 943, 0),
(17, 'Chile', 'CONMEBOL', 1579, 0),
(76, 'China', 'AFC', 1323, 0),
(138, 'Chinese Taipei', 'AFC', 1078, 0),
(61, 'Code dIvoire', 'CAF', 1378, 0),
(10, 'Colombia', 'CONMEBOL', 1622, 0),
(133, 'Comoros', 'CAF', 1088, 0),
(89, 'Congo', 'CAF', 1269, 0),
(56, 'Congo DR', 'CAF', 1389, 0),
(46, 'Costa Rica', 'CONCACAF', 1439, 0),
(6, 'Croatia', 'UEFA', 1642, 0),
(179, 'Cuba', 'CONCACAF', 936, 0),
(80, 'Curacao', 'CONCACAF', 1313, 0),
(95, 'Cyprus', 'UEFA', 1251, 0),
(45, 'Czech Republic', 'UEFA', 1446, 0),
(16, 'Denmark', 'UEFA', 1598, 0),
(184, 'Djibouti', 'CAF', 919, 0),
(184, 'Dominica', 'CONCACAF', 919, 0),
(158, 'Dominican Republic', 'CONCACAF', 1019, 0),
(63, 'Ecuador', 'CONMEBOL', 1368, 0),
(51, 'Egypt', 'CAF', 1420, 0),
(69, 'El Salvador', 'CONCACAF', 1346, 0),
(4, 'England', 'UEFA', 1661, 1),
(145, 'Equatorial Guinea', 'CAF', 1066, 0),
(205, 'Eritrea', 'CAF', 856, 0),
(104, 'Esthonia', 'UEFA', 1202, 0),
(153, 'Eswatini', 'CAF', 1042, 0),
(146, 'Ethiopia', 'CAF', 1061, 0),
(110, 'Faroe Islands', 'UEFA', 1181, 0),
(163, 'Fiji', 'OFC', 996, 0),
(58, 'Finland', 'UEFA', 1386, 0),
(2, 'France', 'UEFA', 1733, 2),
(83, 'Gabon', 'CAF', 1297, 0),
(159, 'Gambia', 'CAF', 1015, 0),
(91, 'Georgia', 'UEFA', 1267, 0),
(15, 'Germany', 'UEFA', 1602, 4),
(46, 'Ghana', 'CAF', 1439, 0),
(196, 'Gibraltar', 'UEFA', 879, 0),
(54, 'Greece', 'UEFA', 1409, 0),
(159, 'Grenada', 'CONCACAF', 1015, 0),
(199, 'Guam', 'AFC', 873, 0),
(130, 'Guatemala', 'CONCACAF', 1104, 0),
(74, 'Guinea', 'CAF', 1328, 0),
(118, 'Guinea-Bissau', 'CAF', 1155, 0),
(166, 'Guyana', 'CONCACAF', 988, 0),
(86, 'Haiti', 'CONCACAF', 1285, 0),
(62, 'Honduras', 'CONCACAF', 1377, 0),
(143, 'Hong Kong', 'AFC', 1072, 0),
(52, 'Hungary', 'UEFA', 1416, 0),
(39, 'Iceland', 'UEFA', 1465, 0),
(108, 'India', 'AFC', 1187, 0),
(173, 'Indonesia', 'AFC', 964, 0),
(33, 'Iran', 'AFC', 1489, 0),
(70, 'Iraq', 'AFC', 1344, 0),
(34, 'Ireland', 'UEFA', 1486, 0),
(93, 'Israel', 'UEFA', 1260, 0),
(13, 'Italy', 'UEFA', 1607, 4),
(48, 'Jamaica', 'CONCACAF', 1438, 0),
(28, 'Japan', 'AFC', 1500, 0),
(97, 'Jordan', 'AFC', 1238, 0),
(118, 'Kazakhsta', 'UEFA', 1155, 0),
(107, 'Kenya', 'CAF', 1199, 0),
(115, 'Kosovo', 'UEFA', 1174, 0),
(147, 'Kuwait', 'AFC', 1060, 0),
(96, 'Kyrgyz Republic', 'AFC', 1240, 0),
(188, 'Laos', 'AFC', 912, 0),
(137, 'Latvia', 'UEFA', 1079, 0),
(89, 'Lebanon', 'AFC', 1269, 0),
(139, 'Lesotho', 'CAF', 1074, 0),
(152, 'Liberia', 'CAF', 1047, 0),
(101, 'Libya', 'CAF', 1215, 0),
(180, 'Liechtenstein', 'UEFA', 926, 0),
(131, 'Lithuania', 'UEFA', 1089, 0),
(98, 'Luxembourg', 'UEFA', 1236, 0),
(182, 'Macau', 'AFC', 922, 0),
(91, 'Madagascar', 'CAF', 1267, 0),
(123, 'Malawi', 'CAF', 1141, 0),
(154, 'Malaysia', 'AFC', 1040, 0),
(155, 'Maldives', 'AFC', 1038, 0),
(56, 'Mali', 'CAF', 1389, 0),
(184, 'Malta', 'UEFA', 919, 0),
(100, 'Mauritania', 'CAF', 1223, 0),
(172, 'Mauritius', 'CAF', 965, 0),
(136, 'Maynmar', 'AFC', 1081, 0),
(11, 'Mexico', 'CONMEBOL', 1621, 0),
(175, 'Moldova', 'UEFA', 959, 0),
(190, 'Mongolia', 'AFC', 906, 0),
(64, 'Montenegro', 'UEFA', 1365, 0),
(183, 'Montserrat', 'CONCACAF', 921, 0),
(43, 'Morocco', 'CAF', 1456, 0),
(106, 'Mozambique', 'CAF', 1200, 0),
(117, 'Namibia', 'CAF', 1160, 0),
(170, 'Nepal', 'AFC', 974, 0),
(14, 'Netherlands', 'UEFA', 1604, 0),
(156, 'New Caledonia', 'OFC', 1035, 0),
(122, 'New Zealand', 'OFC', 1149, 0),
(151, 'Nicaragua', 'CONCACAF', 1051, 0),
(112, 'Niger', 'CAF', 1179, 0),
(31, 'Nigeria', 'CAF', 1493, 0),
(116, 'North Korea', 'AFC', 1170, 0),
(68, 'North Macedonia', 'UEFA', 1347, 0),
(36, 'Northern Ireland', 'UEFA', 1467, 0),
(44, 'Norway', 'UEFA', 1451, 0),
(82, 'Oman', 'AFC', 1303, 0),
(200, 'Pakistan', 'AFC', 867, 0),
(103, 'Palestine', 'AFC', 1204, 0),
(81, 'Panama', 'CONCACAF', 1305, 0),
(165, 'Papua New Guinea', 'OFC', 991, 0),
(41, 'Paraguay', 'CONMEBOL', 1461, 0),
(21, 'Peru', 'CONMEBOL', 1544, 0),
(124, 'Philippines', 'AFC', 1136, 0),
(19, 'Poland', 'UEFA', 1559, 0),
(7, 'Portugal', 'UEFA', 1639, 0),
(178, 'Puerto Rico', 'CONCACAF', 941, 0),
(55, 'Qatar', 'AFC', 1396, 0),
(37, 'Romania', 'UEFA', 1475, 0),
(38, 'Russia', 'UEFA', 1470, 0),
(131, 'Rwanda', 'CAF', 1089, 0),
(194, 'Samoa', 'OFC', 894, 0),
(209, 'San Marino', 'UEFA', 824, 0),
(181, 'Sao Tome and Principe', 'CAF', 923, 0),
(67, 'Saudi Arabia', 'AFC', 1351, 0),
(50, 'Scotland', 'UEFA', 1422, 0),
(20, 'Senegal', 'CAF', 1555, 0),
(29, 'Serbia', 'UEFA', 1494, 0),
(202, 'Seychelles', 'CAF', 866, 0),
(118, 'Sierra Leone', 'CAF', 1155, 0),
(157, 'Singapore', 'AFC', 1020, 0),
(32, 'Slovakia', 'UEFA', 1490, 0),
(64, 'Slovenia', 'UEFA', 1365, 0),
(141, 'Solomon Islands', 'OFC', 1073, 0),
(196, 'Somalia', 'CAF', 879, 0),
(71, 'South Africa', 'CAF', 1334, 0),
(40, 'South Korea', 'AFC', 1464, 0),
(168, 'South Sudan', 'CAF', 983, 0),
(8, 'Spain', 'UEFA', 1636, 1),
(206, 'Sri Lanka', 'AFC', 853, 0),
(139, 'St. Kitts and Nevis', 'CONCACAF', 1074, 0),
(176, 'ST.Lucia', 'CONCACAF', 953, 0),
(167, 'St.Vincent and the Grenadines', 'CONCACAF', 986, 0),
(128, 'Sudan', 'CAF', 1112, 0),
(141, 'Suriname', 'CONCACAF', 1073, 0),
(18, 'Sweden', 'UEFA', 1579, 0),
(12, 'Switzerland', 'UEFA', 1608, 0),
(79, 'Syria', 'AFC', 1314, 0),
(161, 'Tahiti', 'OFC', 1014, 0),
(121, 'Tajikistan', 'AFC', 1152, 0),
(134, 'Tanzania', 'CAF', 1086, 0),
(113, 'Thailand', 'AFC', 1178, 0),
(196, 'Timor - Leste', 'AFC', 879, 0),
(126, 'Togo', 'CAF', 1127, 0),
(203, 'Tonga', 'OFC', 862, 0),
(105, 'Trinidad and Tobago', 'CONCACAF', 1201, 0),
(27, 'Tunisia', 'CAF', 1506, 0),
(29, 'Turkey', 'UEFA', 1494, 0),
(129, 'Turkmenistan', 'AFC', 1107, 0),
(203, 'Turks and Caicos', 'CONCACAF', 862, 0),
(77, 'Uganda', 'CAF', 1321, 0),
(24, 'Ukraine', 'UEFA', 1537, 0),
(71, 'United Arab Emirates', 'AFC', 1334, 0),
(5, 'Uruguay', 'CONMEBOL', 1645, 2),
(207, 'US Virgin Islands', 'CONCACAF', 844, 0),
(22, 'USA', 'CONCACAF', 1542, 0),
(85, 'Uzbekistan', 'AFC', 1386, 0),
(163, 'Vanuatu', 'OFC', 996, 0),
(25, 'Venezuela', 'CONMEBOL', 1517, 0),
(94, 'Vietnam', 'AFC', 1258, 0),
(23, 'Wales', 'UEFA', 1540, 0),
(144, 'Yemen', 'AFC', 1071, 0),
(88, 'Zambia', 'CAF', 1279, 0),
(111, 'Zimbabew', 'CAF', 1180, 0);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `group a`
--

CREATE TABLE `group a` (
  `Position` int(1) NOT NULL,
  `Team` varchar(35) NOT NULL,
  `Played` int(1) NOT NULL,
  `Wins` int(1) NOT NULL,
  `Draws` int(1) NOT NULL,
  `Loses` int(1) NOT NULL,
  `Goals for` int(2) NOT NULL,
  `Goals against` int(2) NOT NULL,
  `Goal difference` int(2) NOT NULL,
  `Points` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `group a`
--

INSERT INTO `group a` (`Position`, `Team`, `Played`, `Wins`, `Draws`, `Loses`, `Goals for`, `Goals against`, `Goal difference`, `Points`) VALUES
(4, 'Brazil', 3, 0, 0, 3, 1, 9, -8, 0),
(3, 'England', 3, 1, 1, 1, 6, 9, -3, 4),
(1, 'Senegal', 3, 3, 0, 0, 12, 2, 10, 9),
(2, 'South Korea', 3, 1, 1, 1, 11, 10, 1, 4);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `group b`
--

CREATE TABLE `group b` (
  `Position` int(1) NOT NULL,
  `Team` varchar(35) NOT NULL,
  `Played` int(1) NOT NULL,
  `Wins` int(1) NOT NULL,
  `Draws` int(1) NOT NULL,
  `Loses` int(1) NOT NULL,
  `Goals for` int(2) NOT NULL,
  `Goals against` int(2) NOT NULL,
  `Goal difference` int(2) NOT NULL,
  `Points` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `group b`
--

INSERT INTO `group b` (`Position`, `Team`, `Played`, `Wins`, `Draws`, `Loses`, `Goals for`, `Goals against`, `Goal difference`, `Points`) VALUES
(2, 'Belgium', 3, 2, 0, 1, 8, 6, 2, 6),
(1, 'Croatia', 3, 2, 1, 0, 8, 2, 6, 7),
(4, 'Egypt', 3, 0, 1, 2, 1, 7, -6, 1),
(3, 'Japan', 3, 0, 2, 1, 4, 6, -2, 2);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `group c`
--

CREATE TABLE `group c` (
  `Position` int(1) NOT NULL,
  `Team` varchar(35) NOT NULL,
  `Played` int(1) NOT NULL,
  `Wins` int(1) NOT NULL,
  `Draws` int(1) NOT NULL,
  `Loses` int(1) NOT NULL,
  `Goals for` int(2) NOT NULL,
  `Goals against` int(2) NOT NULL,
  `Goal difference` int(2) NOT NULL,
  `Points` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `group c`
--

INSERT INTO `group c` (`Position`, `Team`, `Played`, `Wins`, `Draws`, `Loses`, `Goals for`, `Goals against`, `Goal difference`, `Points`) VALUES
(1, 'Greece', 3, 2, 0, 1, 10, 6, 4, 6),
(2, 'Panama', 3, 2, 0, 1, 9, 8, 1, 6),
(4, 'Sweden', 3, 1, 0, 2, 8, 11, -3, 3),
(3, 'Uruguay', 3, 1, 0, 2, 6, 8, -2, 3);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `group d`
--

CREATE TABLE `group d` (
  `Position` int(1) NOT NULL,
  `Team` varchar(35) NOT NULL,
  `Played` int(1) NOT NULL,
  `Wins` int(1) NOT NULL,
  `Draws` int(1) NOT NULL,
  `Loses` int(1) NOT NULL,
  `Goals for` int(2) NOT NULL,
  `Goals against` int(2) NOT NULL,
  `Goal difference` int(2) NOT NULL,
  `Points` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `group d`
--

INSERT INTO `group d` (`Position`, `Team`, `Played`, `Wins`, `Draws`, `Loses`, `Goals for`, `Goals against`, `Goal difference`, `Points`) VALUES
(4, 'France', 3, 0, 0, 3, 6, 13, -7, 0),
(1, 'Iran', 3, 3, 0, 0, 13, 3, 10, 9),
(2, 'Mexico', 3, 2, 0, 1, 8, 8, 0, 6),
(3, 'Nigeria', 3, 1, 0, 2, 7, 10, -3, 3);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `group e`
--

CREATE TABLE `group e` (
  `Position` int(1) NOT NULL,
  `Team` varchar(35) NOT NULL,
  `Played` int(1) NOT NULL,
  `Wins` int(1) NOT NULL,
  `Draws` int(1) NOT NULL,
  `Loses` int(1) NOT NULL,
  `Goals for` int(2) NOT NULL,
  `Goals against` int(2) NOT NULL,
  `Goal difference` int(2) NOT NULL,
  `Points` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `group e`
--

INSERT INTO `group e` (`Position`, `Team`, `Played`, `Wins`, `Draws`, `Loses`, `Goals for`, `Goals against`, `Goal difference`, `Points`) VALUES
(4, 'Argentina', 3, 0, 0, 3, 2, 11, -9, 0),
(1, 'Denmark', 3, 2, 1, 0, 7, 1, 6, 7),
(3, 'Serbia', 3, 1, 1, 1, 4, 5, -1, 4),
(2, 'Spain', 3, 2, 0, 1, 7, 3, 4, 6);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `group f`
--

CREATE TABLE `group f` (
  `Position` int(1) NOT NULL,
  `Team` varchar(35) NOT NULL,
  `Played` int(1) NOT NULL,
  `Wins` int(1) NOT NULL,
  `Draws` int(1) NOT NULL,
  `Loses` int(1) NOT NULL,
  `Goals for` int(2) NOT NULL,
  `Goals against` int(2) NOT NULL,
  `Goal difference` int(2) NOT NULL,
  `Points` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `group f`
--

INSERT INTO `group f` (`Position`, `Team`, `Played`, `Wins`, `Draws`, `Loses`, `Goals for`, `Goals against`, `Goal difference`, `Points`) VALUES
(3, 'Costa Rica', 3, 1, 0, 2, 5, 8, -3, 3),
(2, 'Morocco', 3, 2, 0, 1, 10, 6, 4, 6),
(1, 'Peru', 3, 2, 0, 1, 10, 3, 7, 6),
(4, 'Portugal', 3, 1, 0, 2, 1, 9, -8, 3);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `group g`
--

CREATE TABLE `group g` (
  `Position` int(1) NOT NULL,
  `Team` varchar(35) NOT NULL,
  `Played` int(1) NOT NULL,
  `Wins` int(1) NOT NULL,
  `Draws` int(1) NOT NULL,
  `Loses` int(1) NOT NULL,
  `Goals for` int(2) NOT NULL,
  `Goals against` int(2) NOT NULL,
  `Goal difference` int(2) NOT NULL,
  `Points` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `group g`
--

INSERT INTO `group g` (`Position`, `Team`, `Played`, `Wins`, `Draws`, `Loses`, `Goals for`, `Goals against`, `Goal difference`, `Points`) VALUES
(3, 'Colombia', 3, 1, 0, 2, 8, 7, 1, 3),
(1, 'Germany', 3, 2, 0, 1, 8, 5, 3, 6),
(2, 'Saudi Arabia', 3, 2, 0, 1, 5, 4, 1, 6),
(4, 'Tunisia', 3, 1, 0, 2, 6, 11, -5, 3);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `group h`
--

CREATE TABLE `group h` (
  `Position` int(1) NOT NULL,
  `Team` varchar(35) NOT NULL,
  `Played` int(1) NOT NULL,
  `Wins` int(1) NOT NULL,
  `Draws` int(1) NOT NULL,
  `Loses` int(1) NOT NULL,
  `Goals for` int(2) NOT NULL,
  `Goals against` int(2) NOT NULL,
  `Goal difference` int(2) NOT NULL,
  `Points` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `group h`
--

INSERT INTO `group h` (`Position`, `Team`, `Played`, `Wins`, `Draws`, `Loses`, `Goals for`, `Goals against`, `Goal difference`, `Points`) VALUES
(4, 'Australia', 3, 0, 1, 2, 9, 13, -4, 1),
(1, 'Iceland', 3, 3, 0, 0, 12, 8, 4, 9),
(3, 'Poland', 3, 1, 0, 2, 7, 10, -3, 3),
(2, 'Switzerland', 3, 1, 1, 1, 12, 9, 3, 4);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `official-fifaranking`
--

CREATE TABLE `official-fifaranking` (
  `Rank` int(3) NOT NULL COMMENT 'Potition',
  `Name` char(35) NOT NULL COMMENT 'Country Name',
  `Confederation` char(8) NOT NULL COMMENT 'Confederetion they belong',
  `Points` int(11) NOT NULL COMMENT 'Ponits they have as team',
  `Wins` int(4) NOT NULL COMMENT 'How many times they won.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `official-fifaranking`
--

INSERT INTO `official-fifaranking` (`Rank`, `Name`, `Confederation`, `Points`, `Wins`) VALUES
(149, 'Afganistan', 'AFC', 1052, 0),
(66, 'Albania', 'UEFA', 1356, 0),
(35, 'Algeria', 'CAF', 1482, 0),
(192, 'American Samoa', 'OFC', 900, 0),
(135, 'Andora', 'UEFA', 1082, 0),
(124, 'Angola', 'CAF', 1136, 0),
(210, 'Anguilla', 'CONCACAF', 821, 0),
(126, 'Antigua and Barbuda', 'CONCACAF', 1127, 0),
(9, 'Argentina', 'CONMEBOL', 1623, 2),
(102, 'Armenia', 'UEFA', 1213, 0),
(200, 'Aruba', 'CONCACAF', 867, 0),
(42, 'Australia', 'AFC', 1457, 0),
(26, 'Austria', 'UEFA', 1507, 0),
(114, 'Azerbaijan', 'UEFA', 1177, 0),
(195, 'Bahamas', 'CONCACAF', 880, 0),
(99, 'Bahrain', 'AFC', 1225, 0),
(187, 'Bangladesh', 'AFC', 914, 0),
(162, 'Barbados', 'CONCACAF', 1009, 0),
(87, 'Belarus', 'UEFA', 1283, 0),
(1, 'Belgium', 'UEFA', 1765, 0),
(170, 'Belize', 'CONCACAF', 974, 0),
(84, 'Benin', 'CAF', 1295, 0),
(168, 'Bermuda', 'CONCACAF', 983, 0),
(189, 'Bhutan', 'AFC', 911, 0),
(75, 'Bolivia', 'CONMEBOL', 1324, 0),
(148, 'Botswana', 'CAF', 1055, 0),
(49, 'Boznia and Herxegovina', 'UEFA', 1430, 0),
(3, 'Brazil', 'CONMEBOL', 1712, 5),
(208, 'British Virgin Islands', 'CONCACAF', 842, 0),
(191, 'Brunei Darussalam', 'AFC', 904, 0),
(59, 'Bulgaria', 'UEFA', 1381, 0),
(59, 'Burkina Faso', 'CAF', 1381, 0),
(149, 'Burundi', 'CAF', 1052, 0),
(78, 'Cabo Verde', 'CAF', 1318, 0),
(173, 'Cambodia', 'AFC', 964, 0),
(53, 'Cameroon', 'CAF', 1413, 0),
(73, 'Canada', 'CONCACAF', 1332, 0),
(193, 'Cayman Islands', 'CONCACAF', 897, 0),
(109, 'Central African Republic', 'CAF', 1184, 0),
(177, 'Chad', 'CAF', 943, 0),
(17, 'Chile', 'CONMEBOL', 1579, 0),
(76, 'China', 'AFC', 1323, 0),
(138, 'Chinese Taipei', 'AFC', 1078, 0),
(61, 'Code dIvoire', 'CAF', 1378, 0),
(10, 'Colombia', 'CONMEBOL', 1622, 0),
(133, 'Comoros', 'CAF', 1088, 0),
(89, 'Congo', 'CAF', 1269, 0),
(56, 'Congo DR', 'CAF', 1389, 0),
(46, 'Costa Rica', 'CONCACAF', 1439, 0),
(6, 'Croatia', 'UEFA', 1642, 0),
(179, 'Cuba', 'CONCACAF', 936, 0),
(80, 'Curacao', 'CONCACAF', 1313, 0),
(95, 'Cyprus', 'UEFA', 1251, 0),
(45, 'Czech Republic', 'UEFA', 1446, 0),
(16, 'Denmark', 'UEFA', 1598, 0),
(184, 'Djibouti', 'CAF', 919, 0),
(184, 'Dominica', 'CONCACAF', 919, 0),
(158, 'Dominican Republic', 'CONCACAF', 1019, 0),
(63, 'Ecuador', 'CONMEBOL', 1368, 0),
(51, 'Egypt', 'CAF', 1420, 0),
(69, 'El Salvador', 'CONCACAF', 1346, 0),
(4, 'England', 'UEFA', 1661, 1),
(145, 'Equatorial Guinea', 'CAF', 1066, 0),
(205, 'Eritrea', 'CAF', 856, 0),
(104, 'Esthonia', 'UEFA', 1202, 0),
(153, 'Eswatini', 'CAF', 1042, 0),
(146, 'Ethiopia', 'CAF', 1061, 0),
(110, 'Faroe Islands', 'UEFA', 1181, 0),
(163, 'Fiji', 'OFC', 996, 0),
(58, 'Finland', 'UEFA', 1386, 0),
(2, 'France', 'UEFA', 1733, 2),
(83, 'Gabon', 'CAF', 1297, 0),
(159, 'Gambia', 'CAF', 1015, 0),
(91, 'Georgia', 'UEFA', 1267, 0),
(15, 'Germany', 'UEFA', 1602, 4),
(46, 'Ghana', 'CAF', 1439, 0),
(196, 'Gibraltar', 'UEFA', 879, 0),
(54, 'Greece', 'UEFA', 1409, 0),
(159, 'Grenada', 'CONCACAF', 1015, 0),
(199, 'Guam', 'AFC', 873, 0),
(130, 'Guatemala', 'CONCACAF', 1104, 0),
(74, 'Guinea', 'CAF', 1328, 0),
(118, 'Guinea-Bissau', 'CAF', 1155, 0),
(166, 'Guyana', 'CONCACAF', 988, 0),
(86, 'Haiti', 'CONCACAF', 1285, 0),
(62, 'Honduras', 'CONCACAF', 1377, 0),
(143, 'Hong Kong', 'AFC', 1072, 0),
(52, 'Hungary', 'UEFA', 1416, 0),
(39, 'Iceland', 'UEFA', 1465, 0),
(108, 'India', 'AFC', 1187, 0),
(173, 'Indonesia', 'AFC', 964, 0),
(33, 'Iran', 'AFC', 1489, 0),
(70, 'Iraq', 'AFC', 1344, 0),
(34, 'Ireland', 'UEFA', 1486, 0),
(93, 'Israel', 'UEFA', 1260, 0),
(13, 'Italy', 'UEFA', 1607, 4),
(48, 'Jamaica', 'CONCACAF', 1438, 0),
(28, 'Japan', 'AFC', 1500, 0),
(97, 'Jordan', 'AFC', 1238, 0),
(118, 'Kazakhsta', 'UEFA', 1155, 0),
(107, 'Kenya', 'CAF', 1199, 0),
(115, 'Kosovo', 'UEFA', 1174, 0),
(147, 'Kuwait', 'AFC', 1060, 0),
(96, 'Kyrgyz Republic', 'AFC', 1240, 0),
(188, 'Laos', 'AFC', 912, 0),
(137, 'Latvia', 'UEFA', 1079, 0),
(89, 'Lebanon', 'AFC', 1269, 0),
(139, 'Lesotho', 'CAF', 1074, 0),
(152, 'Liberia', 'CAF', 1047, 0),
(101, 'Libya', 'CAF', 1215, 0),
(180, 'Liechtenstein', 'UEFA', 926, 0),
(131, 'Lithuania', 'UEFA', 1089, 0),
(98, 'Luxembourg', 'UEFA', 1236, 0),
(182, 'Macau', 'AFC', 922, 0),
(91, 'Madagascar', 'CAF', 1267, 0),
(123, 'Malawi', 'CAF', 1141, 0),
(154, 'Malaysia', 'AFC', 1040, 0),
(155, 'Maldives', 'AFC', 1038, 0),
(56, 'Mali', 'CAF', 1389, 0),
(184, 'Malta', 'UEFA', 919, 0),
(100, 'Mauritania', 'CAF', 1223, 0),
(172, 'Mauritius', 'CAF', 965, 0),
(136, 'Maynmar', 'AFC', 1081, 0),
(11, 'Mexico', 'CONMEBOL', 1621, 0),
(175, 'Moldova', 'UEFA', 959, 0),
(190, 'Mongolia', 'AFC', 906, 0),
(64, 'Montenegro', 'UEFA', 1365, 0),
(183, 'Montserrat', 'CONCACAF', 921, 0),
(43, 'Morocco', 'CAF', 1456, 0),
(106, 'Mozambique', 'CAF', 1200, 0),
(117, 'Namibia', 'CAF', 1160, 0),
(170, 'Nepal', 'AFC', 974, 0),
(14, 'Netherlands', 'UEFA', 1604, 0),
(156, 'New Caledonia', 'OFC', 1035, 0),
(122, 'New Zealand', 'OFC', 1149, 0),
(151, 'Nicaragua', 'CONCACAF', 1051, 0),
(112, 'Niger', 'CAF', 1179, 0),
(31, 'Nigeria', 'CAF', 1493, 0),
(116, 'North Korea', 'AFC', 1170, 0),
(68, 'North Macedonia', 'UEFA', 1347, 0),
(36, 'Northern Ireland', 'UEFA', 1467, 0),
(44, 'Norway', 'UEFA', 1451, 0),
(82, 'Oman', 'AFC', 1303, 0),
(200, 'Pakistan', 'AFC', 867, 0),
(103, 'Palestine', 'AFC', 1204, 0),
(81, 'Panama', 'CONCACAF', 1305, 0),
(165, 'Papua New Guinea', 'OFC', 991, 0),
(41, 'Paraguay', 'CONMEBOL', 1461, 0),
(21, 'Peru', 'CONMEBOL', 1544, 0),
(124, 'Philippines', 'AFC', 1136, 0),
(19, 'Poland', 'UEFA', 1559, 0),
(7, 'Portugal', 'UEFA', 1639, 0),
(178, 'Puerto Rico', 'CONCACAF', 941, 0),
(55, 'Qatar', 'AFC', 1396, 0),
(37, 'Romania', 'UEFA', 1475, 0),
(38, 'Russia', 'UEFA', 1470, 0),
(131, 'Rwanda', 'CAF', 1089, 0),
(194, 'Samoa', 'OFC', 894, 0),
(209, 'San Marino', 'UEFA', 824, 0),
(181, 'Sao Tome and Principe', 'CAF', 923, 0),
(67, 'Saudi Arabia', 'AFC', 1351, 0),
(50, 'Scotland', 'UEFA', 1422, 0),
(20, 'Senegal', 'CAF', 1555, 0),
(29, 'Serbia', 'UEFA', 1494, 0),
(202, 'Seychelles', 'CAF', 866, 0),
(118, 'Sierra Leone', 'CAF', 1155, 0),
(157, 'Singapore', 'AFC', 1020, 0),
(32, 'Slovakia', 'UEFA', 1490, 0),
(64, 'Slovenia', 'UEFA', 1365, 0),
(141, 'Solomon Islands', 'OFC', 1073, 0),
(196, 'Somalia', 'CAF', 879, 0),
(71, 'South Africa', 'CAF', 1334, 0),
(40, 'South Korea', 'AFC', 1464, 0),
(168, 'South Sudan', 'CAF', 983, 0),
(8, 'Spain', 'UEFA', 1636, 1),
(206, 'Sri Lanka', 'AFC', 853, 0),
(139, 'St. Kitts and Nevis', 'CONCACAF', 1074, 0),
(176, 'ST.Lucia', 'CONCACAF', 953, 0),
(167, 'St.Vincent and the Grenadines', 'CONCACAF', 986, 0),
(128, 'Sudan', 'CAF', 1112, 0),
(141, 'Suriname', 'CONCACAF', 1073, 0),
(18, 'Sweden', 'UEFA', 1579, 0),
(12, 'Switzerland', 'UEFA', 1608, 0),
(79, 'Syria', 'AFC', 1314, 0),
(161, 'Tahiti', 'OFC', 1014, 0),
(121, 'Tajikistan', 'AFC', 1152, 0),
(134, 'Tanzania', 'CAF', 1086, 0),
(113, 'Thailand', 'AFC', 1178, 0),
(196, 'Timor - Leste', 'AFC', 879, 0),
(126, 'Togo', 'CAF', 1127, 0),
(203, 'Tonga', 'OFC', 862, 0),
(105, 'Trinidad and Tobago', 'CONCACAF', 1201, 0),
(27, 'Tunisia', 'CAF', 1506, 0),
(29, 'Turkey', 'UEFA', 1494, 0),
(129, 'Turkmenistan', 'AFC', 1107, 0),
(203, 'Turks and Caicos', 'CONCACAF', 862, 0),
(77, 'Uganda', 'CAF', 1321, 0),
(24, 'Ukraine', 'UEFA', 1537, 0),
(71, 'United Arab Emirates', 'AFC', 1334, 0),
(5, 'Uruguay', 'CONMEBOL', 1645, 2),
(207, 'US Virgin Islands', 'CONCACAF', 844, 0),
(22, 'USA', 'CONCACAF', 1542, 0),
(85, 'Uzbekistan', 'AFC', 1386, 0),
(163, 'Vanuatu', 'OFC', 996, 0),
(25, 'Venezuela', 'CONMEBOL', 1517, 0),
(94, 'Vietnam', 'AFC', 1258, 0),
(23, 'Wales', 'UEFA', 1540, 0),
(144, 'Yemen', 'AFC', 1071, 0),
(88, 'Zambia', 'CAF', 1279, 0),
(111, 'Zimbabew', 'CAF', 1180, 0);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `schedule`
--

CREATE TABLE `schedule` (
  `Match_ID` int(1) NOT NULL,
  `Home` varchar(35) NOT NULL,
  `Away` varchar(35) NOT NULL,
  `HScore` int(1) NOT NULL,
  `AScore` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `schedule`
--

INSERT INTO `schedule` (`Match_ID`, `Home`, `Away`, `HScore`, `AScore`) VALUES
(101, 'Brazil', 'South Korea', 1, 5),
(102, 'Senegal', 'England', 5, 0),
(103, 'Brazil', 'Senegal', 0, 2),
(104, 'England', 'South Korea', 4, 4),
(105, 'England', 'Brazil', 2, 0),
(106, 'South Korea', 'Senegal', 2, 5),
(107, 'Belgium', 'Japan', 4, 2),
(108, 'Egypt', 'Croatia', 0, 3),
(109, 'Belgium', 'Egypt', 4, 1),
(110, 'Croatia', 'Japan', 2, 2),
(111, 'Croatia', 'Belgium', 3, 0),
(112, 'Japan', 'Egypt', 0, 0),
(113, 'Greece', 'Panama', 0, 3),
(114, 'Sweden', 'Uruguay', 2, 1),
(115, 'Greece', 'Sweden', 5, 2),
(116, 'Uruguay', 'Panama', 4, 1),
(117, 'Uruguay', 'Greece', 1, 5),
(118, 'Panama', 'Sweden', 5, 4),
(119, 'France', 'Nigeria', 1, 5),
(120, 'Iran', 'Mexico', 4, 0),
(121, 'France', 'Iran', 3, 4),
(122, 'Mexico', 'Nigeria', 4, 2),
(123, 'Mexico', 'France', 4, 2),
(124, 'Nigeria', 'Iran', 0, 5),
(125, 'Argentina', 'Serbia', 2, 3),
(126, 'Denmark', 'Spain', 2, 1),
(127, 'Argentina', 'Denmark', 0, 5),
(128, 'Spain', 'Serbia', 3, 1),
(129, 'Spain', 'Argentina', 3, 0),
(130, 'Serbia', 'Denmark', 0, 0),
(131, 'Portugal', 'Morocco', 0, 5),
(132, 'Costa Rica', 'Peru', 0, 5),
(133, 'Portugal', 'Costa Rica', 0, 4),
(134, 'Peru', 'Morocco', 5, 2),
(135, 'Peru', 'Portugal', 0, 1),
(136, 'Morocco', 'Costa Rica', 3, 1),
(137, 'Germany', 'Saudi Arabia', 3, 1),
(138, 'Tunisia', 'Colombia', 5, 4),
(139, 'Germany', 'Tunisia', 4, 0),
(140, 'Colombia', 'Saudi Arabia', 0, 1),
(141, 'Colombia', 'Germany', 4, 1),
(142, 'Saudi Arabia', 'Tunisia', 3, 1),
(143, 'Poland', 'Australia', 4, 2),
(144, 'Iceland', 'Switzerland', 4, 3),
(145, 'Poland', 'Iceland', 3, 4),
(146, 'Switzerland', 'Australia', 5, 5),
(147, 'Switzerland', 'Poland', 4, 0),
(148, 'Australia', 'Iceland', 2, 4),
(149, 'Senegal', 'Belgium', 1, 2),
(150, 'Greece', 'Mexico', 5, 1),
(151, 'Denmark', 'Morocco', 3, 5),
(152, 'Germany', 'Switzerland', 0, 2),
(153, 'Croatia', 'South Korea', 2, 3),
(154, 'Iran', 'Panama', 1, 0),
(155, 'Peru', 'Spain', 3, 1),
(156, 'Iceland', 'Saudi Arabia', 1, 0),
(157, 'Belgium', 'Greece', 0, 5),
(158, 'Morocco', 'Switzerland', 6, 5),
(159, 'South Korea', 'Iran', 3, 5),
(160, 'Peru', 'Iceland', 4, 5),
(161, 'Greece', 'Morocco', 4, 1),
(162, 'Iran', 'Iceland', 3, 2),
(163, 'Morocco', 'Iceland', 3, 4),
(164, 'Greece', 'Iran', 3, 2);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `worldcupfinal`
--

CREATE TABLE `worldcupfinal` (
  `ID` int(2) NOT NULL,
  `Team` char(35) NOT NULL,
  `Confederation` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `worldcupfinal`
--

INSERT INTO `worldcupfinal` (`ID`, `Team`, `Confederation`) VALUES
(1, 'Greece', 'UEFA'),
(2, 'Germany', 'UEFA'),
(3, 'Brazil', 'CONMEBOL'),
(4, 'Portugal', 'UEFA'),
(5, 'Argentina', 'CONMEBOL'),
(6, 'Belgium', 'UEFA'),
(7, 'Poland', 'UEFA'),
(8, 'France', 'UEFA'),
(9, 'Spain', 'UEFA'),
(10, 'Peru', 'CONMEBOL'),
(11, 'Switzerland', 'UEFA'),
(12, 'England', 'UEFA'),
(13, 'Colombia', 'CONMEBOL'),
(14, 'Mexico', 'CONMEBOL'),
(15, 'Uruguay', 'CONMEBOL'),
(16, 'Croatia', 'UEFA'),
(17, 'Denmark', 'UEFA'),
(18, 'Iceland', 'UEFA'),
(19, 'Costa Rica', 'CONCACAF'),
(20, 'Sweden', 'UEFA'),
(21, 'Tunisia', 'CAF'),
(22, 'Egypt', 'CAF'),
(23, 'Senegal', 'CAF'),
(24, 'Iran', 'AFC'),
(25, 'Serbia', 'UEFA'),
(26, 'Nigeria', 'CAF'),
(27, 'Australia', 'AFC'),
(28, 'Japan', 'AFC'),
(29, 'Morocco', 'CAF'),
(30, 'Panama', 'CONCACAF'),
(31, 'South Korea', 'AFC'),
(32, 'Saudi Arabia', 'AFC');

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `fifaranking`
--
ALTER TABLE `fifaranking`
  ADD PRIMARY KEY (`Name`);

--
-- Ευρετήρια για πίνακα `group a`
--
ALTER TABLE `group a`
  ADD PRIMARY KEY (`Team`);

--
-- Ευρετήρια για πίνακα `group b`
--
ALTER TABLE `group b`
  ADD PRIMARY KEY (`Team`);

--
-- Ευρετήρια για πίνακα `group c`
--
ALTER TABLE `group c`
  ADD PRIMARY KEY (`Team`);

--
-- Ευρετήρια για πίνακα `group d`
--
ALTER TABLE `group d`
  ADD PRIMARY KEY (`Team`);

--
-- Ευρετήρια για πίνακα `group e`
--
ALTER TABLE `group e`
  ADD PRIMARY KEY (`Team`);

--
-- Ευρετήρια για πίνακα `group f`
--
ALTER TABLE `group f`
  ADD PRIMARY KEY (`Team`);

--
-- Ευρετήρια για πίνακα `group g`
--
ALTER TABLE `group g`
  ADD PRIMARY KEY (`Team`);

--
-- Ευρετήρια για πίνακα `group h`
--
ALTER TABLE `group h`
  ADD PRIMARY KEY (`Team`);

--
-- Ευρετήρια για πίνακα `official-fifaranking`
--
ALTER TABLE `official-fifaranking`
  ADD PRIMARY KEY (`Name`);

--
-- Ευρετήρια για πίνακα `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`Match_ID`);

--
-- Ευρετήρια για πίνακα `worldcupfinal`
--
ALTER TABLE `worldcupfinal`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `schedule`
--
ALTER TABLE `schedule`
  MODIFY `Match_ID` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=165;

--
-- AUTO_INCREMENT για πίνακα `worldcupfinal`
--
ALTER TABLE `worldcupfinal`
  MODIFY `ID` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=107;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
