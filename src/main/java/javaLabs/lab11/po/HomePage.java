package javaLabs.lab11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public static final String URL = "https://www.demoblaze.com/";
    public HomePage(WebDriver driver){
        this.driver = driver;
        if (!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
        }
    }
    public SignupPage signUp() {
        driver.findElement(By.id("signin2")).click();
        return new SignupPage(driver);
    }

    public LoginPage goToLoginPage() {
        //2. login
        driver.findElement(By.id("login2")).click();
        return new LoginPage(driver);
    }
}
