package com.rcm.cucumber.database.base.iservice;
import com.rcm.cucumber.database.base.models.Client;

public interface IClientService {
    Client getClientById(Long id);
}
