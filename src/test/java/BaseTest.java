import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BaseTest extends Base {

    @Test(priority = 1)
    public void searchAndAddFourthItemToCart() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.searchProduct("iphone13pro");

        SearchPage searchResultsPage = new SearchPage(driver, wait);
        searchResultsPage.selectProduct(3);

        ProductPage productPage = new ProductPage(driver, wait);
        productPage.addToCart();

        WebElement searchPageAssert = driver.findElement(By.xpath("//h2[normalize-space()='Results']"));
        Assert.assertTrue(searchPageAssert.isDisplayed(),"Results");
    }

    @Test(priority = 2, enabled = true)
    public void searchAndAddFirstItemToCart() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.searchProduct("boat rockerz 450 pro headphones");

        SearchPage searchResultsPage = new SearchPage(driver, wait);
        searchResultsPage.selectProduct(0);

        ProductPage productPage = new ProductPage(driver, wait);
        productPage.addToCart();

        WebElement searchPageAssert = driver.findElement(By.xpath("//h2[normalize-space()='Results']"));
        Assert.assertTrue(searchPageAssert.isDisplayed(),"Results");

    }

    @Test(priority = 3)
    public void removeItemAndProceedToCheckout() {

        Cart cartPage = new Cart(driver, wait);
        cartPage.goToCartPage();
        cartPage.removeFirstItem();
        cartPage.goToProceedToBuy();

        WebElement cartPageHeader = driver.findElement(By.xpath("//h2[@id='sc-active-items-header']"));
        Assert.assertTrue(cartPageHeader.isDisplayed(),"Shopping Cart");
    }

}
