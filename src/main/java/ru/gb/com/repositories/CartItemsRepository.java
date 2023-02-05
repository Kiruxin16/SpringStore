package ru.gb.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.gb.com.entities.CartItem;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItem, Long>, JpaSpecificationExecutor<CartItem> {


}
