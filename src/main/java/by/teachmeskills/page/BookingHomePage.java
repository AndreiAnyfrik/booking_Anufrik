package by.teachmeskills.page;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class BookingHomePage {

    public final String autoCompleteLocator = "//ul[@data-testid='autocomplete-results']//div[text()='%s']";
    public final String nameOfHotelLocator = "//div[text()='%s']";
    public final String ratingLocator = "//div[text()='Smarthotel Oslo']//ancestor::div[@data-testid='property-card']" +
            "//div[contains(@aria-label, 'Scored ')]";

    public void searchForHotel(String hotelName) {
        $x("//input[@name='ss']").shouldBe(Condition.enabled).sendKeys(hotelName);
    }

    public void findTipsAutoComplete(String hotelName) {
        $x(String.format(autoCompleteLocator, hotelName))
                .shouldBe(Condition.enabled)
                .click();
    }

    public void clickButtonSearch() {
        $x("//button[@type='submit']").shouldBe(Condition.enabled).click();
    }

    public String getNameOfHotelIsDisplayed(String hotelName) {
        return $x(String.format(nameOfHotelLocator, hotelName)).shouldBe(Condition.exist).getText();
    }

    public String getRatingOfHotel() {
        return $x(ratingLocator).shouldBe(Condition.exist).getText();
    }
}
