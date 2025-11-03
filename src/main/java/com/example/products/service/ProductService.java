package com.example.products.service;

import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Получить все товары
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Получить товар по ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Сохранить новый товар
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Обновить существующий товар
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Товар не найден с ID: " + id));

        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setStockQuantity(productDetails.getStockQuantity());

        return productRepository.save(product);
    }

    // Удалить товар
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
