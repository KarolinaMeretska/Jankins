package fragments.search_result;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

@FindBy(className = "simple-slider-list__item")
public class SearchResultItem  extends HtmlElement {

    @FindBy(xpath = "//div[@class='simple-slider-list-wrap']//li")
    private TextBlock itemName;

    public String getItemName() {
        return  itemName.getText();
    }
}
