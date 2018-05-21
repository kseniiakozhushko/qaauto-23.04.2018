import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class LinkedinHomePage {
    private WebDriver webDriver;

    public LinkedinHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTitle(){
        return webDriver.getTitle();
    }
}
