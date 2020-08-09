package com.vtb.springbootapp.services;


import com.vtb.springbootapp.domain.Product;
import com.vtb.springbootapp.exceptions.ResourceNotFoundException;
import com.vtb.springbootapp.repos.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepo productRepo;

    public void save(Product product) {
        productRepo.save(product);
    }

    public Product getById(Long id) {
        return productRepo.findById(id).orElseThrow(() ->new ResourceNotFoundException());
    }

    public void removeById(Long id){
        productRepo.deleteById(id);
    }

    public List<Product> getAll() {
        return productRepo.findAll();
    }
}
