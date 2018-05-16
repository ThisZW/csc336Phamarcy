-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `PharmacyDB`
--

-- --------------------------------------------------------

--
-- Stored Procedure for Database 'PharmacyDB'
--


--PROCEDURE STARTS HERE;;;

DROP PROCEDURE IF EXISTS browseDataIntoDatabase 
CREATE PROCEDURE browseDataIntoDatabase
Begin


SELECT [id],[Street],[City],[State],[country],[zip_code] FROM [address]
SELECT [id],[first_name],[last_name],[phone_number],[address_id] FROM [patient]
SELECT [id],[description] FROM [payment_method]
SELECT [id],[patient_id],[prescriber_id], [date_of_filled], [payment_method_id] FROM [prescription]
SELECT [id],[name],[phone] FROM [drug_company]
SELECT [id],[name],[cost],[amount],[unit],[dose],[company_id] FROM [drug]
SELECT [prescription_id], [drug_id] FROM [prescription_items]

FROM prescription psp
INNER JOIN patient p 
ON p.id=psp.patient_id 
INNER JOIN payment_method pm 
ON psp.payment_method_id = pm.id
INNER JOIN prescription_items pi 
ON psp.id= pi.prescription_id
INNER JOIN address d 
ON p.address_id=a.id
INNER JOIN drug d 
ON d.id=pi.drug_id
INNER JOIN drug_company 
ON dc.id=d.company_id


END





