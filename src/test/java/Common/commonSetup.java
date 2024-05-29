package Common;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;



public class commonSetup {

    public static WebDriver driver = null;
    private static final Logger logger = LogManager.getLogger(commonSetup.class);

    @BeforeMethod
    public void initialize() {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("src/test/java/Configuration/configuration.properties"));

            String urlWeb = properties.getProperty("url");
            String browser = properties.getProperty("browser");


            ChromeOptions options = new ChromeOptions();
            options.addArguments("remote-allow-origins=*");

            if (browser.equals("chrome")) {
                driver = new ChromeDriver(options);
            } else {
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            }

            // To maximize browser
            driver.manage().window().maximize();

            // Site
            logger.info("URL: {}", urlWeb);

            // To open site
            driver.get(urlWeb);

        } catch (IOException e) {
            logger.error("FAILED:LOADING PROPERTIES FILES", e);
        } catch (Exception e) {
            logger.error("FAILED:INITIALIZING BROWSER", e);
        }
    }

    @AfterMethod
    // Test cleanup
    public void TeardownTest() {
        // Close
        logger.info("CLOSING DRIVER");
        if (driver != null) {
            driver.quit();
        }
    }
}
