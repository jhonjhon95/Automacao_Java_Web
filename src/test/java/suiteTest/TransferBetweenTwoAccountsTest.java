package suiteTest;

import browser.TestBase;
import data.UserData;
import dataFactory.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageTask.ExtractTask;
import pageTask.LoginTask;
import pageTask.RegisterTask;
import pageTask.TransferTask;

@Tag("REGRESSAO")
public class TransferBetweenTwoAccountsTest extends TestBase {

    private final WebDriver driver = getDriver();
    private final RegisterTask registerTask = new RegisterTask(driver);
    private final LoginTask loginTask = new LoginTask(driver);
    private final TransferTask transferTask = new TransferTask(driver);
    private final ExtractTask extractTask = new ExtractTask(driver);

    private final UserFactory jhon = UserData.createJhonUser();
    private final UserFactory joao = UserData.createJoaoUser();

    @DisplayName("Deve realizar a transferência entre contas com sucesso")
    @Test
    public void transferBetweenTwoAccounts() {
        registerUsers();
        loginTask.login(joao);
        performTransfer();
        verifyExtract();
    }

    private void registerUsers() {
        registerTask.register(jhon, true);
        registerTask.register(joao, true);
    }

    private void performTransfer() {
        transferTask.transfer(jhon, 200, "Parabéns!");
    }

    private void verifyExtract() {
        loginTask.login(jhon);
        extractTask.verifyExtract();
    }
}
