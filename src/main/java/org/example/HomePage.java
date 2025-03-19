package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By searchBox = By.id("twotabsearchtextbox");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void searchProduct(String productName) {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchField.clear();
        searchField.sendKeys(productName);
        searchField.submit();
    }
}
