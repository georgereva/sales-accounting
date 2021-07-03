package com.heorhiireva.salesaccounting.service;

import com.heorhiireva.salesaccounting.persistence.entity.Product;
import com.heorhiireva.salesaccounting.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public Product getOne(UUID productId) {
        return productRepository.getOne(productId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public void deleteById(UUID productId) {
        productRepository.deleteById(productId);
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
