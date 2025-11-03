package com.example.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class, args);
        System.out.println("=================================================");
        System.out.println("🚀 Приложение запущено!");
        System.out.println("📱 Откройте браузер: http://localhost:8080/products");
        System.out.println("🗄️ H2 консоль: http://localhost:8080/h2-console");
        System.out.println("=================================================");
    }
}
