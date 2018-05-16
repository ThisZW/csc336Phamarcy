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

CREATE PROCEDURE insertDataIntoDatabase
As
Begin

insert into address(id, street, city, state, country, zip_code)
values (SCOPE_IDENTITY(),'','','','','') -- put values here (from parameters?)

insert into patient(id, first_name, last_name, phone_number, address_id)
values (SCOPE_IDENTITY(),'', '', '', '')  -- put other values here (from parameters?)

insert into payment_method(id, description)
values (SCOPE_IDENTITY(), '')

insert into prescription(id,patient_id, prescriber_id,date_of_filled, payment_method_id)
values (SCOPE_IDENTITY(), '', '', '','')

insert into drug_company(id,name,phone)
values (SCOPE_IDENTITY(), '', '')

insert into drug(id,name,cost,amount,unit,dose,company_id)
values (SCOPE_IDENTITY(), '', '', '','','','')

insert into prescription_items(presciption_id, drug_id)
values ('', '')

End



CREATE PROCEDURE browseDataIntoDatabase
As
Begin

SELECT [id],[Street],[City],[State],[country],[zip_code] FROM [address]
SELECT [id],[first_name],[last_name],[phone_number],[address_id] FROM [patient]
SELECT [id],[description] FROM [payment_method]
SELECT [id],[patient_id],[prescriber_id], [date_of_filled], [payment_method_id] FROM [prescription]
SELECT [id],[name],[phone] FROM [drug_company]
SELECT [id],[name],[cost],[amount],[unit],[dose],[company_id] FROM [drug]
SELECT [prescription_id], [drug_id] FROM [prescription_items]


END



CREATE PROCEDURE updateDataByPatientId(@patient_id int, @prescription_id int, @drug_id int, @company_id int, @id int, @first_name char(20), @last_name char(20), @phone.number int)

AS
Begin
UPDATE [Prescription] SET [] =

UPDATE [Patient] SET [id] = @patient_id，[first_name] = "", [last_name] = "", [phone_number]= '', WHERE [id] = @patient_id

UPDATE [Prescription_items] SET [id] = @prescription_id WHERE [id] = @presciption_id

UPDATE [Drug] SET [id]= @drug_id WHERE  [id] = @drug_id

UPDATE [Drug_company] SET ［id] =company_id WHERE  [id] = @company_id

END





CREATE PROCEDURE deleteDataByPatientId
(@id int, @prescription_id int, @patient_id int, @drug.id int, @company_id int)

AS
Begin

DELETE FROM [Prescription] WHERE [id] = @id
DELETE FROM [Patient] WHERE [id]= @patient_id
DELETE FROM [Prescription_items] WHERE [presciption_id]= @prescription_id
DELETE FROM [Drug] WHERE [id]= [id]=@ drug.id
DELETE FROM [Drug_company] WHERE [id]= @company_id

END







