
DROP SCHEMA IF EXISTS `recipes_db` ;

CREATE SCHEMA IF NOT EXISTS `recipes_db` DEFAULT CHARACTER SET utf8 ;
USE `recipes_db` ;

DROP TABLE IF EXISTS `recipes_db`.`recipe` ;
CREATE TABLE IF NOT EXISTS `recipes_db`.`recipe` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`))
DEFAULT CHARACTER SET = utf8;


DROP TABLE IF EXISTS `recipes_db`.`item` ;
CREATE TABLE IF NOT EXISTS `recipes_db`.`item` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `recipe_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  foreign key(`recipe_id`) references `recipe`(id))
DEFAULT CHARACTER SET = utf8;


DROP TABLE IF EXISTS `recipes_db`.`item_details` ;
CREATE TABLE IF NOT EXISTS `recipes_db`.`item_details` (
  `id` BIGINT(20) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `unit_measures` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `recipes_db`.`item` (`id`))
DEFAULT CHARACTER SET = utf8;


DROP TABLE IF EXISTS `recipes_db`.`user` ;
CREATE TABLE IF NOT EXISTS `recipes_db`.`user` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(70) NOT NULL,
  PRIMARY KEY (`id`))
DEFAULT CHARACTER SET = utf8;

