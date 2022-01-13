package cucumberdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "billing_first_name") private WebElement firstNameField;
    @FindBy(id = "billing_last_name") private WebElement lastNameField;
    @FindBy(id = "billing_address_1") private WebElement billingAddressOneField;
    @FindBy(id = "billing_city") private WebElement billingCityField;
    @FindBy(id = "billing_state") private WebElement billingStateDropdown;
    @FindBy(id = "select2-billing_state-container") private WebElement alternateBillingState;
    @FindBy(id = "billing_postcode") private WebElement zipcodeField;
    @FindBy(id = "billing_email") private WebElement emailField;
    @FindBy(id = "place_order") private WebElement placeOrderButton;
    @FindBy(css = ".woocommerce-notice") private WebElement noticeText;
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    public void enterFirstName(String firstName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(firstNameField));
        e.clear();
        e.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(lastNameField));
        e.clear();
        e.sendKeys(lastName);
    }

    public void enterBillingAddress(String billingAddress) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressOneField));
        e.clear();
        e.sendKeys(billingAddress);
    }

    public void enterBillingCity(String billingCity) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityField));
        e.clear();
        e.sendKeys(billingCity);
    }

    public void selectBillingState(String billingState) {
        wait.until(ExpectedConditions.elementToBeClickable(alternateBillingState)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='" + billingState +"']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", e);
        e.click();

//        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropdown)));
//        select.selectByVisibleText(billingState);
    }

    public void enterBillingZip(String zipcode) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(zipcodeField));
        e.clear();
        e.sendKeys(zipcode);
    }

    public void enterBillingEmail(String email) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(emailField));
        e.clear();
        e.sendKeys(email);
    }

    public void placeOrder() {
        waitForOverlaysToDisappear(overlay);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    public String getNoticeText() {
        return wait.until(ExpectedConditions.visibilityOf(noticeText)).getText();
    }
}
