package ru.gb.com.services;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.com.dto.ProductDto;
import ru.gb.com.dto.convertors.ProductDtoConvertor;
import ru.gb.com.exceptions.ResourseNotFoundException;
import ru.gb.com.entities.Product;
import ru.gb.com.repositories.ProductRepository;
import ru.gb.com.repositories.specification.ProductSpecification;
import ru.gb.com.validators.ProductValidator;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductValidator productValidator;

    private final ProductRepository productRepository;
    private final ProductDtoConvertor productDtoConvertor;

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

        return productRepository.findAll(spec, PageRequest.of(p-1,5)).map(productDtoConvertor::productToDto);
    }



    public ProductDto getProductByID(Long id){
        return productRepository.findById(id).map(productDtoConvertor::productToDto).
              orElseThrow(() -> new ResourseNotFoundException("Product with id: "+
                id+"hadn't founded"));

    }

    public ProductDto addProduct(ProductDto product){
        productValidator.validate(product);
        Product pr = productDtoConvertor.dtoToProduct(product);
        productRepository.save(pr);
        return product;
    }

    public void removeProduct(Long id){
        productRepository.deleteById(id);
    }



    public List<Product> getProductsBetween(Integer minPrice,Integer maxPice){
        return productRepository.getCostDiap(minPrice,maxPice);
    }


    @Transactional
    public ProductDto updateProduct(ProductDto product) {
        Product pr = productRepository.findById(product.getId()).orElseThrow(()->new ResourseNotFoundException("Product with id: "+
                product.getId()+"hadn't founded"));
        pr.setTitle(product.getTitle());
        pr.setPrice(product.getPrice());
        return product;
    }
}
