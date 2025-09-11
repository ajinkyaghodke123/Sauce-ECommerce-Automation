package stepdefs;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pageobjects.*;

public class OrderSteps {

    LoginPage login;
    InventoryPage inventory;
    CartPage cart;
    CheckoutInfoPage info;
    CheckoutOverviewPage overview;
    CheckoutCompletePage complete;

    @Given("I open SauceDemo")
    public void i_open_saucedemo() {
        login = new LoginPage(Hooks.driver);
        login.open();
    }

    @When("I login with username {string} and password {string}")
    public void i_login(String user, String pass) {
        login.login(user, pass);
        inventory = new InventoryPage(Hooks.driver);
    }

    @When("I add product {string} to the cart")
    public void i_add_product_to_cart(String product) {
        inventory.addToCart(product);
        inventory.goToCart();
        cart = new CartPage(Hooks.driver);
    }

    @When("I proceed to checkout with first name {string} last name {string} postal code {string}")
    public void i_proceed_to_checkout(String first, String last, String postal) {
        cart.clickCheckout();
        info = new CheckoutInfoPage(Hooks.driver);
        info.enterInfo(first, last, postal);
    }
}
