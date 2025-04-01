package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.app;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app.AppProductDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/app/v1/products")
public class ProductAppController {

    private final ProductService productService;


    @GetMapping("/find")
    public ResponseEntity<Collection<AppProductDto>> getProducts() {

        Collection<Product> productList = productService.findAll();
        ModelMapper modelMapper = new ModelMapper();

        Collection<AppProductDto> appProductDtos = productList.stream()
                .map(product -> modelMapper.map(product, AppProductDto.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(appProductDtos);
    }

//    @GetMapping("/find")
//    public ResponseEntity<Collection<Product>> getProducts() {
//
//        Collection<Product>productList= productService.findAll();
//        return ResponseEntity.ok(productList);
//    }
}
