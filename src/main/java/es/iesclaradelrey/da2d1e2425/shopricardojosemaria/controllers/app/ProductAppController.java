package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.app;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app.AppProductDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/app/v1/products")
public class ProductAppController {

    private final ProductService productService;


    @GetMapping("/find")
    public ResponseEntity<Page<AppProductDto>> getProducts() {

        Page<Product> productList = productService.findAll(null,null,1,4,"name","asc");
        ModelMapper modelMapper = new ModelMapper();

        List<AppProductDto> appProductDtos = productList.stream()
                .map(product -> modelMapper.map(product, AppProductDto.class))
                .collect(Collectors.toList())                ;

        return ResponseEntity.ok(new PageImpl<>(appProductDtos, productList.getPageable(), productList.getTotalElements()));
    }

//    @GetMapping("/find")
//    public ResponseEntity<Collection<Product>> getProducts() {
//
//        Collection<Product>productList= productService.findAll();
//        return ResponseEntity.ok(productList);
//    }
}
