package javaLabs.lab12.bo;

import javaLabs.lab12.po.HomePage;
import javaLabs.lab12.po.SignupPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.UUID;

public class DemoblazeBO {
    HomePage homePage;
    SignupPage signupPage;
    String login = "iamvova";
    String pass = "Qwarty11!";

    public DemoblazeBO checkSignUpRandomUser() throws InterruptedException {
        homePage = new HomePage();
        signupPage = homePage.signUp();

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
