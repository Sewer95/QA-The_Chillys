Feature: Login

  @Login
  Scenario: Successful user login
    Given User launches the browser
    When User opens home page The Chillys
    And User clicks on Login link
    And User enters valid data
    And User clicks on the Login button
    Then User checks the display of a successful login message
    And User closes browser

  @InvalidPassword
  Scenario Outline: Unsuccessful user login
    Given User launches the browser
    When User opens home page The Chillys
    And User clicks on Login link
    And User enters valid name and invalid password
      | name | password   |
      | name>   | <password> |
    And User clicks on the Login button
    Then User checks the display of an unsuccessful login message
    And User closes browser
    Examples:
      | name     | password        |
      | TestUser | password_Test01 |
      | TestUser | password@Test   |
      | TestUser | Password01      |
      | TestUser | PasswordTest111 |
