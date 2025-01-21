package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.ProductServiceImpl;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.RatingService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.RatingServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;

@Controller
@AllArgsConstructor
@RequestMapping("/product-detail")
public class ProductDetailController {

    ProductServiceImpl productService;
    RatingServiceImpl ratingService;


    @GetMapping({"/", ""})
    public ModelAndView getProductDetail(@RequestParam(name = "productId", required = true) Long productId) {

        Optional<Product> product = productService.findById(productId);
        Category category = product.orElseThrow().getCategory();
        ModelAndView mav = new ModelAndView("product-detail");
        mav.addObject("product", product.orElseThrow());
        Optional<Double> avg= ratingService.averageRatingByProductId(productId);

        if(avg.isPresent()) {
            mav.addObject("avg", ((int)(avg.get()*100))/100.00);
        }else{
            mav.addObject("avg", -1);
        }
        mav.addObject("title", category.getName());
        return mav;
    }
}
