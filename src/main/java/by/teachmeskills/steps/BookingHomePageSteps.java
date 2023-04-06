package by.teachmeskills.steps;

import by.teachmeskills.page.BookingHomePage;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BookingHomePageSteps {

    @Given("User is on {string} page")
    public void userIsOnPage(String pageAddress) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities = chromeOptions;
        open(pageAddress);
    }

    @And("The browser is maximized")
    public void theBrowserIsMaximized() {
        getWebDriver().manage().window().maximize();
    }

    @When("User searches for {string}")
    public void userSearchesFor(String hotelName) {
        new BookingHomePage().searchForHotel(hotelName);
    }

    @Then("User sees autocomplete result {string} suggestion")
    public void userSeesAutocompleteResultSuggestion(String hotelName) {
        new BookingHomePage().findTipsAutoComplete(hotelName);
    }

    @Then("User click on a button search")
    public void userClickOnAButtonSearch() {
        new BookingHomePage().clickButtonSearch();
    }

    BookingHomePage homePage = new BookingHomePage();

    @Then("{string} is displayed on the page")
    public void isDisplayedOnThePage(String hotelName) {
        String actHotelName = homePage.getNameOfHotelIsDisplayed(hotelName);
        Assertions.assertThat(actHotelName).as("Hotel name" + hotelName + "is corrected")
                .isEqualTo(hotelName);
    }

    @Then("{string} is identical")
    public void isIdentical(String rating) {
        String actRatingOfHotel = homePage.getRatingOfHotel();
        Assertions.assertThat(actRatingOfHotel).as("Rating of hotel" + rating + "is corrected")
                .isEqualTo(rating);
    }
}
