-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 05, 2025 at 06:17 PM
-- Server version: 8.2.0
-- PHP Version: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop_mobile_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `cauhinh`
--

DROP TABLE IF EXISTS `cauhinh`;
CREATE TABLE IF NOT EXISTS `cauhinh` (
  `mach` int NOT NULL AUTO_INCREMENT,
  `tench` varchar(50) NOT NULL,
  PRIMARY KEY (`mach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chitietcauhinh`
--

DROP TABLE IF EXISTS `chitietcauhinh`;
CREATE TABLE IF NOT EXISTS `chitietcauhinh` (
  `masp` int NOT NULL,
  `mach` int NOT NULL,
  `donvi` varchar(50) NOT NULL,
  `giatri` varchar(20) NOT NULL,
  KEY `fkchitietcauhinhsanpham` (`masp`),
  KEY `fkchitietcauhinhcauhinh` (`mach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chitietdonhang`
--

DROP TABLE IF EXISTS `chitietdonhang`;
CREATE TABLE IF NOT EXISTS `chitietdonhang` (
  `madh` int NOT NULL,
  `masp` int NOT NULL,
  `soluong` int NOT NULL,
  `dongia` decimal(10,0) NOT NULL,
  `thanhtien` decimal(10,0) NOT NULL,
  PRIMARY KEY (`madh`,`masp`),
  KEY `fkchitietdonhangsanpham` (`masp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chitietgiohang`
--

DROP TABLE IF EXISTS `chitietgiohang`;
CREATE TABLE IF NOT EXISTS `chitietgiohang` (
  `magh` int NOT NULL,
  `masp` int NOT NULL,
  `soluong` int NOT NULL,
  `dongia` decimal(10,0) NOT NULL,
  `thanhtien` decimal(10,0) NOT NULL,
  PRIMARY KEY (`magh`,`masp`),
  KEY `fkchitietgiohangsanpham` (`masp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `donhang`
--

DROP TABLE IF EXISTS `donhang`;
CREATE TABLE IF NOT EXISTS `donhang` (
  `madh` int NOT NULL AUTO_INCREMENT,
  `makh` int NOT NULL,
  `trangthai` tinyint NOT NULL,
  `ngaytao` timestamp NOT NULL,
  `tongtien` decimal(10,0) NOT NULL,
  PRIMARY KEY (`madh`),
  KEY `fkdonhangkhachhang` (`makh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dophangiai`
--

DROP TABLE IF EXISTS `dophangiai`;
CREATE TABLE IF NOT EXISTS `dophangiai` (
  `madpg` int NOT NULL AUTO_INCREMENT,
  `giatri` varchar(50) NOT NULL,
  PRIMARY KEY (`madpg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `giohang`
--

DROP TABLE IF EXISTS `giohang`;
CREATE TABLE IF NOT EXISTS `giohang` (
  `magh` int NOT NULL AUTO_INCREMENT,
  `makh` int NOT NULL,
  PRIMARY KEY (`magh`),
  KEY `fkgiohangkhachhang` (`makh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hang`
--

DROP TABLE IF EXISTS `hang`;
CREATE TABLE IF NOT EXISTS `hang` (
  `mahang` int NOT NULL AUTO_INCREMENT,
  `tenhang` varchar(50) NOT NULL,
  PRIMARY KEY (`mahang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
CREATE TABLE IF NOT EXISTS `hoadon` (
  `mahd` int NOT NULL AUTO_INCREMENT,
  `madh` int NOT NULL,
  `manv` int NOT NULL,
  `tongtien` decimal(10,0) NOT NULL,
  `ngaytao` timestamp NOT NULL,
  PRIMARY KEY (`mahd`),
  KEY `fkhoadondonhang` (`madh`),
  KEY `fkhoadonnhanvien` (`manv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE IF NOT EXISTS `khachhang` (
  `makh` int NOT NULL AUTO_INCREMENT,
  `tenkh` varchar(50) NOT NULL,
  `diachi` varchar(50) NOT NULL,
  `sdt` char(11) NOT NULL,
  `email` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `matkhau` char(100) NOT NULL,
  PRIMARY KEY (`makh`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `sdt` (`sdt`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`makh`, `tenkh`, `diachi`, `sdt`, `email`, `matkhau`) VALUES
(3, 'Tan', 'Quan4', '0998728472', 'tanboro365@gmail.com', '$2a$10$Uu7/qxD9v7Dtj5C.978On.6LcqCVesFx/0sNDzX3HqHFBw0BoS.ha');

-- --------------------------------------------------------

--
-- Table structure for table `mausanpham`
--

DROP TABLE IF EXISTS `mausanpham`;
CREATE TABLE IF NOT EXISTS `mausanpham` (
  `mamau` int NOT NULL AUTO_INCREMENT,
  `giatri` varchar(50) NOT NULL,
  PRIMARY KEY (`mamau`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `manv` int NOT NULL AUTO_INCREMENT,
  `tennv` varchar(50) NOT NULL,
  `diachi` varchar(50) NOT NULL,
  `sdt` char(11) NOT NULL,
  `chucvu` tinyint NOT NULL,
  `ngaysinh` timestamp NOT NULL,
  `taikhoan` char(20) NOT NULL,
  `matkhau` char(50) NOT NULL,
  PRIMARY KEY (`manv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
CREATE TABLE IF NOT EXISTS `sanpham` (
  `masp` int NOT NULL AUTO_INCREMENT,
  `mahang` int NOT NULL,
  `madpg` int NOT NULL,
  `mamau` int NOT NULL,
  `tinhtrang` tinyint NOT NULL,
  `tensp` varchar(50) NOT NULL,
  `gia` decimal(10,0) NOT NULL,
  `hinhanh` char(50) NOT NULL,
  PRIMARY KEY (`masp`),
  KEY `fksanphamhang` (`mahang`),
  KEY `fksanphamdophangiai` (`madpg`),
  KEY `fksanphammau` (`mamau`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietcauhinh`
--
ALTER TABLE `chitietcauhinh`
  ADD CONSTRAINT `fkchitietcauhinhcauhinh` FOREIGN KEY (`mach`) REFERENCES `cauhinh` (`mach`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fkchitietcauhinhsanpham` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD CONSTRAINT `fkchitietdonhangdonhang` FOREIGN KEY (`madh`) REFERENCES `donhang` (`madh`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fkchitietdonhangsanpham` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `chitietgiohang`
--
ALTER TABLE `chitietgiohang`
  ADD CONSTRAINT `fkchitietgiohanggiohang` FOREIGN KEY (`magh`) REFERENCES `giohang` (`magh`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fkchitietgiohangsanpham` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `donhang`
--
ALTER TABLE `donhang`
  ADD CONSTRAINT `fkdonhangkhachhang` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `giohang`
--
ALTER TABLE `giohang`
  ADD CONSTRAINT `fkgiohangkhachhang` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `fkhoadondonhang` FOREIGN KEY (`madh`) REFERENCES `donhang` (`madh`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fkhoadonnhanvien` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `fksanphamdophangiai` FOREIGN KEY (`madpg`) REFERENCES `dophangiai` (`madpg`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fksanphamhang` FOREIGN KEY (`mahang`) REFERENCES `hang` (`mahang`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fksanphammau` FOREIGN KEY (`mamau`) REFERENCES `mausanpham` (`mamau`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
