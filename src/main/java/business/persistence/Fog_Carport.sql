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
-- Table `fog_carport`.`material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_carport`.`material`
(
    `id`                   INT         NOT NULL,
    `unit`                 VARCHAR(45) NOT NULL,
    `material_description` VARCHAR(45) NOT NULL,
    `meter_price`          DOUBLE      NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fog_carport`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_carport`.`users`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `email`    VARCHAR(90) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `role`     VARCHAR(20) NOT NULL DEFAULT 'customer',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 5
    DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fog_carport`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_carport`.`order`
(
    `id`           INT         NOT NULL AUTO_INCREMENT,
    `width`        INT         NOT NULL,
    `length`       INT         NOT NULL,
    `height`       INT         NOT NULL,
    `retail_price` DOUBLE      NOT NULL,
    `final_price`  DOUBLE      NOT NULL,
    `status`       VARCHAR(45) NOT NULL,
    `users_id`     INT         NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `order_id_UNIQUE` (`id` ASC) VISIBLE,
    INDEX `fk_order_users1_idx` (`users_id` ASC) VISIBLE,
    CONSTRAINT `fk_order_users1`
        FOREIGN KEY (`users_id`)
            REFERENCES `fog_carport`.`users` (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fog_carport`.`order_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_carport`.`order_item`
(
    `id`                  INT         NOT NULL AUTO_INCREMENT,
    `amount`              INT         NOT NULL,
    `length`              INT         NOT NULL,
    `context_description` VARCHAR(45) NOT NULL,
    `order_id`            INT         NOT NULL,
    `material_id`         INT         NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `materials_id_UNIQUE` (`id` ASC) VISIBLE,
    INDEX `fk_order_item_order1_idx` (`order_id` ASC) VISIBLE,
    INDEX `fk_order_item_material1_idx` (`material_id` ASC) VISIBLE,
    CONSTRAINT `fk_order_item_material1`
        FOREIGN KEY (`material_id`)
            REFERENCES `fog_carport`.`material` (`id`),
    CONSTRAINT `fk_order_item_order1`
        FOREIGN KEY (`order_id`)
            REFERENCES `fog_carport`.`order` (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;


