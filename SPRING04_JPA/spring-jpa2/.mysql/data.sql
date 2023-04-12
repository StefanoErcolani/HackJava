-- INSERT INTO menu(dish_name, ingredients, price, restaurant_id)
-- value('pasta al sugo', 'pasta, sugo', 7, 1),
--     ('frittura di pesce', 'alici, gamberi, totani', 15, 1),
--     ('frutta stagionale', 'mele, pere, banane', 9, 1),
--     ('tiramisù', 'savoiardi, caffè e tutto quello che sta', 8, 1);

 ALTER TABLE menu RENAME COLUMN restaurant TO restaurant_id;

