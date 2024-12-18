INSERT INTO categories (name, description, image_url) VALUES
                                                         ('Coffees', 'Enjoy the finest coffee blends', '/img/categories/coffee.png'),
                                                         ('Teas', 'Discover the magic of our tea selections', '/img/categories/tea.webp'),
                                                         ('Cocktails', 'Crafted cocktails for every occasion', '/img/categories/cocktail.jpg'),
                                                         ('Pintxos', 'Basque-inspired gourmet bites', '/img/categories/pintxos.jpg'),
                                                         ('Desserts', 'Sweet delights to end your meal', '/img/categories/dessert.webp');
-- Productos de Coffees
INSERT INTO products (category_id, name, description, price, image_url) VALUES
                                                                           ((SELECT id FROM categories WHERE name = 'Coffees'), 'Espresso', 'Classic Italian coffee', 4.50, '/img/products/coffees/espresso.webp'),
                                                                           ((SELECT id FROM categories WHERE name = 'Coffees'), 'Cappuccino', 'Perfect blend of coffee and milk foam', 5.50, '/img/products/coffees/cappuccino.jpg'),
                                                                           ((SELECT id FROM categories WHERE name = 'Coffees'), 'Latte', 'Smooth coffee with steamed milk', 5.00, '/img/products/coffees/latte.jpg'),
                                                                           ((SELECT id FROM categories WHERE name = 'Coffees'), 'Americano', 'Simple and bold black coffee', 4.00, '/img/products/coffees/americano.jpeg'),
                                                                           ((SELECT id FROM categories WHERE name = 'Coffees'), 'Mocha', 'Coffee with a chocolate twist', 5.75, '/img/products/coffees/mocha.jpg');

-- Productos de Teas
INSERT INTO products (category_id, name, description, price, image_url) VALUES
                                                                           ((SELECT id FROM categories WHERE name = 'Teas'), 'Green Tea', 'Refreshing and healthy', 3.50, '/img/products/teas/green-tea.webp'),
                                                                           ((SELECT id FROM categories WHERE name = 'Teas'), 'Black Tea', 'Strong and full-bodied', 3.75, '/img/products/teas/black-tea.png'),
                                                                           ((SELECT id FROM categories WHERE name = 'Teas'), 'Chamomile', 'Calming herbal tea', 4.00, '/img/products/teas/chamomile.jpg'),
                                                                           ((SELECT id FROM categories WHERE name = 'Teas'), 'Oolong', 'A perfect balance of flavor', 4.25, '/img/products/teas/oolong.jpeg'),
                                                                           ((SELECT id FROM categories WHERE name = 'Teas'), 'Mint Tea', 'Refreshing mint flavor', 3.50, '/img/products/teas/mint-tea.jpg');

-- Productos de Cocktails
INSERT INTO products (category_id, name, description, price, image_url) VALUES
                                                                           ((SELECT id FROM categories WHERE name = 'Cocktails'), 'Mojito', 'Classic Cuban cocktail', 8.00, '/img/products/cocktails/mojito.jpg'),
                                                                           ((SELECT id FROM categories WHERE name = 'Cocktails'), 'Margarita', 'A citrusy favorite', 9.00, '/img/products/cocktails/margarita.jpg'),
                                                                           ((SELECT id FROM categories WHERE name = 'Cocktails'), 'Negroni', 'Bold and sophisticated', 10.00, '/img/products/cocktails/negroni.jpg'),
                                                                           ((SELECT id FROM categories WHERE name = 'Cocktails'), 'Piña Colada', 'Tropical pineapple delight', 8.50, '/img/products/cocktails/pina-colada.webp'),
                                                                           ((SELECT id FROM categories WHERE name = 'Cocktails'), 'Daiquiri', 'Refreshing lime cocktail', 9.50, '/img/products/cocktails/daiquiri.jpg');

-- Productos de Pintxos
INSERT INTO products (category_id, name, description, price, image_url) VALUES
                                                                           ((SELECT id FROM categories WHERE name = 'Pintxos'), 'Jamon Pintxo', 'Ham on crusty bread', 3.50, '/img/products/pintxos/jamon-pintxo.jpg'),
                                                                           ((SELECT id FROM categories WHERE name = 'Pintxos'), 'Tortilla Pintxo', 'Spanish omelette bite', 3.75, '/img/products/pintxos/tortilla-pintxo.webp'),
                                                                           ((SELECT id FROM categories WHERE name = 'Pintxos'), 'Shrimp Pintxo', 'Shrimp with garlic', 4.00, '/img/products/pintxos/shrimp-pintxo.jpg'),
                                                                           ((SELECT id FROM categories WHERE name = 'Pintxos'), 'Chorizo Pintxo', 'Spicy sausage and pepper', 4.25, '/img/products/pintxos/chorizo-pintxo.jpg'),
                                                                           ((SELECT id FROM categories WHERE name = 'Pintxos'), 'Cheese Pintxo', 'Artisan cheese selection', 4.50, '/img/products/pintxos/cheese-pintxo.jpg');

-- Productos de Desserts
INSERT INTO products (category_id, name, description, price, image_url) VALUES
                                                                           ((SELECT id FROM categories WHERE name = 'Desserts'), 'Brownie', 'Rich chocolate dessert', 4.50, '/img/products/desserts/brownie.png'),
                                                                           ((SELECT id FROM categories WHERE name = 'Desserts'), 'Cheesecake', 'Creamy and indulgent', 5.00, '/img/products/desserts/cheesecake.jpg'),
                                                                           ((SELECT id FROM categories WHERE name = 'Desserts'), 'Tiramisu', 'Classic Italian dessert', 5.50, '/img/products/desserts/tiramisu.jpg'),
                                                                           ((SELECT id FROM categories WHERE name = 'Desserts'), 'Panna Cotta', 'Silky and smooth', 5.25, '/img/products/desserts/panna-cotta.jpg'),
                                                                           ((SELECT id FROM categories WHERE name = 'Desserts'), 'Ice Cream', 'Assorted gourmet flavors', 4.00, '/img/products/desserts/ice-cream.webp');
