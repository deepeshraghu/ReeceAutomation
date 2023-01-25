package Steps;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

   public static WebDriver driver;

    @Before
    public void beforescanario(Scenario scenario)
    {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        extent.createTest(scenario.getName().replaceAll(" ","_"));
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("user-agent=\"Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)\"");
//        chromeOptions.addArguments("general.useragent.override",userAgent);
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--enable-javascript");
        driver = new ChromeDriver(chromeOptions);
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After(order=1) //Cucumber hook - runs for each scenario
    public static void quitDriver() {
        driver.quit();
    }
    @After(order = 2) // Cucumber After Hook with order 1
    public void takeScreenShotOnFailedScenario(Scenario scenario) {

        System.out.println("Taking screenshot from Cucumber After hook with order=2 if the scenario fails");
        if ((scenario.isFailed())) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

}