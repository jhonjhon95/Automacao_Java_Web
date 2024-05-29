package pageElements;

import browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtractPage {
    private final WebDriver driver;
    private final Waits waits;

    public ExtractPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(this.driver);
    }

    public WebElement getExtractBalance() {
        return waits.visibilityOfElement(By.id("textBalanceAvailable"));
    }
}
