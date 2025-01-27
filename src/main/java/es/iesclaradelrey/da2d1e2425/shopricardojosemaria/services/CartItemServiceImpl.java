package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    @Override
    public void save(CartItem cartItem) {

        Optional<CartItem> previousCartItem=cartItemRepository.findByProductId(cartItem.getProduct().getId());
        if(previousCartItem.isPresent()){
            CartItem newCartItem=previousCartItem.get();
            newCartItem.setQuantity(newCartItem.getQuantity()+1);
            cartItemRepository.save(newCartItem);
        }else{
            cartItemRepository.save(cartItem);
        }
    }

    @Override
    public Collection<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public Optional<CartItem> findById(long id) {
        return cartItemRepository.findById(id);
    }
}
