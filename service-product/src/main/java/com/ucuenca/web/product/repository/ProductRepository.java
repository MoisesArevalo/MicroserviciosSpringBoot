package com.ucuenca.web.product.repository;

import com.ucuenca.web.product.entity.Category;
import com.ucuenca.web.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    public List<Product> findByCategory(Category category);

}
