package javaLabs.lab11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public static final String URL = "https://demoqa.com/login";
    public HomePage(WebDriver driver){
        this.driver = driver;
        if (!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
        }
    }
    public SignupPage signUp() {
        return new SignupPage(driver);
    }

    public LoginPage goToLoginPage() {
        //2. login
        driver.findElement(By.id("login")).click();
        return new LoginPage(driver);
    }
}
