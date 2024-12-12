package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.commandLineRunners;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CategoryService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class CategoryCommandLineRunner implements CommandLineRunner {

    private final CategoryService categoryService;
    private final ProductService productService;

    @Override
    public void run(String... args) throws Exception {

        long id = 1L;

// Categorías
        Category coffee = new Category(id++, "Coffees", "Enjoy the finest coffee blends", "/img/categories/coffee.png");
        Category tea = new Category(id++, "Teas", "Discover the magic of our tea selections", "/img/categories/tea.webp");
        Category cocktail = new Category(id++, "Cocktails", "Crafted cocktails for every occasion", "/img/categories/cocktail.jpg");
        Category pintxo = new Category(id++, "Pintxos", "Basque-inspired gourmet bites", "/img/categories/pintxos.jpg");
        Category dessert = new Category(id++, "Desserts", "Sweet delights to end your meal", "/img/categories/dessert.webp");

// Productos de Coffees
        Product espresso = new Product(id++, coffee, "Espresso", "Classic Italian coffee", 4.50, "/img/products/coffees/espresso.webp");
        Product cappuccino = new Product(id++, coffee, "Cappuccino", "Perfect blend of coffee and milk foam", 5.50, "/img/products/coffees/cappuccino.jpg");
        Product latte = new Product(id++, coffee, "Latte", "Smooth coffee with steamed milk", 5.00, "/img/products/coffees/latte.jpg");
        Product americano = new Product(id++, coffee, "Americano", "Simple and bold black coffee", 4.00, "/img/products/coffees/americano.jpeg");
        Product mocha = new Product(id++, coffee, "Mocha", "Coffee with a chocolate twist", 5.75, "/img/products/coffees/mocha.jpg");

// Productos de Teas
        Product greenTea = new Product(id++, tea, "Green Tea", "Refreshing and healthy", 3.50, "/img/products/teas/green-tea.webp");
        Product blackTea = new Product(id++, tea, "Black Tea", "Strong and full-bodied", 3.75, "/img/products/teas/black-tea.png");
        Product chamomile = new Product(id++, tea, "Chamomile", "Calming herbal tea", 4.00, "/img/products/teas/chamomile.jpg");
        Product oolong = new Product(id++, tea, "Oolong", "A perfect balance of flavor", 4.25, "/img/products/teas/oolong.jpeg");
        Product mintTea = new Product(id++, tea, "Mint Tea", "Refreshing mint flavor", 3.50, "/img/products/teas/mint-tea.jpg");

// Productos de Cocktails
        Product mojito = new Product(id++, cocktail, "Mojito", "Classic Cuban cocktail", 8.00, "/img/products/cocktails/mojito.jpg");
        Product margarita = new Product(id++, cocktail, "Margarita", "A citrusy favorite", 9.00, "/img/products/cocktails/margarita.jpg");
        Product negroni = new Product(id++, cocktail, "Negroni", "Bold and sophisticated", 10.00, "/img/products/cocktails/negroni.jpg");
        Product piñaColada = new Product(id++, cocktail, "Piña Colada", "Tropical pineapple delight", 8.50, "/img/products/cocktails/pina-colada.webp");
        Product daiquiri = new Product(id++, cocktail, "Daiquiri", "Refreshing lime cocktail", 9.50, "/img/products/cocktails/daiquiri.jpg");

// Productos de Pintxos
        Product jamonPintxo = new Product(id++, pintxo, "Jamon Pintxo", "Ham on crusty bread", 3.50, "/img/products/pintxos/jamon-pintxo.jpg");
        Product tortillaPintxo = new Product(id++, pintxo, "Tortilla Pintxo", "Spanish omelette bite", 3.75, "/img/products/pintxos/tortilla-pintxo.webp");
        Product shrimpPintxo = new Product(id++, pintxo, "Shrimp Pintxo", "Shrimp with garlic", 4.00, "/img/products/pintxos/shrimp-pintxo.jpg");
        Product chorizoPintxo = new Product(id++, pintxo, "Chorizo Pintxo", "Spicy sausage and pepper", 4.25, "/img/products/pintxos/chorizo-pintxo.jpg");
        Product cheesePintxo = new Product(id++, pintxo, "Cheese Pintxo", "Artisan cheese selection", 4.50, "/img/products/pintxos/cheese-pintxo.jpg");

// Productos de Desserts
        Product brownie = new Product(id++, dessert, "Brownie", "Rich chocolate dessert", 4.50, "/img/products/desserts/brownie.png");
        Product cheesecake = new Product(id++, dessert, "Cheesecake", "Creamy and indulgent", 5.00, "/img/products/desserts/cheesecake.jpg");
        Product tiramisu = new Product(id++, dessert, "Tiramisu", "Classic Italian dessert", 5.50, "/img/products/desserts/tiramisu.jpg");
        Product pannaCotta = new Product(id++, dessert, "Panna Cotta", "Silky and smooth", 5.25, "/img/products/desserts/panna-cotta.jpg");
        Product iceCream = new Product(id++, dessert, "Ice Cream", "Assorted gourmet flavors", 4.00, "/img/products/desserts/ice-cream.webp");

// Guardar categorías
        categoryService.save(coffee);
        categoryService.save(tea);
        categoryService.save(cocktail);
        categoryService.save(pintxo);
        categoryService.save(dessert);

// Guardar productos
        productService.save(espresso);
        productService.save(cappuccino);
        productService.save(latte);
        productService.save(americano);
        productService.save(mocha);

        productService.save(greenTea);
        productService.save(blackTea);
        productService.save(chamomile);
        productService.save(oolong);
        productService.save(mintTea);

        productService.save(mojito);
        productService.save(margarita);
        productService.save(negroni);
        productService.save(piñaColada);
        productService.save(daiquiri);

        productService.save(jamonPintxo);
        productService.save(tortillaPintxo);
        productService.save(shrimpPintxo);
        productService.save(chorizoPintxo);
        productService.save(cheesePintxo);

        productService.save(brownie);
        productService.save(cheesecake);
        productService.save(tiramisu);
        productService.save(pannaCotta);
        productService.save(iceCream);

    }
}
