package validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageElements.ExtractPage;
import reports.Relatory;
import reports.Screenshot;

import static reports.Relatory.testFail;
import static reports.Relatory.testPass;

public class ExtractValidation {

    private final WebDriver driver;
    private final ExtractPage extractPage;

    public ExtractValidation(WebDriver driver) {
        this.driver = driver;
        this.extractPage = new ExtractPage(this.driver);
    }

    public void deductedBalanceValidation() {
        try {
            String expectedBalance = "R$ 800,00";
            String actualBalance = extractPage.getExtractBalance().getText();
            Assertions.assertEquals(expectedBalance, actualBalance);
            Relatory.testPass("Houve sucesso na realização do débito.",
                    Screenshot.captureScreenshot(driver, "debitoRealizado-Sucesso"));
        } catch (AssertionError e) {
            Relatory.testFail("Houve uma falha na realização do débito.",
                    Screenshot.captureScreenshot(driver, "debitoRealizado-Falha"));
            throw e;
        }
    }

    public void addedBalanceValidation() {
        try {
            String expectedBalance = "R$ 1.200,00";
            String actualBalance = extractPage.getExtractBalance().getText();
            Assertions.assertEquals(expectedBalance, actualBalance);
            Relatory.testPass("Houve sucesso no recebimento dos créditos.",
                    Screenshot.captureScreenshot(driver, "creditoRecebido-Sucesso"));
        } catch (AssertionError e) {
            Relatory.testFail("Houve uma falha no recebimento do crédito.",
                    Screenshot.captureScreenshot(driver, "creditoRecebido-Falha"));
            throw e;
        }
    }
}
