package com.example.productservice.repository;

import com.example.productservice.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryProductRepository {

    private final Map<String, Product> productStore = new HashMap<>();

    public List<Product> findAll() {
        return new ArrayList<>(productStore.values());
    }

    public Optional<Product> findById(String id) {
        return Optional.ofNullable(productStore.get(id));
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(UUID.randomUUID().toString());
        }
        productStore.put(product.getId(), product);
        return product;
    }

    public void deleteById(String id) {
        productStore.remove(id);
    }
}
