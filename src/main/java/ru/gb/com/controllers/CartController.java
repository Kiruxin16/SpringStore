package ru.gb.com.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.gb.com.dto.CartItemDto;
import ru.gb.com.dto.ProductDto;
import ru.gb.com.services.CartService;
import ru.gb.com.services.ProductService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;


    @GetMapping
    public Page<CartItemDto> getCartList(@RequestParam(name = "p")Integer page){
        if(page<1){
            page=1;
        }
        return cartService.getCartList(page);

    }

    @PostMapping("/{id}")
    public ProductDto addProductTocArt(ProductDto product){
        productService.getProductByID(product.getId());
        return cartService.addTocart(product);
    }


}
