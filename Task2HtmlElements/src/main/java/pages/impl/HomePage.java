package pages.impl;

import fragments.SearchForm;
import fragments.UserAccount;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.Link;

public class HomePage extends BasePage {

    private SearchForm searchForm;
    private UserAccount userAccount;

    @FindBy(xpath = "//a[text()='Health & Care']")
    private Link linkHealthAndCare;

    @FindBy(xpath = "//a[@href='/feedback/']")
    private Link linkFeedback;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        searchForm.inputTextToSearchField(text);
    }

    public void loginIn(String login, String password) {
        userAccount.inputTextToUserAccount(login, password);
        userAccount.clickSubmit();
    }

    public void redirect() {
        linkHealthAndCare.click();
    }

    public String restorePassword() {
        userAccount.clickOnEntranceToTheCabinet();
        userAccount.clickOnForgetPasswordButton();
        return userAccount.getRestorePassMessage();
    }

    public boolean loginFormIsPresent() {
        return userAccount.getLoginForm().isDisplayed();
    }

    public void loginWithoutEmail(String password) {
        userAccount.clickOnEntranceToTheCabinet();
        userAccount.typeTextToPasswordField(password);
        userAccount.clickSubmit();
    }

    public void loginWithoutPassword(String login) {
        userAccount.clickOnEntranceToTheCabinet();
        userAccount.typeTextToEmailField(login);
        userAccount.clickSubmit();
    }

    public boolean verifyErrorAttributeForField(String field) {
        if(field.equals("login")) {
            return userAccount.getUserLoginField().getCssValue("border-color").equals("rgb(218, 65, 18)");
        }
        else {
            return userAccount.getUserPasswordField().getCssValue("border-color").equals("rgb(218, 65, 18)");
        }
    }

    public void clickLinkFeedback() {
        linkFeedback.click();
    }

    @Override
    public WebElement getLoadableElement() {
        return null;
    }


}
