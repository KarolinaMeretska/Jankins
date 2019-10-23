package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public abstract class BasePage implements Page {
    protected String PAGE_URL = "https://makeup.com.ua/";
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(this.driver)), this);
    }

    @Override
    public void openPage() {
        driver.get(PAGE_URL);
    }

    @Override
    public boolean isPageLoaded() {
        return getLoadableElement().isDisplayed();
    }
}
