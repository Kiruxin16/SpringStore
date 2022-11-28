package ru.gb.com.repositories;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.gb.com.items.CartItem;
import ru.gb.com.items.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItem, Long>, JpaSpecificationExecutor<CartItem> {


}
