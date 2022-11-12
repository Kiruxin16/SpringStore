package ru.gb.com.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.com.items.Product;
import ru.gb.com.repositories.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public Product getProductByID(Long id){
        return productRepository.findById(id).orElseThrow();

    }

    public void addProduct(String title,Integer price){
        Product pr = new Product();
        pr.setTitle(title);
        pr.setPrice(price);
        productRepository.save(pr);
    }

    public void removeProduct(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> getProductsExpensThan(Integer minPice){
        return productRepository.getMinFilter(minPice);
    }
    public List<Product> getProductsCheaperThan(Integer maxPice){
        return productRepository.getMaxFilter(maxPice);
    }

    public List<Product> getProductsBetween(Integer minPrice,Integer maxPice){
        return productRepository.getCostDiap(minPrice,maxPice);
    }









}
