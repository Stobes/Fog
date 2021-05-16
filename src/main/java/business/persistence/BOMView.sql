SELECT material_description, order_item.length, order_item.amount, unit, context_description, `order`.id
FROM material,
     order_item,
     `order`,
     users
WHERE material.id = order_item.material_id
  AND order_item.order_id = order.id
  AND `order`.users_id = users.id;