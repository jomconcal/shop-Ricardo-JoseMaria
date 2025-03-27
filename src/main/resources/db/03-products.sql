-- Productos de Coffees
INSERT INTO products (category_id, name, description, productDetail, price, imageUrl)
VALUES ((SELECT id FROM categories WHERE name = 'Coffees'), 'Espresso', 'Classic Italian coffee',
        'Espresso is a concentrated coffee brewed by forcing a small amount of nearly boiling water through finely-ground coffee beans. It has a strong, bold flavor with a rich crema on top.',
        4.50, '/img/products/coffees/espresso.webp'),
       ((SELECT id FROM categories WHERE name = 'Coffees'), 'Cappuccino', 'Perfect blend of coffee and milk foam',
        'Cappuccino is a combination of espresso and steamed milk, topped with thick, velvety foam. It’s a popular coffee drink that’s smooth, rich, and ideal for any time of day.',
        5.50, '/img/products/coffees/cappuccino.jpg'),
       ((SELECT id FROM categories WHERE name = 'Coffees'), 'Latte', 'Smooth coffee with steamed milk',
        'Latte is made with espresso and steamed milk, topped with a small amount of milk foam. It has a creamy and mild flavor that makes it a favorite for many coffee lovers.',
        5.00, '/img/products/coffees/latte.jpg'),
       ((SELECT id FROM categories WHERE name = 'Coffees'), 'Americano', 'Simple and bold black coffee',
        'Americano is made by diluting espresso with hot water, resulting in a coffee with a rich, full flavor that’s less intense than espresso but just as satisfying.',
        4.00, '/img/products/coffees/americano.jpeg'),
       ((SELECT id FROM categories WHERE name = 'Coffees'), 'Mocha', 'Coffee with a chocolate twist',
        'Mocha is a combination of espresso, steamed milk, and chocolate syrup or powder. It’s a rich, sweet, and indulgent coffee drink with a perfect balance of chocolate and coffee flavors.',
        5.75, '/img/products/coffees/mocha.jpg');

-- Productos de Teas
INSERT INTO products (category_id, name, description, productDetail, price, imageUrl)
VALUES ((SELECT id FROM categories WHERE name = 'Teas'), 'Green Tea', 'Refreshing and healthy',
        'Green tea is made from unoxidized leaves, giving it a fresh, light taste. Rich in antioxidants, it’s known for its health benefits, including boosting metabolism and improving brain function.',
        3.50, '/img/products/teas/green-tea.webp'),
       ((SELECT id FROM categories WHERE name = 'Teas'), 'Black Tea', 'Strong and full-bodied',
        'Black tea is fully oxidized, giving it a deep, robust flavor. It has higher caffeine content than other teas and is perfect for a morning pick-me-up or as a midday refreshment.',
        3.75, '/img/products/teas/black-tea.png'),
       ((SELECT id FROM categories WHERE name = 'Teas'), 'Chamomile', 'Calming herbal tea',
        'Chamomile tea is made from dried chamomile flowers and has a sweet, floral flavor. It is widely known for its calming and sleep-inducing properties, making it an ideal bedtime drink.',
        4.00, '/img/products/teas/chamomile.jpg'),
       ((SELECT id FROM categories WHERE name = 'Teas'), 'Oolong', 'A perfect balance of flavor',
        'Oolong tea is partially fermented, giving it a unique flavor profile that’s somewhere between green and black tea. It’s aromatic, smooth, and pairs perfectly with a variety of foods.',
        4.25, '/img/products/teas/oolong.jpeg'),
       ((SELECT id FROM categories WHERE name = 'Teas'), 'Mint Tea', 'Refreshing mint flavor',
        'Mint tea is made from mint leaves, known for its invigorating and cooling effect. It has a refreshing, crisp taste that aids digestion and soothes the stomach.',
        3.50, '/img/products/teas/mint-tea.jpg');

-- Productos de Cocktails
INSERT INTO products (category_id, name, description, productDetail, price, imageUrl)
VALUES ((SELECT id FROM categories WHERE name = 'Cocktails'), 'Mojito', 'Classic Cuban cocktail',
        'Mojito is a cocktail made with white rum, sugar, lime juice, soda water, and mint. It’s known for its refreshing, minty flavor and is the perfect drink for a summer day or any casual gathering.',
        8.00, '/img/products/cocktails/mojito.jpg'),
       ((SELECT id FROM categories WHERE name = 'Cocktails'), 'Margarita', 'A citrusy favorite',
        'Margarita is made with tequila, lime juice, and orange liqueur, served with a salted rim. It’s tangy, sweet, and perfect for any fiesta or celebration.',
        9.00, '/img/products/cocktails/margarita.jpg'),
       ((SELECT id FROM categories WHERE name = 'Cocktails'), 'Negroni', 'Bold and sophisticated',
        'Negroni is a cocktail made with equal parts gin, vermouth rosso, and Campari. It’s a strong, bitter, and sophisticated drink that’s perfect for cocktail connoisseurs.',
        10.00, '/img/products/cocktails/negroni.jpg'),
       ((SELECT id FROM categories WHERE name = 'Cocktails'), 'Piña Colada', 'Tropical pineapple delight',
        'Piña Colada is a tropical cocktail made with rum, coconut cream, and pineapple juice. It’s a smooth, creamy, and sweet drink that transports you to a beachside paradise.',
        8.50, '/img/products/cocktails/pina-colada.webp'),
       ((SELECT id FROM categories WHERE name = 'Cocktails'), 'Daiquiri', 'Refreshing lime cocktail',
        'Daiquiri is a cocktail made with rum, lime juice, and sugar. It’s simple, refreshing, and perfect for those who enjoy a tart and sweet cocktail.',
        9.50, '/img/products/cocktails/daiquiri.jpg');

