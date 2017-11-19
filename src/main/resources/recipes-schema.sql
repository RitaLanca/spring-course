
DROP SCHEMA IF EXISTS `recipes_db` ;

CREATE SCHEMA IF NOT EXISTS `recipes_db` DEFAULT CHARACTER SET utf8 ;
USE `recipes_db` ;

DROP TABLE IF EXISTS `recipes_db`.`recipe` ;

CREATE TABLE `recipe_db`.`recipe` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  `servings` INT NULL,
   `author_id` INT NULL,
   INDEX `author_id_idx` (`author_id` ASC),
  PRIMARY KEY (`id`)),
  FOREIGN KEY (`author_id`)
  REFERENCES `recipe_db`.`author` (`id`),
DEFAULT CHARACTER SET = utf8;


DROP TABLE IF EXISTS `recipes_db`.`category` ;
CREATE TABLE `recipe_db`.`category` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
DEFAULT CHARACTER SET = utf8;


DROP TABLE IF EXISTS `recipes_db`.`ingredient` ;
CREATE TABLE `recipe_db`.`ingredient` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `name`));
DEFAULT CHARACTER SET = utf8;

DROP TABLE IF EXISTS `recipes_db`.`recipe_ingredient` ;
CREATE TABLE `recipe_db`.`recipe_ingredient` (
  `recipe_id` INT NOT NULL,
  `ingredient_id` INT NOT NULL,
  `quantity` INT NULL,
  `unit_measures` VARCHAR(45) NULL,
  INDEX `id_recipe` (`recipe_id` ASC),
  INDEX `id_ingredient` (`ingredient_id` ASC),
  CONSTRAINT `id_recipe`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `recipe_db`.`recipe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_ingredient`
    FOREIGN KEY (`ingredient_id`)
    REFERENCES `recipe_db`.`ingredient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
    DROP TABLE IF EXISTS `recipes_db`.`author` ; 
    CREATE TABLE `recipe_db`.`recipe_category` (
  `id_category` INT NOT NULL,
  `id_recipe` INT NOT NULL,
  INDEX `recipe_id_idx` (`id_recipe` ASC),
  INDEX `category_id_idx` (`id_category` ASC),
  CONSTRAINT `recipe_id`
    FOREIGN KEY (`id_recipe`)
    REFERENCES `recipe_db`.`recipe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `category_id`
    FOREIGN KEY (`id_category`)
    REFERENCES `recipe_db`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
DROP TABLE IF EXISTS `recipes_db`.`author` ;
CREATE TABLE `recipe_db`.`author` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
DEFAULT CHARACTER SET = utf8;



