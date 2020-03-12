package com.rcm.cucumber.page.webpages;

import com.rcm.cucumber.page.structure.PageObject;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;


@Component @Getter
public class GooglePage extends PageObject {

    public GooglePage (WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@name='q']")
    private WebElement googleSearchBar;
}
