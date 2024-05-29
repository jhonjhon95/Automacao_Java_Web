package validations;

import dataFactory.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageElements.AccountPage;
import reports.Relatory;
import reports.Screenshot;

import static reports.Relatory.testFail;
import static reports.Relatory.testPass;

public class LoginValidation {

    private final WebDriver driver;
    private final AccountPage accountPage;

    public LoginValidation(WebDriver driver) {
        this.driver = driver;
        this.accountPage = new AccountPage(this.driver);
    }

    public void loginSuccessValidation(UserFactory user) {
        try {
            String expectedGreeting = "Olá " + user.getName() + ",";
            String actualGreeting = accountPage.getInicialText().getText();
            Assertions.assertEquals(expectedGreeting, actualGreeting);
            testPass("Houve sucesso na realização do login.",
                    Screenshot.captureScreenshot(driver, "loginRealizado-Sucesso"));
        } catch (AssertionError e) {
            testFail("Houve uma falha na realização do login.",
                    Screenshot.captureScreenshot(driver, "loginRealizado-Falha"));
            throw e;
        }
    }
}
