package javaLabs.lab11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupPage {
    private WebDriver driver;
    public SignupPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isOpen() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(By.id("signInModalLabel")).isDisplayed();
    }

    public SignupPage inputLogin(String login) throws InterruptedException {
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"sign-username\"]")).sendKeys(login);
        return this;
    }

    public SignupPage inputPassword(String pass) {
        driver.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys(pass);
        return this;
    }

    public SignupPage signup() {
        driver.findElement(By.xpath("//button[text()=\"Sign up\"]")).click();
        return this;
    }

    public HomePage checkAcceptAlert() throws InterruptedException {

        Thread.sleep(1000);
        Assert.assertEquals(driver.switchTo().alert().getText(), "Sign up successful.");
        driver.switchTo().alert().accept();
        return  new HomePage(driver);
    }
}
