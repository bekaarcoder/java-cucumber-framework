package cucumberdemo.steps;

import cucumberdemo.context.TestContext;
import cucumberdemo.pages.CartPage;
import cucumberdemo.pages.PageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartStepDefinitions {
    private CartPage cartPage;

    public CartStepDefinitions(TestContext context) {
        cartPage = PageFactory.getCartPage(context.driver);
    }

    @Then("I should see {int} {string} in the cart")
    public void iShouldSeeInTheCart(int quantity, String productName) {
        Assert.assertEquals(productName, cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }

    @And("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
        cartPage.proceedToCheckout();
    }
}
