-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 28, 2017 at 04:22 AM
-- Server version: 5.7.20-log
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fitness`
--

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `bmical`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `bmical` (IN `s` INT, IN `i` INT)  NO SQL
update bmival SET bmi=((bmival.weight*100*100)/(bmival.height*bmival.height)) where sid=s or iid=i$$

DROP PROCEDURE IF EXISTS `calculate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `calculate` (IN `s` INT)  NO SQL
insert into amount VALUES(s,(select sum(fees) from class where sid=s))$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `amount`
--

DROP TABLE IF EXISTS `amount`;
CREATE TABLE IF NOT EXISTS `amount` (
  `sid` decimal(2,0) NOT NULL,
  `total` decimal(5,0) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `amount`
--

INSERT INTO `amount` (`sid`, `total`) VALUES
('1', '2500'),
('2', '3000'),
('3', '5500'),
('5', '1200'),
('6', '4200');

-- --------------------------------------------------------

--
-- Table structure for table `bmival`
--

DROP TABLE IF EXISTS `bmival`;
CREATE TABLE IF NOT EXISTS `bmival` (
  `sid` int(2) DEFAULT NULL,
  `iid` int(3) DEFAULT NULL,
  `height` int(3) DEFAULT NULL,
  `weight` int(3) DEFAULT NULL,
  `bmi` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bmival`
--

INSERT INTO `bmival` (`sid`, `iid`, `height`, `weight`, `bmi`) VALUES
(1, NULL, 160, 23, 9),
(NULL, 103, 160, 50, 20),
(NULL, 105, 160, 60, 23),
(3, NULL, 160, 80, 31),
(6, NULL, 190, 40, 11),
(7, NULL, 190, 100, 28),
(8, NULL, 180, 80, 25),
(NULL, 106, 190, 60, 17),
(4, NULL, 160, 52, 20),
(2, NULL, 160, 100, 39);

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
CREATE TABLE IF NOT EXISTS `branch` (
  `bid` decimal(1,0) NOT NULL,
  `address` varchar(20) DEFAULT NULL,
  `head` decimal(3,0) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `phno` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`bid`, `address`, `head`, `start_date`, `phno`) VALUES
('1', 'MG ROAD', '101', '2000-04-13', '9480634263'),
('2', 'RAJAJINAGAR', '102', '1999-10-31', '9580634263'),
('3', 'malleshwaram', '103', '2001-11-30', '9555634263'),
('4', 'JAYANAGAR', '104', '2002-02-09', '8885634263'),
('5', 'koramangala', '105', '2005-04-29', '8843234263');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
CREATE TABLE IF NOT EXISTS `class` (
  `sid` decimal(2,0) NOT NULL,
  `iid` decimal(3,0) DEFAULT NULL,
  `bid` decimal(1,0) DEFAULT NULL,
  `form` varchar(20) NOT NULL,
  `day` varchar(10) DEFAULT NULL,
  `fees` decimal(4,0) DEFAULT NULL,
  PRIMARY KEY (`sid`,`form`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`sid`, `iid`, `bid`, `form`, `day`, `fees`) VALUES
('1', '101', '2', 'PILATES', 'MONDAY', '1500'),
('1', '102', '2', 'YOGA', 'TUEDAY', '1000'),
('2', '101', '1', 'YOGA', 'MONDAY', '1000'),
('2', '101', '2', 'ZUMBA', 'SUNDAY', '2000'),
('3', '103', '5', 'HIIT', 'SUNDAY', '500'),
('3', '102', '2', 'PILATES', 'TUESDAY', '1500'),
('3', '102', '5', 'TRX', 'SUNDAY', '500'),
('3', '102', '3', 'YOGA', 'MONDAY', '1000'),
('3', '101', '2', 'ZUMBA', 'monday', '2000'),
('5', '101', '3', 'TRX', 'MONDAY', '1200'),
('6', '101', '4', 'TRX', 'SUNDAY', '1200'),
('6', '102', '3', 'YOGA', 'SUNDAY', '1000'),
('6', '101', '2', 'ZUMBA', 'MONDAY', '2000');

--
-- Triggers `class`
--
DROP TRIGGER IF EXISTS `idtrans`;
DELIMITER $$
CREATE TRIGGER `idtrans` AFTER INSERT ON `class` FOR EACH ROW if new.sid != NULL
THEN 
insert into amount (sid) values(new.sid);
end if
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `pilates`;
DELIMITER $$
CREATE TRIGGER `pilates` BEFORE INSERT ON `class` FOR EACH ROW if new.form = 'PILATES'
THEN
set new.fees=1500;
ELSEIF new.form = 'HIIT'
THEN
set new.fees=1800;
ELSEIF new.form = 'TRX'
THEN
set new.fees=1200;
ELSEIF new.form = 'YOGA'
THEN
set new.fees=1000;
ELSEIF new.form = 'ZUMBA'
THEN
set new.fees=2000;
end IF
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
CREATE TABLE IF NOT EXISTS `instructor` (
  `id` decimal(3,0) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `phno` decimal(10,0) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`id`, `name`, `gender`, `dob`, `phno`, `email`) VALUES
('101', 'deepa', 'f', '1980-12-16', '8762554021', 'deepabhat@gmail.com'),
('102', 'archana', 'f', '1975-10-16', '7762554021', 'archanakumar@gmail.com'),
('103', 'ranjitha', 'f', '1979-05-13', '7487554021', 'nitara@gmail.com'),
('104', 'ck', 'm', '1979-03-26', '7487721021', 'ck@gmail.com'),
('105', 'parsh', 'm', '1982-05-02', '9686552543', 'upadhye@gmail.com'),
('106', 'preethi', 'f', '1990-06-12', '8686552543', 'preethi@gmail.com'),
('107', 'SHIDTA', 'f', '1987-04-03', '564687564', 'shidta@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `instructor_b`
--

DROP TABLE IF EXISTS `instructor_b`;
CREATE TABLE IF NOT EXISTS `instructor_b` (
  `id` decimal(3,0) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `join_date` date DEFAULT NULL,
  `exp` decimal(10,0) DEFAULT NULL,
  `salary` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `instructor_b`
--

INSERT INTO `instructor_b` (`id`, `address`, `join_date`, `exp`, `salary`) VALUES
('101', 'chamarajapete', '1994-05-02', '2', '42000'),
('102', 'jp nagar 9th phase', '1995-07-12', '3', '16000'),
('103', 'jayanagar', '2001-05-02', '0', '11500'),
('104', 'simoga', '2001-07-25', '0', '2000'),
('105', 'dharwad', '2000-03-20', '8', '72000'),
('106', 'chennai', '2001-05-02', '4', '65000'),
('107', 'mangalore', '2000-11-14', '2', '32000');

-- --------------------------------------------------------

--
-- Table structure for table `instructor_f`
--

DROP TABLE IF EXISTS `instructor_f`;
CREATE TABLE IF NOT EXISTS `instructor_f` (
  `iid` decimal(3,0) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `month` varchar(10) DEFAULT NULL,
  `date_of_transfer` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `instructor_f`
--

INSERT INTO `instructor_f` (`iid`, `amount`, `month`, `date_of_transfer`) VALUES
('101', '10000', 'jan', '2017-02-05'),
('102', '1000', 'JANUARY', '2017-02-05'),
('103', '10000', 'jan', '2017-02-05'),
('104', '10000', 'march', '2017-02-05'),
('101', '42000', 'october', '2017-10-01'),
('101', '42000', 'november', '2017-11-01'),
('102', '16000', 'november', '2017-11-01'),
('102', '16000', 'october', '2017-10-01'),
('103', '11500', 'october', '2017-10-01'),
('103', '11500', 'november', '2017-11-01'),
('104', '2000', 'november', '2017-11-01'),
('104', '2000', 'october', '2017-10-01'),
('105', '72000', 'november', '2017-11-01'),
('105', '72000', 'october', '2017-10-01'),
('106', '65000', 'october', '2017-10-01'),
('106', '65000', 'november', '2017-11-01'),
('107', '32000', 'november', '2017-11-01'),
('107', '32000', 'october', '2017-10-01'),
('108', '42000', 'october', '2017-10-01'),
('108', '42000', 'november', '2017-11-01');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff` (
  `stid` varchar(4) NOT NULL,
  `bid` decimal(1,0) DEFAULT NULL,
  `dept` varchar(10) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `phone` decimal(10,0) DEFAULT NULL,
  `salary` decimal(10,0) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`stid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`stid`, `bid`, `dept`, `address`, `phone`, `salary`, `gender`, `dob`, `name`) VALUES
('s001', '5', 'manager', 'jayanagar', '8452013446', '23500', 'm', '1982-03-01', 'vishak'),
('s101', '1', 'production', 'jp nagar', '8151112146', '21000', 'f', '1964-02-10', 'amita'),
('s102', '1', 'production', 'jp nagar', '9151112146', '18000', 'm', '1967-04-10', 'poorna'),
('s201', '2', 'backstage', 'girinagar', '9151112146', '18000', 'm', '1984-11-13', 'ananth'),
('s202', '2', 'backstage', 'basavangudi', '8050112146', '19000', 'f', '1988-08-03', 'anne'),
('s301', '2', 'wardrobe', 'yelahanka', '8050144446', '19500', 'f', '1988-08-07', 'ritu'),
('s401', '3', 'make up', 'jayanagar', '9686013446', '16500', 'f', '1990-05-10', 'keertana'),
('s402', '3', 'make up', 'girinagar', '9686054546', '16500', 'm', '1988-07-09', 'ajay'),
('s501', '4', 'marketing', 'kormangala', '9476054546', '22500', 'f', '1985-05-03', 'shwetha'),
('s502', '1', 'marketing', 'chunchgatta', '9476054473', '22800', 'm', '1964-02-10', 'vineeth');

-- --------------------------------------------------------

--
-- Table structure for table `staff_f`
--

DROP TABLE IF EXISTS `staff_f`;
CREATE TABLE IF NOT EXISTS `staff_f` (
  `amount` decimal(10,0) DEFAULT NULL,
  `month` varchar(10) DEFAULT NULL,
  `date_of_transfer` date DEFAULT NULL,
  `stid` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `staff_f`
--

INSERT INTO `staff_f` (`amount`, `month`, `date_of_transfer`, `stid`) VALUES
('23500', 'october', '2017-10-01', 's001'),
('23500', 'november', '2017-11-01', 's001'),
('21000', 'november', '2017-11-01', 's101'),
('21000', 'october', '2017-10-01', 's101'),
('18000', 'october', '2017-10-01', 's102'),
('18000', 'november', '2017-11-01', 's102'),
('18000', 'november', '2017-11-01', 's201'),
('18000', 'october', '2017-10-01', 's201'),
('19000', 'october', '2017-10-01', 's202'),
('19000', 'november', '2017-11-01', 's202'),
('19500', 'november', '2017-11-01', 's301'),
('19500', 'october', '2017-10-01', 's301'),
('16500', 'october', '2017-10-01', 's401'),
('16500', 'november', '2017-11-01', 's401'),
('16500', 'november', '2017-11-01', 's402'),
('16500', 'october', '2017-10-01', 's402'),
('22500', 'october', '2017-10-01', 's501'),
('22500', 'november', '2017-11-01', 's501'),
('22800', 'november', '2017-11-01', 's502'),
('22800', 'october', '2017-10-01', 's502');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `id` decimal(2,0) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `phno` decimal(10,0) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `gender`, `dob`, `phno`, `email`) VALUES
('1', 'medini', 'f', '1997-05-02', '8050102046', 'medinishastry@gmail.com'),
('2', 'sunidhi', 'f', '1997-05-18', '8762062262', 'sunidhigurudutt@gmail.com'),
('3', 'utkarsh', 'm', '1997-03-20', '9686719846', 'utkarshjogani@gmail.com'),
('4', 'srikanth', 'm', '1997-03-29', '8686719846', 'srikanthkatti@gmail.com'),
('5', 'ankit', 'm', '1997-04-10', '7686719846', 'ankitkulkarni@gmail.com'),
('6', 'shaista', 'f', '1997-10-31', '7886719846', 'shaistafathima@gmail.com'),
('7', 'sudhatri', 'f', '1997-05-07', '8886719846', 'sudhatri@gmail.com'),
('8', 'niranjan', 'm', '1996-12-23', '9448419846', 'niranjanananth@gmail.com'),
('9', 'madhuri', 'f', '1995-12-02', '7848419846', 'madhurikaushik@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `student_b`
--

DROP TABLE IF EXISTS `student_b`;
CREATE TABLE IF NOT EXISTS `student_b` (
  `id` decimal(2,0) DEFAULT NULL,
  `gname` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `phone` decimal(10,0) DEFAULT NULL,
  `join_date` date DEFAULT NULL,
  `exp` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student_b`
--

INSERT INTO `student_b` (`id`, `gname`, `address`, `phone`, `join_date`, `exp`) VALUES
('2', 'gurudutt', 'jp nagar', '9448447055', '2011-01-11', '6'),
('1', 'ram murthy', 'nandigardens', '28436505', '2014-01-11', '4'),
('3', 'ajay', 'guwahati', '8448447055', '2010-06-11', '6'),
('4', 'katti', 'bangalore', '7448447055', '2013-08-12', '6'),
('5', 'anil kulkarni', 'basaweshwar', '7454247055', '2010-08-12', '4'),
('6', 'riyaz', 'jayanagar', '8954247055', '2012-07-12', '5'),
('7', 'bharadwaj', 'malleshwaram', '7774247055', '2010-07-12', '5'),
('8', 'ananth', 'yallahanka', '7756347055', '2011-07-12', '4'),
('9', 'kaushik', 'chamarajapete', '6536347055', '2011-07-12', '7'),
('10', 'shashi', 'jp nagar', '6553347055', '2010-07-12', '5');

-- --------------------------------------------------------

--
-- Table structure for table `student_f`
--

DROP TABLE IF EXISTS `student_f`;
CREATE TABLE IF NOT EXISTS `student_f` (
  `sid` decimal(2,0) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `month` varchar(10) DEFAULT NULL,
  `date_of_submission` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student_f`
--

INSERT INTO `student_f` (`sid`, `amount`, `month`, `date_of_submission`) VALUES
('1', '500', 'october', '2017-10-01'),
('1', '500', 'november', '2017-09-01'),
('3', '800', 'november', '2017-11-01'),
('4', '800', 'october', '2017-10-01'),
('4', '800', 'november', '2017-11-03'),
('5', '1000', 'november', '2017-11-03'),
('5', '1000', 'october', '2017-10-03'),
('6', '800', 'october', '2017-10-02'),
('6', '800', 'november', '2017-11-05'),
('7', '1550', 'november', '2018-01-04'),
('7', '1550', 'november', '2018-01-04'),
('8', '850', 'october', '2017-10-01'),
('8', '850', 'november', '2017-11-01'),
('9', '850', 'november', '2017-11-01'),
('9', '850', 'october', '2017-10-07'),
('10', '2000', 'october', '2017-10-09'),
('10', '2000', 'november', '2017-11-09'),
('7', '1550', 'november', '2018-01-04'),
('7', '1550', 'november', '2018-01-04'),
('7', '1550', 'november', '2018-01-04'),
('4', '800', 'december', '2017-12-03');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
