Feature: Home Page

  @Navigate
  Scenario: Check that the home page title is displayed
    Given User launches the browser
    When User opens home page The Chillys
    Then Check that the home page title is displayed
    And User closes browser