package validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageElements.AccountPage;
import reports.Relatory;
import reports.Screenshot;

import static reports.Relatory.testFail;
import static reports.Relatory.testPass;

public class AccountValidation {
    private final WebDriver driver;
    private final AccountPage accountPage;

    public AccountValidation(WebDriver driver) {
        this.driver = driver;
        this.accountPage = new AccountPage(this.driver);
    }

    public void accountBalanceValidation() {
        try {
            String expectedBalance = "Saldo em conta R$ 1.200,00";
            String actualBalance = accountPage.getBalance().getText();
            Assertions.assertEquals(expectedBalance, actualBalance);
            Relatory.testPass("Houve sucesso no recebimento do saldo.",
                    Screenshot.captureScreenshot(driver, "saldoNaConta-Sucesso"));
        } catch (AssertionError e) {
            Relatory.testFail("Houve uma falha no recebimento do saldo.",
                    Screenshot.captureScreenshot(driver, "saldoNaConta-Falha"));
            throw e;
        }
    }
}
