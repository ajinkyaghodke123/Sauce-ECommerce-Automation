package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartBtn;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    public void addToCart(String product) {
        addToCartBtn.click(); // You can enhance this for dynamic product selection
    }

    public void goToCart() {
        cartIcon.click();
    }
}
