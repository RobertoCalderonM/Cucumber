package com.rcm.cucumber.step_definitions;

import com.rcm.cucumber.api.models.Client;
import com.rcm.cucumber.api.service.ClientAPI;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ApiSteps {
    @Autowired
    ClientAPI clientAPI;

    @Then("A Client is found with id {long} in ClientsAPI")
    public void clientWithIdSaysClientApi(Long id){
        Client response=clientAPI.getClientById(id);
        log.info(String.format("Clients API Response: %s",response));
    }
}
