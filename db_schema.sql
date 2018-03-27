CREATE DATABASE  IF NOT EXISTS 'orders';
USE 'orders';

--
-- Table structure for table 'orders'
--

DROP TABLE IF EXISTS orders;

CREATE TABLE orders (
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'name' varchar(45) DEFAULT NULL,
  'description' varchar(45) DEFAULT NULL,
  'date_created' datetime DEFAULT NULL,
  'finished' bit(1) DEFAULT b'0',
  PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

