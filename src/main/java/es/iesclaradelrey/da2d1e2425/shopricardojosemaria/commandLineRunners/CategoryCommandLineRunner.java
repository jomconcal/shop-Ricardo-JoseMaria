package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.commandLineRunners;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryCommandLineRunner implements CommandLineRunner {

    private final CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {

        Category test= new Category(1L,"Test","This is a test","/img/menu-item-1.jpg");
        Category test2= new Category(2L,"Test2","This is another test","/img/menu-item-2.jpg");
        categoryService.save(test);
        categoryService.save(test2);
    }
}
