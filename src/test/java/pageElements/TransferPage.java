package pageElements;

import browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferPage {
    private final WebDriver driver;
    private final Waits waits;

    public TransferPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(this.driver);
    }

    public WebElement getDigit() {
        return driver.findElement(By.name("digit"));
    }

    public WebElement getTransferValue() {
        return driver.findElement(By.name("transferValue"));
    }

    public WebElement getDescription() {
        return driver.findElement(By.name("description"));
    }

    public WebElement getAccountNumber() {
        return waits.visibilityOfElement(By.name("accountNumber"));
    }

    public WebElement getTextTransferPage() {
        return waits.visibilityOfElement(By.id("modalText"));
    }

    public WebElement getButtonTransferNow() {
        return driver.findElement(By.xpath("//button[text()='Transferir agora']"));
    }

    public WebElement getButtonClose() {
        return driver.findElement(By.id("btnCloseModal"));
    }

    public WebElement getButtonBack() {
        return driver.findElement(By.id("btnBack"));
    }
}
