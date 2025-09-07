package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    // 🔒 Locators
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By successMsg = By.className("complete-header");   // Thank you for your order!
    private By dispatchMsg = By.className("complete-text");    // Your order has been dispatched...
    private By ponyImage = By.className("pony_express");       // Pony image
    private By errorMsg = By.cssSelector("h3[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // 🌍 Actions
    public void enterDetails(String f, String l, String p) {
        driver.findElement(firstName).sendKeys(f);
        driver.findElement(lastName).sendKeys(l);
        driver.findElement(postalCode).sendKeys(p);
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public void clickFinish() {
        driver.findElement(finishBtn).click();
    }

    // ✅ Validations
    public String getSuccessMsg() {
        return driver.findElement(successMsg).getText();
    }

    public String getDispatchMsg() {
        return driver.findElement(dispatchMsg).getText();
    }

    public boolean isPonyImageDisplayed() {
        return driver.findElement(ponyImage).isDisplayed();
    }

    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }
}
