package lab12;


import javaLabs.lab12.bo.DemoblazeBO;
import javaLabs.lab12.WebDriverSupplier;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SignUpLoginTest {



    @BeforeTest
    void setup(){
        WebDriverSupplier.setupDriver();
    }
    @Test
    void endToEndTest() throws InterruptedException {

        DemoblazeBO demoblazeBO = new DemoblazeBO();

        demoblazeBO.checkSignUpRandomUser()
                .checkLoginUser();

    }


    @AfterTest
    void closeBrowser(){
        WebDriverSupplier.closeDriver();
    }
}
