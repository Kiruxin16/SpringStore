package ru.gb.com.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.gb.com.dto.convertors.CartDtoConvertor;
import ru.gb.com.dto.CartItemDto;
import ru.gb.com.dto.ProductDto;
import ru.gb.com.entities.CartItem;
import ru.gb.com.repositories.CartItemsRepository;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartItemsRepository cartRepository;
    private final CartDtoConvertor cartDtoConvertor;
    public Page<CartItemDto> getCartList(Integer p) {
       return cartRepository.findAll(PageRequest.of(p-1,5)).map(cartDtoConvertor::cartItemToDto);
    }

    public ProductDto addTocart(ProductDto product){
        if(cartRepository.existsById(product.getId())){
            CartItem cartItem =cartRepository.getById(product.getId());
            cartItem.setAmount(cartItem.getAmount()+1);
        }else {
            cartRepository.save(cartDtoConvertor.productDtoToCartItem(product));
        }
        return product;
    }
}
