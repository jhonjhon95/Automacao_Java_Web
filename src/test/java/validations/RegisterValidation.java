package validations;

import dataFactory.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageElements.RegisterPage;
import reports.Relatory;
import reports.Screenshot;

import static reports.Relatory.testFail;
import static reports.Relatory.testPass;

public class RegisterValidation {

    private final WebDriver driver;
    private final RegisterPage registerPage;

    public RegisterValidation(WebDriver driver) {
        this.driver = driver;
        this.registerPage = new RegisterPage(this.driver);
    }

    public void registerSuccessValidation(UserFactory user) {
        try {
            String expectedAccount = "A conta " + user.getAccountNumber() + "-" + user.getId() + " foi criada com sucesso";
            String actualRegisterText = registerPage.getModalAccountText().getText();
            Assertions.assertEquals(expectedAccount, actualRegisterText);
            testPass("Houve sucesso na realização do cadastro.",
                    Screenshot.captureScreenshot(driver, "cadastroRealizado-Sucesso"));
        } catch (AssertionError e) {
            testFail("Houve uma falha na realização do cadastro.",
                    Screenshot.captureScreenshot(driver, "cadastroRealizado-Falha"));
            throw e;
        }
    }
}
