package cucumberdemo.steps;

import cucumberdemo.constants.Constants;
import cucumberdemo.constants.EndPoint;
import cucumberdemo.context.TestContext;
import cucumberdemo.domainObjects.BillingDetails;
import cucumberdemo.factory.DriverFactory;
import cucumberdemo.pages.CartPage;
import cucumberdemo.pages.CheckoutPage;
import cucumberdemo.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import java.util.List;
import java.util.Map;

public class MyStepDefinition {
    private WebDriver driver;
    private BillingDetails billingDetails;

    public MyStepDefinition(TestContext context) {
        driver = context.driver;
    }

    @Given("I am a guest customer")
    public void iAmAGuestCustomer() {
//        driver = DriverFactory.getDriver();
        new StorePage(driver).load(Constants.STORE);
    }


}
