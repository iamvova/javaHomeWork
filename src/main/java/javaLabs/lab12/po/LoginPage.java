package javaLabs.lab12.po;

import javaLabs.lab12.wrapper.Decorator;
import javaLabs.lab12.wrapper.TextElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static javaLabs.lab12.WebDriverSupplier.driver;

public class LoginPage {


    //driver.findElement(By.xpath("//*[@id=\"userName\"]"))
    @FindBy(xpath="//*[@id=\"userName\"]" )
    private WebElement loginUsernameInput;
    //driver.findElement(By.xpath("//*[@id=\"password\"]"))
    @FindBy(xpath="//*[@id=\"password\"]")
    private WebElement loginPassInput;
    //driver.findElement(By.xpath("//button[@id="login"]"))
    @FindBy(xpath="//button[@id=\"login\"]")
    private WebElement loginButton;

    //driver.findElement(By.id("nameofuser"))
    @FindBy(id="userName-value")
    private TextElement loginLabel;


    public LoginPage(){
        PageFactory.initElements(new Decorator(driver), this);
    }

    public LoginPage inputLogin(String login) throws InterruptedException {
        Thread.sleep(1000);
        loginUsernameInput.sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String pass) {
        loginPassInput.sendKeys(pass);
        return this;
    }

    public LoginPage login() {
        loginButton.click();
        return this;
    }

    public String loginLabel() throws InterruptedException {
        Thread.sleep(3000);
        return loginLabel.waitForVisibleGetText();
    }


}
