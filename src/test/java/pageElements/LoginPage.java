package pageElements;

import browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;
    private final Waits waits;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(this.driver);
    }

    public WebElement getEmail() {
        return waits.visibilityOfElement(By.name("email"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.name("password"));
    }

    public WebElement getAccessButton() {
        return driver.findElement(By.xpath("//button[contains(text(),'Acessar')]"));
    }

    public WebElement getRegisterButton() {
        return driver.findElement(By.xpath("//button[text()='Registrar']"));
    }
}
