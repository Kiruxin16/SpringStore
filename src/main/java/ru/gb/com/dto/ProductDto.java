package ru.gb.com.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.com.items.Product;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private Integer price;

    private String title;

    public ProductDto(Product product){
        this.id=product.getId();
        this.price=product.getPrice();
        this.title=product.getTitle();

    }

}
