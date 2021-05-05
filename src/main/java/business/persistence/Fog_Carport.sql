-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fog_carport
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fog_carport
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fog_carport` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `fog_carport`;

-- -----------------------------------------------------
-- Table `fog_carport`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_carport`.`users`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `email`    VARCHAR(90) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `role`     VARCHAR(20) NOT NULL DEFAULT 'customer',
    `name`     VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 4
    DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fog_carport`.`bill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_carport`.`bill`
(
    `bill_id`      INT    NOT NULL AUTO_INCREMENT,
    `retail_price` DOUBLE NOT NULL,
    `final_price`  DOUBLE NOT NULL,
    PRIMARY KEY (`bill_id`),
    UNIQUE INDEX `bill_id_UNIQUE` (`bill_id` ASC) VISIBLE
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog_carport`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_carport`.`order`
(
    `order_id` INT    NOT NULL AUTO_INCREMENT,
    `width`    DOUBLE NOT NULL,
    `length`   DOUBLE NOT NULL,
    `users_id` INT    NOT NULL,
    `bill_id`  INT    NOT NULL,
    PRIMARY KEY (`order_id`),
    UNIQUE INDEX `order_id_UNIQUE` (`order_id` ASC) VISIBLE,
    INDEX `fk_order_users1_idx` (`users_id` ASC) VISIBLE,
    INDEX `fk_order_bill1_idx` (`bill_id` ASC) VISIBLE,
    CONSTRAINT `fk_order_users1`
        FOREIGN KEY (`users_id`)
            REFERENCES `fog_carport`.`users` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_order_bill1`
        FOREIGN KEY (`bill_id`)
            REFERENCES `fog_carport`.`bill` (`bill_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog_carport`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_carport`.`category`
(
    `category_id`   INT         NOT NULL AUTO_INCREMENT,
    `category_name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`category_id`),
    UNIQUE INDEX `category_id_UNIQUE` (`category_id` ASC) VISIBLE
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog_carport`.`materials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_carport`.`materials`
(
    `materials_id` INT         NOT NULL AUTO_INCREMENT,
    `description`  VARCHAR(45) NOT NULL,
    `height`       DOUBLE      NOT NULL,
    `width`        DOUBLE      NOT NULL,
    `length`       DOUBLE      NOT NULL,
    `price`        DOUBLE      NOT NULL,
    `category_id`  INT         NOT NULL,
    `order_id`     INT         NOT NULL,
    PRIMARY KEY (`materials_id`),
    UNIQUE INDEX `materials_id_UNIQUE` (`materials_id` ASC) VISIBLE,
    INDEX `fk_materials_category_idx` (`category_id` ASC) VISIBLE,
    INDEX `fk_materials_order1_idx` (`order_id` ASC) VISIBLE,
    CONSTRAINT `fk_materials_category`
        FOREIGN KEY (`category_id`)
            REFERENCES `fog_carport`.`category` (`category_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_materials_order1`
        FOREIGN KEY (`order_id`)
            REFERENCES `fog_carport`.`order` (`order_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;

