package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinRequestPasswordResetSubmitPage extends LinkedinBasePage {
    public LinkedinRequestPasswordResetSubmitPage (WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return resendLinkButton.isDisplayed();
    }

    @FindBy(id = "resend-url")
    private WebElement resendLinkButton;

    public LinkedinSetNewPasswordPage navigateToLinkFromEmail() {
        String messageSubject = "данное сообщение содержит ссылку для изменения пароля";
        String messageTo = "ksko.ksko1996@gmail.com";
        String messageFrom = "<security-noreply@linkedin.com>";
        String message =gMailService.waitMessage(messageSubject, messageTo, messageFrom,60);
        //To change your LinkedIn password, click <a href="
        //" style
        String resetPasswordLink = StringUtils.substringBetween(message, "Чтобы изменить пароль в LinkedIn, нажмите <a href=\"","\" style").replace("&amp;", "&");
        System.out.println("Content: "+ resetPasswordLink);

        webDriver.get(resetPasswordLink);

        return new LinkedinSetNewPasswordPage(webDriver);
    }

}
