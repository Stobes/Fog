-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema Fog_Carport
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Fog_Carport
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Fog_Carport` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `Fog_Carport` ;

-- -----------------------------------------------------
-- Table `Fog_Carport`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fog_Carport`.`role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE INDEX `role_id_UNIQUE` (`role_id` ASC) VISIBLE,
  UNIQUE INDEX `role_UNIQUE` (`role` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fog_Carport`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fog_Carport`.`employee` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role_id` INT NOT NULL,
  UNIQUE INDEX `idemployee_UNIQUE` (`employee_id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  PRIMARY KEY (`employee_id`),
  INDEX `fk_employee_role_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_employee_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `Fog_Carport`.`role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fog_Carport`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fog_Carport`.`customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE INDEX `customer_id_UNIQUE` (`customer_id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fog_Carport`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fog_Carport`.`category` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE INDEX `category_id_UNIQUE` (`category_id` ASC) VISIBLE,
  UNIQUE INDEX `category_name_UNIQUE` (`category_name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fog_Carport`.`materials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fog_Carport`.`materials` (
  `materials_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  `height` DOUBLE NOT NULL,
  `width` DOUBLE NOT NULL,
  `length` DOUBLE NOT NULL,
  `price` DOUBLE NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`materials_id`),
  UNIQUE INDEX `materials_id_UNIQUE` (`materials_id` ASC) VISIBLE,
  INDEX `fk_materials_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_materials_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `Fog_Carport`.`category` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fog_Carport`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fog_Carport`.`order` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `width` DOUBLE NOT NULL,
  `length` DOUBLE NOT NULL,
  `materials_id` INT NOT NULL,
  `employee_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE INDEX `order_id_UNIQUE` (`order_id` ASC) VISIBLE,
  INDEX `fk_order_materials1_idx` (`materials_id` ASC) VISIBLE,
  INDEX `fk_order_employee1_idx` (`employee_id` ASC) VISIBLE,
  INDEX `fk_order_customer1_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_materials1`
    FOREIGN KEY (`materials_id`)
    REFERENCES `Fog_Carport`.`materials` (`materials_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `Fog_Carport`.`employee` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `Fog_Carport`.`customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fog_Carport`.`bill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fog_Carport`.`bill` (
  `bill_id` INT NOT NULL AUTO_INCREMENT,
  `retail_price` DOUBLE NOT NULL,
  `final_price` DOUBLE NOT NULL,
  `order_id` INT NOT NULL,
  PRIMARY KEY (`bill_id`),
  UNIQUE INDEX `bill_id_UNIQUE` (`bill_id` ASC) VISIBLE,
  INDEX `fk_bill_order1_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_bill_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `Fog_Carport`.`order` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
