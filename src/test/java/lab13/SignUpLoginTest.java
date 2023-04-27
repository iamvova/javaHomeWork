package lab13;


import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import javaLabs.lab12.WebDriverSupplier;
import javaLabs.lab12.bo.DemoblazeBO;
import javaLabs.lab13.SuiteListener;
import javaLabs.lab13.TestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SuiteListener.class, TestListener.class, UniversalVideoListener.class})
public class SignUpLoginTest {



    @BeforeTest
    void setup(){
        WebDriverSupplier.setupDriver();
    }

    @Video
    @Test
    void endToEndTest() throws InterruptedException {

        DemoblazeBO demoblazeBO = new DemoblazeBO();

        demoblazeBO.checkSignUpRandomUser()
                .checkLoginUser();

    }

    @Test
    void endToEndFailTest() throws InterruptedException {

        DemoblazeBO demoblazeBO = new DemoblazeBO();

        demoblazeBO.checkSignUpRandomUser()
                .failTest();

    }


    @AfterTest
    void closeBrowser(){
        WebDriverSupplier.closeDriver();
    }
}
