package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.app;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app.AppProductDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<PagedModel<AppProductDto>> getProducts(
            @RequestParam(defaultValue = "",required = false) String search,
            @RequestParam(required = false) Long cat,
            @RequestParam(defaultValue = "1") Integer pageNumber,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "name") String orderBy,
            @RequestParam(defaultValue = "asc") String orderDir            ) {

        Page<Product> productList = productService.findAll(search,cat,pageNumber-1,pageSize,orderBy,orderDir);
        ModelMapper modelMapper = new ModelMapper();

        List<AppProductDto> appProductDtos = productList.stream()
                .map(product -> modelMapper.map(product, AppProductDto.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new PagedModel<>(new PageImpl<>(appProductDtos, productList.getPageable(), productList.getTotalElements())));
    }

}
