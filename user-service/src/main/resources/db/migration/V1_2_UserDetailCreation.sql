-- USER DETAIL TABLE
CREATE TABLE `user_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` char(36) NOT NULL,
  `name` varchar(500) NOT NULL,
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `deleted_on` TIMESTAMP DEFAULT NULL,
  `security_id` varchar(11) NOT NULL,
  `date_of_birth` TIMESTAMP NOT NULL,
  `gender` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `user_details_userId_DeletedOn` (`user_id`,`deleted_on`),
  KEY `user_id_deleted` (`deleted_on`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
-- ADDRESSES TABLE
CREATE TABLE `addresses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` char(36) NOT NULL,
  `city` varchar(25) NOT NULL,
  `address` varchar(250) NOT NULL,
  `zipcode` char(36) NOT NULL,
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `deleted_on` TIMESTAMP DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `addresses_user_id_DeletedOn` (`user_id`,`deleted_on`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

-- ORGANISATIONS TABLE
CREATE TABLE `organisations`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` char(36) NOT NULL,
  `name` varchar(250) NOT NULL,
  `address` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `deleted_on` TIMESTAMP DEFAULT NULL,
)

