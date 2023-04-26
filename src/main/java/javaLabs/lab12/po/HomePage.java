package javaLabs.lab12.po;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static javaLabs.lab12.WebDriverSupplier.driver;

public class HomePage {

    public static final String URL = "https://demoqa.com/login";

    //driver.findElement(By.id("login2"))
    @FindBy(id = "login")
    private WebElement login;
    public HomePage(){
        if (!URL.equals(driver.getCurrentUrl())){
            driver.get(URL);
        }
        PageFactory.initElements(driver, this);
    }
    public SignupPage signUp() {
        return new SignupPage();
    }

    public LoginPage goToLoginPage() {
        login.click();
        return new LoginPage();
    }
}
