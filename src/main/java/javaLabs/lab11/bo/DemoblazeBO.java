package javaLabs.lab11.bo;

import javaLabs.lab11.po.HomePage;
import javaLabs.lab11.po.SignupPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.UUID;

public class DemoblazeBO {

    private WebDriver driver;
    HomePage homePage;
    SignupPage signupPage;
    String login = "iamvova";
    String pass = "Qwarty11!";
    public DemoblazeBO(WebDriver driver) {
        this.driver = driver;
    }

    public DemoblazeBO checkSignUpRandomUser() throws InterruptedException {
        homePage = new HomePage(driver);
        signupPage = homePage.signUp();

        //1.1 verify sign up page open
        Assert.assertTrue(signupPage.isOpen());

        return this;
    }


    public void checkLoginUser() throws InterruptedException {
        String userLabel = homePage.goToLoginPage()
                .inputLogin(login)
                .inputPassword(pass)
                .login()
                .loginLabel();

        Assert.assertEquals(userLabel, login);
    }
}
