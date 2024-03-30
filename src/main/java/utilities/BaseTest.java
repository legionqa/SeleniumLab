package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.legion.pages.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@ExtendWith(CustomTestWatcher.class)
public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static PageGenerator page;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().clearDriverCache();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        page = new PageGenerator(driver);
        CustomTestWatcher watcher = new CustomTestWatcher();
        watcher.setDriver(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
