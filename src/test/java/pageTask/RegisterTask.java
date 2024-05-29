package pageTask;

import browser.Waits;
import dataFactory.UserFactory;
import org.openqa.selenium.WebDriver;
import pageElements.RegisterPage;
import validations.RegisterValidation;

import static reports.Relatory.createTest;

public class RegisterTask {

    private final WebDriver driver;
    private final Waits waits;

    private final RegisterPage registerPage;
    private final RegisterValidation registerValidation;
    private final LoginTask loginTask;

    public RegisterTask(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(this.driver);
        this.registerPage = new RegisterPage(this.driver);
        this.registerValidation = new RegisterValidation(this.driver);
        this.loginTask = new LoginTask(this.driver);
    }

    public void register(UserFactory user, boolean balance) {
        createTest("Cadastro " + user.getName(), "Deve cadastrar o(a) usuário(a) " + user.getName());
        loginTask.clickButtonRegister();
        registerPage.getEmail().sendKeys(user.getEmail());
        registerPage.getName().sendKeys(user.getName());
        registerPage.getPassword().sendKeys(user.getPassword());
        registerPage.getPasswordConfirmation().sendKeys(user.getConfirmPassword());
        setBalance(balance);
        waits.loadElement(registerPage.getRegisterButton());
        registerPage.getRegisterButton().click();
        extractAccountNumber(user);
        registerValidation.registerSuccessValidation(user);
        waits.loadElement(registerPage.getCloseButton());
        registerPage.getCloseButton().click();
        refreshPage();
    }

    public void extractAccountNumber(UserFactory user) {
        String registerText = registerPage.getModalAccountText().getText();
        String[] removeSpaces = registerText.split(" ");
        String[] removeHyphen = removeSpaces[2].split("-");

        String number = removeHyphen[0];
        String id = removeHyphen[1];

        user.setAccountNumber(number);
        user.setId(id);
    }

    public void setBalance(boolean hasBalance) {
        if (hasBalance) {
            waits.fixedWaits(2000);
            registerPage.getToggle().click();
            waits.fixedWaits(2000);
        }
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}
