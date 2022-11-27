package ru.gb.com.services;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.gb.com.dto.ProductDto;
import ru.gb.com.dto.ProductDtoCreator;
import ru.gb.com.exceptions.ResourseNotFoundException;
import ru.gb.com.items.Product;
import ru.gb.com.repositories.ProductRepository;
import ru.gb.com.repositories.specification.ProductSpecification;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoCreator productDtoCreator;

    public Page<ProductDto> find(Integer p, Integer minPrice, Integer maxPrice, String partTitle){
        Specification<Product> spec = Specification.where(null);
        if(minPrice!=null){
            spec=spec.and(ProductSpecification.priceGreaterThanOrEqualTo(minPrice));
        }
        if(maxPrice!=null){
            spec=spec.and(ProductSpecification.priceLessThanOrEqualTo(maxPrice));
        }
        if(partTitle!=null){
            spec=spec.and(ProductSpecification.titleLike(partTitle));
        }

        return productRepository.findAll(spec, PageRequest.of(p-1,5)).map(product -> productDtoCreator.productToDto(product));
    }



    public ProductDto getProductByID(Long id){
        return productRepository.findById(id).map(product -> productDtoCreator.productToDto(product)).
              orElseThrow(() -> new ResourseNotFoundException("Product with id: "+
                id+"hadn't founded"));

    }

    public void addProduct(ProductDto product){
        Product pr = productDtoCreator.dtoToProduct(product);
        productRepository.save(pr);
    }

    public void removeProduct(Long id){
        productRepository.deleteById(id);
    }



    public List<Product> getProductsBetween(Integer minPrice,Integer maxPice){
        return productRepository.getCostDiap(minPrice,maxPice);
    }









}
