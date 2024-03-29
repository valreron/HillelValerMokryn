package lessons.homeworkOfLesson18;

import io.github.bonigarcia.wdm.WebDriverManager;
import lessons.listeners.CustomerExtentReportListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.MainPage;
import utils.DriverHolder;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Listeners(CustomerExtentReportListener.class)
public class BaseTest {
    static {
        System.setProperty("extent.reporter.html.start", "true");
        System.setProperty("extent.reporter.html.out", "target/extentReport/ExtentHTML.html");
    }

    protected WebDriver driver;
    protected static String fileName = "LambdaTest.txt";
    protected static String filePath = "target/downloads/";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", new File(filePath).getAbsolutePath());
        options.setExperimentalOption("prefs", prefs);

        this.driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        DriverHolder.setDriver(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public MainPage openMainPage() {
        driver.get("https://the-internet.herokuapp.com/");
        return new MainPage(driver);
    }
}
