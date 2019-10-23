package fragments;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(className = "header-top")
public class UserAccount extends HtmlElement {

    @FindBy(xpath = "//div[@class='header-top']//div//div//div")
    private HtmlElement entranceToTheCabinet;

    @FindBy(xpath = "//input[@name='user_login']")
    private HtmlElement userLogin;

    @FindBy (xpath = "//input[@name='user_pw']")
    private HtmlElement userPassword;

    @FindBy(xpath = "//form[@id='form-auth']//button")
    private Button submit;

    @FindBy(xpath="//form[@data-popup='forget-password']//h2")
    private HtmlElement restorePassText;

    @FindBy(xpath = "//div[@data-popup-handler='forget-password']")
    private HtmlElement forgetPasswordButton;

    @FindBy(xpath = "//form[@data-popup='auth']")
    private HtmlElement loginForm;

    public void inputTextToUserAccount(String login, String password) {
        entranceToTheCabinet.click();
        userLogin.clear();
        userLogin.sendKeys(login);
        userPassword.click();
        userPassword.clear();
        userPassword.sendKeys(password);
    }

    public void clickSubmit() {
        submit.click();
    }

    public void clickOnForgetPasswordButton() {
        forgetPasswordButton.click();
    }

    public String getRestorePassMessage() {
        return restorePassText.getText();
    }

    public void clickOnEntranceToTheCabinet() {
        entranceToTheCabinet.click();
    }

    public HtmlElement getLoginForm() {
        return loginForm;
    }

    public HtmlElement getUserLoginField() {
        return userLogin;
    }

    public HtmlElement getUserPasswordField() {
        return userPassword;
    }

    public void typeTextToPasswordField(String password) {
        userPassword.click();
        userPassword.clear();
        userPassword.sendKeys(password);
    }

    public void typeTextToEmailField(String login) {
        userLogin.clear();
        userLogin.sendKeys(login);
    }
}
