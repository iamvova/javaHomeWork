package javaLabs.lab11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public LoginPage inputLogin(String login) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String pass) {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass);
        return this;
    }

    public LoginPage login() {
        driver.findElement(By.xpath("//button[@id=\"login\"]")).click();
        return this;
    }


    public String loginLabel() throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElement(By.id("userName-value")).getText();
    }
}
