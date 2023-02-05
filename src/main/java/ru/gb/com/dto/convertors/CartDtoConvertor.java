package ru.gb.com.dto.convertors;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.com.dto.CartItemDto;
import ru.gb.com.dto.ProductDto;
import ru.gb.com.entities.CartItem;

@Component
@Data
@NoArgsConstructor
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
