package com.rcm.cucumber.database.base.service;

import com.rcm.cucumber.database.base.iservice.IProductService;
import com.rcm.cucumber.database.base.models.Product;
import com.rcm.cucumber.database.base.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepo;

    @Override
    @Transactional(readOnly = true)
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProductByName(String name) {
        return productRepo.findByName(name);
    }
}
