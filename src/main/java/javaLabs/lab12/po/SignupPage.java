package javaLabs.lab12.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static javaLabs.lab12.WebDriverSupplier.driver;

public class SignupPage {


    //driver.findElement(By.id("signInModalLabel"))
    @FindBy(id = "userForm")
    private WebElement signInModalLabel;


    public SignupPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean isOpen() throws InterruptedException {
        Thread.sleep(1000);
        return signInModalLabel.isDisplayed();
    }
}
