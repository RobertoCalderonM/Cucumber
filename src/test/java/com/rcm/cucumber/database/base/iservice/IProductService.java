package com.rcm.cucumber.database.base.iservice;

import com.rcm.cucumber.database.base.models.Product;

public interface IProductService {
    Product getProductById(Long id);
    Product getProductByName(String name);
}
