package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
    private final WebDriver driver;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /** Adds the named product, e.g. "Sauce Labs Backpack" -> id add-to-cart-sauce-labs-backpack. */
    public void addToCart(String product) {
        String id = "add-to-cart-" + product.trim().toLowerCase().replace(' ', '-');
        driver.findElement(By.id(id)).click();
    }

    public void goToCart() {
        cartIcon.click();
    }
}
