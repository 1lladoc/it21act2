-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.16-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for it21
CREATE DATABASE IF NOT EXISTS `it21` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `it21`;

-- Dumping structure for table it21.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `username` text NOT NULL,
  `password` text NOT NULL,
  `lastname` text NOT NULL,
  `firstname` text NOT NULL,
  `type` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table it21.users: ~0 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `username`, `password`, `lastname`, `firstname`, `type`) VALUES
	(0000000001, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'lladoc', 'ruben', 0),
	(0000000002, 'cardo', '1e19c7c863aeeb35f93d8abf25ec010d', 'martin', 'coco', 0),
	(0000000003, 'jam', '5275cb415e5bc3948e8f2cd492859f26', 'maningo', 'jose', 0),
	(0000000004, 'bass', '9176ef320a628c35e44fb0b79c729594', 'tumabing', 'gwapo', 0),
	(0000000005, 'juan', 'a94652aa97c7211ba8954dd15a3cf838', 'dela cruz', 'juan', 0),
	(0000000006, 'klasdjflkjfglk', 'b34ab9932de0d9ba7008556eac9e6f92', 'adasd', 'dsafasdf', 0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
