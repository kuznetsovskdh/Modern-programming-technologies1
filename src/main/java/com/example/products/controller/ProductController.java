package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Главная страница
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("product", new Product());
        return "products";
    }

    // новый товар
    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("product") Product product,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("products", productService.getAllProducts());
            return "products";
        }
        productService.saveProduct(product);
        return "redirect:/products";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Товар не найден"));
        model.addAttribute("product", product);
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("editMode", true);
        return "products";
    }


    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id,
                                @Valid @ModelAttribute("product") Product product,
                                BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            model.addAttribute("products", productService.getAllProducts());
            model.addAttribute("editMode", true);
            return "products";
        }
        productService.updateProduct(id, product);
        return "redirect:/products";
    }


    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
