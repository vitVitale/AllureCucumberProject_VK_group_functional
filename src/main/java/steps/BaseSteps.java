package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by VITALIY on 27.10.2017.
 */
public class BaseSteps {

    public static WebDriver driver;
    String baseUrl;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseUrl = "https://vk.com/";
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @After
    public void after() {

        driver.quit();
    }

    public static WebDriver getDriver() {

        return driver;
    }
}
