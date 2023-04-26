package javaLabs.lab12;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverSupplier {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static void setupDriver() {
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public static WebDriverWait getWaitInstance(){
        if(wait == null) wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        return wait;
    }



    public static void closeDriver() {
        driver.close();
        driver.quit();
    }
}
