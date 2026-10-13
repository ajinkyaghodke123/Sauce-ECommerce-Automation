package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @Then("I should see order confirmation message")
    public void i_should_see_order_confirmation_message() {
        overview = new CheckoutOverviewPage(Hooks.driver);
        overview.finishOrder();
        complete = new CheckoutCompletePage(Hooks.driver);
        Assert.assertEquals("Thank you for your order!", complete.getConfirmationText());
    }
}
