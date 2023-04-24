package lab10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Lab10Test {

    private WebDriver driver;
    @BeforeTest
    void setup(){
        //System.setProperty("web-driver.chrome.driver", "C:/Users/ME/IdeaProjects/labJava/driver/chromedriver");
        ChromeDriverManager.getInstance().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

    }
    @Test
    void simpleWDTest(){
        //step 1
        driver.get("https://demoqa.com");

        //step 2
        //1
        WebElement demoqaFooter = driver.findElement(By.tagName("footer"));
        Assert.assertTrue(demoqaFooter.isDisplayed());

        //2
        WebElement demoqaCard = driver.findElement(By.className("card"));
        Assert.assertTrue(demoqaCard.isDisplayed());

        //3
        WebElement demoqaSvg = driver.findElement(By.tagName("svg"));
        Assert.assertTrue(demoqaSvg.isDisplayed());

        //4
        WebElement demoqaCardUp = driver.findElement(By.className("card-up"));
        Assert.assertTrue(demoqaCardUp.isDisplayed());

        //5
        WebElement demoqaText = driver.findElement(By.tagName("h5"));
        Assert.assertEquals(demoqaText.getText(), "Elements");

    }

    @AfterTest
    void closeBrowser(){
        driver.close();
        driver.quit();
    }

}
