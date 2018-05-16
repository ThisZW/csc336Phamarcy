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


CREATE PROCEDURE deleteDataByPatientId
(@id int, @prescription_id int, @patient_id int, @drug.id int, @company_id int)

AS
Begin

/*
DELETE FROM [Prescription] WHERE [id] = @id
DELETE FROM [Patient] WHERE [id]= @patient_id
DELETE FROM [Prescription_items] WHERE [presciption_id]= @prescription_id
DELETE FROM [Drug] WHERE [id]= [id]=@ drug.id
DELETE FROM [Drug_company] WHERE [id]= @company_id 
*/

DELETE [p],[pi],[psp],[d],[dc]
FROM prescription AS psp
WHERE [id]= @id
LEFT JOIN
patient AS p ON p.id=psp.patient_id
LEFT JOIN
prescription_items AS pi ON psp.id= pi.prescription_id
LEFT JOIN
drug AS d ON d.id= pi.drug.id
LEFT JOIN
drug_company AS dc ON dc.id=d.company_id
WHERE
p.id=@id



END







