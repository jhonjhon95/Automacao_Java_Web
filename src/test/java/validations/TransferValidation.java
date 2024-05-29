package validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageElements.TransferPage;
import reports.Relatory;
import reports.Screenshot;

import static reports.Relatory.testFail;
import static reports.Relatory.testPass;

public class TransferValidation {

    private final WebDriver driver;
    private final TransferPage transferPage;

    public TransferValidation(WebDriver driver) {
        this.driver = driver;
        this.transferPage = new TransferPage(this.driver);
    }

    public void transferSuccessValidation() {
        try {
            String expectedText = "Transferencia realizada com sucesso";
            String actualText = transferPage.getTextTransferPage().getText();
            Assertions.assertEquals(expectedText, actualText);
            testPass("Houve sucesso na realização da transferencia.",
                    Screenshot.captureScreenshot(driver, "transferenciaRealizada-Sucesso"));
        } catch (AssertionError e) {
            testFail("Houve uma falha na realização da transferência.",
                    Screenshot.captureScreenshot(driver, "transferenciaRealizada-Falha"));
            throw e;
        }
    }
}
