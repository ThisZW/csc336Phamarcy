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


CREATE PROCEDURE updateDataByPatientId(@patient_id int, @prescription_id int, @drug_id int, @company_id int, @id int, @first_name char(20), @last_name char(20), @phone.number int)


Begin
/*
UPDATE [Prescription] SET [id] = @prescription_id WHERE [id]=@id 

UPDATE [Patient] SET [id] = @patient_id，[first_name] = "", [last_name] = "", [phone_number]= '', WHERE [id] = @patient_id

UPDATE [Prescription_items] SET [id] = @prescription_id WHERE [id] = @presciption_id

UPDATE [Drug] SET [id]= @drug_id WHERE  [id] = @drug_id

UPDATE [Drug_company] SET ［id] =company_id WHERE  [id] = @company_id
*/


UPDATE prescription
AS psp

LEFT JOIN
patient AS p ON p.id=psp.patient_id

LEFT JOIN
prescritpion_items AS pi ON psp.id= pi.prescription_id

LEFT JOIN 
drug AS d ON d.id=pi.drug_ud

LEFT JOIN
drug_company AS dc ON dc.id=d.company_id

SET [p.first_name] =@‘’ , [p.last_name]=@‘’, [p.phone_number]=@‘’
WHERE
P.id=@id



END







