package com.rcm.cucumber.database.base.repositories;

import com.rcm.cucumber.database.base.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Client,Long> {

}
