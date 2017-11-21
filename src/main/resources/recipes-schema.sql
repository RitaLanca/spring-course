

DROP SCHEMA IF EXISTS `recipes_db` ;


CREATE SCHEMA IF NOT EXISTS `recipes_db` DEFAULT CHARACTER SET utf8 ;
USE `recipes_db` ;


DROP TABLE IF EXISTS `recipes_db`.`author` ;

CREATE TABLE IF NOT EXISTS `recipes_db`.`author` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(70) NOT NULL,
  `surname` VARCHAR(70) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



DROP TABLE IF EXISTS `recipes_db`.`category` ;

CREATE TABLE IF NOT EXISTS `recipes_db`.`category` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



DROP TABLE IF EXISTS `recipes_db`.`recipe` ;

CREATE TABLE IF NOT EXISTS `recipes_db`.`recipe` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `servings` INT,
  `description` LONGTEXT,
  `author_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  foreign key(author_id) references author(id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


DROP TABLE IF EXISTS `recipes_db`.`category_recipe` ;

CREATE TABLE IF NOT EXISTS `recipes_db`.`category_recipe` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_id` BIGINT(20) NOT NULL,
  `recipe_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`category_id`)
    REFERENCES `recipes_db`.`category` (`id`),
  FOREIGN KEY (`recipe_id`)
    REFERENCES `recipes_db`.`recipe` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



DROP TABLE IF EXISTS `recipes_db`.`ingredient` ;

CREATE TABLE IF NOT EXISTS `recipes_db`.`ingredient` (
  `id` BIGINT(20) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


DROP TABLE IF EXISTS `recipes_db`.`ingredient_recipe` ;

CREATE TABLE IF NOT EXISTS `recipes_db`.`ingredient_recipe` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `ingredient_id` BIGINT(20) NOT NULL,
  `recipe_id` BIGINT(20) NOT NULL,
  `quantity` INT NOT NULL,
  `unit_measure` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`ingredient_id`)
    REFERENCES `recipes_db`.`ingredient` (`id`),
  FOREIGN KEY (`recipe_id`)
    REFERENCES `recipes_db`.`recipe` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;