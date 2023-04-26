package javaLabs.lab12.wrapper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static javaLabs.lab12.WebDriverSupplier.driver;
import static javaLabs.lab12.WebDriverSupplier.getWaitInstance;

public class TextElement extends Element {
    public TextElement(WebElement webElement){
        super(webElement);
    }


    public String waitForVisibleGetText() {
        System.out.println("Start waiting.."+getWebElement());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(getWebElement()));

        return getWebElement().getText();
    }

}
