package com.example.products.repository;

import com.example.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository предоставляет методы:
    // - save() - для сохранения и обновления
    // - findAll() - для получения всех записей
    // - findById() - для поиска по ID
    // - deleteById() - для удаления по ID
    // - и многие другие
}
