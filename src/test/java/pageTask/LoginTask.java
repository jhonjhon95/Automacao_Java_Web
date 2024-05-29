package pageTask;

import browser.Waits;
import dataFactory.UserFactory;
import org.openqa.selenium.WebDriver;
import pageElements.LoginPage;
import validations.LoginValidation;

import static reports.Relatory.createTest;

public class LoginTask {

    private final WebDriver driver;
    private final Waits waits;
    private final LoginPage loginPage;
    private final LoginValidation loginValidation;

    public LoginTask(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(this.driver);
        this.loginPage = new LoginPage(this.driver);
        this.loginValidation = new LoginValidation(this.driver);
    }

    public void login(UserFactory user) {
        createTest("Login " + user.getName(), "Deve logar na conta do(a) " + user.getName());
        loginPage.getEmail().sendKeys(user.getEmail());
        loginPage.getPassword().sendKeys(user.getPassword());
        loginPage.getAccessButton().click();
        waits.fixedWaits(2000);
        loginValidation.loginSuccessValidation(user);
    }

    public void clickButtonRegister() {
        waits.loadElement(loginPage.getRegisterButton());
        loginPage.getRegisterButton().click();
    }
}
