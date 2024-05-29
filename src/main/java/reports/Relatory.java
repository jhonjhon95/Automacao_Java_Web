package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.model.Media;


import static utils.DateFormater.formattedDate;

public class Relatory {

    public static ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static final String path = System.getProperty("user.dir");

    public static void relatoryConfiguration() {
        String date = formattedDate();
        spark = new ExtentSparkReporter(path + "/reports/relatorio_" + date + "/RelatorioBugBank.html");
        spark.config().setReportName("Relatório Automação BugBank");
        spark.config().setDocumentTitle("Relatório Automação BugBank");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        spark.config().setCss( ".search-icon { color: white;} .ico {color: purple} .logo-bugbank {margin-top: 5px;} .vheader {background: linear-gradient(to right bottom, rgb(214, 42, 146), rgb(164, 34, 227));} .badge-primary { color: purple; background-color: #ffffff;} ");
        spark.config().setJs("$('.nav-logo').html('<img src=\"https://i.imgur.com/VWiBjYr.png\" class=\"logo-bugbank\" style=\"margin-left: 250px; width: 100px; height: auto;\"/>');");

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public synchronized static ExtentReports getRelatory(){
        if (extent == null){
            relatoryConfiguration();
        }
        return extent;
    }

    public static ExtentTest createTest(String name, String description){
        test = extent.createTest(name, description);
        return test;
    }

    public static void testPass ( String description , Media capture){
        test.pass(description, capture);
    }

    public static void testFail ( String description , Media capture){
        test.fail(description, capture);
    }

    public static void finishRelatory(){
        extent.flush();
    }


}