-- Productos de Pintxos
INSERT INTO products (category_id, name, description, productDetail, price, imageUrl)
VALUES ((SELECT id FROM categories WHERE name = 'Pintxos'), 'Jamon Pintxo', 'Ham on crusty bread',
        'Jamon Pintxo is a Basque-inspired bite consisting of thinly sliced cured ham served on a piece of crusty bread. It’s simple, savory, and delicious, perfect for a tapas-style meal.',
        3.50, '/img/products/pintxos/jamon-pintxo.jpg'),
       ((SELECT id FROM categories WHERE name = 'Pintxos'), 'Tortilla Pintxo', 'Spanish omelette bite',
        'Tortilla Pintxo is a small portion of traditional Spanish omelette, made with eggs, potatoes, and onions. It’s a classic Basque tapa that’s hearty, flavorful, and comforting.',
        3.75, '/img/products/pintxos/tortilla-pintxo.webp'),
       ((SELECT id FROM categories WHERE name = 'Pintxos'), 'Shrimp Pintxo', 'Shrimp with garlic',
        'Shrimp Pintxo features succulent shrimp sautéed with garlic and served on a slice of toasted bread. It’s a savory bite full of flavor, perfect for seafood lovers.',
        4.00, '/img/products/pintxos/shrimp-pintxo.jpg'),
       ((SELECT id FROM categories WHERE name = 'Pintxos'), 'Chorizo Pintxo', 'Spicy sausage and pepper',
        'Chorizo Pintxo is a Basque-style tapa made with spicy sausage and grilled peppers, served on a slice of crusty bread. It’s flavorful, smoky, and packs a bit of heat.',
        4.25, '/img/products/pintxos/chorizo-pintxo.jpg'),
       ((SELECT id FROM categories WHERE name = 'Pintxos'), 'Cheese Pintxo', 'Artisan cheese selection',
        'Cheese Pintxo offers a variety of artisan cheeses served on bread. It’s a delightful and rich bite that pairs wonderfully with wine and is perfect for cheese lovers.',
        4.50, '/img/products/pintxos/cheese-pintxo.jpg');

-- Productos de Desserts
INSERT INTO products (category_id, name, description, productDetail, price, imageUrl)
VALUES ((SELECT id FROM categories WHERE name = 'Desserts'), 'Brownie', 'Rich chocolate dessert',
        'Brownie is a dense, fudgy chocolate dessert that’s perfect for any chocolate lover. It’s rich, moist, and packed with flavor, often enjoyed with a scoop of vanilla ice cream.',
        4.50, '/img/products/desserts/brownie.png'),
       ((SELECT id FROM categories WHERE name = 'Desserts'), 'Cheesecake', 'Creamy and indulgent',
        'Cheesecake is a rich, creamy dessert made with cream cheese, eggs, and sugar, typically set on a graham cracker crust. It’s a decadent treat that’s perfect for any occasion.',
        5.00, '/img/products/desserts/cheesecake.jpg'),
       ((SELECT id FROM categories WHERE name = 'Desserts'), 'Tiramisu', 'Classic Italian dessert',
        'Tiramisu is an Italian dessert made with layers of coffee-soaked ladyfingers, mascarpone cheese, cocoa powder, and a dusting of chocolate. It’s indulgent and perfect after a meal.',
        5.50, '/img/products/desserts/tiramisu.jpg'),
       ((SELECT id FROM categories WHERE name = 'Desserts'), 'Panna Cotta', 'Silky and smooth',
        'Panna Cotta is an Italian dessert made with sweetened cream that’s set with gelatin. It’s silky, smooth, and typically served with fresh fruit or a berry compote.',
        5.25, '/img/products/desserts/panna-cotta.jpg'),
       ((SELECT id FROM categories WHERE name = 'Desserts'), 'Ice Cream', 'Assorted gourmet flavors',
        'Ice Cream comes in a variety of flavors, from classic vanilla to exotic fruit or chocolate varieties. It’s creamy, cold, and perfect for a summer day or any sweet craving.',
        4.00, '/img/products/desserts/ice-cream.webp');

UPDATE products
SET stock = 10
WHERE name IN ('Espresso', 'Ice Cream', 'Tiramisu', 'Brownie');
