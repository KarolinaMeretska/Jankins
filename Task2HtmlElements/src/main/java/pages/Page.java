package pages;

import org.openqa.selenium.WebElement;

public interface Page {
        boolean isPageLoaded();

        void openPage();

        WebElement getLoadableElement();
        }
