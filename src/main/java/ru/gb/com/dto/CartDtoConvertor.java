package ru.gb.com.dto;

import org.springframework.stereotype.Component;
import ru.gb.com.items.CartItem;

@Component
public class CartDtoConvertor {

    public CartItemDto cartItemToDto(CartItem cartItem){
        CartItemDto ca= new CartItemDto();
        ca.setId(cartItem.getId());
        ca.setPrice(cartItem.getPrice());
        ca.setTitle(cartItem.getTitle());
        ca.setAmount(cartItem.getAmount());
        return ca;
    }

    public CartItem dtoToCartItem(CartItemDto cartItem){
        CartItem ca= new CartItem();
        ca.setId(cartItem.getId());
        ca.setPrice(cartItem.getPrice());
        ca.setTitle(cartItem.getTitle());
        ca.setAmount(cartItem.getAmount());
        return ca;
    }
    public CartItem productDtoToCartItem(ProductDto product){
        CartItem ca= new CartItem();
        ca.setId(product.getId());
        ca.setPrice(product.getPrice());
        ca.setTitle(product.getTitle());
        ca.setAmount(1);
        return ca;
    }

}
