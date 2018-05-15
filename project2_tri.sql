-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: orderingsystemins.cdkb9s3xi6ry.us-east-2.rds.amazonaws.com:3306
-- Generation Time: May 15, 2018 at 03:09 PM
-- Server version: 5.6.39-log
-- PHP Version: 7.0.28-0ubuntu0.16.04.1

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
-- TRIGGERS for Database 'PharmacyDB'
--


--trigger on drug table, restricting the input of drug cost > 0
CREATE TRIGGER `drugtri` AFTER UPDATE ON `drug`
 FOR EACH ROW BEGIN
IF NEW.cost <= 0 THEN
    UPDATE roles SET cost = OLD.cost WHERE cost = NEW.cost;
    END IF;
  END


