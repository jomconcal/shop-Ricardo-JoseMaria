package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.app;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app.AppCartItemDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CartItemService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/app/v1/cart")
public class CartAppController {

    private final CartItemService cartItemService;

    @GetMapping({"","/"})
    public ResponseEntity<PagedModel<AppCartItemDto>> getAppCartItems(){

        Page<CartItem> cartItems = cartItemService.findAll(0,1,"name", "asc");
        ModelMapper modelMapper = new ModelMapper();

        List<AppCartItemDto> cartItemsDto = cartItems.stream().map(cartItem -> modelMapper.map(cartItem, AppCartItemDto.class)).toList();

        return ResponseEntity.ok(new PagedModel<>(new PageImpl<>(cartItemsDto, cartItems.getPageable(), cartItems.getTotalElements())));
    }

}
