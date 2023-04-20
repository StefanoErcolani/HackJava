-- INSERT INTO posts(title, body, publish_date, author_id)
-- values("Hello", "Sono un corpo", "111213", 1);

-- DELETE FROM authors;
-- INSERT INTO authors(firstname, lastname, email)
-- values("Ciccio", "Engrassia", "ergrasso99@aulab.it"),
-- ("Franco", "Poldo", "polderia@aulab.it"),
-- ("Luigi", "Pagli", "paglione12@aulab.it"),
-- ("Roberto", "Carasso", "bob12@aulab.it");

-- INSERT INTO posts(title, body, publish_date, author_id)
-- values("La nenai", "Non so cosa sia", "112211", 1),
-- ("La nenai 2", "Ancora niente", "122211", 1),
-- ("Dolore", "Ho sbattuto il piede", "130702", 2),
-- ("Afrismo", "Curucuccucù", "021004", 2),
-- ("Il legno", "Il legno è bello", "040203", 3),
-- ("Sabbia", "Sabbiasabbiasabbia", "070707", 4);
-- UPDATE posts p SET author_id = 1 WHERE p.id = 244; 
-- UPDATE posts p SET author_id = 1 WHERE p.id = 244; 
-- UPDATE posts p SET author_id = 2 WHERE p.id = 245; 
-- UPDATE posts p SET author_id = 2 WHERE p.id = 246; 
-- UPDATE posts p SET author_id = 3 WHERE p.id = 247; 
-- UPDATE posts p SET author_id = 4 WHERE p.id = 248; 

DELETE FROM posts p WHERE p.body = 'Fucile';