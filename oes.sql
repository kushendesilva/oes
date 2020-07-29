-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 25, 2020 at 01:09 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oes`
--

-- --------------------------------------------------------

--
-- Table structure for table `course_details`
--

CREATE TABLE `course_details` (
  `course_name` varchar(20) NOT NULL,
  `time` time NOT NULL,
  `course_no` int(4) UNSIGNED NOT NULL,
  `date_of_creation` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp(),
  `hide` smallint(6) UNSIGNED NOT NULL DEFAULT 0,
  `total_question` int(5) UNSIGNED NOT NULL DEFAULT 0,
  `question_mark` int(5) UNSIGNED NOT NULL DEFAULT 4
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_details`
--

INSERT INTO `course_details` (`course_name`, `time`, `course_no`, `date_of_creation`, `hide`, `total_question`, `question_mark`) VALUES
('APPTITUDE', '00:30:00', 33, '2020-04-24 23:00:41', 0, 0, 2),
('COMPUTER', '00:00:45', 34, '2020-04-24 23:06:26', 0, 3, 0),
('MATHS', '00:00:30', 32, '2020-04-24 21:28:58', 0, 8, 4);

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `q_id` varchar(5) NOT NULL,
  `q_statement` longtext NOT NULL,
  `option_1` varchar(150) NOT NULL,
  `option_2` varchar(150) NOT NULL,
  `option_3` varchar(150) NOT NULL,
  `option_4` varchar(150) NOT NULL,
  `correct_option` int(1) NOT NULL,
  `course_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`q_id`, `q_statement`, `option_1`, `option_2`, `option_3`, `option_4`, `correct_option`, `course_name`) VALUES
('CM1', 'Who is the father of computer?', 'Charles Babbage', 'Ada Lovelace', 'Bill Gates', 'Steve Jobs', 1, 'COMPUTER'),
('CM2', 'What is the first electronic digital computer? ', 'ENIAC', 'MARK1 ', 'Z3', 'iCOM', 1, 'COMPUTER'),
('CM3', 'IC chips used in computer are usually made of?		', 'Lead', 'Silicon', 'Gold', 'Silver', 2, 'COMPUTER');

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

CREATE TABLE `result` (
  `Username` varchar(15) NOT NULL,
  `course_name` varchar(20) NOT NULL,
  `time_taken` time NOT NULL DEFAULT '00:00:00',
  `total_questions` int(3) NOT NULL,
  `wrong_question` int(3) NOT NULL,
  `attempted_question` int(3) NOT NULL,
  `obtained_marks` int(5) NOT NULL,
  `total_marks` int(5) NOT NULL,
  `percentage` float NOT NULL,
  `test_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `result`
--

INSERT INTO `result` (`Username`, `course_name`, `time_taken`, `total_questions`, `wrong_question`, `attempted_question`, `obtained_marks`, `total_marks`, `percentage`, `test_date`) VALUES
('kush', 'APPTITUDE', '00:00:01', 9, 0, 0, 0, 18, 0, '2020-04-24 20:02:11'),
('kush', 'APPTITUDE', '00:00:02', 8, 0, 0, 0, 16, 0, '2020-04-24 22:20:54');

-- --------------------------------------------------------

--
-- Table structure for table `userdetails`
--

CREATE TABLE `userdetails` (
  `Username` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL DEFAULT '12345',
  `FirstName` varchar(10) NOT NULL,
  `MiddleName` varchar(10) DEFAULT '',
  `LastName` varchar(10) DEFAULT '',
  `Gender` char(1) NOT NULL,
  `E-mail` varchar(30) NOT NULL,
  `Mobile` char(10) NOT NULL,
  `DOB` date NOT NULL,
  `RegNo` int(10) UNSIGNED NOT NULL,
  `RegDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp(),
  `Address` longtext NOT NULL,
  `College` varchar(60) NOT NULL,
  `Verify` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userdetails`
--

INSERT INTO `userdetails` (`Username`, `Password`, `FirstName`, `MiddleName`, `LastName`, `Gender`, `E-mail`, `Mobile`, `DOB`, `RegNo`, `RegDate`, `Address`, `College`, `Verify`) VALUES
('kush', '1234', 'kushen', 'thimira', 'de silva', 'M', 'kushenthimira@gmail.com', '766827384', '2000-02-16', 52, '2020-04-24 22:55:42', 'kjnewfndkjcn', 'saegis', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course_details`
--
ALTER TABLE `course_details`
  ADD PRIMARY KEY (`course_name`),
  ADD UNIQUE KEY `course_no` (`course_no`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`q_id`),
  ADD KEY `course_name` (`course_name`);

--
-- Indexes for table `result`
--
ALTER TABLE `result`
  ADD KEY `Username` (`Username`),
  ADD KEY `course_name` (`course_name`);

--
-- Indexes for table `userdetails`
--
ALTER TABLE `userdetails`
  ADD PRIMARY KEY (`RegNo`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD UNIQUE KEY `E-mail` (`E-mail`),
  ADD UNIQUE KEY `Mobile` (`Mobile`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course_details`
--
ALTER TABLE `course_details`
  MODIFY `course_no` int(4) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `userdetails`
--
ALTER TABLE `userdetails`
  MODIFY `RegNo` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `questions`
--
ALTER TABLE `questions`
  ADD CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`course_name`) REFERENCES `course_details` (`course_name`);

--
-- Constraints for table `result`
--
ALTER TABLE `result`
  ADD CONSTRAINT `result_ibfk_1` FOREIGN KEY (`Username`) REFERENCES `userdetails` (`Username`),
  ADD CONSTRAINT `result_ibfk_2` FOREIGN KEY (`course_name`) REFERENCES `course_details` (`course_name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
