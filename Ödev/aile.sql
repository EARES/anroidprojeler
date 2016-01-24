-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 31 Ara 2015, 16:06:27
-- Sunucu sürümü: 5.6.17
-- PHP Sürümü: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Veritabanı: `aile`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `akbaki`
--

CREATE TABLE IF NOT EXISTS `akbaki` (
  `id` int(2) NOT NULL,
  `yas` int(2) NOT NULL,
  `akrabalik` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `akbaki`
--

INSERT INTO `akbaki` (`id`, `yas`, `akrabalik`) VALUES
(1, 19, 'kardes'),
(2, 50, 'anne'),
(3, 21, 'abi');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `egitim`
--

CREATE TABLE IF NOT EXISTS `egitim` (
  `id` int(2) NOT NULL,
  `egitim_durumu` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `egitim`
--

INSERT INTO `egitim` (`id`, `egitim_durumu`) VALUES
(1, 'universite'),
(2, 'universite'),
(3, 'lise');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `emre`
--

CREATE TABLE IF NOT EXISTS `emre` (
  `id` int(2) NOT NULL,
  `ad` varchar(15) NOT NULL,
  `soyad` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `emre`
--

INSERT INTO `emre` (`id`, `ad`, `soyad`) VALUES
(1, 'Emre', 'Akbaki'),
(2, 'Zuhal', 'Akbaki'),
(3, 'Eren', 'Akbaki');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
