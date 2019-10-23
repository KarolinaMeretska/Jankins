package pages.impl;

import fragments.FooterSubscriptions;
import fragments.subscription_page_result.SubscriptionResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.Link;

public class HealthCarePage extends BasePage {
    private FooterSubscriptions footerSubscriptions;
    private SubscriptionResult subscriptionResult;

    @FindBy(xpath = "//link[@href='https://makeup.com.ua/categorys/339969/']")
    private Link urlPageHealthAndCare;

    public HealthCarePage(WebDriver driver) {
        super(driver);
    }

    public void subscription(String email) {
        footerSubscriptions.createSubscription(email);
    }

    public boolean verifyingSubscription() {
        subscriptionResult.displayed();
        return true;
    }

    @Override
    public WebElement getLoadableElement() {
        return urlPageHealthAndCare;
    }
}
