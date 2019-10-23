package fragments;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(className = "header-right-row")
public class SearchForm extends HtmlElement {

    @FindBy(xpath = "//input[@id='search-input']")
    private TextInput searchField;

    public void inputTextToSearchField(String text) {
        searchField.click();
        searchField.clear();
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
    }
}
