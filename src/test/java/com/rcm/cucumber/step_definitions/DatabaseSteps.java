package com.rcm.cucumber.step_definitions;

import com.rcm.cucumber.database.base.models.Client;
import com.rcm.cucumber.database.base.models.Product;
import com.rcm.cucumber.database.base.service.ClientService;
import com.rcm.cucumber.database.base.service.ProductService;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class DatabaseSteps {

    @Autowired
    ClientService clientService;

    @Autowired
    ProductService productService;

    @Then("A Client is found with id {long} in db")
    public void clientWithIdSaysDb(Long id){
    Client client=clientService.getClientById(id);
    log.info(String.format("%s %s says hi!",client.getFirstName(),client.getLastName()));
    }

    @Then("A Product is found with id {long} in db")
    public void productWithIdSaysDb(Long id){
        Product product=productService.getProductById(id);
        log.info(String.format("%s with price %.2f says hi!",product.getName(),product.getPrice()));
    }

    @Then("A Product is found with name {string} in db")
    public void productWithNameSaysDb(String name){
        Product product=productService.getProductByName(name);
        log.info(String.format("%s with price %.2f says hi!",product.getName(),product.getPrice()));
    }
}
