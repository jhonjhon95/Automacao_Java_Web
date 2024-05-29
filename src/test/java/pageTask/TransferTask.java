package pageTask;

import browser.Waits;
import dataFactory.UserFactory;
import org.openqa.selenium.WebDriver;
import pageElements.TransferPage;
import validations.ExtractValidation;
import validations.TransferValidation;

import static reports.Relatory.createTest;

public class TransferTask {

    private final WebDriver driver;
    private final Waits waits;
    private final TransferPage transferPage;
    private final AccountTask accountTask;
    private final TransferValidation transferValidation;
    private final ExtractValidation extractValidation;

    public TransferTask(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(this.driver);
        this.transferPage = new TransferPage(this.driver);
        this.accountTask = new AccountTask(this.driver);
        this.transferValidation = new TransferValidation(this.driver);
        this.extractValidation = new ExtractValidation(this.driver);
    }

    public void transfer(UserFactory user, int value, String description) {
        createTest("Transfêrencia entre contas", "Deve transferir o saldo de R$" + value + " para o(a) " + user.getName());
        accountTask.clickTransferButton();
        transferPage.getAccountNumber().sendKeys(user.getAccountNumber());
        transferPage.getDigit().sendKeys(user.getId());
        transferPage.getTransferValue().sendKeys(String.valueOf(value));
        transferPage.getDescription().sendKeys(description);
        transferPage.getButtonTransferNow().click();
        transferValidation.transferSuccessValidation();
        waits.loadElement(transferPage.getButtonClose());
        transferPage.getButtonClose().click();
        waits.loadElement(transferPage.getButtonBack());
        transferPage.getButtonBack().click();
        accountTask.clickExtractButton();
        extractValidation.deductedBalanceValidation();
        accountTask.clickExitButton();
    }
}
