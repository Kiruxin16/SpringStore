package ru.gb.com.validators;

import org.springframework.stereotype.Component;
import ru.gb.com.dto.ProductDto;
import ru.gb.com.exceptions.ValidateException;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {

    List<String> messagePool;
    public void validate(ProductDto product){
        messagePool=new ArrayList<>();

        if(product.getPrice()<1){
            messagePool.add("Price can't be lower than 1");
        }
        if(product.getTitle().isBlank()){
            messagePool.add("'Title' field can't be empty");
        }
        if(!messagePool.isEmpty()){
            throw new ValidateException(messagePool);
        }
    }
}
