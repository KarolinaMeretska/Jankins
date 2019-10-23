package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.impl.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private LoginResultPage loginResultPage;
    private HealthCarePage healthCarePage;
    private FeedbackPage feedbackPage;

    @BeforeClass
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
        loginResultPage = new LoginResultPage(driver);
        healthCarePage = new HealthCarePage(driver);
        feedbackPage = new FeedbackPage(driver);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    /**
     *This test checks the opening of the search page after the search query
     */
    @Test
        public void checkSearchPageOpeningAfterSearchQuery() {
            homePage.openPage();
            homePage.search("Brelil");
            searchResultPage.isPageLoaded();
            assertThat(searchResultPage.isPageLoaded())
                    .as("Search results Page wasn't loaded")
                    .isTrue();
        }

    /**
     * This test checks that after the search in the "Новинки" section, all items contains "Brelil"
     */
    @Test
    public void checkSearchOnHomePage() {
        homePage.openPage();
        homePage.search("Brelil");
        searchResultPage.isPageLoaded();
        searchResultPage.getSearchResultItemsNames()
                .forEach(itemName ->
                        assertThat(itemName.contains("Brelil"))
                                .as("Found item, that shouldn't be is search results: %s", itemName)
                                .isTrue());
    }

    /**
     * Checks user login in with valid data
     */
    @Test
    public void checksUserLoginIn() {
        homePage.openPage();
        homePage.loginIn("kilyakilya24@gmail.com","aA543210");
        loginResultPage.isPageLoaded();
        assertThat(loginResultPage.isPageLoaded())
                .as("Search results Page wasn't loaded")
                .isTrue();
    }

    /**
     * This test check subscription from Health and Care page
     */
    @Test
    public void verifySubscriptionFromHealthAndCarePage() {
        homePage.openPage();
        homePage.redirect();
        healthCarePage.isPageLoaded();
        healthCarePage.subscription("kilyakilya24@gmail.com");
        healthCarePage.verifyingSubscription();
        assertThat(healthCarePage.verifyingSubscription())
                .as("Not subscribed")
                .isTrue();
    }

    /**
     * Check the form for the text "восстановление пароля"
     */
    @Test
    public void verifyRestorePasswordForm() {
        homePage.openPage();
        assertEquals("восстановление пароля",homePage.restorePassword().toLowerCase());
    }

    /**
     * Check logging in with invalid email and valid password
     */
    @Test
    public void loginWithInvalidEmail() {
        homePage.openPage();
        homePage.loginIn("kilya24@gmail.com","aA543210");
        assertThat(homePage.loginFormIsPresent())
                .as("Login form is hidden")
                .isTrue();
    }

    @Test
    public void checkSearchWithNegativeValue() {
        homePage.openPage();
        homePage.search("sfdfghdgjjhgffdsgh");
        assertThat(searchResultPage.getSearchText().contains("Найдено 0 товаров"))
                .as("Not validation on search with invalid data")
                .isTrue();
    }


    /**
     * Check logging in with empty email field and valid password
     */
    @Test
    public void loginWithoutEmail() {
        homePage.openPage();
        homePage.loginWithoutEmail("aA543210");
        assertThat(homePage.verifyErrorAttributeForField("login"))
                .as("Email field not contains red error border")
                .isTrue();
    }

    /**
     * Check logging in with valid email and invalid password
     */
    @Test
    public void loginWithoutPassword() {
        homePage.openPage();
        homePage.loginWithoutPassword("kilyakilya24@gmail.com");
        assertThat(homePage.verifyErrorAttributeForField("password"))
                .as("Password field not contains red error border")
                .isTrue();
    }

    /**
     * Check subscription from Health & Care page with invalid email
     */
    @Test
    public void verifySubscriptionWithInvalidEmailFromHealthAndCarePage() {
        homePage.openPage();
        homePage.redirect();
        healthCarePage.isPageLoaded();
        healthCarePage.subscription("dfghfhgdfsg@dsfgd.com");
        healthCarePage.verifyingSubscription();
        assertThat(healthCarePage.verifyingSubscription())
                .as("No validation on email")
                .isFalse();
    }

    /**
     * This test checks send feedback with selected "marketing department" and invalid email
     */
    @Test
    public void sendFeedbackWithInvalidEmailInRussianLanguage() {
        homePage.openPage();
        homePage.clickLinkFeedback();
        feedbackPage.createFeedbackInRussianLanguage("Paul","dfghfhgdfsg@dsfgd.com", "hrgertr",
                "utfsdgfbs hbvgfdgyd dsgyds fsdiu" );
        feedbackPage.sendFeedback();
        assertThat(feedbackPage.verifyingSendFeedback())
                .as("No validation on email")
                .isFalse();
    }

    /**
     * This test checks send feedback with selected ukrainian language,"marketing department", and introduced valid email
     */
    @Test
    public void sendFeedbackWithInvalidEmailInUkrainianLanguage() {
        homePage.openPage();
        homePage.clickLinkFeedback();
        feedbackPage.selectUkrainianLanguage();
        feedbackPage.displayUkrainianLanguage();
        assertEquals("напишіть нам листа",feedbackPage.displayUkrainianLanguage().toLowerCase());
        feedbackPage.createFeedbackInUkrainianLanguage("Lili", "kilyakilya24@gmail.com",
                "title", "gfsygfs sfgs fsdg ");
        feedbackPage.sendFeedback();
        assertThat(feedbackPage.verifyingSendFeedback())
                .isFalse();
    }

    /**
     * This test checks send feedback with selected "marketing department" and invalid email
     */
    @Test
    public void sendFeedbackWithInvalidEmail() {
        homePage.openPage();
        homePage.clickLinkFeedback();
        feedbackPage.createFeedbackInRussianLanguage("Paul","dfghfhgdfsg@", "hrgertr",
                "gfbs hbvgyd dsgyds fsdiu" );
        feedbackPage.sendFeedback();
        assertThat(feedbackPage.verifyErrorAttributeForEmailField("dfghfhgdfsg@"))
                .as("Email field not contains red error border")
                .isTrue();
    }

    @AfterClass
    public void stopDriver() {
        driver.quit();
    }

}
