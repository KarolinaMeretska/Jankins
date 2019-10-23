package pages.impl;

import fragments.subscription_page_result.SubscriptionResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class FeedbackPage extends BasePage {

    private SubscriptionResult subscriptionResult;

    @FindBy(xpath = "//form[@id='form-feedback']")
    private HtmlElement feedbackForm;

    @FindBy(xpath = "//div[@class='custom-select']")
    private HtmlElement department;

    @FindBy(xpath = "//input[@id='contacts-name']")
    private HtmlElement contactName;

    @FindBy(xpath = "//input[@id='contacts-email']")
    private HtmlElement contactEmail;

    @FindBy(xpath = "//input[@id='contacts-subj']")
    private HtmlElement subject;

    @FindBy(xpath = "//textarea[@id='contacts-message']")
    private HtmlElement message;

    @FindBy(xpath = "//textarea[@id='contacts-message']/../../following-sibling::div/button")
    private HtmlElement sendFeedback;

    @FindBy(xpath = "//div[@data-value='4']")
    private HtmlElement marketingDepartment;

    @FindBy(xpath = "//a[@lang='uk']")
    private HtmlElement ukrainianLanguage;

    @FindBy(xpath = "//div[@class='form-wrap']/h2")
    private TextBlock formTitle;


    public FeedbackPage(WebDriver driver) {
        super(driver);
    }

    public void createFeedbackInRussianLanguage(String name, String email, String messageSubject, String messageFeedback) {
        department.click();
        marketingDepartment.click();
        contactName.click();
        contactName.sendKeys(name);
        contactEmail.clear();
        contactEmail.sendKeys(email);
        subject.clear();
        subject.sendKeys(messageSubject);
        message.clear();
        message.sendKeys(messageFeedback);
    }

    public void sendFeedback() {
        sendFeedback.click();
    }

    public boolean verifyingSendFeedback() {
        subscriptionResult.displayed();
        return true;
    }

    public void selectUkrainianLanguage() {
        ukrainianLanguage.click();
    }

    public String displayUkrainianLanguage() {
        return formTitle.getText();
    }

    public void createFeedbackInUkrainianLanguage(String name, String email, String messageSubject, String messageFeedback) {
        department.click();
        marketingDepartment.click();
        contactName.click();
        contactName.sendKeys(name);
        contactEmail.clear();
        contactEmail.sendKeys(email);
        subject.clear();
        subject.sendKeys(messageSubject);
        message.clear();
        message.sendKeys(messageFeedback);
    }

    public boolean verifyErrorAttributeForEmailField(String emailField) {
        if(emailField.equals("contactEmail")) {
            return contactEmail.getCssValue("border-color").equals("rgb(218, 65, 18)");
        }
        else {
            return contactEmail.getCssValue("border-color").equals("rgb(218, 65, 18)");
        }
    }

    @Override
    public WebElement getLoadableElement() {
        return feedbackForm;
    }
}
