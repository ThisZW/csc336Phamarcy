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

CREATE PROCEDURE insertDataIntoDatabase(@id INT, @street VARCHAR(20),@city VARCHAR(20), @state VARCHAR(20), @country VARCHAR(20), @zip_code VARCHAR(20), @first_name VARCHAR(20), @last_name VARCHAR(20), @phone_number VARCHAR(20), @address_id VARCHAR(20), @description VARCHAR(20), @patient_id INT, @prescriber_id INT, @date_of_filled VARCHAR(20), @patient_id INT, @prescriber_id INT @date_of_filled INT, @payment_method_id VARCHAR(20), @name VARCHAR(20), @phone INT, @d.name VARCHAR(20), @cost INT, @amount INT, @unit VARCHAR(20), @dose INT, @company_id INT, @presciption_id INT, @drug_id INT)
Begin

insert into address(id, street, city, state, country, zip_code)
values (SCOPE_IDENTITY(),'@street','@city','@state','@country','@zip_code') -- put values here (from parameters?)

insert into patient(id, first_name, last_name, phone_number, address_id)
values (SCOPE_IDENTITY(),'@first_name', '@last_name', '@phone_number', '@address_id')  -- put other values here (from parameters?)

insert into payment_method(id, description)
values (SCOPE_IDENTITY(), '@description')

insert into prescription(id,patient_id, prescriber_id,date_of_filled, payment_method_id)
values (SCOPE_IDENTITY(), '@patient_id', '@prescriber_id ', '@date_of_filled ‘,’@ayment_method_id’)

insert into drug_company(id,name,phone)
values (SCOPE_IDENTITY(), ‘@name’, ‘@phone’)

insert into drug(id,d.name,cost,amount,unit,dose,company_id)
values (SCOPE_IDENTITY(), ‘@d.name’, ‘@cost’, ‘@amount’,’@unit’,’@dose’,’@company_id’)

insert into prescription_items(presciption_id, drug_id)
values (‘@presciption_id’, ‘@drug_id’)

End
