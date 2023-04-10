Feature: Booking hotel search

  Scenario Outline: Search for hotel on the Booking site
    Given User is on "https://www.booking.com/searchresults.en-gb.html" page
    And The browser is maximized
    When User searches for "<hotelName>"
    Then User sees autocomplete result "<hotelName>" suggestion
    Then User click on a button search
    Then "<hotelName>" is displayed on the page
    Then "<rating>" is identical
    Examples:
      | hotelName       | rating |
      | Smarthotel Oslo | 7.7    |
