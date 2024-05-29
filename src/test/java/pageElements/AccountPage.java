package pageElements;

import browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
    private final WebDriver driver;
    private final Waits waits;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(this.driver);
    }

    public WebElement getTransferButton() {
        return driver.findElement(By.id("btn-TRANSFERÊNCIA"));
    }

    public WebElement getExtractButton() {
        return driver.findElement(By.id("btn-EXTRATO"));
    }

    public WebElement getExitButton() {
        return driver.findElement(By.id("btnExit"));
    }

    public WebElement getBalance() {
        return waits.visibilityOfElement(By.id("textBalance"));
    }

    public WebElement getInicialText() {
        return waits.visibilityOfElement(By.id("textName"));
    }
}
