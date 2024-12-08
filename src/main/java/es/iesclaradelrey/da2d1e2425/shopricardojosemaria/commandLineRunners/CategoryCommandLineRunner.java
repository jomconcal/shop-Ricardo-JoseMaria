package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.commandLineRunners;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CategoryService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryCommandLineRunner implements CommandLineRunner {

    private final CategoryService categoryService;
    private final ProductService productService;

    @Override
    public void run(String... args) throws Exception {

        long id= 1L;
        Category coffee = new Category(id++, "Coffee", "The best coffee quality", "/img/menu-item-1.jpg");
        Category tea = new Category(id++, "Tea", "Our teas has the best flavour in the market", "/img/menu-item-2.jpg");

        Product machiato= new Product(id++,coffee,"Macchiato","Soft coffee",5.95,"/img/menu-item-3.jpg");
        Product roibos= new Product(id++,tea,"Roibos","Nice infusion",7.00,"/img/menu-item-4.jpg");

        categoryService.save(coffee);
        categoryService.save(tea);

        productService.save(machiato);
        productService.save(roibos);
    }
}
