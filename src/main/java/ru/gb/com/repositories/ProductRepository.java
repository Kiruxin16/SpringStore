package ru.gb.com.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gb.com.items.Product;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("select p from Product p where p.price >= :price" )
    List<Product> getMinFilter(Integer price);

    @Query("select p from Product p where p.price <= :price" )
    List<Product> getMaxFilter(Integer price);

    @Query("select p from Product p where p.price >= :minPrice and p.price <= :maxPrice" )
    List<Product> getCostDiap(Integer minPrice, Integer maxPrice);
}
