package ru.gb.com.repositories.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.gb.com.items.Product;

public class ProductSpecification {
    public static Specification<Product> priceGreaterThanOrEqualTo(Integer price){
        return (((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"),price)));

    }

    public static Specification<Product> priceLessThanOrEqualTo(Integer price){
        return (((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"),price)));

    }

    public static Specification<Product> titleLike(String titlePart){
        return (((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"),String.format("%%%s%%",titlePart))));

    }
}
