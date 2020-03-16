package com.rcm.cucumber.database.base.repositories;

import com.rcm.cucumber.database.base.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findByName(String name);

}
