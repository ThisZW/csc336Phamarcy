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
