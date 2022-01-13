package cucumberdemo.pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    private static StorePage storePage;
    private static CheckoutPage checkoutPage;
    private static CartPage cartPage;

    public static StorePage getStorePage(WebDriver driver) {
        return storePage == null ? new StorePage(driver) : storePage;
    }

    public static CheckoutPage getCheckoutPage(WebDriver driver) {
        return checkoutPage == null ? new CheckoutPage(driver) : checkoutPage;
    }

    public static CartPage getCartPage(WebDriver driver) {
        return cartPage == null ? new CartPage(driver) : cartPage;
    }
}
