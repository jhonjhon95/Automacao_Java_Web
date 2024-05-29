package browser;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.commons.util.PackageUtils;
import org.openqa.selenium.WebDriver;

import static reports.Relatory.finishRelatory;
import static reports.Relatory.getRelatory;

public class TestBase {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        driver = DriverFactory.getOrCreateDriver(Browser.CHROME);
        return driver;
    }


    @BeforeEach
    public void setupDriver() {
        getRelatory();
        driver.get("https://bugbank.netlify.app/#");
    }

    @AfterEach
    public void teardown() {
        finishRelatory();
        if (driver != null) {
            DriverFactory.quitDriver();
        }
    }
}
