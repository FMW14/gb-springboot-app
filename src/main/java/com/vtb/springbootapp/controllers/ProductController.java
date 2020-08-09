package com.vtb.springbootapp.controllers;

import com.vtb.springbootapp.domain.Product;
import com.vtb.springbootapp.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("frontProducts", productService.getAll());
        return "products";
    }

    @GetMapping("/remove/{id}")
    public String removeProduct(@PathVariable Long id) {
        productService.removeById(id);
        return "redirect:/products/all";
    }

    @GetMapping("/edit/{id}")
    public String editProductById(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "product-edit-page";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products/all";
    }

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products/all";
    }
}
