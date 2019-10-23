package fragments.subscription_page_result;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//div[@id='popup']")
public class SubscriptionResult extends HtmlElement {

    @FindBy(id = "popup__window")

    private HtmlElement messageWindow;

    public void displayed() {
        messageWindow.isDisplayed();
    }
}
