package ru.gb.com.dto.convertors;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.com.dto.ProductDto;
import ru.gb.com.entities.Product;

@Data
@NoArgsConstructor
@Component
public class ProductDtoConvertor {



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
