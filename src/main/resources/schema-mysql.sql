
CREATE TABLE IF NOT EXISTS `quiz_123` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(500) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `is_published` tinyint DEFAULT '0',
  PRIMARY KEY (`id`)
);

