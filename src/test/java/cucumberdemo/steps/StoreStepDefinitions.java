package cucumberdemo.steps;

import cucumberdemo.constants.EndPoint;
import cucumberdemo.context.TestContext;
import cucumberdemo.pages.PageFactory;
import cucumberdemo.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StoreStepDefinitions {
    private StorePage storePage;

    public StoreStepDefinitions(TestContext context) {
        storePage = PageFactory.getStorePage(context.driver);
    }

    @Given("I am on store page")
    public void iAmOnStorePage() {
//        driver = DriverFactory.getDriver();
        storePage.load(EndPoint.STORE.url);
    }

    @When("I add a {string} to the cart")
    public void iAddAToTheCart(String productName) throws InterruptedException {
        storePage.addToCart(productName);
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() throws InterruptedException {
        storePage.addToCart("Blue Shoes");
    }
}
