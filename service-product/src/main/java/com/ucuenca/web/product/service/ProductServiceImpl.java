package com.ucuenca.web.product.service;

import com.ucuenca.web.product.entity.Category;
import com.ucuenca.web.product.entity.Product;
import com.ucuenca.web.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements  ProductService{

    private final ProductRepository productRepository;

    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
//        return productRepository.findById(id).orElse(null);
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus("CREATED");
        product.setCreateAt(new Date());

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productdb = getProduct(product.getId());
        if(productdb != null){
            productdb.setName(product.getName());
            productdb.setPrice(product.getPrice());
            productdb.setDescription(product.getDescription());
            productdb.setCategory(product.getCategory());
            return productRepository.save(productdb);
        }
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productdb =getProduct(id);
        if(productdb != null){
            productdb.setStatus("DELETE");
            return productRepository.save(productdb);
        }
        return  null;

    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        Product productdb =getProduct(id);
        if(productdb != null){
            productdb.setStock(productdb.getStock()+quantity);
            return productRepository.save(productdb);
        }
        return null;
    }
}
