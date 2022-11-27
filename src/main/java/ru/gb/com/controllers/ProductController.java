package ru.gb.com.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import ru.gb.com.dto.ProductDto;
import ru.gb.com.dto.ProductDtoCreator;
import ru.gb.com.items.Product;
import ru.gb.com.repositories.specification.ProductSpecification;
import ru.gb.com.services.ProductService;


import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;



/*    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductByID(@PathVariable long id){
        Optional<Product> product = productService.getProductByID(id);
        if(product.isPresent())
        {
            return new  ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        else return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }*/

    @GetMapping("/{id}")
    public ProductDto getProductByID(@PathVariable long id){
        return productService.getProductByID(id);
    }



    @GetMapping()
    public Page<ProductDto> getProductList(@RequestParam(name = "p",defaultValue = "1")Integer page,
                                        @RequestParam(name = "min_cost",required = false)Integer minCost,
                                        @RequestParam(name = "max_cost",required = false)Integer maxCost,
                                        @RequestParam(name = "title_part",required = false)String partTitle
    ){
        if(page<1){
            page=1;
        }

        return productService.find(page,minCost,maxCost,partTitle);
    }



    @PutMapping
    public void updateProduct(@RequestBody ProductDto product){
        productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public  void removeProduct(@PathVariable Long id){
        productService.removeProduct(id);
    }


    @PostMapping()
    public void addProduct(@RequestBody ProductDto product){
        productService.addProduct(product);
    }


}
