package org.example;//package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Cart {
    private WebDriver driver;
    private WebDriverWait wait;

    private By cartIcon = By.id("nav-cart"); // Amazon cart icon
    private By deleteButtons = By.cssSelector("input[value='Delete']");
    private By proceedToCheckout = By.name("proceedToRetailCheckout");

    public Cart(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void goToCartPage() {
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartButton.click();
    }

    public void removeFirstItem() {
        goToCartPage();
        List<WebElement> buttons = driver.findElements(deleteButtons);
        if (!buttons.isEmpty()) {
            buttons.getFirst().click();
        }
    }

    public void goToProceedToBuy(){
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
        cartButton.click();
    }

}

