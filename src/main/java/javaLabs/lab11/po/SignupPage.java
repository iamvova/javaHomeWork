package javaLabs.lab11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    private WebDriver driver;
    public SignupPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isOpen() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(By.id("userForm")).isDisplayed();
    }

}
