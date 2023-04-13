-- select *
-- from restaurant;

-- select *
-- from restaurant
-- join menu on restaurant.id = menu.restaurant_id;

-- select * 
-- from restaurant
-- join menu on restaurant.id = menu.restaurant_id;

select *
from menu m
left join menu_clients mc on m.id = mc.menu_id
left join clients cl on cl.id = mc.clients_id;
