package ru.gb.com.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.com.items.Product;
import ru.gb.com.services.ProductService;


import java.util.List;


@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;



    @GetMapping("/products/{id}")
    public Product getProductByID(@PathVariable long id){
        return productService.getProductByID(id);
    }

    @GetMapping("/products")
    public List<Product> getProductList(){
        return productService.getProductList();
    }


    @GetMapping("/products/filter/mincost")
    public List<Product> getExpensive(@RequestParam Integer cost){
        return  productService.getProductsExpensThan(cost);
    }

    @GetMapping("/products/filter/maxcost")
    public List<Product> getCheaper(@RequestParam Integer cost){
        return  productService.getProductsCheaperThan(cost);
    }

    @GetMapping("/products/filter/diapasone")
    public List<Product> getCheaper(@RequestParam Integer minCost,@RequestParam Integer maxCost){
        return  productService.getProductsBetween(minCost,maxCost);
    }

    @GetMapping("/products/delete/{id}")
    public  void removeProduct(@PathVariable Long id){
        productService.removeProduct(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestParam String title,@RequestParam Integer price){
        productService.addProduct(title,price);
    }


}
