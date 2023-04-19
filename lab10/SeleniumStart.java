package javaHomeWork.lab10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumStart {

    public static void main(String[] args) {

        //1. Setup ChromeDriver using driver file and properties.

        //System.setProperty("web-driver.chrome.driver", "C:/Users/ME/IdeaProjects/labJava/driver/chromedriver");
        //WebDriver driver = new ChromeDriver();


        //2. Setup ChromeDriver using DriverManager.
        //V16. https://demoqa.com (Book Store Application - Book Store)
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com");

        //My first UI test:
        //go to the page from your variant
        //choose any 5 different elements;
        //Use different WebElement methods to communicate with those elements. (one element - at least one interaction)


        //1
        WebElement demoqaFooter = driver.findElement(By.tagName("footer"));
        demoqaFooter.click();
        System.out.println("1: click" + demoqaFooter);

        //2
        WebElement demoqaCard = driver.findElement(By.className("card"));
        System.out.println("2: " + demoqaCard.getTagName());

        //3
        WebElement demoqaSvg = driver.findElement(By.tagName("svg"));
        System.out.println("3: " + demoqaSvg.getAttribute("height"));

        //4
        WebElement demoqaCardUp = driver.findElement(By.className("card-up"));
        System.out.println("3: " + demoqaCardUp.getCssValue("background-image"));

        //5
        WebElement demoqaText = driver.findElement(By.tagName("h5"));
        System.out.println("5: " + demoqaText.getText());


        //Make a testNG test case to check visibility of your elements.



        driver.close();
        driver.quit();





    }
}
