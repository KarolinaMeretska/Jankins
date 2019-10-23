package fragments;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(xpath = "//footer//form")
public class FooterSubscriptions extends HtmlElement {

    @FindBy(xpath = "//div[@class='input-wrap']/input[@type='email']")
    private TextInput inputField;

    @FindBy(xpath = "//footer//form//button")
    private Button subscriptionsButton;

    public void createSubscription(String email) {
        inputField.clear();
        inputField.sendKeys(email);
        subscriptionsButton.click();
    }

}
