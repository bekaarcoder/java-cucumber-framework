package cucumberdemo.steps;

import cucumberdemo.context.TestContext;
import cucumberdemo.domainObjects.BillingDetails;
import cucumberdemo.pages.CartPage;
import cucumberdemo.pages.CheckoutPage;
import cucumberdemo.pages.PageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutStepDefinitions {
    private final TestContext context;
    private CheckoutPage checkout;

    public CheckoutStepDefinitions(TestContext context) {
        this.context = context;
        checkout = PageFactory.getCheckoutPage(context.driver);
    }

    @And("My billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }


    @When("I provide billing details")
    public void iProvideBillingDetails() {
        checkout.enterFirstName(context.billingDetails.getBillingFirstName());
        checkout.enterLastName(context.billingDetails.getBillingLastName());
        checkout.enterBillingAddress(context.billingDetails.getBillingAddress());
        checkout.enterBillingCity(context.billingDetails.getBillingCity());
        checkout.selectBillingState(context.billingDetails.getBillingState());
        checkout.enterBillingZip(context.billingDetails.getBillingZip());
        checkout.enterBillingEmail(context.billingDetails.getBillingEmail());
    }

    @And("I place an order")
    public void iPlaceAnOrder() throws InterruptedException {
        checkout.placeOrder();
    }

    @Then("Order is placed successfully")
    public void orderIsPlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.", checkout.getNoticeText());
    }
}
