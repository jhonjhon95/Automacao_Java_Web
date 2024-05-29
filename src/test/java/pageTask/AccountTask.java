package pageTask;

import browser.Waits;
import org.openqa.selenium.WebDriver;
import pageElements.AccountPage;

public class AccountTask {
    private final WebDriver driver;
    private final Waits waits;
    private final AccountPage accountPage;

    public AccountTask(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(this.driver);
        this.accountPage = new AccountPage(this.driver);
    }

    public void clickExitButton() {
        waits.loadElement(accountPage.getExitButton());
        accountPage.getExitButton().click();
    }

    public void clickTransferButton() {
        waits.loadElement(accountPage.getTransferButton());
        accountPage.getTransferButton().click();
    }

    public void clickExtractButton() {
        waits.loadElement(accountPage.getExtractButton());
        accountPage.getExtractButton().click();
    }
}
