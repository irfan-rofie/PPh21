-- phpMyAdmin SQL Dump
-- version 3.1.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 02, 2015 at 07:54 PM
-- Server version: 5.1.33
-- PHP Version: 5.2.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `pph21`
--
CREATE DATABASE `pph21` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `pph21`;

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE IF NOT EXISTS `pegawai` (
  `nik` varchar(255) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `biayaJabatan` bigint(20) NOT NULL,
  `gaji` bigint(20) NOT NULL,
  `iuranPensiun` bigint(20) NOT NULL,
  `jabatan` varchar(15) NOT NULL,
  `jumlahAnak` int(11) DEFAULT NULL,
  `nama` varchar(25) NOT NULL,
  `perusahaan` varchar(25) NOT NULL,
  `status` varchar(15) NOT NULL,
  PRIMARY KEY (`nik`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`nik`, `alamat`, `biayaJabatan`, `gaji`, `iuranPensiun`, `jabatan`, `jumlahAnak`, `nama`, `perusahaan`, `status`) VALUES
('0204121003', 'Tasikmalaya', 250000, 5000000, 100000, 'programmer', 2, 'IRFAN ROFIE', 'PT. Fedora', 'menikah'),
('0204121000', 'somewhere', 200000, 4000000, 50000, 'programmer', 0, 'pulan', 'PT. Fedora', 'belum');

-- --------------------------------------------------------

--
-- Table structure for table `trx_hitung`
--

CREATE TABLE IF NOT EXISTS `trx_hitung` (
  `nik` varchar(255) NOT NULL,
  `PPhNettoPerTahun` bigint(20) DEFAULT NULL,
  `PPhPerBulan` bigint(20) DEFAULT NULL,
  `PPhPerTahun` bigint(20) DEFAULT NULL,
  `gajiBersihSebelumPajak` bigint(20) DEFAULT NULL,
  `gajiBersihSetelahPajak` bigint(20) DEFAULT NULL,
  `pengurang` bigint(20) DEFAULT NULL,
  `pkp` bigint(20) DEFAULT NULL,
  `ptkp` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`nik`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trx_hitung`
--

INSERT INTO `trx_hitung` (`nik`, `PPhNettoPerTahun`, `PPhPerBulan`, `PPhPerTahun`, `gajiBersihSebelumPajak`, `gajiBersihSetelahPajak`, `pengurang`, `pkp`, `ptkp`) VALUES
('0204121003', 55800000, 450000, 5400000, 4650000, 4200000, 350000, 36000000, 19800000),
('0204121000', 45000000, 121500, 1458000, 3750000, 3628500, 250000, 29160000, 15840000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(10) NOT NULL,
  `username` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `password`, `username`) VALUES
(1, 'admin', 'admin');
