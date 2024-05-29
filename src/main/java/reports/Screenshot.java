package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static utils.DateFormater.formattedDate;
import static utils.DateFormater.formattedDateAndHour;

public class Screenshot {

    public static final String path = System.getProperty("user.dir");


    public static Media captureScreenshot(WebDriver driver, String name) {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            String dateAndHour = formattedDateAndHour();
            String date = formattedDate();


            String destinationFile = path + File.separator + "reports" + File.separator + "screenshots_" + date + File.separator + name + "_" + dateAndHour + ".png";

            File targetFile = new File(destinationFile);

            FileUtils.copyFile(SrcFile, targetFile);

            System.out.println("Screenshot captured: " + destinationFile);
            return MediaEntityBuilder.createScreenCaptureFromPath(destinationFile).build();
        } catch (Exception e) {
            System.out.println("Error while capturing screenshot: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
