package com.rcm.cucumber.database.base.service;

import com.rcm.cucumber.database.base.iservice.IClientService;
import com.rcm.cucumber.database.base.models.Client;
import com.rcm.cucumber.database.base.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService implements IClientService {
    @Autowired
    ClientsRepository clientsRepo;

    @Override
    @Transactional(readOnly = true)
    public Client getClientById(Long id) {
        return clientsRepo.findById(id).orElse(null);
    }
}
