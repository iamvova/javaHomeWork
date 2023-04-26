package lab11;


import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import javaLabs.lab11.bo.DemoblazeBO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EndToEndTest {


    private WebDriver driver;
    @BeforeTest
    void setup(){
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }
    @Test
    void endToEndTest() throws InterruptedException {

        DemoblazeBO demoblazeBO = new DemoblazeBO(driver);

        demoblazeBO.checkSignUpRandomUser()
                .checkLoginUser();

    }


    @AfterTest
    void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
