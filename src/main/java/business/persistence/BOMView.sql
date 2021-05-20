CREATE
    ALGORITHM = UNDEFINED
    DEFINER = `root`@`localhost`
    SQL SECURITY DEFINER
    VIEW `fog_carport`.`new_view` AS
SELECT
    `fog_carport`.`material`.`material_description` AS `material_description`,
    `fog_carport`.`order_item`.`length` AS `length`,
    `fog_carport`.`order_item`.`amount` AS `amount`,
    `fog_carport`.`material`.`unit` AS `unit`,
    `fog_carport`.`order_item`.`context_description` AS `context_description`,
    `fog_carport`.`order`.`id` AS `id`
FROM
    (((`fog_carport`.`material`
        JOIN `fog_carport`.`order_item`)
        JOIN `fog_carport`.`order`)
        JOIN `fog_carport`.`users`)
WHERE
    ((`fog_carport`.`material`.`id` = `fog_carport`.`order_item`.`material_id`)
        AND (`fog_carport`.`order_item`.`order_id` = `fog_carport`.`order`.`id`)
        AND (`fog_carport`.`order`.`users_id` = `fog_carport`.`users`.`id`))