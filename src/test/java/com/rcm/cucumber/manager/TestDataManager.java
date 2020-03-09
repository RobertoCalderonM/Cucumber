package com.rcm.cucumber.manager;

import com.rcm.cucumber.entity.User;
import io.cucumber.java.Scenario;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TestDataManager {
    private User user;
    private Scenario scenario;
}
