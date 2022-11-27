package ru.gb.com.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.com.items.Product;

@Data
@NoArgsConstructor
@Component
public class ProductDtoCreator {



    public Product dtoToProduct(ProductDto dto){
        Product pr =  new Product();
        pr.setPrice(dto.getPrice());
        pr.setTitle(dto.getTitle());
        return pr;
    }


    public ProductDto productToDto(Product product){
        return new ProductDto(product);
    }




}
