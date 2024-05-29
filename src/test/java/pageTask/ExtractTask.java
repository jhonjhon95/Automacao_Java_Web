package pageTask;

import browser.Waits;
import org.openqa.selenium.WebDriver;
import pageElements.ExtractPage;
import validations.AccountValidation;
import validations.ExtractValidation;

import static reports.Relatory.createTest;

public class ExtractTask {
    private final WebDriver driver;
    private final Waits waits;
    private final AccountTask accountTask;
    private final AccountValidation accountValidation;
    private final ExtractValidation extractValidation;
    private final ExtractPage extractPage;

    public ExtractTask(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(this.driver);
        this.accountTask = new AccountTask(this.driver);
        this.extractPage = new ExtractPage(this.driver);
        this.accountValidation = new AccountValidation(this.driver);
        this.extractValidation = new ExtractValidation(this.driver);
    }

    public void verifyExtract() {
        createTest("Validar saldo na conta", "Deve validar o saldo na conta");
        accountValidation.accountBalanceValidation();
        accountTask.clickExtractButton();
        extractValidation.addedBalanceValidation();
        accountTask.clickExitButton();
    }
}
