package pages.impl;

import fragments.search_result.SearchResultItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(className = "simple-slider-list-wrap")
    private HtmlElement catalogSection;

    @FindBy(xpath = "//div[@class='search-results']")
    private HtmlElement searchResultText;

    private List<SearchResultItem> searchResultItemList;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        super.PAGE_URL += "search/";
    }

    public List<String> getSearchResultItemsNames() {
        ArrayList<String> names = new ArrayList();
        searchResultItemList.forEach(item -> names.add(item.getItemName()));
        return names;
    }

    public String getSearchText() {
        return searchResultText.getText();
    }

    @Override
    public WebElement getLoadableElement() {
        return catalogSection;
    }
}
