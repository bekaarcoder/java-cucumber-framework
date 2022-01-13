package cucumberdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "td.product-name a") private WebElement productNameField;
    @FindBy(css = "input[title='Qty']") private WebElement quantityField;
    @FindBy(css = ".checkout-button") private WebElement checkoutButton;

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOf(productNameField)).getText();
    }

    public int getProductQuantity() {
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(quantityField)).getAttribute("value"));
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}
