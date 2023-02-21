import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    public static FluentWait fluentWait = null;
    public static Actions action = null;

    @BeforeSuite
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL){
        url = baseURL;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);

        driver.get(url);
    }

    @AfterMethod
    static void closeBrowser(){
        driver.quit();
    }

    @DataProvider(name = "incorrectLoginProviders")
    public static Object[][] getIncorrectLoginProviders() {

        return new Object[][]{
                {"invalid@email.com", "invalidPass"},
                {"demo@mailcom", "invalid"},
                {"", ""},
                {"bademail@email", "!@$lklhkla"}
        };
    }
}
