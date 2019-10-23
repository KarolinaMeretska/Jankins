package pages.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.Form;

public class LoginResultPage extends BasePage {
    @FindBy(className = "form-inner-wrap")
    private Form formLogin;

    public LoginResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getLoadableElement() {
        return formLogin;
    }
}
