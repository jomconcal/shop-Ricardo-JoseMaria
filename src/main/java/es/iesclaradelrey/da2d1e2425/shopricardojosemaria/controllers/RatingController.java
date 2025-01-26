package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Rating;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CategoryService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.ProductService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.RatingService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.RatingServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/rating")
@AllArgsConstructor
public class RatingController {

    private final RatingServiceImpl ratingService;
    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping({"/",""})
    public ModelAndView getRating(@RequestParam(name = "productId", required = true) Long productId) {
        ModelAndView mv = new ModelAndView("product-rating");
        Optional<Double> avg = ratingService.averageRatingByProductId(productId);
        String category= productService.findById(productId).orElseThrow().getCategory().getName();
        mv.addObject("category", category);

        if(avg.isPresent()) {
            mv.addObject("avg", avg.get());

           List<Rating> ratings = ratingService.getRatingsByProductId(productId);

            mv.addObject("ratings", ratings);

        }else{
            mv.addObject("avg", -1.0);
        }

        return mv;
    }
}
